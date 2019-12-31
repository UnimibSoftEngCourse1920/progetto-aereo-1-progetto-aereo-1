package it.bicocca.aereoserverside.services;

import it.bicocca.aereoserverside.entity.User;
import it.bicocca.aereoserverside.exception.NotFoundException;

public interface UserService {
    User getByMail(String email) throws NotFoundException;
    User getById(Long id) throws NotFoundException;
}//end class
