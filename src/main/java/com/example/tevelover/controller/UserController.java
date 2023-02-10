package com.example.tevelover.controller;

import com.example.tevelover.dto.UserDto;
import com.example.tevelover.model.User;
import com.example.tevelover.services.iface.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<User> createUser( @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listUser( @PathVariable Long id){
        return  ResponseEntity.ok().body(userService.listFindById(id));
    }

    @GetMapping
    public  ResponseEntity<List<User>> listUsers(){
        return  ResponseEntity.ok().body(userService.listAll());
    }

    @GetMapping("/pagination")
    public  ResponseEntity<Page<User>> pageUsers(@RequestParam int page){
        return  ResponseEntity.ok().body(userService.listAllPagination(page));
    }


    @PutMapping("/{id}")
    public  ResponseEntity<User> editeUsers( @PathVariable(value="id")  Long id, @RequestBody UserDto userDto ){
        return  ResponseEntity.ok().body(userService.editUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser( @PathVariable Long id){
        userService.deleteUser(id);
        return  ResponseEntity.noContent().build();
    }

}
