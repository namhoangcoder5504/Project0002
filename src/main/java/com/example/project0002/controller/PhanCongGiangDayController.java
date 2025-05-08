package com.example.project0002.controller;

import com.example.project0002.model.PhanCongGiangDay;
import com.example.project0002.service.PhanCongGiangDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phanconggiangday")
public class PhanCongGiangDayController {
    @Autowired
    private PhanCongGiangDayService phanCongGiangDayService;

    // Create
    @PostMapping
    public ResponseEntity<PhanCongGiangDay> createPhanCongGiangDay(@RequestBody PhanCongGiangDay phanCongGiangDay) {
        PhanCongGiangDay createdPhanCongGiangDay = phanCongGiangDayService.createPhanCongGiangDay(phanCongGiangDay);
        return ResponseEntity.ok(createdPhanCongGiangDay);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<PhanCongGiangDay>> getAllPhanCongGiangDay() {
        List<PhanCongGiangDay> phanCongGiangDayList = phanCongGiangDayService.getAllPhanCongGiangDay();
        return ResponseEntity.ok(phanCongGiangDayList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<PhanCongGiangDay> getPhanCongGiangDayById(@PathVariable String id) {
        PhanCongGiangDay phanCongGiangDay = phanCongGiangDayService.getPhanCongGiangDayById(id);
        return ResponseEntity.ok(phanCongGiangDay);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<PhanCongGiangDay> updatePhanCongGiangDay(@PathVariable String id, @RequestBody PhanCongGiangDay phanCongGiangDayDetails) {
        PhanCongGiangDay updatedPhanCongGiangDay = phanCongGiangDayService.updatePhanCongGiangDay(id, phanCongGiangDayDetails);
        return ResponseEntity.ok(updatedPhanCongGiangDay);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhanCongGiangDay(@PathVariable String id) {
        phanCongGiangDayService.deletePhanCongGiangDay(id);
        return ResponseEntity.noContent().build();
    }

    // Search
    @GetMapping("/search")
    public ResponseEntity<List<PhanCongGiangDay>> searchPhanCongGiangDay(@RequestParam String query) {
        List<PhanCongGiangDay> results = phanCongGiangDayService.searchPhanCongGiangDay(query);
        return ResponseEntity.ok(results);
    }

    // Get GiangVien PhanCongGiangDay by ID
    @GetMapping("/giangvien/{id}")
    public ResponseEntity<List<PhanCongGiangDay>> getGiangVienPhanConGiangDayById(@PathVariable String id) {
        List<PhanCongGiangDay> results = phanCongGiangDayService.getGiangVienPhanConGiangDayById(id);
        return ResponseEntity.ok(results);
    }
}