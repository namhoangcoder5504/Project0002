package com.example.project0002.repository;

import com.example.project0002.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {
    Optional<HocPhan> findByTen(String ten);
}