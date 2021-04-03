package com.warley.vaccinesbrazil.api.services;

import com.warley.vaccinesbrazil.api.entitys.user.Users;
import com.warley.vaccinesbrazil.api.entitys.vaccine.Vaccine;
import com.warley.vaccinesbrazil.api.entitys.vaccine.requests.VaccinePostRequestBody;
import com.warley.vaccinesbrazil.api.entitys.vaccine.requests.mapper.VaccineMapper;
import com.warley.vaccinesbrazil.api.error.UserNotFoundException;
import com.warley.vaccinesbrazil.api.repository.UsersRepository;
import com.warley.vaccinesbrazil.api.repository.VaccineApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class VaccineApplicationService {

    private final VaccineApplicationRepository vaccineApplicationRepository;
    private final UsersRepository usersRepository;

    public VaccineApplicationService(VaccineApplicationRepository vaccineApplicationRepository,
                                     UsersRepository usersRepository) {
        this.vaccineApplicationRepository = vaccineApplicationRepository;
        this.usersRepository = usersRepository;
    }

    public Vaccine saveVaccineApplication(VaccinePostRequestBody vaccinePostRequestBody) {
        Users users = usersRepository.findById(vaccinePostRequestBody.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found in database, please make sure you entered the id correctly!"));
        Vaccine vac = VaccineMapper.INSTANCE.toVaccine(vaccinePostRequestBody);
        vac.setUsers(users);
        return vaccineApplicationRepository.save(vac);
    }

}
