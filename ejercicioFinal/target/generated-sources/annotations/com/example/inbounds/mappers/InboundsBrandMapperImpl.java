package com.example.inbounds.mappers;

import com.example.commons.dtos.BrandDto;
import com.example.commons.dtos.PriceDto;
import com.example.commons.dtos.ProductDto;
import com.example.domain.vos.Brand;
import com.example.domain.vos.Price;
import com.example.domain.vos.Product;
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
public class InboundsBrandMapperImpl implements InboundsBrandMapper {

    @Override
    public List<BrandDto> mapResponseList(List<Brand> vos) {
        if ( vos == null ) {
            return null;
        }

        List<BrandDto> list = new ArrayList<BrandDto>( vos.size() );
        for ( Brand brand : vos ) {
            list.add( mapResponse( brand ) );
        }

        return list;
    }

    @Override
    public Brand mapRequest(BrandDto dto) {
        if ( dto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( dto.getId() );
        brand.setName( dto.getName() );
        brand.setPrices( priceDtoListToPriceList( dto.getPrices() ) );

        return brand;
    }

    @Override
    public BrandDto mapResponse(Brand vo) {
        if ( vo == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setId( vo.getId() );
        brandDto.setName( vo.getName() );

        return brandDto;
    }

    protected List<Price> priceDtoListToPriceList(List<PriceDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Price> list1 = new ArrayList<Price>( list.size() );
        for ( PriceDto priceDto : list ) {
            list1.add( priceDtoToPrice( priceDto ) );
        }

        return list1;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDto.getId() );
        product.setPrices( priceDtoListToPriceList( productDto.getPrices() ) );
        product.setCreatedAt( productDto.getCreatedAt() );
        product.setUpdatedAt( productDto.getUpdatedAt() );
        product.setName( productDto.getName() );
        product.setCategory( productDto.getCategory() );
        product.setEndOfSalesDate( productDto.getEndOfSalesDate() );

        return product;
    }

    protected Price priceDtoToPrice(PriceDto priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        Price price = new Price();

        price.setId( priceDto.getId() );
        price.setBrand( mapRequest( priceDto.getBrand() ) );
        price.setProduct( productDtoToProduct( priceDto.getProduct() ) );
        price.setStartDate( priceDto.getStartDate() );
        price.setEndDate( priceDto.getEndDate() );
        price.setPriceList( priceDto.getPriceList() );
        price.setPriority( priceDto.getPriority() );
        price.setPrice( priceDto.getPrice() );
        price.setCurrency( priceDto.getCurrency() );

        return price;
    }
}
