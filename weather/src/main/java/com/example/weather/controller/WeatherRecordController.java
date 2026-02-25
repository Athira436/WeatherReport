package com.example.weather.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weather.model.WeatherRecord;
import com.example.weather.repository.WeatherRecordRepository;

@RestController
@RequestMapping("/weather")
public class WeatherRecordController {

	@Autowired
	private WeatherRecordRepository repo;

	@GetMapping
	public List<WeatherRecord> listAll() {
		return repo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WeatherRecord> getOne(@PathVariable Long id) {
		return repo.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public WeatherRecord create(@RequestBody WeatherRecord record) {
		return repo.save(record);
	}

	@PutMapping("/{id}")
	public ResponseEntity<WeatherRecord> update(@PathVariable Long id, @RequestBody WeatherRecord updated) {
		return repo.findById(id).map(existing -> {
			updated.setId(existing.getId());
			return ResponseEntity.ok(repo.save(updated));
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		return repo.findById(id).map(r -> {
			repo.deleteById(id);
			return ResponseEntity.noContent().<Void>build();
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
