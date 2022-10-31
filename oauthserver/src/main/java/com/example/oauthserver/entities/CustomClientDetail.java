package com.example.oauthserver.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;


public class CustomClientDetail implements ClientDetails {
    private AppClient appClient;

    public CustomClientDetail(AppClient client) {
        this.appClient=client;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {

        return this.appClient.getAccessTokenValidity();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {

        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> ga=new ArrayList<GrantedAuthority>();
        ga.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        return ga;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {

        String[]  gt=this.appClient.getAuthorizedGrantTypes().split(",");

        Set<String> gts=new HashSet<String>();

        for(String s:gt)
            gts.add(s);
		gts.stream().forEach(System.out::println);

        return gts;
    }

    @Override
    public String getClientId() {

        return this.appClient.getClientId();
    }

    @Override
    public String getClientSecret() {
        return this.appClient.getClientSecret();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {

        return this.appClient.getRefreshTokenValidity();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {

        String[]  gt=this.appClient.getWebServerRedirectUri().split(",");

        Set<String> gts=new HashSet<String>();

        for(String s:gt)
            gts.add(s);

        return gts;
    }

    @Override
    public Set<String> getResourceIds() {

        String[]  gt=this.appClient.getResourceIds().split(",");

        Set<String> gts=new HashSet<String>();

        for(String s:gt)
            gts.add(s);

        return gts;
    }

    @Override
    public Set<String> getScope() {

        String[]  gt=this.appClient.getScope().split(",");

        Set<String> gts=new HashSet<String>();

        for(String s:gt)
            gts.add(s);

        return gts;
    }

    @Override
    public boolean isAutoApprove(String arg0) {

        return false;
    }

    @Override
    public boolean isScoped() {

        return true;
    }

    @Override
    public boolean isSecretRequired() {

        return true;
    }
}
