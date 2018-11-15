package com.ojolali.isale.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employees")
public class Employee {
	
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
    @Column(name = "address", nullable = false)
    @Getter @Setter
    private String address;
    

    @NotNull
    @Column(name = "phone_no", nullable = false)
    @Getter @Setter
    private String phoneNo;
    
    
    @NotNull
    @Column(name = "joinedDate")
    @Getter @Setter
    private Date joinedDate;

    @OneToOne
    @JoinColumn(name = "id_user")
    @Getter @Setter
    private User user;
    

    @Email
    @NotNull
    @NotEmpty
    @Getter @Setter
    @Column(nullable = false, unique = true)
    private String email;


    @NotNull
    @NotEmpty
    @Getter @Setter
    @Column(name = "birth_place")
    private String birthPlace;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Getter @Setter
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    
    
}
