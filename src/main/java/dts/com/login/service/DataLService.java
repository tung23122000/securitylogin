package dts.com.login.service;

import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

public interface DataLService {
    @Transactional
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    DataL createD(DataL dataL);
   List<DataL> selecteAll();
}
