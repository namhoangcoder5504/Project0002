package com.example.project0002.controller;

import com.example.project0002.model.Khoa;
import com.example.project0002.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khoa")
public class KhoaController {

    @Autowired
    private KhoaService khoaService;

    // Create
    @PostMapping
    public ResponseEntity<Khoa> createKhoa(@RequestBody Khoa khoa) {
        Khoa createdKhoa = khoaService.createKhoa(khoa);
        return ResponseEntity.ok(createdKhoa);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Khoa>> getAllKhoa() {
        List<Khoa> khoaList = khoaService.getAllKhoa();
        return ResponseEntity.ok(khoaList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Khoa> getKhoaById(@PathVariable String id) {
        Khoa khoa = khoaService.getKhoaById(id);
        return ResponseEntity.ok(khoa);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Khoa> updateKhoa(@PathVariable String id, @RequestBody Khoa khoaDetails) {
        Khoa updatedKhoa = khoaService.updateKhoa(id, khoaDetails);
        return ResponseEntity.ok(updatedKhoa);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhoa(@PathVariable String id) {
        khoaService.deleteKhoa(id);
        return ResponseEntity.noContent().build();
    }

    // Search
    @GetMapping("/search")
    public ResponseEntity<List<Khoa>> searchKhoa(@RequestParam String ten) {
        List<Khoa> khoaList = khoaService.searchKhoa(ten);
        return ResponseEntity.ok(khoaList);
    }
}