package dts.com.login.service.impl;

import dts.com.login.entity.CustomDataDetails;
import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DataAuthService implements UserDetailsService {
    @Autowired
    DataLRespository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DataL inDB = userRepository.findByUsername(username);
        if (inDB == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomDataDetails(inDB);
    }
}
