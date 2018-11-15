package com.ojolali.isale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "c_security_permission")
public class Permission {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Getter @Setter
    private String id;

    @NotNull
    @NotEmpty
    @Column(name = "permission_label", nullable = false, unique = false)
    @Getter @Setter
    private String label;

    @NotNull
    @NotEmpty
    @Column(name = "permission_value", nullable = false, unique = true)
    @Getter @Setter
    private String value;

    @Override
    public String toString() {
        return value;
    }

}

