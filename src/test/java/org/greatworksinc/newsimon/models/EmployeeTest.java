package org.greatworksinc.newsimon.models;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.testing.EqualsTester;
import static com.google.common.truth.Truth.assertThat;

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
  
  @Test
  public void json() throws JsonGenerationException, JsonMappingException, IOException {
    ObjectMapper mapper = new ObjectMapper();
    /* These are just for experiment
    mapper.writeValue(new File("JsonOutput.json"), builder().build());
    assertThat(mapper.writeValueAsString(builder().build())).isEqualTo("{\"name\":\"Nhoj Htims\",\"job\":\"Wall\",\"department\":\"Worker\",\"salary\":\"2^32\"}");
    Employee retrieved = mapper.readValue(new File("JsonOutput.json"), Employee.class);
     */
    Employee retrieved = mapper.readValue(mapper.writeValueAsString(builder().build()), Employee.class);
    assertThat(retrieved).isEqualTo(builder().build());
  }

  private Employee.Builder builder() {
    return Employee.builder()
        .department("Worker")
        .job("Wall")
        .name("Nhoj Htims")
        .salary("2^32");
  }

}
