package dts.com.login.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "data_log")
public class DataL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;
    private String password;

}

