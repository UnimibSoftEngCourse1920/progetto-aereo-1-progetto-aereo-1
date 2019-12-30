package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository {
    Optional<User> getById(Long id);
    Optional<User> getByEmail(String email);
}//end interface
