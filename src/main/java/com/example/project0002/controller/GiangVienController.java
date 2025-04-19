package com.example.project0002.controller;

import com.example.project0002.model.GiangVien;
import com.example.project0002.service.GiangVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/giangvien")
public class GiangVienController {

    @Autowired
    private GiangVienService giangVienService;

    // Create
    @PostMapping
    public ResponseEntity<GiangVien> createGiangVien(@RequestBody GiangVien giangVien) {
        GiangVien createdGiangVien = giangVienService.createGiangVien(giangVien);
        return ResponseEntity.ok(createdGiangVien);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<GiangVien>> getAllGiangVien() {
        List<GiangVien> giangVienList = giangVienService.getAllGiangVien();
        return ResponseEntity.ok(giangVienList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<GiangVien> getGiangVienById(@PathVariable String id) {
        GiangVien giangVien = giangVienService.getGiangVienById(id);
        return ResponseEntity.ok(giangVien);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<GiangVien> updateGiangVien(@PathVariable String id, @RequestBody GiangVien giangVienDetails) {
        GiangVien updatedGiangVien = giangVienService.updateGiangVien(id, giangVienDetails);
        return ResponseEntity.ok(updatedGiangVien);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiangVien(@PathVariable String id) {
        giangVienService.deleteGiangVien(id);
        return ResponseEntity.noContent().build();
    }
}