package com.warley.vaccinesbrazil.api.entitys.vaccine;

import com.warley.vaccinesbrazil.api.entitys.user.Users;
import com.warley.vaccinesbrazil.api.utils.AbstractEntity;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Vaccine extends AbstractEntity {

    @NotBlank(message = "Vaccine name cannot be null or blank!")
    private String vaccineName;

    @NotNull(message = "Application date cannot be null or blank!")
    private LocalDate applicationDate;

    @NotNull
    @ManyToOne
    private Users users;

}
