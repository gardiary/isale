package com.ojolali.isale.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Ivans
 */
@Entity @Table(name = "c_security_role")
public class Role {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Getter @Setter
    private String id;
    
    @NotNull
    @Column(name = "name", nullable = false, unique = true)
    @Getter @Setter
    private String name;

    @Column(name = "description")
    @Getter @Setter
    private String description;
    
    @ManyToMany
    @OrderBy("value asc")
    @JoinTable(
        name="c_security_role_permission", 
        joinColumns=@JoinColumn(name="id_role", nullable=false),
        inverseJoinColumns=@JoinColumn(name="id_permission", nullable=false)
    )
    @Getter @Setter
    private Set<Permission> permissionSet = new HashSet<Permission>();

}
