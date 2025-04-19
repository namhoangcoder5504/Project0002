package com.example.project0002.controller;

import com.example.project0002.model.CotDiem;
import com.example.project0002.service.CotDiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotdiem")
public class CotDiemController {

    @Autowired
    private CotDiemService cotDiemService;

    // Create
    @PostMapping
    public ResponseEntity<CotDiem> createCotDiem(@RequestBody CotDiem cotDiem) {
        CotDiem createdCotDiem = cotDiemService.createCotDiem(cotDiem);
        return ResponseEntity.ok(createdCotDiem);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<CotDiem>> getAllCotDiem() {
        List<CotDiem> cotDiemList = cotDiemService.getAllCotDiem();
        return ResponseEntity.ok(cotDiemList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<CotDiem> getCotDiemById(@PathVariable String id) {
        CotDiem cotDiem = cotDiemService.getCotDiemById(id);
        return ResponseEntity.ok(cotDiem);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CotDiem> updateCotDiem(@PathVariable String id, @RequestBody CotDiem cotDiemDetails) {
        CotDiem updatedCotDiem = cotDiemService.updateCotDiem(id, cotDiemDetails);
        return ResponseEntity.ok(updatedCotDiem);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCotDiem(@PathVariable String id) {
        cotDiemService.deleteCotDiem(id);
        return ResponseEntity.noContent().build();
    }
}