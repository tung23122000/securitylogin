package dts.com.login.controller;

import dts.com.login.entity.DataL;
import dts.com.login.service.DataLService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataLController {
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    private final DataLService dataLService;
    private final BCryptPasswordEncoder passwordEncoder;
    public DataLController(DataLService dataLService,
                           BCryptPasswordEncoder passwordEncoder) {this.dataLService = dataLService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/creat")
    public DataL creatData(@RequestBody DataL dataL) {
        dataL.setPassword(this.passwordEncoder.encode(dataL.getPassword()));
        return dataLService.createD(dataL);
    }

    @GetMapping("/all")
    public List<DataL> selecteAll() {
        return dataLService.selecteAll();
    }
}
