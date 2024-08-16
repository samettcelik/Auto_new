package com.demo.authdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.authdemo.entity.Material;
import com.demo.authdemo.entity.Personel;
import com.demo.authdemo.repository.MaterialRepository;
import com.demo.authdemo.repository.PersonelRepository;

@Service
public class PersonelService {

    @Autowired
    private PersonelRepository personelRepository;
    @Autowired
    private MaterialRepository materialRepository;

    public List<Personel> searchPersonel(String query) {
        return personelRepository.findBySicilNoOrAdSoyadContainingIgnoreCase(query, query);
    }
    
    public List<Personel> SearchPersonel(String query) {
        return personelRepository.searchPersonelWithRoom(query);
    }
       public List<Material> getMaterialsByPersonel(Long perId) {
        return materialRepository.findByPersonelPerId(perId);
    }
    
}