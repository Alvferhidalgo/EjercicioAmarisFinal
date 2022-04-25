package com.example.domain.services;

import com.example.commons.dtos.PriceDto;
import com.example.domain.vos.Price;
import com.example.inbounds.mappers.InboundsPriceMapper;
import com.example.inbounds.ports.in.PriceInputPort;
import com.example.outbounds.ports.PriceOutputPort;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PriceService implements PriceInputPort {

  private final PriceOutputPort priceOutputPort;
  private final Logger log = LoggerFactory.getLogger(PriceService.class);
  private final InboundsPriceMapper inboundsPriceMapper;

  @Override
  public List<Price> findAll() {
    return priceOutputPort.findAll().stream().map(inboundsPriceMapper::mapRequest).collect(Collectors.toList());
  }

  @Override
  public Price save(final PriceDto dto) {
    return inboundsPriceMapper.mapRequest(priceOutputPort.save(dto));
  }

  @Override
  public void delete(final String id) {
    priceOutputPort.delete(id);
  }

  public void updateFromRequest(final String productId, final Integer priceListId, final Double price) {
    List<Price> productPrices = priceOutputPort.findAll().stream().map(inboundsPriceMapper::mapRequest)
        .filter(p -> p.getProduct().getId().equals(productId) && p.getPriceList().equals(priceListId)).collect(Collectors.toList());
    productPrices.forEach(p -> p.setPrice(price));
    priceOutputPort.saveAll(productPrices.stream().map(inboundsPriceMapper::mapResponse).collect(Collectors.toList()));
    log.info("Price changed in database with values: Product id = " + productId + " price list = " + priceListId + " new price: " + price);
  }

  @Override
  public List<Price> findByDateProductBrand(final String applicationDate, final String productId, final String brandId) {
    LocalDateTime application = LocalDateTime.parse(applicationDate);
    return priceOutputPort.findAll().stream().map(inboundsPriceMapper::mapRequest)
        .filter(p -> checkDate(application, p.getStartDate(), p.getEndDate())).filter(p -> productId.equals(p.getProduct().getId()))
        .filter(p -> brandId.equals(p.getBrand().getId())).collect(Collectors.toList());
  }

  private Boolean checkDate(final LocalDateTime currentDate, final LocalDateTime startDate, final LocalDateTime endDate) {
    return currentDate.isAfter(startDate) && currentDate.isBefore(endDate) || currentDate.equals(startDate) || currentDate.equals(endDate);
  }
}
