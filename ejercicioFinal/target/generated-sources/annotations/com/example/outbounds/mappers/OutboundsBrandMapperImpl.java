package com.example.outbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.outbounds.entities.BrandEntity;
import com.example.outbounds.entities.PriceEntity;
import com.example.outbounds.entities.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-20T13:41:38+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class OutboundsBrandMapperImpl implements OutboundsBrandMapper {

    @Override
    public List<BrandDto> mapResponseList(List<BrandEntity> vos) {
        if ( vos == null ) {
            return null;
        }

        List<BrandDto> list = new ArrayList<BrandDto>( vos.size() );
        for ( BrandEntity brandEntity : vos ) {
            list.add( mapResponse( brandEntity ) );
        }

        return list;
    }

    @Override
    public BrandEntity mapRequest(BrandDto dto) {
        if ( dto == null ) {
            return null;
        }

        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setId( dto.getId() );
        brandEntity.setName( dto.getName() );
        brandEntity.setPrices( priceDtoListToPriceEntityList( dto.getPrices() ) );

        return brandEntity;
    }

    @Override
    public BrandDto mapResponse(BrandEntity vo) {
        if ( vo == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setId( vo.getId() );
        brandDto.setName( vo.getName() );

        return brandDto;
    }

    protected List<PriceEntity> priceDtoListToPriceEntityList(List<PriceDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PriceEntity> list1 = new ArrayList<PriceEntity>( list.size() );
        for ( PriceDto priceDto : list ) {
            list1.add( priceDtoToPriceEntity( priceDto ) );
        }

        return list1;
    }

    protected ProductEntity productDtoToProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( productDto.getId() );
        productEntity.setPrices( priceDtoListToPriceEntityList( productDto.getPrices() ) );
        productEntity.setCreatedAt( productDto.getCreatedAt() );
        productEntity.setUpdatedAt( productDto.getUpdatedAt() );
        productEntity.setName( productDto.getName() );
        productEntity.setCategory( productDto.getCategory() );
        productEntity.setEndOfSalesDate( productDto.getEndOfSalesDate() );

        return productEntity;
    }

    protected PriceEntity priceDtoToPriceEntity(PriceDto priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setId( priceDto.getId() );
        priceEntity.setBrand( mapRequest( priceDto.getBrand() ) );
        priceEntity.setProduct( productDtoToProductEntity( priceDto.getProduct() ) );
        priceEntity.setStartDate( priceDto.getStartDate() );
        priceEntity.setEndDate( priceDto.getEndDate() );
        priceEntity.setPriceList( priceDto.getPriceList() );
        priceEntity.setPriority( priceDto.getPriority() );
        priceEntity.setPrice( priceDto.getPrice() );
        priceEntity.setCurrency( priceDto.getCurrency() );

        return priceEntity;
    }
}
