package org.greatworksinc.newsimon;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class EmployeeDAOTest {

  //TODO Using in memory mySQL database for unitTest and use smaller set of seed data.
  @Test
  public void test() {
    
    assertThat(new EmployeeDAO().findEmployees()).hasSize(32062);
  }

}
