package com.drbotro.userdb_sb_a5_mysql.controllers;

import com.drbotro.userdb_sb_a5_mysql.model.User;
import com.drbotro.userdb_sb_a5_mysql.service.UserService;
import com.drbotro.userdb_sb_a5_mysql.util.QueryResult;
import com.drbotro.userdb_sb_a5_mysql.util.RestResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    protected UserService userService;

    protected ObjectMapper mapper;

    @RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String userJson) throws IOException {

        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJson, User.class);

        if (!this.validate(user)) {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios no están informados");
        }

        this.userService.save(user);
        return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
    }

    @RequestMapping(value="/getUsers", method = RequestMethod.GET)
    public List<User> getUsers (){
        return this.userService.findAll();
    }

    @RequestMapping(value="/deleteUser", method = RequestMethod.POST)
    public void deleteUser(@RequestBody String userJson) throws Exception {

        this.mapper = new ObjectMapper();
        User user = this.mapper.readValue(userJson, User.class);

        if(user.getId() == null){
            throw new Exception("El id esta nulo");
        }

        this.userService.deleteUser(user.getId());
    }

    private boolean validate(User user) {
        boolean isValid = true;

        if(StringUtils.trimToNull(user.getFirstName()) == null){
            isValid = false;
        }

        if(StringUtils.trimToNull(user.getFirstSurname()) == null){
            isValid = false;
        }

        if(StringUtils.trimToNull(user.getAddress()) == null){
            isValid = false;
        }

        return isValid;
    }
}
