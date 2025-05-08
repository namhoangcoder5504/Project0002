package com.example.project0002.controller;

import com.example.project0002.model.ChuongTrinhDaoTao;
import com.example.project0002.service.ChuongTrinhDaoTaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chuongtrinhdaotao")
public class ChuongTrinhDaoTaoController {

    @Autowired
    private ChuongTrinhDaoTaoService chuongTrinhDaoTaoService;

    // Create
    @PostMapping
    public ResponseEntity<ChuongTrinhDaoTao> createChuongTrinhDaoTao(@RequestBody ChuongTrinhDaoTao chuongTrinhDaoTao) {
        ChuongTrinhDaoTao createdChuongTrinh = chuongTrinhDaoTaoService.createChuongTrinhDaoTao(chuongTrinhDaoTao);
        return ResponseEntity.ok(createdChuongTrinh);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<ChuongTrinhDaoTao>> getAllChuongTrinhDaoTao() {
        List<ChuongTrinhDaoTao> chuongTrinhList = chuongTrinhDaoTaoService.getAllChuongTrinhDaoTao();
        return ResponseEntity.ok(chuongTrinhList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<ChuongTrinhDaoTao> getChuongTrinhDaoTaoById(@PathVariable String id) {
        ChuongTrinhDaoTao chuongTrinh = chuongTrinhDaoTaoService.getChuongTrinhDaoTaoById(id);
        return ResponseEntity.ok(chuongTrinh);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ChuongTrinhDaoTao> updateChuongTrinhDaoTao(@PathVariable String id, @RequestBody ChuongTrinhDaoTao chuongTrinhDetails) {
        ChuongTrinhDaoTao updatedChuongTrinh = chuongTrinhDaoTaoService.updateChuongTrinhDaoTao(id, chuongTrinhDetails);
        return ResponseEntity.ok(updatedChuongTrinh);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChuongTrinhDaoTao(@PathVariable String id) {
        chuongTrinhDaoTaoService.deleteChuongTrinhDaoTao(id);
        return ResponseEntity.noContent().build();
    }

    // Get by NganhHoc ID
    @GetMapping("/nganhhoc/{nganhHocId}")
    public ResponseEntity<List<ChuongTrinhDaoTao>> getCTDTByNganhHocId(@PathVariable String nganhHocId) {
        List<ChuongTrinhDaoTao> chuongTrinhList = chuongTrinhDaoTaoService.getCTDTByNganhHocId(nganhHocId);
        return ResponseEntity.ok(chuongTrinhList);
    }
}