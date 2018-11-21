package com.ojolali.isale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Getter @Setter
    private String id;
    
    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    @Getter @Setter
    private String name;

    @Column(name = "price")
    @Getter @Setter
    private Double price;
    

    @Column(name = "unit_type")
    @Getter @Setter
    private String unitType;

}
