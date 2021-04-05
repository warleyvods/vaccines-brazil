package com.warley.vaccinesbrazil.api.entitys.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warley.vaccinesbrazil.api.entitys.vaccine.Vaccine;
import com.warley.vaccinesbrazil.api.utils.AbstractEntity;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Users users = (Users) o;
        return Objects.equals(name, users.name) && Objects.equals(email, users.email)
                && Objects.equals(cpf, users.cpf) && Objects.equals(birthDate, users.birthDate)
                && Objects.equals(vaccines, users.vaccines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, cpf, birthDate, vaccines);
    }
}
