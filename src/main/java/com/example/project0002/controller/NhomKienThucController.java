package com.example.project0002.controller;

import com.example.project0002.model.NhomKienThuc;
import com.example.project0002.service.NhomKienThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhomkienthuc")
public class NhomKienThucController {

    @Autowired
    private NhomKienThucService nhomKienThucService;

    // Create
    @PostMapping
    public ResponseEntity<NhomKienThuc> createNhomKienThuc(@RequestBody NhomKienThuc nhomKienThuc) {
        NhomKienThuc createdNhomKienThuc = nhomKienThucService.createNhomKienThuc(nhomKienThuc);
        return ResponseEntity.ok(createdNhomKienThuc);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<NhomKienThuc>> getAllNhomKienThuc() {
        List<NhomKienThuc> nhomKienThucList = nhomKienThucService.getAllNhomKienThuc();
        return ResponseEntity.ok(nhomKienThucList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<NhomKienThuc> getNhomKienThucById(@PathVariable String id) {
        NhomKienThuc nhomKienThuc = nhomKienThucService.getNhomKienThucById(id);
        return ResponseEntity.ok(nhomKienThuc);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<NhomKienThuc> updateNhomKienThuc(@PathVariable String id, @RequestBody NhomKienThuc nhomKienThucDetails) {
        NhomKienThuc updatedNhomKienThuc = nhomKienThucService.updateNhomKienThuc(id, nhomKienThucDetails);
        return ResponseEntity.ok(updatedNhomKienThuc);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhomKienThuc(@PathVariable String id) {
        nhomKienThucService.deleteNhomKienThuc(id);
        return ResponseEntity.noContent().build();
    }

    // Get by ChuongTrinhDaoTao ID
    @GetMapping("/chuongtrinhdaotao/{chuongTrinhDaoTaoId}")
    public ResponseEntity<List<NhomKienThuc>> getNhomKienThucByChuongTrinhDaoTaoId(@PathVariable String chuongTrinhDaoTaoId) {
        List<NhomKienThuc> nhomKienThucList = nhomKienThucService.getNhomKienThucByChuongTrinhDaoTaoId(chuongTrinhDaoTaoId);
        return ResponseEntity.ok(nhomKienThucList);
    }
}