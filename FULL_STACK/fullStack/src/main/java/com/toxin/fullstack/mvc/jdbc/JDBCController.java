package com.toxin.fullstack.mvc.jdbc;

import com.toxin.fullstack.mvc.bean.DBLog;
import com.toxin.fullstack.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JDBCController {

    @Autowired
    private JDBCExample jdbcExample;

    @RequestMapping(value = "/jdbcQueryAllUsers", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        System.out.println("All Users is called");

        List<User> users = jdbcExample.allUSers();

        return new ModelAndView("/jdbc/jdbc", "resultObject", users);
    }

    @RequestMapping(value = "/jdbcInsert/logstring/{logstring}", method=RequestMethod.GET)
    public ModelAndView insertLog(@PathVariable(value = "logstring") String logstring) {
        System.out.println("InsertLog is called");

        DBLog dbLog = new DBLog();
        dbLog.setLOGSTRING(logstring);
        boolean result = jdbcExample.insertLog(dbLog);

        return new ModelAndView("/jdbc/jdbc", "resultObject", result);
    }

    @RequestMapping(value = "/jdbcSelectLogs", method = RequestMethod.GET)
    public ModelAndView selectLogs() {
        System.out.println("Select log is called");

        List<DBLog> dbLogs = jdbcExample.allLogs();

        return new ModelAndView("/jdbc/jdbc", "resultObject", dbLogs);
    }

    @RequestMapping(value = "/jdbcDelete/user/{iduser}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable(value = "iduser") int iduser) {
        System.out.println("Delete User is called");

        boolean result = jdbcExample.deleteUser(iduser);

        return new ModelAndView("/jdbc/jdbc", "resultObject", result);
    }

    @RequestMapping(value = "/jdbcUpdate/user/username/{username}/enabled/{enabled}", method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable(value = "username")String username, @PathVariable(value = "enabled") boolean enabled) {
        System.out.println("Update user is called");

        User user = new User();
        user.setUsername(username);
        boolean result = jdbcExample.updateUserEnable(user, enabled);

        return new ModelAndView("/jdbc/jdbc", "resultObject", result);
    }

}
