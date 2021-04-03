package com.warley.vaccinesbrazil.api.entitys.user.requests;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class UserPostRequestBody {

    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;

}
