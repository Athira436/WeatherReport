package com.example.weather.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.weather.model.WeatherRecord;
import com.example.weather.repository.WeatherRecordRepository;

@Service
public class WeatherRecordService {

    private final WeatherRecordRepository repo;

    @Autowired
    public WeatherRecordService(WeatherRecordRepository repo) {
        this.repo = repo;
    }

    public List<WeatherRecord> findAll() {
        return repo.findAll();
    }

    public WeatherRecord findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException("WeatherRecord not found: " + id));
    }

    public WeatherRecord create(WeatherRecord record) {
        return repo.save(record);
    }

    @Transactional
    public WeatherRecord update(Long id, WeatherRecord updated) {
        WeatherRecord existing = repo.findById(id).orElseThrow(() -> new NoSuchElementException("WeatherRecord not found: " + id));
        existing.setDatetimeUtc(updated.getDatetimeUtc());
        existing.setConds(updated.getConds());
        existing.setDewptm(updated.getDewptm());
        existing.setFog(updated.getFog());
        existing.setHail(updated.getHail());
        existing.setHeatindexm(updated.getHeatindexm());
        existing.setHum(updated.getHum());
        existing.setPrecipm(updated.getPrecipm());
        existing.setPressurem(updated.getPressurem());
        existing.setRain(updated.getRain());
        existing.setSnow(updated.getSnow());
        existing.setTempm(updated.getTempm());
        existing.setThunder(updated.getThunder());
        existing.setTornado(updated.getTornado());
        existing.setVism(updated.getVism());
        existing.setWdird(updated.getWdird());
        existing.setWdire(updated.getWdire());
        existing.setWgustm(updated.getWgustm());
        existing.setWindchillm(updated.getWindchillm());
        existing.setWspdm(updated.getWspdm());
        return repo.save(existing);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("WeatherRecord not found: " + id);
        }
        repo.deleteById(id);
    }

}

