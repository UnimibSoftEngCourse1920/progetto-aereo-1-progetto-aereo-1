package it.bicocca.aereoserverside.repository;

import it.bicocca.aereoserverside.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    User getByEmail(String email);
}//end interface
