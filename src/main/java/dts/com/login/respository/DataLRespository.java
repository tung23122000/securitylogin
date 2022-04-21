package dts.com.login.respository;

import dts.com.login.entity.DataL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLRespository extends JpaRepository<DataL, Long> {
    @Query(nativeQuery = true ,value = "SELECT * FROM data_log WHERE user_name LIKE ?1")
    DataL findByEmail(String username);
}
