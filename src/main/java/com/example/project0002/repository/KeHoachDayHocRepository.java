package com.example.project0002.repository;

import com.example.project0002.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, String> {
}