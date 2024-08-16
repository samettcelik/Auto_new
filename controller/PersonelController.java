package com.demo.authdemo.controller;

import java.util.List;

import com.demo.authdemo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.authdemo.entity.Material;
import com.demo.authdemo.entity.Personel;
import com.demo.authdemo.service.PersonelService;

@RestController
@RequestMapping("/api/personel")
public class PersonelController {

    @Autowired
    private PersonelService personelService;

    @Autowired
    private MaterialService materialService;

    @GetMapping("/search")
    public List<Personel> searchPersonel(@RequestParam("query") String query) {
        return personelService.searchPersonel(query);
    }

    @GetMapping("/materials")
    public List<Material> getMaterialsByPersonel(@RequestParam("perId") Long perId) {
        return personelService.getMaterialsByPersonel(perId);
    }

    @GetMapping("/count-found-materials")
    public int getFoundMaterialCountByPersonel(@RequestParam("perId") Long perId,
            @RequestParam("roomId") Long roomId) {
        return materialService.getFoundMaterialCountByPersonelAndRoom(perId, roomId);
    }

    @GetMapping("/count-not-found-materials")
    public int getNotFoundMaterialCountByPersonel(@RequestParam("perId") Long perId,
            @RequestParam("roomId") Long roomId) {
        return materialService.getNotFoundMaterialCountByPersonelAndRoom(perId, roomId);
    }

    @GetMapping("/count-total-materials")
    public int getTotalMaterialCountByPersonelAndRoom(@RequestParam("perId") Long perId,
            @RequestParam("roomId") Long roomId) {
        return materialService.getTotalMaterialCountByPersonelAndRoom(perId, roomId);
    }

}