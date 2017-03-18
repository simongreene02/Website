package org.greatworksinc.newsimon.models;

import com.google.common.base.Objects;
import static com.google.common.base.Strings.emptyToNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class Employee {
  private final String name;
  private final String job;
  private final String department;
  private final String salary;

  private Employee(Builder builder) {
    this.name = checkNotNull(emptyToNull(builder.name));
    this.job = checkNotNull(emptyToNull(builder.job));
    this.department = checkNotNull(emptyToNull(builder.department));
    this.salary = checkNotNull(emptyToNull(builder.salary));
  }

  
  public String getId() {
    return "0"; //TODO Add ID detection
  }
  
  public String getName() {
    return name;
  }


  public String getJob() {
    return job;
  }


  public String getDepartment() {
    return department;
  }


  public String getSalary() {
    return salary;
  }


  public static Builder builder() {
    return new Builder();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name, job, department, salary);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Employee) {
      Employee that = (Employee) obj;
      // check null if we allow variable to be null
      return this.name.equals(that.name) && this.job.equals(that.job) && this.department.equals(that.department)
          && this.salary.equals(that.salary);
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder builder2 = new StringBuilder();
    builder2.append("Employee [name=").append(name).append(", job=").append(job).append(", department=")
        .append(department).append(", salary=").append(salary).append("]");
    return builder2.toString();
  }

  public static class Builder {
    private String name;
    private String job;
    private String department;
    private String salary;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder job(String job) {
      this.job = job;
      return this;
    }

    public Builder department(String department) {
      this.department = department;
      return this;
    }

    public Builder salary(String salary) {
      this.salary = salary;
      return this;
    }

    public Employee build() {
      return new Employee(this);
    }

  }
}
