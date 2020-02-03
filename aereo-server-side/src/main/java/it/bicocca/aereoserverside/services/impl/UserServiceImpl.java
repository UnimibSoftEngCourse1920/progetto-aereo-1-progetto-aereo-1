package it.bicocca.aereoserverside.services.impl;

import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.exception.NotFoundException;
import it.bicocca.aereoserverside.repository.UserRepository;
import it.bicocca.aereoserverside.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByMail(String mail) throws NotFoundException {
        return userRepository.getByEmail(mail);
    }

    @Override
    public User getById(Long id) throws NotFoundException {
        return userRepository.getById(id);
    }

}//end class