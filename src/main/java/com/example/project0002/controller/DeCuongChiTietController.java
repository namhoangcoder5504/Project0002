package com.example.project0002.controller;

import com.example.project0002.model.DeCuongChiTiet;
import com.example.project0002.service.DeCuongChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/decuongchitiet")
public class DeCuongChiTietController {

    @Autowired
    private DeCuongChiTietService deCuongChiTietService;

    // Create
    @PostMapping
    public ResponseEntity<DeCuongChiTiet> createDeCuongChiTiet(@RequestBody DeCuongChiTiet deCuongChiTiet) {
        DeCuongChiTiet createdDeCuongChiTiet = deCuongChiTietService.createDeCuongChiTiet(deCuongChiTiet);
        return ResponseEntity.ok(createdDeCuongChiTiet);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<DeCuongChiTiet>> getAllDeCuongChiTiet() {
        List<DeCuongChiTiet> deCuongChiTietList = deCuongChiTietService.getAllDeCuongChiTiet();
        return ResponseEntity.ok(deCuongChiTietList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<DeCuongChiTiet> getDeCuongChiTietById(@PathVariable String id) {
        DeCuongChiTiet deCuongChiTiet = deCuongChiTietService.getDeCuongChiTietById(id);
        return ResponseEntity.ok(deCuongChiTiet);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<DeCuongChiTiet> updateDeCuongChiTiet(@PathVariable String id, @RequestBody DeCuongChiTiet deCuongChiTietDetails) {
        DeCuongChiTiet updatedDeCuongChiTiet = deCuongChiTietService.updateDeCuongChiTiet(id, deCuongChiTietDetails);
        return ResponseEntity.ok(updatedDeCuongChiTiet);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeCuongChiTiet(@PathVariable String id) {
        deCuongChiTietService.deleteDeCuongChiTiet(id);
        return ResponseEntity.noContent().build();
    }
}