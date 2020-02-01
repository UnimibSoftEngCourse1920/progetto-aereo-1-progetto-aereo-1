package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User getByMail(String email) throws NotFoundException;
    User getById(Long id) throws NotFoundException;
    List<User> getAll();

}//end class
