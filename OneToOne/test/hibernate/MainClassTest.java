package hibernate;


import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainClassTest {

    private String jdbcUrl;
    private String user;
    private String pass;

    @Before
    public void init() {
        jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
        user = "hbstudent";
        pass = "hbstudent";
    }

    @Test

    public void createSessionTest() {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

