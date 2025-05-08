package com.example.project0002.service;

import com.example.project0002.model.ChuongTrinhDaoTao;
import com.example.project0002.model.NganhHoc;
import com.example.project0002.repository.ChuongTrinhDaoTaoRepository;
import com.example.project0002.repository.NganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChuongTrinhDaoTaoService {

    @Autowired
    private ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

    @Autowired
    private NganhHocRepository nganhHocRepository;

    // Create
    public ChuongTrinhDaoTao createChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
        Optional<ChuongTrinhDaoTao> existingChuongTrinh = chuongTrinhDaoTaoRepository.findByTen(chuongTrinhDaoTao.getTen());
        if (existingChuongTrinh.isPresent()) {
            throw new IllegalArgumentException("Chương trình đào tạo với tên " + chuongTrinhDaoTao.getTen() + " đã tồn tại!");
        }

        // Kiểm tra ngành học tồn tại
        NganhHoc nganhHoc = nganhHocRepository.findById(chuongTrinhDaoTao.getNganhHoc().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ngành học với ID: " + chuongTrinhDaoTao.getNganhHoc().getId()));

        chuongTrinhDaoTao.setNganhHoc(nganhHoc);

        return chuongTrinhDaoTaoRepository.save(chuongTrinhDaoTao);
    }

    // Read (all)
    public List<ChuongTrinhDaoTao> getAllChuongTrinhDaoTao() {
        return chuongTrinhDaoTaoRepository.findAll();
    }

    // Read (by ID)
    public ChuongTrinhDaoTao getChuongTrinhDaoTaoById(String id) {
        return chuongTrinhDaoTaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy chương trình đào tạo với ID: " + id));
    }

    // Update
    public ChuongTrinhDaoTao updateChuongTrinhDaoTao(String id, ChuongTrinhDaoTao chuongTrinhDetails) {
        ChuongTrinhDaoTao chuongTrinh = chuongTrinhDaoTaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy chương trình đào tạo với ID: " + id));

        // Kiểm tra trùng lặp tên chương trình (trừ chính chương trình đang cập nhật)
        Optional<ChuongTrinhDaoTao> existingChuongTrinh = chuongTrinhDaoTaoRepository.findByTen(chuongTrinhDetails.getTen());
        if (existingChuongTrinh.isPresent() && !existingChuongTrinh.get().getId().equals(id)) {
            throw new IllegalArgumentException("Chương trình đào tạo với tên " + chuongTrinhDetails.getTen() + " đã tồn tại!");
        }

        // Cập nhật thông tin
        chuongTrinh.setTen(chuongTrinhDetails.getTen());
        chuongTrinh.setHeDaoTao(chuongTrinhDetails.getHeDaoTao());
        chuongTrinh.setTrinhDo(chuongTrinhDetails.getTrinhDo());
        chuongTrinh.setTongTinChi(chuongTrinhDetails.getTongTinChi());
        chuongTrinh.setThoiGianDaoTao(chuongTrinhDetails.getThoiGianDaoTao());

        // Cập nhật ngành học nếu có
        if (chuongTrinhDetails.getNganhHoc() != null) {
            NganhHoc nganhHoc = nganhHocRepository.findById(chuongTrinhDetails.getNganhHoc().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ngành học với ID: " + chuongTrinhDetails.getNganhHoc().getId()));
            chuongTrinh.setNganhHoc(nganhHoc);
        }

        return chuongTrinhDaoTaoRepository.save(chuongTrinh);
    }

    // Delete
    public void deleteChuongTrinhDaoTao(String id) {
        ChuongTrinhDaoTao chuongTrinh = chuongTrinhDaoTaoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy chương trình đào tạo với ID: " + id));
        chuongTrinhDaoTaoRepository.delete(chuongTrinh);
    }

    public List<ChuongTrinhDaoTao> getCTDTByNganhHocId(String id) {
        return chuongTrinhDaoTaoRepository.findByNganhHoc_Id(id);
    }
}