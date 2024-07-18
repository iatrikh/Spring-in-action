package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.data.CustomerRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private CustomerRepository customerRepo;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(CustomerRepository userRepo, PasswordEncoder passwordEncoder) {
        this.customerRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        customerRepo.save(form.toCustomer(passwordEncoder));
        return "redirect:/login";
    }
}
