/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.bank.controller;

import com.bank.bank.entities.Nasabah;
import com.bank.bank.services.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asus
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class BankRestController {
    
    @Autowired
    private BankServiceImpl nasabahServiceImpl;
    
    @GetMapping("/bank")
    public Iterable<Nasabah> findAllNasabah() {
        return nasabahServiceImpl.findAllData();
    }
    
    //mendapatkan data berdasarkan id
    @GetMapping("/bank/{id}")
    public ResponseEntity<Nasabah> findNasabahById(@PathVariable Integer id){
        Nasabah nasabah = nasabahServiceImpl.findDataById(id);
        return ResponseEntity.ok(nasabah);
    }
    
    //menyimapan data
    @PostMapping("/bank")
    public void saveNasabah(@RequestBody Nasabah nasabah) {
        nasabahServiceImpl.saveData(nasabah);
    }
    
    //update data
    @PutMapping("/bank/{id}")
    public ResponseEntity<Nasabah> updateNasabah(@PathVariable Integer id, @RequestBody Nasabah nasabahdetails) {
        Nasabah nasabah = nasabahServiceImpl.findDataById(id);
        
//        nasabah.setNasabahId(nasabahdetails.getNasabahId());
        nasabah.setNasabahNama(nasabahdetails.getNasabahNama());
        nasabah.setNasabahAlamat(nasabahdetails.getNasabahAlamat());
        nasabah.setNasabahTempatlahir(nasabahdetails.getNasabahTempatlahir());
        nasabah.setNasabahTanggallahir(nasabahdetails.getNasabahTanggallahir());
        nasabah.setNasabahNoktp(nasabahdetails.getNasabahNoktp());
        nasabah.setNasabahNohandphone(nasabahdetails.getNasabahNohandphone());
        nasabah.setNasabahEmail(nasabahdetails.getNasabahEmail());
        
        nasabahServiceImpl.saveData(nasabah);
        return new ResponseEntity<>(nasabah, HttpStatus.OK);
    }
    
    //menghapus data
    @DeleteMapping("/bank/{id}")
    public void deleteNasabah(@PathVariable Integer id) {
        nasabahServiceImpl.deleteData(id);
    }
    
    
    //mengambil data berdasarkan no KTP
    @GetMapping("bank/ktp/{ktp}")
    public Iterable<Nasabah> findByKTP(@PathVariable String ktp) {
        
//        char noktp = ktp.toCharArray();
//        for (char noktp : ktp.toCharArray()) {
//            System.out.println("noktp" + noktp);
//        }
//        Iterable<Nasabah> nasabah = nasabahServiceImpl.findByNasabahNoktp(ktp);
        return nasabahServiceImpl.findByNasabahNoktp(ktp);
    }
    
}
