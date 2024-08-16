package com.demo.authdemo.controller;

import com.demo.authdemo.entity.Material;
import com.demo.authdemo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping("/total/{roomId}")
    public ResponseEntity<Integer> getTotalMaterialCount(@PathVariable Long roomId) {
        int totalMaterials = materialService.getTotalMaterialCount(roomId);
        return ResponseEntity.ok(totalMaterials);
    }

    @GetMapping("/found/{roomId}")
    public ResponseEntity<Integer> getFoundMaterialCount(@PathVariable Long roomId) {
        int foundMaterials = materialService.getFoundMaterialCount(roomId);
        return ResponseEntity.ok(foundMaterials);
    }

    @GetMapping("/other-locations/{roomId}")
    public ResponseEntity<Integer> getMaterialCountInOtherLocations(@PathVariable Long roomId) {
        int materialsInOtherLocations = materialService.getMaterialCountInOtherLocations(roomId);
        return ResponseEntity.ok(materialsInOtherLocations);
    }

    @PostMapping("/update-status")
    public ResponseEntity<String> updateMaterialStatus(@RequestParam Long barkodNo, @RequestParam boolean found) {
        materialService.updateMaterialStatus(barkodNo, found);
        return ResponseEntity.ok("Material status updated");
    }

    // Yeni Endpoint: Barkod ile Materyal ve İlişkili Verileri Getir
    @GetMapping("/details/{barkodNo}")
    public ResponseEntity<Material> getMaterialDetails(@PathVariable Long barkodNo) {
        Material material = materialService.getMaterialDetailsByBarkodNo(barkodNo);
        return ResponseEntity.ok(material);
    }

    @PostMapping("/update-status-by-params")
    public ResponseEntity<String> updateMaterialStatusByParams(@RequestParam Long roomId,
            @RequestParam Long perId,
            @RequestParam Long barkodNo,
            @RequestParam boolean found) {
        materialService.updateMaterialStatusByParams(roomId, perId, barkodNo, found);
        return ResponseEntity.ok("Material status updated with parameters");
    }
}
