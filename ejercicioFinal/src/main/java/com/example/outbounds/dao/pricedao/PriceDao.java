package com.example.outbounds.dao.pricedao;

import com.example.outbounds.mappers.OutboundsPriceMapper;
import com.example.outbounds.repositories.PriceEntityRepository;
import com.example.commons.dtos.PriceDto;
import com.example.outbounds.ports.PriceOutputPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PriceDao implements PriceOutputPort {

  private final PriceEntityRepository repository;
  private final OutboundsPriceMapper outboundsPriceMapper;

  @Override
  public List<PriceDto> findAll() {
    return repository.findAll().stream().map(outboundsPriceMapper::mapResponse).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public PriceDto save(final PriceDto dto) {
    return outboundsPriceMapper.mapResponse(repository.save(outboundsPriceMapper.mapRequest(dto)));
  }

  @Override
  public void saveAll(final List<PriceDto> dto) {
    repository.saveAll(dto.stream().map(outboundsPriceMapper::mapRequest).collect(Collectors.toList()));
  }

  @Override
  public void delete(final String id) {
    repository.deleteById(id);
  }
}
