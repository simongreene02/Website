package com.djd.fun.txtserve;

/**
 * @author JGD
 * @since 12/10/16
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspExampleServlet extends HttpServlet {
  private final Random random;

  public JspExampleServlet() {
    this.random = new Random();
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    List<String> result = new ArrayList();
    result.add("IP Address [" + random.nextInt(256) + ".");
    result.add(random.nextInt(256) + ".");
    result.add(random.nextInt(256) + ".");
    result.add(random.nextInt(256) + "]");

    request.setAttribute("data", result);

    request.getRequestDispatcher("index.jsp").forward(request, response);
  }
}