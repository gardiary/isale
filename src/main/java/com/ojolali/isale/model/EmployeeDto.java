package com.ojolali.isale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class EmployeeDto {
	

    
    @Getter @Setter
    private String name;


    @Getter @Setter
    private String address;


    @Getter @Setter
    private String staffRole;


    @Getter @Setter
    private String phoneNo;
    
    
    @Getter @Setter
    private Date joinedDate;

    

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
    @Column(name = "birth_date_str	")
    private String birthDateStr;

    
}
