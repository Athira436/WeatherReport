package com.example.weather.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.weather.model.WeatherRecord;
import com.example.weather.service.WeatherRecordService;

@Component
public class CsvDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(CsvDataLoader.class);

    private final WeatherRecordService service;

    public CsvDataLoader(WeatherRecordService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) throws Exception {
        long existing = service.findAll().size();
        if (existing > 0) {
            log.info("Database already contains {} records — skipping CSV import.", existing);
            return;
        }

        InputStream in = getClass().getClassLoader().getResourceAsStream("testset.csv");
        if (in == null) {
            log.warn("testset.csv not found on classpath — skipping import");
            return;
        }

        List<WeatherRecord> loaded = new ArrayList<>();

        try (BufferedReader r = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String header = r.readLine();
            if (header == null) {
                log.warn("testset.csv is empty");
                return;
            }

            String line;
            while ((line = r.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] cols = line.split(",", -1);
                // Trim all columns
                for (int i = 0; i < cols.length; i++) cols[i] = cols[i].trim();

                // Ensure we have up to 20 columns expected by WeatherRecord constructor
                String[] vals = new String[20];
                for (int i = 0; i < vals.length; i++) {
                    vals[i] = i < cols.length ? cols[i] : null;
                    if ("".equals(vals[i])) vals[i] = null;
                }

                WeatherRecord rec = new WeatherRecord(
                        vals[0], // datetimeUtc
                        vals[1], // conds
                        vals[2], // dewptm
                        vals[3], // fog
                        vals[4], // hail
                        vals[5], // heatindexm
                        vals[6], // hum
                        vals[7], // precipm
                        vals[8], // pressurem
                        vals[9], // rain
                        vals[10], // snow
                        vals[11], // tempm
                        vals[12], // thunder
                        vals[13], // tornado
                        vals[14], // vism
                        vals[15], // wdird
                        vals[16], // wdire
                        vals[17], // wgustm
                        vals[18], // windchillm
                        vals[19]  // wspdm
                );

                loaded.add(service.create(rec));
            }
        }

        log.info("Imported {} weather records from CSV.", loaded.size());
    }

}
