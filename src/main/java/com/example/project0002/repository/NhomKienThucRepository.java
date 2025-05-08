package com.example.project0002.repository;

import com.example.project0002.model.NhomKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhomKienThucRepository extends JpaRepository<NhomKienThuc, String> {
    Optional<NhomKienThuc> findByTen(String ten);

    List<NhomKienThuc> findByChuongTrinhDaoTao_Id(String id);
}