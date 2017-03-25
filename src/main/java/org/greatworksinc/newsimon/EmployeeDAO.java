package org.greatworksinc.newsimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.greatworksinc.newsimon.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;

//TODO Externalize all the data-related constants
public class EmployeeDAO {
  private static final Logger log = LoggerFactory.getLogger(EmployeeDAO.class);
  // JDBC driver name and database URL
  private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  //private static final String DB_URL = "jdbc:mysql://localhost/workers&useSSL=false";
  private static final String DB_URL = "jdbc:mysql://localhost/workers?verifyServerCertificate=false&serverTimezone=UTC&useSSL=true";
  // Database credentials
  private static final String USER = "root";
  private static final String PASS = "simongreene";
  private static final String ALL_EMPLOYEES = "select * from Employee";
  private static final String EMPLOYEES_BY_DEPARTMENT = "select * from Employee where Department = '";

  public EmployeeDAO() {
    try {
      Class.forName(JDBC_DRIVER);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Employee> findEmployees() {
    ImmutableList.Builder<Employee> employees = ImmutableList.builder();

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(ALL_EMPLOYEES)) {
      while (rs.next()) {
        Employee employee = Employee.builder().name(rs.getString("Name")).job(rs.getString("Title"))
            .department(rs.getString("Department")).salary(rs.getString("Salary")).build();
        employees.add(employee);
      }

    } catch (SQLException e) {
      log.warn("SQL failed", e);
    }
    return employees.build();
  }

  public List<Employee> findEmployeesByDepartment(String department) {
    ImmutableList.Builder<Employee> employees = ImmutableList.builder();

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        //TODO validate department to avoid XSS 
        ResultSet rs = stmt.executeQuery(EMPLOYEES_BY_DEPARTMENT + department + "'")) {
      while (rs.next()) {
        Employee employee = Employee.builder().name(rs.getString("Name")).job(rs.getString("Title"))
            .department(rs.getString("Department")).salary(rs.getString("Salary")).build();
        employees.add(employee);
      }

    } catch (SQLException e) {
      log.warn("SQL failed", e);
    }
    return employees.build();
  }

}// end FirstExample