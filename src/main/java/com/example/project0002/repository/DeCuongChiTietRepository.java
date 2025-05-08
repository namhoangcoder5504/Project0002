package com.example.project0002.repository;

import com.example.project0002.model.DeCuongChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeCuongChiTietRepository extends JpaRepository<DeCuongChiTiet, String> {
    List<DeCuongChiTiet> findByHocPhan_Id(String id);
}