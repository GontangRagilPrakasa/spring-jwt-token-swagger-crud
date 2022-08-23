package com.tutorial.jwtauthentication.component;

import com.tutorial.jwtauthentication.model.UserRoles;
import com.tutorial.jwtauthentication.model.Users;
import com.tutorial.jwtauthentication.repository.UserRepository;
import com.tutorial.jwtauthentication.repository.UserRoleRepository;
import com.tutorial.jwtauthentication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
//@Component
public class ApplicationOnStartup implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("Running On Application Event");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Users users1 = userRepository.findByUsername("admin");
        Users users2 = userRepository.findByUsername("user");


            Users admin = Users.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .businessTitle("Administrator")
                    .fullName("Gontang Ragil Prakasa")
                    .build();

            Users user = Users.builder()
                    .username("user")
                    .password(passwordEncoder.encode("user"))
                    .businessTitle("Only User")
                    .fullName("Gontang Ragil Prakasa Users")
                    .build();
            List<Users> users = new ArrayList<>();
            users.add(user);
            users.add(admin);
            userRepository.saveAll(users);


            UserRoles adminRoleADmin = UserRoles.builder()
                    .users(admin)
                    .role("ROLE_ADMIN")
                    .build();

            UserRoles adminRoleUser = UserRoles.builder()
                    .users(admin)
                    .role("ROLE_USER")
                    .build();

            UserRoles userRoleUser = UserRoles.builder()
                    .users(user)
                    .role("ROLE_USER")
                    .build();

            List<UserRoles> userRoles = new ArrayList<>();
            userRoles.add(adminRoleADmin);
            userRoles.add(adminRoleUser);
            userRoles.add(userRoleUser);

            userRoleRepository.saveAll(userRoles);

    }
}
