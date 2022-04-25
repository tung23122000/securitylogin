package dts.com.login.service.impl;

import dts.com.login.entity.CustomDataDetails;
import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import dts.com.login.service.DataLService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DataLServiceImpl implements DataLService {

//@Autowired
//    PasswordEncoder passwordEncoder;
    private final  DataLRespository dataLRespository;
    private final  PasswordEncoder passwordEncoder;

    public DataLServiceImpl(DataLRespository dataLRespository,
                            PasswordEncoder passwordEncoder) {
        this.dataLRespository = dataLRespository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public DataL save(DataL dataL) {
        dataL.setPassword(this.passwordEncoder.encode(dataL.getPassword()));
        return this.dataLRespository.save(dataL);

    }

    @Override
    public DataL updateUser(long id, DataL dataL) {
        DataL inDB = dataLRespository.getById(id);
        inDB.setLastUpdated(LocalDateTime.now());
        return dataLRespository.save(inDB);
    }



}
