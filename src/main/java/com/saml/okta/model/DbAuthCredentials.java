package com.saml.okta.model;

import lombok.Data;

@Data
public class DbAuthCredentials {
    private String username;
    private String password;
}