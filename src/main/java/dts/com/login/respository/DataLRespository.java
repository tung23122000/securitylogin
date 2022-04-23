package dts.com.login.respository;

import dts.com.login.entity.DataL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLRespository extends JpaRepository<DataL, Long> {
    DataL findByUsername(String username);
}
