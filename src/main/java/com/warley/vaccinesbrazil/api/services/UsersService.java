package com.warley.vaccinesbrazil.api.services;

import com.warley.vaccinesbrazil.api.entitys.user.Users;
import com.warley.vaccinesbrazil.api.entitys.user.requests.UserPostRequestBody;
import com.warley.vaccinesbrazil.api.entitys.user.requests.mapper.UserMapper;
import com.warley.vaccinesbrazil.api.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users saveUser(UserPostRequestBody userPostRequestBody) {
        Users user = UserMapper.INSTANCE.toUser(userPostRequestBody);
        return usersRepository.save(user);
    }

}
