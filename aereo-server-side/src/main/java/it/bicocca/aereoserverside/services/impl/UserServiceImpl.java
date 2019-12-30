package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.exception.UserNotFoundException;
import it.bicocca.aereoserverside.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return (User) userRepository.save(user); //to be fixed
    }

    public User getByMail(String mail) throws UserNotFoundException {
        return userRepository.getByEmail(mail).orElseThrow(
                () -> new UserNotFoundException("User not found"));
    }

    public User getById(Long id) throws UserNotFoundException {
        return userRepository.getById(id).orElseThrow(
                () -> new UserNotFoundException("User not found"));
    }

}//end class