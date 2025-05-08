package com.example.project0002.repository;

import com.example.project0002.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, String> {
    List<KeHoachDayHoc> findByHocKyAndHocPhan_Id(int hocKy, String hocPhan_id);
}