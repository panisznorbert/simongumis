package simongumis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import simongumis.entities.UserEntity;
import simongumis.repositories.UserRepository;

import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));


        return new User(username, user.getPassword(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }
}
