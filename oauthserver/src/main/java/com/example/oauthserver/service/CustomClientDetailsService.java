package com.example.oauthserver.service;

import com.example.oauthserver.entities.AppClient;
import com.example.oauthserver.entities.CustomClientDetail;
import com.example.oauthserver.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        AppClient appClient = clientRepository.findByClientId(clientId);

        if(appClient == null)
        {
            throw new ClientRegistrationException("client with "+clientId+" is not available");
        }
        return new CustomClientDetail(appClient);
    }
}
