package org.greatworksinc.newsimon.models;

import org.junit.Test;

import com.google.common.testing.EqualsTester;

public class EmployeeTest {

  @Test
  public void equality() {

    new EqualsTester().addEqualityGroup(builder().build(), builder().build())
        .addEqualityGroup(builder().department("Workforce").build())
        .addEqualityGroup(builder().job("Lesser Deity").build())
        .addEqualityGroup(builder().name("Some Guy").build())
        .addEqualityGroup(builder().salary("OVERFLOW ERROR").build())
        .testEquals();

  }
  
  @Test(expected = NullPointerException.class)
  public void empty() {

    builder().name("").build();
  }

  private Employee.Builder builder() {
    return Employee.builder()
        .department("Worker")
        .job("Wall")
        .name("Nhoj Htims")
        .salary("2^32");
  }

}
