package com.warley.vaccinesbrazil.api.entitys.vaccine.requests;

import java.time.LocalDate;


public class VaccinePostRequestBody {

    private String vaccineName;
    private LocalDate applicationDate;
    private Long userId;

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
