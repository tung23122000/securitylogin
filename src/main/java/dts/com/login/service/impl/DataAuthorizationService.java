package dts.com.login.service.impl;

import dts.com.login.entity.DataL;
import dts.com.login.respository.DataLRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DataAuthorizationService {
    @Autowired
    DataLRespository userRepository;

    public boolean canUpdate(long loggedInUser, long userId){
        if(loggedInUser != userId)
            return false;

        Optional<DataL> optional = userRepository.findById(userId);
        if(!optional.isPresent())
            return false;

        DataL inDB = optional.get();
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        if(inDB.getLastUpdated() != null && inDB.getLastUpdated().isAfter(twentyFourHoursAgo))
            return false;

        return true;
    }
}
