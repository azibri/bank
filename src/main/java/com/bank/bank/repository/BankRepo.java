/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.repository;

import com.bank.bank.entities.Nasabah;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author asus
 */
@Repository
public interface BankRepo extends CrudRepository<Nasabah, Integer> {
    public Iterable<Nasabah> findByNasabahNoktp(@Param("nasabahNoktp") String nasabahNoktp);
}
