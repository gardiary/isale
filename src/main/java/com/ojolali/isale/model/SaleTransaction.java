package com.ojolali.isale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="sale_trans")
public class SaleTransaction {
	
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Getter @Setter
    private String id;

    
    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    @Getter @Setter
    private String name;

    @NotNull
    @Column(name = "retail_price")
    @Getter @Setter
    private Double retailPrice;


    @NotNull
    @Column(name = "wholesale_price")
    @Getter @Setter
    private Double wholesalePrice;


    @NotNull
    @Column(name = "quantity")
    @Getter @Setter
    private Long quantity;
    
    
    @ManyToOne
//    @NotNull
    @JoinColumn(name = "product_id")
    private Product product;


}
