package com.example.weather.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String datetimeUtc;
    private String conds;
    private String dewptm;
    private String fog;
    private String hail;
    private String heatindexm;
    private String hum;
    private String precipm;
    private String pressurem;
    private String rain;
    private String snow;
    private String tempm;
    private String thunder;
    private String tornado;
    private String vism;
    private String wdird;
    private String wdire;
    private String wgustm;
    private String windchillm;
    private String wspdm;

    public WeatherRecord() {}

    public WeatherRecord(String datetimeUtc, String conds, String dewptm, String fog, String hail,
                         String heatindexm, String hum, String precipm, String pressurem, String rain,
                         String snow, String tempm, String thunder, String tornado, String vism,
                         String wdird, String wdire, String wgustm, String windchillm, String wspdm) {
        this.datetimeUtc = datetimeUtc;
        this.conds = conds;
        this.dewptm = dewptm;
        this.fog = fog;
        this.hail = hail;
        this.heatindexm = heatindexm;
        this.hum = hum;
        this.precipm = precipm;
        this.pressurem = pressurem;
        this.rain = rain;
        this.snow = snow;
        this.tempm = tempm;
        this.thunder = thunder;
        this.tornado = tornado;
        this.vism = vism;
        this.wdird = wdird;
        this.wdire = wdire;
        this.wgustm = wgustm;
        this.windchillm = windchillm;
        this.wspdm = wspdm;
    }

    public String getDatetimeUtc() { return datetimeUtc; }
    public void setDatetimeUtc(String datetimeUtc) { this.datetimeUtc = datetimeUtc; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConds() { return conds; }
    public void setConds(String conds) { this.conds = conds; }

    public String getDewptm() { return dewptm; }
    public void setDewptm(String dewptm) { this.dewptm = dewptm; }

    public String getFog() { return fog; }
    public void setFog(String fog) { this.fog = fog; }

    public String getHail() { return hail; }
    public void setHail(String hail) { this.hail = hail; }

    public String getHeatindexm() { return heatindexm; }
    public void setHeatindexm(String heatindexm) { this.heatindexm = heatindexm; }

    public String getHum() { return hum; }
    public void setHum(String hum) { this.hum = hum; }

    public String getPrecipm() { return precipm; }
    public void setPrecipm(String precipm) { this.precipm = precipm; }

    public String getPressurem() { return pressurem; }
    public void setPressurem(String pressurem) { this.pressurem = pressurem; }

    public String getRain() { return rain; }
    public void setRain(String rain) { this.rain = rain; }

    public String getSnow() { return snow; }
    public void setSnow(String snow) { this.snow = snow; }

    public String getTempm() { return tempm; }
    public void setTempm(String tempm) { this.tempm = tempm; }

    public String getThunder() { return thunder; }
    public void setThunder(String thunder) { this.thunder = thunder; }

    public String getTornado() { return tornado; }
    public void setTornado(String tornado) { this.tornado = tornado; }

    public String getVism() { return vism; }
    public void setVism(String vism) { this.vism = vism; }

    public String getWdird() { return wdird; }
    public void setWdird(String wdird) { this.wdird = wdird; }

    public String getWdire() { return wdire; }
    public void setWdire(String wdire) { this.wdire = wdire; }

    public String getWgustm() { return wgustm; }
    public void setWgustm(String wgustm) { this.wgustm = wgustm; }

    public String getWindchillm() { return windchillm; }
    public void setWindchillm(String windchillm) { this.windchillm = windchillm; }

    public String getWspdm() { return wspdm; }
    public void setWspdm(String wspdm) { this.wspdm = wspdm; }

    @Override
    public String toString() {
        return "WeatherRecord{" +
                "datetimeUtc='" + datetimeUtc + '\'' +
                ", conds='" + conds + '\'' +
                ", tempm='" + tempm + '\'' +
                ", hum='" + hum + '\'' +
                ", wspdm='" + wspdm + '\'' +
                '}';
    }

}
