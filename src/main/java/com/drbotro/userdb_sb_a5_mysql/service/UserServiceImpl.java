package com.drbotro.userdb_sb_a5_mysql.service;

import com.drbotro.userdb_sb_a5_mysql.dao.UserRepository;
import com.drbotro.userdb_sb_a5_mysql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    protected UserRepository userRepository;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
