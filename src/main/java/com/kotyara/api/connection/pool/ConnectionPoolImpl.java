package com.kotyara.api.connection.pool;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ConnectionPoolImpl implements ConnectionPool {

  private final String url;
  private final String user;
  private final String password;
  private final List<Connection> connectionPool;
  private static final int POOL_SIZE = 20;
  private static final int MAX_TIMEOUT = 5;

  private ConnectionPoolImpl(String url, String user, String password, List<Connection> connectionPool) {
    this.url = url;
    this.user = user;
    this.password = password;
    this.connectionPool = connectionPool;
  }

  public static ConnectionPoolImpl create(String url, String user, String password) throws SQLException {
    List<Connection> pool = new ArrayList<>();
    for (int i = 0; i < POOL_SIZE; i++) {
      pool.add(createConnection(url, user, password));
    }
    return new ConnectionPoolImpl(url, user, password, pool);
  }

  private static Connection createConnection(String url, String user, String password) throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  @Override
  public Connection getConnection() throws SQLException {
    if (connectionPool.size() == 0) {
      throw new ConnectionPoolException("No available connections!");
    }

    Connection connection = connectionPool.remove(connectionPool.size() - 1);
    if (!connection.isValid(MAX_TIMEOUT)) {
      connection = createConnection(url, user, password);
    }

    log.info("Getting a connection from pool {}", connection);
    return connection;
  }

  @Override
  public boolean releaseConnection(Connection connection) {
    log.info("Returning a connection to the pool");
    return connectionPool.add(connection);
  }

  @Override
  public List<Connection> getConnectionPool() {
    return connectionPool;
  }

  @Override
  public int getSize() {
    return connectionPool.size();
  }

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public String getUser() {
    return user;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public void shutdown() throws SQLException {
    log.info("Returning a connection to the pool");
    connectionPool.forEach(this::releaseConnection);
    for (Connection c : connectionPool) {
      c.close();
    }
    connectionPool.clear();
  }
}
