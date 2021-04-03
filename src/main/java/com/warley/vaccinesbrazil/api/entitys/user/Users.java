package com.warley.vaccinesbrazil.api.entitys.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.warley.vaccinesbrazil.api.entitys.vaccine.Vaccine;
import com.warley.vaccinesbrazil.api.utils.AbstractEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static java.time.format.DateTimeFormatter.*;

@Data
@Entity
public class Users extends AbstractEntity {

    @NotBlank(message = "Name cannot be null or blank!")
    private String name;

    @Email
    @NotBlank(message = "Email cannot be null or blank!")
    @Column(unique = true)
    private String email;

    @CPF
    @NotBlank(message = "CPF cannot be null or blank!")
    @Column(unique = true)
    private String cpf;

    @NotNull(message = "Birth Date cannot be null!")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private List<Vaccine> vaccines;


}