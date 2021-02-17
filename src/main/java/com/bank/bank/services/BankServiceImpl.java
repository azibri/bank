/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.services;

import com.bank.bank.entities.Nasabah;
import com.bank.bank.repository.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asus
 */
@Service
public class BankServiceImpl implements BankService{

    @Autowired
    private BankRepo nasabahRepo;
    
    @Override
    public Iterable<Nasabah> findAllData() {
        return nasabahRepo.findAll();
    }

    @Override
    public Nasabah findDataById(Integer id) {
        return nasabahRepo.findById(id).get();
    }

    @Override
    public void saveData(Nasabah nasabah) {
        nasabahRepo.save(nasabah);
    }

    @Override
    public void deleteData(Integer id) {
        nasabahRepo.deleteById(id);
    }

    @Override
    public Iterable<Nasabah> findByNasabahNoktp(String nasabahNoktp) {
        return nasabahRepo.findByNasabahNoktp(nasabahNoktp);
    }
    
}
