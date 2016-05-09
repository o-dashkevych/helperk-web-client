package ua.nure.helperk.rest.myapi.controller;

import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.entity.UserRole;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface UserAccountController {

    boolean loginUser(User user);

//	boolean isUserExistByEmail(String email);

    boolean registerNewUser(User user);

    UserRole getRoleByEmail(String email);

    List<User> getAll();

    User getUserByEmail(String email);
}
