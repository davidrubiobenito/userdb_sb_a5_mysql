package com.drbotro.userdb_sb_a5_mysql.service;

import com.drbotro.userdb_sb_a5_mysql.model.User;

import java.util.List;

public interface UserService {

    /**
     * Guarda un usuario
     * @param user
     * @return el ussuario guardado
     */
    User save(User user);

    /**
     * Recupera la lista de usuarios
     * @return lista de usuarios
     */
    List<User> findAll();

    /**
     * Elimina un usuario con el id recibido
     * @param id
     */
    void deleteUser(Long id);
}
