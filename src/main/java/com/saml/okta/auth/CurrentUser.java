package com.saml.okta.auth;

import java.lang.annotation.*;

/**
 * Represents the current authenticated user during HTTP requests
 * @author rohangupta
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
