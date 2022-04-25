package dts.com.login.controller;

import dts.com.login.entity.DataL;
import dts.com.login.service.DataLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DataLController {


    private final DataLService dataLService;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataLController(DataLService dataLService,
                           BCryptPasswordEncoder passwordEncoder) {
        this.dataLService = dataLService;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/user")
    public DataL createUser(@RequestBody DataL user) {
        return this.dataLService.save(user);
    }

    @PutMapping("/api/1.0/users/{id}")
    public DataL updateUser(@PathVariable long id, @RequestBody DataL user) {
        return this.dataLService.updateUser(id, user);
    }
}
