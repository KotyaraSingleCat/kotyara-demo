package com.kotyara.repository;

import com.kotyara.api.connection.pool.ConnectionPool;
import com.kotyara.api.connection.pool.ConnectionPoolImpl;
import com.kotyara.api.entity.User;
import com.kotyara.api.entity.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Primary
@Component
public class JdbcTestConnectionPool implements AbstractRepository<User>{

  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String user;
  @Value("${spring.datasource.password}")
  private String password;

  @Override
  public List<User> getAll() {
    List<User> users = new ArrayList<>();
    ConnectionPool connectionPool = null;
    Connection con = null;
    try {

     connectionPool = ConnectionPoolImpl.create(url, user, password);
      con = connectionPool.getConnection();
      PreparedStatement pr = con.prepareStatement("select * from user");
      ResultSet resultSet = pr.executeQuery();

      while (resultSet.next()) {
        users.add(new User(resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("email"),
                            resultSet.getString("password"),
                            UserRole.valueOf(resultSet.getString("role"))));
      }

    } catch (SQLException e) {
      e.printStackTrace();
      try {
        con.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      connectionPool.releaseConnection(con);
    }
    return users;
  }

  @Override
  public void create(User user) {
    ConnectionPool connectionPool = null;
    Connection con = null;
    try {

      connectionPool = ConnectionPoolImpl.create(url, this.user, password);
      con = connectionPool.getConnection();
      PreparedStatement pr = con.prepareStatement("INSERT INTO user(firstName, lastName, email, password, role) VALUES (?, ?, ?, ?, ?)");
      pr.setString(1, user.getFirstName());
      pr.setString(2, user.getLastName());
      pr.setString(3, user.getEmail());
      pr.setString(4, user.getPassword());
      pr.setString(5, user.getRole().toString());
      pr.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
      try {
        con.close();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      connectionPool.releaseConnection(con);
    }
  }
}
