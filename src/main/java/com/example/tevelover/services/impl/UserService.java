package com.example.tevelover.services.impl;

import com.example.tevelover.dto.UserDto;
import com.example.tevelover.model.User;
import com.example.tevelover.repository.IUserRepository;
import com.example.tevelover.services.iface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .address(userDto.getAddress())
                .gender(userDto.getGender())
                .age(userDto.getAge())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User listFindById(Long id) {
        Optional<User> userOpt= userRepository.findById(id);
        return userOpt.orElse(null);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> listAllPagination(int page) {
        Pageable elements = PageRequest.of(page-1, 10);
        Page<User> users= userRepository.findAll(elements);
        return users;
    }

    @Override
    public User editUser(Long id, UserDto userDto) {
        Optional<User> userOpt= userRepository.findById(id);
        if(userOpt.isPresent()) {
            User user = userOpt.get();
             user = User.builder()
                     .id(id)
                    .name(userDto.getName())
                    .lastName(userDto.getLastName())
                    .address(userDto.getAddress())
                    .gender(userDto.getGender())
                    .age(userDto.getAge())
                     .datetime(user.getDatetime())
                    .build();
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOpt= userRepository.findById(id);
        if(userOpt.isPresent()){
            userRepository.deleteById(id);
        }
    }
}
