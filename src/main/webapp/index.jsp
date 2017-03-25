<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    List<String> data = (List<String>)request.getAttribute("data");
    if (data == null) {
      data = new ArrayList<String>();
      data.add("You need to generate new IP Address.");
    }
    String ip="";
    for(String item : data) {
      ip += item;
    }
%>
    <h2><%= ip %></h2>
<form action="/jspstuff">
  <input type="submit" value="Generate IP Address" />
</form>
</body>
</html>