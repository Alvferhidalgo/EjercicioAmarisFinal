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
public class InboundsProductMapperImpl implements InboundsProductMapper {

    @Override
    public List<ProductDto> mapResponseList(List<Product> vos) {
        if ( vos == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( vos.size() );
        for ( Product product : vos ) {
            list.add( mapResponse( product ) );
        }

        return list;
    }

    @Override
    public Product mapRequest(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( dto.getId() );
        product.setPrices( priceDtoListToPriceList( dto.getPrices() ) );
        product.setCreatedAt( dto.getCreatedAt() );
        product.setUpdatedAt( dto.getUpdatedAt() );
        product.setName( dto.getName() );
        product.setCategory( dto.getCategory() );
        product.setEndOfSalesDate( dto.getEndOfSalesDate() );

        return product;
    }

    @Override
    public ProductDto mapResponse(Product vo) {
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

    protected Brand brandDtoToBrand(BrandDto brandDto) {
        if ( brandDto == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setId( brandDto.getId() );
        brand.setName( brandDto.getName() );
        brand.setPrices( priceDtoListToPriceList( brandDto.getPrices() ) );

        return brand;
    }

    protected Price priceDtoToPrice(PriceDto priceDto) {
        if ( priceDto == null ) {
            return null;
        }

        Price price = new Price();

        price.setId( priceDto.getId() );
        price.setBrand( brandDtoToBrand( priceDto.getBrand() ) );
        price.setProduct( mapRequest( priceDto.getProduct() ) );
        price.setStartDate( priceDto.getStartDate() );
        price.setEndDate( priceDto.getEndDate() );
        price.setPriceList( priceDto.getPriceList() );
        price.setPriority( priceDto.getPriority() );
        price.setPrice( priceDto.getPrice() );
        price.setCurrency( priceDto.getCurrency() );

        return price;
    }
}
