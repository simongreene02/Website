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
      Employee that = (Employee)obj;
      // check null if we allow variable to be null
      return  this.name.equals(that.name) 
          && this.job.equals(that.job)
          && this.department.equals(that.department)
          && this.salary.equals(that.salary);
    }
    return false;
  }
  
  public static class Builder {
    private String name;
    private String job ;
    private String department ;
    private String salary ;
    
    
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
