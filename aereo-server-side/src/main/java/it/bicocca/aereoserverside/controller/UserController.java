package it.bicocca.aereoserverside.controller;

import it.bicocca.aereoserverside.DTO.UserDTO;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.services.impl.FidelityCardServiceImpl;
import it.bicocca.aereoserverside.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private FidelityCardServiceImpl fidelityCardService;

    @CrossOrigin
    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody UserDTO userDTO) {
        System.out.println(userDTO);

        User newUser = new User(userDTO, fidelityCardService.saveCard());
        return userService.save(newUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }


}//end class
