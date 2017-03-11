package org.greatworksinc.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.greatworksinc.newsimon.EmployeeDAO;
import org.greatworksinc.newsimon.models.Employee;

public class EmployeeServlet extends HttpServlet {
  private EmployeeDAO dao;

  @Override
  public void init() {
    // TODO initalize dao in constructor
    dao = new EmployeeDAO();
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String department = request.getParameter("department");
    List<Employee> employees = dao.findEmployeesByDepartment(department);
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html><html><body>");
    
    out.println(employees);
    out.println("</body>");
    out.println("</html>");
    
  }
}
