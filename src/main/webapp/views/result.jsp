<%@page language="java"%>
<html>
    <body>
       <!-- <h2>Result is:<%= session.getAttribute("res") %></h2>-->
       <%-- this is comment block --%>

        <h2> Welcome to jsp</h2>
        <p> ${alien} </p> <%-- alien is object from the controller set using ModelAndView --%>

        <p> welcome to ${course} world</p>

    </body>
</html>