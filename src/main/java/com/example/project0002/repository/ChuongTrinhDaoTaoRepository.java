package com.example.project0002.repository;

import com.example.project0002.model.ChuongTrinhDaoTao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChuongTrinhDaoTaoRepository extends JpaRepository<ChuongTrinhDaoTao, String> {
    Optional<ChuongTrinhDaoTao> findByTen(String ten);
}