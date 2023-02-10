package com.example.tevelover.services.iface;

import com.example.tevelover.dto.UserDto;
import com.example.tevelover.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    User createUser (UserDto userDto);

    User  listFindById(Long id);

     List<User> listAll();

     Page<User> listAllPagination(int page);

     User editUser(Long id, UserDto userDto );

     void  deleteUser(Long id);

}
