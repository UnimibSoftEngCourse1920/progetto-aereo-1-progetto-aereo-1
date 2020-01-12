package it.bicocca.aereoserverside.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register/{test}")
    /*public ResponseEntity registerUser(
            @RequestParam(name = "user") String userStr) //to be checked
    throws JsonProcessingException {
        User user = new ObjectMapper().readValue(userStr, User.class);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);*/
    public ResponseEntity registerUser(@PathVariable String test){
        System.out.println(test);
        return new ResponseEntity<>(HttpStatus.CREATED);
}

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }


}//end class
