package cardealer.com.controller;

import cardealer.com.daoImpl.UserDaoImpl;
import cardealer.com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    UserDaoImpl dao = new UserDaoImpl();

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public @ResponseBody User createUser(@RequestBody User user) {

        dao.createUser(user);
        return user;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody User loginUser(@RequestBody User user) {

        User userLogged = dao.loginUser(user);
        if (userLogged != null) {
            System.out.println("logged in");
        }
        return user;
    }
}
