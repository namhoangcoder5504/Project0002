package com.example.project0002.controller;

import com.example.project0002.model.KeHoachMonHoc;
import com.example.project0002.service.KeHoachMonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kehoachmonhoc")
public class KeHoachMonHocController {

    @Autowired
    private KeHoachMonHocService keHoachMonHocService;

    // Create
    @PostMapping
    public ResponseEntity<KeHoachMonHoc> createKeHoachMonHoc(@RequestBody KeHoachMonHoc keHoachMonHoc) {
        KeHoachMonHoc createdKeHoachMonHoc = keHoachMonHocService.createKeHoachMonHoc(keHoachMonHoc);
        return ResponseEntity.ok(createdKeHoachMonHoc);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<KeHoachMonHoc>> getAllKeHoachMonHoc() {
        List<KeHoachMonHoc> keHoachMonHocList = keHoachMonHocService.getAllKeHoachMonHoc();
        return ResponseEntity.ok(keHoachMonHocList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<KeHoachMonHoc> getKeHoachMonHocById(@PathVariable String id) {
        KeHoachMonHoc keHoachMonHoc = keHoachMonHocService.getKeHoachMonHocById(id);
        return ResponseEntity.ok(keHoachMonHoc);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<KeHoachMonHoc> updateKeHoachMonHoc(@PathVariable String id, @RequestBody KeHoachMonHoc keHoachMonHocDetails) {
        KeHoachMonHoc updatedKeHoachMonHoc = keHoachMonHocService.updateKeHoachMonHoc(id, keHoachMonHocDetails);
        return ResponseEntity.ok(updatedKeHoachMonHoc);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKeHoachMonHoc(@PathVariable String id) {
        keHoachMonHocService.deleteKeHoachMonHoc(id);
        return ResponseEntity.noContent().build();
    }
}