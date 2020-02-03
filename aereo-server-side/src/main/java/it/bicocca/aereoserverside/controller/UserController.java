package it.bicocca.aereoserverside.controller;

import it.bicocca.aereoserverside.DTO.UserDTO;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.services.impl.FidelityCardServiceImpl;
import it.bicocca.aereoserverside.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @CrossOrigin
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @CrossOrigin
    @GetMapping("/user/{mail}/{password}")
    public User getUserByEmail(@PathVariable String mail,
                               @PathVariable String password) {
        User loggedU = userService.getByMail(mail);
        if((loggedU != null) && (loggedU.getPassword().equals(password))) {
            return loggedU;
        }
        return null;
    }
}//end class
