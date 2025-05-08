package com.example.project0002.repository;

import com.example.project0002.model.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, String> {
    Optional<Khoa> findByTen(String ten);

    List<Khoa> findByTenContainingIgnoreCase(String ten);
}