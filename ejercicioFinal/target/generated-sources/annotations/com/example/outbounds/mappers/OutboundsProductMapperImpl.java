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
    date = "2022-04-20T13:41:39+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class OutboundsProductMapperImpl implements OutboundsProductMapper {

    @Override
    public List<ProductDto> mapResponseList(List<ProductEntity> vos) {
        if ( vos == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( vos.size() );
        for ( ProductEntity productEntity : vos ) {
            list.add( mapResponse( productEntity ) );
        }

        return list;
    }

    @Override
    public ProductEntity mapRequest(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( dto.getId() );
        productEntity.setPrices( priceDtoListToPriceEntityList( dto.getPrices() ) );
        productEntity.setCreatedAt( dto.getCreatedAt() );
        productEntity.setUpdatedAt( dto.getUpdatedAt() );
        productEntity.setName( dto.getName() );
        productEntity.setCategory( dto.getCategory() );
        productEntity.setEndOfSalesDate( dto.getEndOfSalesDate() );

        return productEntity;
    }

    @Override
    public ProductDto mapResponse(ProductEntity vo) {
        if ( vo == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( vo.getId() );
        productDto.setCreatedAt( vo.getCreatedAt() );
        productDto.setUpdatedAt( vo.getUpdatedAt() );
        productDto.setName( vo.getName() );
        productDto.setCategory( vo.getCategory() );
        productDto.setEndOfSalesDate( vo.getEndOfSalesDate() );

        return productDto;
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

    protected BrandEntity brandDtoToBrandEntity(BrandDto brandDto) {
        if ( brandDto == null ) {
            return null;
        }

        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setId( brandDto.getId() );
        brandEntity.setName( brandDto.getName() );
        brandEntity.setPrices( priceDtoListToPriceEntityList( brandDto.getPrices() ) );

        return brandEntity;
    }

    protected PriceEntity priceDtoToPriceEntity(PriceDto priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setId( priceDto.getId() );
        priceEntity.setBrand( brandDtoToBrandEntity( priceDto.getBrand() ) );
        priceEntity.setProduct( mapRequest( priceDto.getProduct() ) );
        priceEntity.setStartDate( priceDto.getStartDate() );
        priceEntity.setEndDate( priceDto.getEndDate() );
        priceEntity.setPriceList( priceDto.getPriceList() );
        priceEntity.setPriority( priceDto.getPriority() );
        priceEntity.setPrice( priceDto.getPrice() );
        priceEntity.setCurrency( priceDto.getCurrency() );

        return priceEntity;
    }
}
