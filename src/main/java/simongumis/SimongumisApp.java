package simongumis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import simongumis.entities.UserEntity;
import simongumis.repositories.UserRepository;
import simongumis.views.idopontfoglalas.IdopontfoglalasView;

import java.util.logging.Logger;

@SpringBootApplication
public class SimongumisApp implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private final static Logger LOGGER = Logger.getLogger(IdopontfoglalasView.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SimongumisApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("kezdes: " + userRepository);
        UserEntity userEntity = new UserEntity("Norbi", passwordEncoder.encode("Norbi01"), null);
        userRepository.save(userEntity);
    }
}
