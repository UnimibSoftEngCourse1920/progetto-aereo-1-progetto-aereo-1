package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.exception.UserNotFoundException;

public interface UserService {
    User getByMail(String email) throws UserNotFoundException;
    User getById(Integer id) throws UserNotFoundException;
}//end class
