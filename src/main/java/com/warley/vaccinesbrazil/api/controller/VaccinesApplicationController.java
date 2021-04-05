package com.warley.vaccinesbrazil.api.controller;

import com.warley.vaccinesbrazil.api.entitys.vaccine.Vaccine;
import com.warley.vaccinesbrazil.api.entitys.vaccine.requests.VaccinePostRequestBody;
import com.warley.vaccinesbrazil.api.services.VaccineApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("vaccines")
public class VaccinesApplicationController {

    private final VaccineApplicationService vaccineApplicationService;

    public VaccinesApplicationController(VaccineApplicationService vaccineApplicationService) {
        this.vaccineApplicationService = vaccineApplicationService;
    }

    @PostMapping("/saveVaccineApplication")
    public ResponseEntity<Vaccine> saveVaccineApplication(@Valid @RequestBody VaccinePostRequestBody vaccinePostRequestBody) {
        return new ResponseEntity<>(vaccineApplicationService.saveVaccineApplication(vaccinePostRequestBody), HttpStatus.CREATED);
    }

}
