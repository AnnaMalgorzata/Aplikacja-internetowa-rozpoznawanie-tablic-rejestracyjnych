package org.pracainzynierska.services;

import org.pracainzynierska.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {

    @Autowired
    private JpaUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private HttpSession session;

    // nie sprawdza? ale pobiera użytkownika o podanym username z bazy
    // i następnie sprawdza czy podane hasło jest odpowienie
    // w funkcji checkPassword sprawdzamy również czy użytkownik,
    // który chce się zalogować ma uprawnienia administratora
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        CustomUserDetails user = userDetailsService.loadUserByUsername(username);

        return checkPassword(user, password, bCryptPasswordEncoder);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

    private Authentication checkPassword(CustomUserDetails user, String rawPassword, PasswordEncoder encoder) {

        if (encoder.matches(rawPassword, user.getPassword())) {
            int userId = user.getUser().getId();
            session.setAttribute("userId", userId);

            boolean isAdmin = user.getUser().isAdmin();
            session.setAttribute("admin", new Boolean(isAdmin).toString());

            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        } else {
            throw new BadCredentialsException("Bad credentials");
        }

    }
}
