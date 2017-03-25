package org.greatworksinc.newsimon;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class EmployeeDAOTest {

  //TODO Using in memory mySQL database for unitTest and use smaller set of seed data.
//  @Ignore("Test is not needed")
  @Test
  public void findEmployeesByDepartment() {
    
    assertThat(new EmployeeDAO().findEmployeesByDepartment("CITY COUNCIL")).hasSize(396);
  }

}
