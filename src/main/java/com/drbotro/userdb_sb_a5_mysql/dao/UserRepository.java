package com.drbotro.userdb_sb_a5_mysql.dao;

import com.drbotro.userdb_sb_a5_mysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);

}
