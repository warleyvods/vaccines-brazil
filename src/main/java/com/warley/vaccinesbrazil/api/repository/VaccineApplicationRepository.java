package com.warley.vaccinesbrazil.api.repository;

import com.warley.vaccinesbrazil.api.entitys.vaccine.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccineApplicationRepository extends JpaRepository<Vaccine, Long> {
}
