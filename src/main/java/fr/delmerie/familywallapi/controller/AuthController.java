package fr.delmerie.familywallapi.controller;

import fr.delmerie.familywallapi.dao.RoleRepository;
import fr.delmerie.familywallapi.entities.Role;
import fr.delmerie.familywallapi.entities.Users;
import fr.delmerie.familywallapi.services.impl.RoleServiceImpl;
import fr.delmerie.familywallapi.services.impl.UserServiceImpl;
import fr.delmerie.familywallapi.utils.error.AlwaysExistException;
import fr.delmerie.familywallapi.utils.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody Users userToSignin) {
        Users user = null;
        if (!userService.isEmailOrUsernameToken(userToSignin.getEmail(), userToSignin.getUsername())) {
            List<Role> role = new ArrayList<>();
            role.add(roleService.getOneById(2).get());
            user = new Users((Long) null, userToSignin.getEmail(), userToSignin.getUsername(),
                    encoder.encode(userToSignin.getPassword()),
                    true, role);
            userService.save(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body("ERROR");
    }
}
