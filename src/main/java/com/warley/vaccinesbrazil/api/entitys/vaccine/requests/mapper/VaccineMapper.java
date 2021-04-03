package com.warley.vaccinesbrazil.api.entitys.vaccine.requests.mapper;

import com.warley.vaccinesbrazil.api.entitys.vaccine.Vaccine;
import com.warley.vaccinesbrazil.api.entitys.vaccine.requests.VaccinePostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public abstract class VaccineMapper {

    public static final VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    @Mapping(target = "users.id", source = "userId")
    public abstract Vaccine toVaccine(VaccinePostRequestBody vaccinePostRequestBody);

}
