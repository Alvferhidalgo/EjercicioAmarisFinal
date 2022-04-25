package com.example.commons;

public interface EndpointsConstants {

  String FIND_ALL_PRICES = "/prices/findall";
  String CREATE_PRICES = "/prices/create";
  String UPDATE_PRICES = "/prices/update";
  String DELETE_PRICES = "/prices/delete/{id}";
  String FIND_BY_DATE_PRODUCT_BRAND = "/prices/findfiltered/{applicationDate}/{productId}/{brandId}";

  String FIND_ALL_PRODUCTS = "/products/findall";
  String CREATE_PRODUCTS = "/products/create";
  String UPDATE_PRODUCTS = "/products/update";
  String DELETE_PRODUCTS = "/products/delete/{id}";
}
