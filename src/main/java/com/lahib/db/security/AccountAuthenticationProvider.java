package com.lahib.db.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Adil on 4/19/2017.
 */
@Component
@Slf4j
public class AccountAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    /**
     * A Spring Security UserDetailsService implementation based upon the
     * Account entity model.
     */
    @Autowired
    private AccountUserDetailsService userDetailsService;

    /**
     * A PasswordEncoder instance to hash clear text password values.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        log.debug("> additionalAuthenticationChecks");

        if (token.getCredentials() == null
                || userDetails.getPassword() == null) {
            throw new BadCredentialsException("Credentials may not be null.");
        }

        if (!passwordEncoder.matches((String) token.getCredentials(),
                userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials.");
        }

        log.debug("< additionalAuthenticationChecks");
    }

    @Override
    protected UserDetails retrieveUser(String username,
                                       UsernamePasswordAuthenticationToken token)
            throws AuthenticationException {
        log.debug("> retrieveUser");

        UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        log.debug("< retrieveUser");
        return userDetails;
    }
}
