package com.ojolali.isale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="customers")
@ToString
public class Customer {
	/**
Payment_method (Cash/Credit Card)
Payment_status (Paid/Unpaid)
	 */
	
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Getter @Setter
    private String id;

    
    @NotNull
    @Column(name = "name")
    @Getter @Setter
    private String name;


    @Column(name = "address")
    @Getter @Setter
    private String address;
    

    @Column(name = "phone_no")
    @Getter @Setter
    private String phoneNo;
    


    @Email
    @Getter @Setter
    @Column( unique = true)
    private String email;

    
}
