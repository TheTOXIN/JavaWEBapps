package com.toxin.fullstack.mvc.jdbc;

import com.toxin.fullstack.mvc.bean.DBLog;
import com.toxin.fullstack.mvc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCExample {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("JDBCExample postConstruct is called. datasource = " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean insertLog(DBLog log) {
        final String INSERT_SQL = "INSERT INTO LOG (LOGSTRING) VALUES (?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(INSERT_SQL);
            statement.setString(1, log.getLOGSTRING());
            return statement;
        });

        return true;
    }

    public List<DBLog> allLogs() {
        final String QUERY_SQL = "SELECT * FROM LOG ORDER BY IDLOG";

        return jdbcTemplate.query(QUERY_SQL, (resultSet, i) -> {
            DBLog log = new DBLog();
            log.setIDLOG(resultSet.getInt("IDLOG"));
            log.setLOGSTRING(resultSet.getString("LOGSTRING"));
            return log;
        });
    }

    public List<User> allUSers() {
        final String QUERY_SQL = "SELECT * FROM USER ORDER BY IDUSER";

        return jdbcTemplate.query(QUERY_SQL, (resultSet, i) -> {
            User user = new User();
            user.setIdUser(resultSet.getInt("IDUSER"));
            user.setUsername(resultSet.getString("USERNAME"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setEnabled(resultSet.getBoolean("ENABLED"));
            return user;
        });
    }

    public boolean deleteUser(int idUser) {
        final String DELETE_SQL= "DELETE FROM USER WHERE IDUSER LIKE ?";

        int result = jdbcTemplate.update(DELETE_SQL, new Object[]{idUser});

        return result > 0;
    }

    public boolean updateUserEnable(User user, boolean enable) {
        final String UPDATE_SQL = "UPDATE USER SET ENABLED = ? WHERE USERNAME = ?";

        int result = jdbcTemplate.update(UPDATE_SQL, new Object[]{enable, user.getUsername()});

        return result > 0;
    }

}
