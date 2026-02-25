package com.example.weather.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.weather.model.WeatherRecord;

@Repository
public interface WeatherRecordRepository extends JpaRepository<WeatherRecord, Long> {
    List<WeatherRecord> findByDatetimeUtc(String datetimeUtc);
}
