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
@Table(name="carts")
public class Cart {
	
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
    @Column(name = "price", nullable = false, unique = true)
    @Getter @Setter
    private Double price;

    @NotNull
    @Column(name = "image")
    @Getter @Setter
    private String image;
    

    @NotNull
    @Column(name = "quantity")
    @Getter @Setter
    private Long quantity;

}
