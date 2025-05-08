package com.example.project0002.service;

import com.example.project0002.model.CotDiem;
import com.example.project0002.model.DeCuongChiTiet;
import com.example.project0002.repository.CotDiemRepository;
import com.example.project0002.repository.DeCuongChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotDiemService {

    @Autowired
    private CotDiemRepository cotDiemRepository;

    @Autowired
    private DeCuongChiTietRepository deCuongChiTietRepository;

    // Create
    public CotDiem createCotDiem(CotDiem cotDiem) {
        Optional<CotDiem> existingCotDiem = cotDiemRepository.findByTen(cotDiem.getTen());
        if (existingCotDiem.isPresent()) {
            throw new IllegalArgumentException("Cột điểm với tên " + cotDiem.getTen() + " đã tồn tại!");
        }

        // Kiểm tra đề cương chi tiết tồn tại
        DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(cotDiem.getDeCuongChiTiet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + cotDiem.getDeCuongChiTiet().getId()));
        cotDiem.setDeCuongChiTiet(deCuongChiTiet);

        return cotDiemRepository.save(cotDiem);
    }

    // Read (all)
    public List<CotDiem> getAllCotDiem() {
        return cotDiemRepository.findAll();
    }

    // Read (by ID)
    public CotDiem getCotDiemById(String id) {
        return cotDiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cột điểm với ID: " + id));
    }

    // Update
    public CotDiem updateCotDiem(String id, CotDiem cotDiemDetails) {
        CotDiem cotDiem = cotDiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cột điểm với ID: " + id));

        // Kiểm tra trùng lặp tên cột điểm (trừ chính cột điểm đang cập nhật)
        Optional<CotDiem> existingCotDiem = cotDiemRepository.findByTen(cotDiemDetails.getTen());
        if (existingCotDiem.isPresent() && !existingCotDiem.get().getId().equals(id)) {
            throw new IllegalArgumentException("Cột điểm với tên " + cotDiemDetails.getTen() + " đã tồn tại!");
        }

        cotDiem.setTen(cotDiemDetails.getTen());
        cotDiem.setMoTa(cotDiemDetails.getMoTa());

        // Cập nhật đề cương chi tiết nếu có
        if (cotDiemDetails.getDeCuongChiTiet() != null) {
            DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(cotDiemDetails.getDeCuongChiTiet().getId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + cotDiemDetails.getDeCuongChiTiet().getId()));

            cotDiem.setDeCuongChiTiet(deCuongChiTiet);
        }

        return cotDiemRepository.save(cotDiem);
    }

    // Delete
    public void deleteCotDiem(String id) {
        CotDiem cotDiem = cotDiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cột điểm với ID: " + id));
        cotDiemRepository.delete(cotDiem);
    }

    public List<CotDiem> getCotDiemByDeCuongChiTiet(String deCuongChiTietId) {
        DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(deCuongChiTietId)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + deCuongChiTietId));

        return cotDiemRepository.findByDeCuongChiTiet_Id(deCuongChiTietId);
    }
}