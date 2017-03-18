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

    out.println("<!DOCTYPE html><html><head><style>table, th, td {border: 1px solid black;}</style></head><body>");

    out.println("<table><tr><th>ID</th><th>Name</th><th>Title</th><th>Department</th><th>Salary</th></tr>");
    
    employees.forEach(employee -> out.println(
        String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", 
            employee.getId(),
            employee.getName(),
            employee.getJob(),
            employee.getDepartment(),
            employee.getSalary())));
    
    out.println("</table></body>");
    out.println("</html>");

  }
}
