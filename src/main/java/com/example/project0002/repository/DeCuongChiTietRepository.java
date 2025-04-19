package com.example.project0002.repository;

import com.example.project0002.model.DeCuongChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeCuongChiTietRepository extends JpaRepository<DeCuongChiTiet, String> {
}