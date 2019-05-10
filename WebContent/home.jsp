<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
<%@ page import="com.sit.hb.SaveQuery" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sit.bean.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Home</title>
<link href="css/home.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">

<script>
function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>
</head>

<body class="mbody">
 <div class="header">
      <span class="logo"><h2> Admin Control Panel</h2></span>
 <% System.out.println(" jsp user"+session.getAttribute("user")); %>
 <%if(session.getAttribute("user")!=null){ %>
    <p>
     Hello, ${ sessionScope.user } <br>
     <a href="logout" style="color:red; text-decoration: none">Logout</a> 
    </p>
 </div>
 <div class="wbody">
 
 <div class="left">
	<button type="button" onMouseover= "this.style.color='red'" onmouseout="this.style.color='white'" class="btn btn-primary btn-lg btn-block" class="tablinks" onclick="openTab(event, 'Test1')">View Queries</button>
	<button type="button" onMouseover= "this.style.color='red'" onmouseout="this.style.color='white'" class="btn btn-primary btn-lg btn-block" class="tablinks" onclick="openTab(event, 'Test2')">Add New Student</button>
	<button type="button" onMouseover= "this.style.color='red'" onmouseout="this.style.color='white'" class="btn btn-primary btn-lg btn-block"  class="tablinks" onclick="openTab(event, 'Test3')">Generate Reports</button>
	<button type="button" onMouseover= "this.style.color='red'" onmouseout="this.style.color='white'" class="btn btn-primary btn-lg btn-block"  class="tablinks" onclick="openTab(event, 'Test4')">Other details</button>   
 </div>
 
 <div class="right">
   <div id="Test1" class="tabcontent">
   
     
     <table class="table table-striped">
  		<thead>
    		<tr class="th12">
    		  <th scope="col">Sno</th>
    		  <th scope="col">Name</th>
      		  <th scope="col">Email</th>
      		  <th scope="col">City</th>
      		  <th scope="col">Query</th>
      		  <th scope="col">Test</th>
    		</tr>
  		</thead>
  		<tbody>
    <%!  int count=1; %> 
    <% List<Student> rs=SaveQuery.getAllQueries();%> 
     <%   for(Student st: rs){%>
    
   
    
  		 
    	<tr style="color:white">
    	  <th scope="row"><% out.println(st.getId()); %></th>
    	  <td><% out.print(st.getsName()); %></td>
    	  <td><%out.print(st.getFatherName()); %></td>
    	  <td><%out.print(st.getMobile());%></td>
    	  <td><%out.print(st.getEmail());%></td>
    	  <td><%out.print(st.getCity());%></td>
  
<%out.println(); %>
<% } %>
	 </tbody>
</table>
   </div>
   
   <div id="Test2" class="tabcontent">
   <h3>This is Test 2</h3>
    <a class="th12" href="index.html">Add New Student</a>
   </div>
   <div id="Test3" class="tabcontent">
   <h3>This is Test 3</h3>
   </div>
   <div id="Test4" class="tabcontent">
   <h3>This is Test 4</h3>
   </div>
 </div>
 
 </div>
 <div class="footer">
   <p> &#169; :Softnet Computer Academy.| Designed By : <a href="https://www.ncs-india.com/" target="blank"> &#169; Vivek Singh </a></p>
 </div>

<%}else{ response.sendRedirect("login.html");} %>

</body>
<style>
.th12{
 color: white;
 font-weight: bold;
}
.table{
   overflow-y:scroll;
   overflow-x:auto;
   height:600px;
   display:block;
}
</style>

</html>
