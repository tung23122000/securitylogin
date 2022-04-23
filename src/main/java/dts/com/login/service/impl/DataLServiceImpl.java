package dts.com.login.service.impl;

import dts.com.login.entity.CustomDataDetails;
import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import dts.com.login.service.DataLService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DataLServiceImpl implements DataLService {

//@Autowired
//    PasswordEncoder passwordEncoder;

    private final DataLRespository dataLRespository;
    private final BCryptPasswordEncoder passwordEncoder;
    public DataLServiceImpl(DataLRespository dataLRespository,
                            BCryptPasswordEncoder passwordEncoder) {
        this.dataLRespository = dataLRespository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DataL createD(DataL dataL) {
//        String encoderPa = this.passwordEncoder.encode(dataL.getPassword());
//       dataL.setPassword(encoderPa);
        return dataLRespository.save(dataL);
    }

    @Override
    public List<DataL> selecteAll() {
        return dataLRespository.findAll();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        DataL user = dataLRespository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new CustomDataDetails(user);
//
//    }

}
