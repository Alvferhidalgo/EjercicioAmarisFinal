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
    date = "2022-04-20T13:39:20+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class OutboundsPriceMapperImpl implements OutboundsPriceMapper {

    @Override
    public PriceDto mapResponse(PriceEntity vo) {
        if ( vo == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setId( vo.getId() );
        priceDto.setBrand( brandEntityToBrandDto( vo.getBrand() ) );
        priceDto.setProduct( productEntityToProductDto( vo.getProduct() ) );
        priceDto.setStartDate( vo.getStartDate() );
        priceDto.setEndDate( vo.getEndDate() );
        priceDto.setPriceList( vo.getPriceList() );
        priceDto.setPriority( vo.getPriority() );
        priceDto.setPrice( vo.getPrice() );
        priceDto.setCurrency( vo.getCurrency() );

        return priceDto;
    }

    @Override
    public List<PriceDto> mapResponseList(List<PriceEntity> vos) {
        if ( vos == null ) {
            return null;
        }

        List<PriceDto> list = new ArrayList<PriceDto>( vos.size() );
        for ( PriceEntity priceEntity : vos ) {
            list.add( mapResponse( priceEntity ) );
        }

        return list;
    }

    @Override
    public PriceEntity mapRequest(PriceDto dto) {
        if ( dto == null ) {
            return null;
        }

        PriceEntity priceEntity = new PriceEntity();

        priceEntity.setId( dto.getId() );
        priceEntity.setBrand( brandDtoToBrandEntity( dto.getBrand() ) );
        priceEntity.setProduct( productDtoToProductEntity( dto.getProduct() ) );
        priceEntity.setStartDate( dto.getStartDate() );
        priceEntity.setEndDate( dto.getEndDate() );
        priceEntity.setPriceList( dto.getPriceList() );
        priceEntity.setPriority( dto.getPriority() );
        priceEntity.setPrice( dto.getPrice() );
        priceEntity.setCurrency( dto.getCurrency() );

        return priceEntity;
    }

    protected BrandDto brandEntityToBrandDto(BrandEntity brandEntity) {
        if ( brandEntity == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setId( brandEntity.getId() );
        brandDto.setName( brandEntity.getName() );
        brandDto.setPrices( mapResponseList( brandEntity.getPrices() ) );

        return brandDto;
    }

    protected ProductDto productEntityToProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( productEntity.getId() );
        productDto.setPrices( mapResponseList( productEntity.getPrices() ) );
        productDto.setCreatedAt( productEntity.getCreatedAt() );
        productDto.setUpdatedAt( productEntity.getUpdatedAt() );
        productDto.setName( productEntity.getName() );
        productDto.setCategory( productEntity.getCategory() );
        productDto.setEndOfSalesDate( productEntity.getEndOfSalesDate() );

        return productDto;
    }

    protected List<PriceEntity> priceDtoListToPriceEntityList(List<PriceDto> list) {
        if ( list == null ) {
            return null;
        }

        List<PriceEntity> list1 = new ArrayList<PriceEntity>( list.size() );
        for ( PriceDto priceDto : list ) {
            list1.add( mapRequest( priceDto ) );
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
}
