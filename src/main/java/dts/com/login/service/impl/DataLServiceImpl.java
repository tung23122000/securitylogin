package dts.com.login.service.impl;

import dts.com.login.entity.CustomDataDetails;
import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import dts.com.login.service.DataLService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataLServiceImpl implements DataLService {
    private final DataLRespository dataLRespository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        DataL dataL = dataLRespository.findByName(userName);
        if (dataL == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        return new org.springframework.security.core.userdetails.User(
                dataL.getUserName(), dataL.getPassword(), grantedAuthorities);
    }

    public DataLServiceImpl(DataLRespository dataLRespository) {this.dataLRespository = dataLRespository;}

    @Override
    public DataL createD(DataL dataL) {
        return dataLRespository.save(dataL);
    }

    @Override
    public List<DataL> selecteAll() {
        return dataLRespository.findAll();
    }





}
