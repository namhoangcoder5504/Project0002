package com.example.project0002.service;

import com.example.project0002.model.PhanCongGiangDay;
import com.example.project0002.model.GiangVien;
import com.example.project0002.repository.PhanCongGiangDayRepository;
import com.example.project0002.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhanCongGiangDayService {

    @Autowired
    private PhanCongGiangDayRepository phanCongGiangDayRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    // Create
    public PhanCongGiangDay createPhanCongGiangDay(PhanCongGiangDay phanCongGiangDay) {
        // Kiểm tra giảng viên tồn tại
        GiangVien giangVien = giangVienRepository.findById(phanCongGiangDay.getGiangVien().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy giảng viên với ID: " + phanCongGiangDay.getGiangVien().getId()));
        phanCongGiangDay.setGiangVien(giangVien);

        return phanCongGiangDayRepository.save(phanCongGiangDay);
    }

    // Read (all)
    public List<PhanCongGiangDay> getAllPhanCongGiangDay() {
        return phanCongGiangDayRepository.findAll();
    }

    // Read (by ID)
    public PhanCongGiangDay getPhanCongGiangDayById(String id) {
        return phanCongGiangDayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy phân công giảng dạy với ID: " + id));
    }

    // Update
    public PhanCongGiangDay updatePhanCongGiangDay(String id, PhanCongGiangDay phanCongGiangDayDetails) {
        PhanCongGiangDay phanCongGiangDay = phanCongGiangDayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy phân công giảng dạy với ID: " + id));

        phanCongGiangDay.setSoTiet(phanCongGiangDayDetails.getSoTiet());

        // Cập nhật giảng viên nếu có
        if (phanCongGiangDayDetails.getGiangVien() != null) {
            GiangVien giangVien = giangVienRepository.findById(phanCongGiangDayDetails.getGiangVien().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy giảng viên với ID: " + phanCongGiangDayDetails.getGiangVien().getId()));
            phanCongGiangDay.setGiangVien(giangVien);
        }

        return phanCongGiangDayRepository.save(phanCongGiangDay);
    }

    // Delete
    public void deletePhanCongGiangDay(String id) {
        PhanCongGiangDay phanCongGiangDay = phanCongGiangDayRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy phân công giảng dạy với ID: " + id));
        phanCongGiangDayRepository.delete(phanCongGiangDay);
    }
}