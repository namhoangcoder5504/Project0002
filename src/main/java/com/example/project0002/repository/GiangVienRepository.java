package com.example.project0002.repository;

import com.example.project0002.model.GiangVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String> {
    Optional<GiangVien> findByHoTen(String hoTen);
    
    List<GiangVien> findByHoTenAndChuyenMonContainingIgnoreCase(String hoTen, String chuyenMon);
}