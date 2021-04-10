package com.saurabh.example.springrestpractice.resources;

import com.saurabh.example.springrestpractice.exceptions.UserNotFoundException;
import com.saurabh.example.springrestpractice.models.User;
import com.saurabh.example.springrestpractice.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class UserResource {

//    Delete user     DELETE /users/1

    @Autowired
    private UserDaoService userDaoService;
    //   Get all Users   GET       /users
    @GetMapping(path = "/users")
    public List<User> allUsers(){
        return userDaoService.findAll();
    }

    //    Get one user   GET      /users/{id}
    @GetMapping(path = "/users/{userId}")
    public User retriveUser(@PathVariable("userId") int userId){
        User retrivedUser=userDaoService.findOne(userId);
        if(Objects.isNull(retrivedUser))
            throw new UserNotFoundException("user "+userId+" Not found");
        return retrivedUser;
    }
//Create user     POST     /users
    //input  - details of user
    //output - CREATED  & created uri
    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
    User createdUser=userDaoService.adduser(user);
    //Okay we have a response , we have to return 2 things

        //2 uri of created resource
        URI location= getURILocation("{id}",createdUser);
       return ResponseEntity.created(location).build();//1 http status code 201 Created
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        User user=userDaoService.deleteById(userId);
        if(Objects.isNull(user))
            throw new UserNotFoundException(userId+" doesn't exists to delete ");
    }

    private URI getURILocation(String param,User createdUser) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(param)
                .buildAndExpand(createdUser.getUserId())
                .toUri();
    }

}

