package com.ojolali.isale.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mwiyono
 */
public class OrderDto {

    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private Long quantity;

    @Getter @Setter
    private Double totalPrice;

    @Getter @Setter
    private String employeeId;

}
