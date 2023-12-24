package rs.raf.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import rs.raf.demo.model.*;
import rs.raf.demo.repositories.*;


@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public BootstrapData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Loading Data...");

        User admin = new User();
        admin.setName("Admin");
        admin.setSurname("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword(this.passwordEncoder.encode("admin"));
        admin.setPermissions("can_create_users,can_read_users,can_update_users,can_delete_users");
        this.userRepository.save(admin);

        User c = new User();
        c.setName("c");
        c.setSurname("c");
        c.setEmail("c@gmail.com");
        c.setPassword(this.passwordEncoder.encode("c"));
        c.setPermissions("can_create_users");
        this.userRepository.save(c);

        User r = new User();
        r.setName("r");
        r.setSurname("r");
        r.setEmail("r@gmail.com");
        r.setPassword(this.passwordEncoder.encode("r"));
        r.setPermissions("can_read_users");
        this.userRepository.save(r);

        User n = new User();
        n.setName("n");
        n.setSurname("n");
        n.setEmail("n@gmail.com");
        n.setPassword(this.passwordEncoder.encode("n"));
        this.userRepository.save(n);

        System.out.println("Data loaded!");
    }
}
