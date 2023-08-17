package org.pracainzynierska.services;

import org.pracainzynierska.component.WSClient;
import org.pracainzynierska.model.CustomUserDetails;
import org.pracainzynierska.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

        @Autowired
        private WSClient wsClient;

        @Override
        public CustomUserDetails loadUserByUsername(String username) {
            User user = wsClient.findUserByUsername(username);

            if(user == null) {
                throw new UsernameNotFoundException("Problem during authentication!");
            }

            return new CustomUserDetails(user);
        }
}
