package com.example.project0002.service;

import com.example.project0002.model.KeHoachMonHoc;
import com.example.project0002.model.HocPhan;
import com.example.project0002.repository.KeHoachMonHocRepository;
import com.example.project0002.repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeHoachMonHocService {

    @Autowired
    private KeHoachMonHocRepository keHoachMonHocRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    // Create
    public KeHoachMonHoc createKeHoachMonHoc(KeHoachMonHoc keHoachMonHoc) {
        // Kiểm tra học phần tồn tại
        HocPhan hocPhan = hocPhanRepository.findById(keHoachMonHoc.getHocPhan().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + keHoachMonHoc.getHocPhan().getId()));
        keHoachMonHoc.setHocPhan(hocPhan);

        return keHoachMonHocRepository.save(keHoachMonHoc);
    }

    // Read (all)
    public List<KeHoachMonHoc> getAllKeHoachMonHoc() {
        return keHoachMonHocRepository.findAll();
    }

    // Read (by ID)
    public KeHoachMonHoc getKeHoachMonHocById(String id) {
        return keHoachMonHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch môn học với ID: " + id));
    }

    // Update
    public KeHoachMonHoc updateKeHoachMonHoc(String id, KeHoachMonHoc keHoachMonHocDetails) {
        KeHoachMonHoc keHoachMonHoc = keHoachMonHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch môn học với ID: " + id));

        keHoachMonHoc.setNamHoc(keHoachMonHocDetails.getNamHoc());
        keHoachMonHoc.setSoLuong(keHoachMonHocDetails.getSoLuong());
        keHoachMonHoc.setThoiGianBatDauThuc(keHoachMonHocDetails.getThoiGianBatDauThuc());
        keHoachMonHoc.setThoiGianKetThuc(keHoachMonHocDetails.getThoiGianKetThuc());

        // Cập nhật học phần nếu có
        if (keHoachMonHocDetails.getHocPhan() != null) {
            HocPhan hocPhan = hocPhanRepository.findById(keHoachMonHocDetails.getHocPhan().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + keHoachMonHocDetails.getHocPhan().getId()));
            keHoachMonHoc.setHocPhan(hocPhan);
        }

        return keHoachMonHocRepository.save(keHoachMonHoc);
    }

    // Delete
    public void deleteKeHoachMonHoc(String id) {
        KeHoachMonHoc keHoachMonHoc = keHoachMonHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch môn học với ID: " + id));
        keHoachMonHocRepository.delete(keHoachMonHoc);
    }

    public List<KeHoachMonHoc> getKeHoachMonHocByNamHocAndHocPhan(int namHoc, String hocPhanId) {
        return keHoachMonHocRepository.findByNamHocAndHocPhan_Id(namHoc, hocPhanId);
    }
}