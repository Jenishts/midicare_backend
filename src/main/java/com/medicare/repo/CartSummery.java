package com.medicare.repo;

public interface CartSummery {

    Integer getProductId();

    String getProductName();

    Double getPrice();

    Double getDiscountPrice();

    boolean getProductAvailability();


}
