package simongumis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import simongumis.entities.UserEntity;
import simongumis.repositories.UserRepository;

@SpringBootApplication
@EntityScan(basePackages = "simongumis.entities")
public class SimongumisApp implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SimongumisApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = new UserEntity("Norbi", passwordEncoder.encode("Norbi01"), null);
        userRepository.save(userEntity);
    }
}
