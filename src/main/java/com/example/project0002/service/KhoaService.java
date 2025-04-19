package com.example.project0002.service;

import com.example.project0002.model.Khoa;
import com.example.project0002.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaService {

    @Autowired
    private KhoaRepository khoaRepository;

    // Create
    public Khoa createKhoa(Khoa khoa) {
        Optional<Khoa> existingKhoa = khoaRepository.findByTen(khoa.getTen());
        if (existingKhoa.isPresent()) {
            throw new IllegalArgumentException("Khoa với tên " + khoa.getTen() + " đã tồn tại!");
        }
        return khoaRepository.save(khoa);
    }

    // Read (all)
    public List<Khoa> getAllKhoa() {
        return khoaRepository.findAll();
    }

    // Read (by ID)
    public Khoa getKhoaById(String id) {
        return khoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + id));
    }

    // Update
    public Khoa updateKhoa(String id, Khoa khoaDetails) {
        Khoa khoa = khoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + id));

        // Kiểm tra trùng lặp tên khoa (trừ chính khoa đang cập nhật)
        Optional<Khoa> existingKhoa = khoaRepository.findByTen(khoaDetails.getTen());
        if (existingKhoa.isPresent() && !existingKhoa.get().getId().equals(id)) {
            throw new IllegalArgumentException("Khoa với tên " + khoaDetails.getTen() + " đã tồn tại!");
        }

        khoa.setTen(khoaDetails.getTen());
        khoa.setMoTa(khoaDetails.getMoTa());
        return khoaRepository.save(khoa);
    }

    // Delete
    public void deleteKhoa(String id) {
        Khoa khoa = khoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + id));
        khoaRepository.delete(khoa);
    }
}