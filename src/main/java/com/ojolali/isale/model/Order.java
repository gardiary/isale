package com.ojolali.isale.model;

import java.util.Date;

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
@Table(name="orders")
public class Order {

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
    @Column(name = "transactionDate")
    @Getter @Setter
    private Date transactionDate;
}
