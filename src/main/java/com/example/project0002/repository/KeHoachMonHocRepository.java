package com.example.project0002.repository;

import com.example.project0002.model.KeHoachMonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHoachMonHocRepository extends JpaRepository<KeHoachMonHoc, String> {
    List<KeHoachMonHoc> findByNamHocAndHocPhan_Id(int namHoc, String hocPhan_id);
}