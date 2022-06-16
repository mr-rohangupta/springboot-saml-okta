package com.saml.okta.repository;

import com.saml.okta.model.StoredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<StoredUser,String> {

    Optional<StoredUser> findByUsernameIgnoreCase(String username);
}
