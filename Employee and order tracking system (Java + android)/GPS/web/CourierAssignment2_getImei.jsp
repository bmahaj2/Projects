<%@page import="java.sql.*"%>
<!--Ajax ... Returns Information of employee-->

<%
    String username = request.getParameter("username");
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gps", "root", "SYSTEM");
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs1 = stmt.executeQuery("select * from signup where username='" + username + "'");
        //returns list of devices alloted to passed username
        rs1.next();
%>
<!--          <table border="2" style="background-color: aqua">-->
<table border="0" class="tablestyle" cellspacing="5">

    <tr>
        <td>Username:</td>
        <td><%=username%></td>
        <td rowspan="2"><img src="<%=rs1.getString("photo")%>" height="80" width="100"/></td>
    </tr>
    <tr>
        <td>Mobile No.</td>
        <td><%=rs1.getString("mobile_no")%></td>
    </tr>    
    <%
        ResultSet rs = stmt.executeQuery("select * from device_allotment where username=\'" + username + "\' and releasedate is null");
    %>
    <tr>
        <td>
            <select name="imei" id="imei">
                <option>--Select a device--</option>
                <%
                    while (rs.next()) {
                %>
                <option value="<%=rs.getString("IMEI")%>"><%=rs.getString("IMEI")%></option>
                <%
                    }
                %>
            </select>
        </td>
    </tr>

</table>
<%
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>
