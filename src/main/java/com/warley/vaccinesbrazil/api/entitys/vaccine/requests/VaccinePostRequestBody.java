package com.warley.vaccinesbrazil.api.entitys.vaccine.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VaccinePostRequestBody {

    private String vaccineName;
    private LocalDate applicationDate;
    private Long userId;

}
