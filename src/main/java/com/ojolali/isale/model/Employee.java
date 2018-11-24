package com.ojolali.isale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employees")
@ToString
public class Employee {
	
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


    @Column(name = "staffRole")
    @Getter @Setter
    private String staffRole;


    @Column(name = "phone_no")
    @Getter @Setter
    private String phoneNo;
    
    
    @Column(name = "joinedDate")
    @Getter @Setter
    private Date joinedDate;

    @OneToOne
    @JoinColumn(name = "id_user")
    @Getter @Setter
    private User user;
    

    @Email
    @Getter @Setter
    @Column( unique = true)
    private String email;


    @Getter @Setter
    @Column(name = "birth_place")
    private String birthPlace;


//    @Getter @Setter
////    @DateTimeFormat(pattern="dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
//    @Column(name = "birth_date")
//    private Date birthDate;

    @Getter @Setter
//    @DateTimeFormat(pattern="dd/MM/yyyy")
//    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private String birthDateStr;

    
}
