package dts.com.login.service;

import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

public interface DataLService  {

    DataL save(DataL dataL);
    DataL updateUser(long id, DataL dataL);
}
