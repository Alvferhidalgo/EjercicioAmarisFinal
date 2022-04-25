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
public class InboundsPriceMapperImpl implements InboundsPriceMapper {

    @Override
    public PriceDto mapResponse(Price vo) {
        if ( vo == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setId( vo.getId() );
        priceDto.setBrand( brandToBrandDto( vo.getBrand() ) );
        priceDto.setProduct( productToProductDto( vo.getProduct() ) );
        priceDto.setStartDate( vo.getStartDate() );
        priceDto.setEndDate( vo.getEndDate() );
        priceDto.setPriceList( vo.getPriceList() );
        priceDto.setPriority( vo.getPriority() );
        priceDto.setPrice( vo.getPrice() );
        priceDto.setCurrency( vo.getCurrency() );

        return priceDto;
    }

    @Override
    public List<PriceDto> mapResponseList(List<Price> vos) {
        if ( vos == null ) {
            return null;
        }

        List<PriceDto> list = new ArrayList<PriceDto>( vos.size() );
        for ( Price price : vos ) {
            list.add( mapResponse( price ) );
        }

        return list;
    }

    @Override
    public Price mapRequest(PriceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Price price = new Price();

        price.setId( dto.getId() );
        price.setBrand( brandDtoToBrand( dto.getBrand() ) );
        price.setProduct( productDtoToProduct( dto.getProduct() ) );
        price.setStartDate( dto.getStartDate() );
        price.setEndDate( dto.getEndDate() );
        price.setPriceList( dto.getPriceList() );
        price.setPriority( dto.getPriority() );
        price.setPrice( dto.getPrice() );
        price.setCurrency( dto.getCurrency() );

        return price;
    }

    protected BrandDto brandToBrandDto(Brand brand) {
        if ( brand == null ) {
            return null;
        }

        BrandDto brandDto = new BrandDto();

        brandDto.setId( brand.getId() );
        brandDto.setName( brand.getName() );
        brandDto.setPrices( mapResponseList( brand.getPrices() ) );

        return brandDto;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setPrices( mapResponseList( product.getPrices() ) );
        productDto.setCreatedAt( product.getCreatedAt() );
        productDto.setUpdatedAt( product.getUpdatedAt() );
        productDto.setName( product.getName() );
        productDto.setCategory( product.getCategory() );
        productDto.setEndOfSalesDate( product.getEndOfSalesDate() );

        return productDto;
    }

    protected List<Price> priceDtoListToPriceList(List<PriceDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Price> list1 = new ArrayList<Price>( list.size() );
        for ( PriceDto priceDto : list ) {
            list1.add( mapRequest( priceDto ) );
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
}
