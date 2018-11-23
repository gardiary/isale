/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ojolali.isale.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ojolali.isale.model.PasswordResetToken;
import com.ojolali.isale.model.User;

@Repository
public interface PasswordResetTokenDao extends PagingAndSortingRepository<PasswordResetToken, String> {

    PasswordResetToken findByUser(User user);

    PasswordResetToken findByToken(String token);

    @Modifying
    @Query("DELETE PasswordResetToken prt WHERE prt.expiryDate <= :now")
    void deleteExpiredToken(@Param("now") Date date);
}
