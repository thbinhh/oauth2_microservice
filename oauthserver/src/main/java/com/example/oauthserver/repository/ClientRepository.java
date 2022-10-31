package com.example.oauthserver.repository;

import com.example.oauthserver.entities.AppClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<AppClient, String> {
    AppClient findByClientId(String clientId);

    Optional<AppClient> findById(String id);

    Boolean existsByClientId(String clientid);
}
