package org.greatworksinc.newsimon;

/**
 * @author JGD
 * @since 12/10/16
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TxtServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html><html>");
    out.println("<body bgcolor=\"#ffff18\">");
    out.println("<h1>Current Date Time is " + new Date() + "</h1>");
    out.println("</body>");
    out.println("</html>");
  }
}

