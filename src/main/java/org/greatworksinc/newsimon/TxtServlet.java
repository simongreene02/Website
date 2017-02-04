package org.greatworksinc.newsimon;

/**
 * @author JGD
 * @since 12/10/16
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TxtServlet extends HttpServlet {
	private RandomAnagram anagram;

	@Override
	public void init() {
		anagram = new RandomAnagram();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html><html>");
		out.print("<body bgcolor=\"#");
		if (new Random().nextBoolean()) {
			out.print("ff");
		} else {
			out.print("00");
		}
		if (new Random().nextBoolean()) {
			out.print("ff");
		} else {
			out.print("00");
		}
		if (new Random().nextBoolean()) {
			out.println("ff\">");
		} else {
			out.println("00\">");
		}
		out.println("<h1>Current Date Time is " + new Date() + "</h1>");
		String[] input = request.getParameterValues("input");
		if (input != null && input.length > 0) {
			out.println("<table border=\"1\" style=\"width:100%\">");
			out.println("<tr>\n<th>Input</th>\n<th>Anagram</th>\n</tr>");
			for (String inputValue : input) {
				out.println("<tr>\n<td>" + inputValue + "</td>\n<td>" + anagram.generateAnagram(inputValue) + "</td>\n</tr>");
			}
			out.println("</table>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
