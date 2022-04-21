package dts.com.login.controller;

import dts.com.login.entity.DataL;
import dts.com.login.service.DataLService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataLController {

    private final DataLService dataLService;

    public DataLController(DataLService dataLService) {this.dataLService = dataLService;}

    @PostMapping("/creat")
    public DataL creatData(@RequestBody DataL dataL) {
        return dataLService.createD(dataL);
    }

    @GetMapping("/all")
    public List<DataL> selecteAll() {
        return dataLService.selecteAll();
    }
}
