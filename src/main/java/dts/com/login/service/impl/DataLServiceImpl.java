package dts.com.login.service.impl;

import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import dts.com.login.service.DataLService;
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
        this.passwordEncoder = passwordEncoder;
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

//    public UserService(DataLRespository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public User save(User user) {
//        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
//        return this.userRepository.save(user);
//    }
//
//    public User updateUser(long id, User user) {
//        User inDB = userRepository.getOne(id);
//        inDB.setDisplayName(user.getDisplayName());
//        inDB.setLastUpdated(LocalDateTime.now());
//        return userRepository.save(inDB);
//    }

}
