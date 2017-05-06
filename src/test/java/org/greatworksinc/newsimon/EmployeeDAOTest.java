package org.greatworksinc.newsimon;

import static com.google.common.truth.Truth.assertThat;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

public class EmployeeDAOTest {

  private @Mock Connection conn;
  private EmployeeDAO dao;
  @Before
  public void setup() {
    dao = new EmployeeDAO(conn);
  }
  // TODO Using in memory mySQL database for unitTest and use smaller set of
  // seed data.
  // @Ignore("Test is not needed")
//  @Test
//  public void findEmployeesByDepartment() {
//
//    assertThat(new EmployeeDAO().findEmployeesByDepartment("CITY COUNCIL")).hasSize(396);
//  }

}
