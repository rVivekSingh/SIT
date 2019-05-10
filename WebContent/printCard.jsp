<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
<%@ page import="com.sit.hb.SaveQuery" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sit.bean.Student" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Record</title>
 <link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
 <script src="js/jquery.min.js"></script>
</head>
<body class="container" id="studentDetails">
<% System.out.println(" Print card student"+session.getAttribute("student")); %>
 <%if(session.getAttribute("student")!=null){ %>
 <%Student student=(Student)session.getAttribute("student");  %>
 <% System.out.println(" Print card student2222222222"+student); %>
    <div style="text-align:center">
        <h3 style="font-weight:Bold">Softnet Computer Academy</h3>
   </div>
   <div>
   <p style="text-align:center">
    Bisafi road, Zeromile , Madhubani, Bihar, India-847121 <br>
    softnetitech@gmail.com	, +91-7415811801 , +91-9708494644 
   </p>
   </div>
   <hr>
<form>
  <div class="row">
    <div class="form-group col-md-4">
     <div class="student-image text-center">
  		 <img id="blah" src="#" alt="your image" width="150px" height="150px" />
      </div>
    </div>
    <div class="form-group col-md-2">
    <label style="padding-top:30px;" class="labelText">Student Name</label>
    </div>
    <div class="form-group col-md-6" style="padding-top:30px;">
      <input  type="text" value="<%=student.getsName()%>" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Student Id</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="<%=student.getId()%>" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Father's Name</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="<%=student.getFatherName()%>" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Mobile Number</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="<%=student.getMobile()%>" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
 <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Email</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="<%=student.getEmail()%>" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
 
  <div class="row">
  <div class="form-group col-md-1">
   <label class="labelText">Courses</label> 
  </div>
  <div class="form-group col-md-2">
   <input type="text" value="<%=student.getCourses()%>" class="form-control" disabled id="inputPassword4"> 
  </div>
  <div class="form-group col-md-1"></div> 
  <div class="form-group col-md-2">
    <label class="labelText">Total Fee</label>
  </div>
    <div class="form-group col-md-4">
      <input type="number" value="<%=student.getTotalFee()%>" class="form-control"  id="inputPassword4">
    </div>
  </div>
 
  <br><br>
  <div class="row">
   <div class="container">
        <div class="identity-card">
            <div class="card">
                <div class="card-body row">
                    <div class="col-md-6">
                        <div class="identity-title text-center" style="background-color: gray;color: black;">
                            <p class="text-uppercase"><b>Student Identity Card</b></p>
                        </div>
                        <div class="identity-details">
                            <div class="student-image text-center">
  								<img id="blah1" src="#" alt="your image" width="150px" height="150px" />
                            </div>
                            <div class="input-fields">
                                <div class="form-group row">
                                    <div class="col-md-4">
                                        <label><b>Name:-</b></label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" value="<%=student.getsName()%>" >
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-4">
                                        <label><b>Student Id:-</b></label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" value="<%=student.getGenId()%>" >
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-4">
                                        <label><b>Date:-</b></label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" value="<%=student.getStartDate()%>" >
                                    </div>
                                </div>
                                <div class="signature">
                                    <p class="float-right">Signature</p>
                                </div>
                            </div>
                        </div>
                        <div class="identity-footer">
                            <p>Softnet Computer Academy</p>
                            <p>Bisfi Road, ZeroMile,Madhubani,Bihar-847121</p>
                            <p>Mob:- <span>7987598264</span></p>
                        </div>
                    </div>
                    <div class="vertical-line"></div>
                    <div class="col-md-6">
                        <div class="row">
	                         <div class="col-md-4 labelText">Course name</div>
	                         <div class="col-md-4 labelText">Start date</div>
	                         <div class="col-md-4 labelText">End date</div>
                        </div>
                        <div class="row">
                          <div class="col-md-4">
                             <label><%=student.getCourses()%></label>
                          </div>
                           <div class="col-md-4">
                             <label><%=student.getStartDate()%></label>
                          </div>
                           <div class="col-md-4">
                             <label><%=student.getEndDate()%></label>
                          </div>
                        </div><br><br><br><br>
                        <div class="identity-tnc">
                             <p>Terms & Condition</p>
                             <ol>
                                 <li>Students should carry ID Card</li>
                                 <li>This ID card is valid for 1 year from date of registration.</li>
                                 <li>Fees is non Refundable </li>
                             </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
  </div><br>
  
   <hr style="border-top: dotted 2px;"/>
  <br>
  <div style="text-align: center;">
   <button type="submit" onclick="window.print()" class="btn btn-primary">Print Details</button>
   <a href="home.jsp" class="btn btn-info" role="button">Go Home</a>
   <input type='file' id="imgInp" name="Load Image File"/>
  </div>
</form>

<%}else{ response.sendRedirect("login.html");} %>
</body>
<script type="text/javascript">
function readURL(input) {

	  if (input.files && input.files[0]) {
	    var reader = new FileReader();

	    reader.onload = function(e) {
	      $('#blah').attr('src', e.target.result);
	      $('#blah1').attr('src', e.target.result);
	    }

	    reader.readAsDataURL(input.files[0]);
	  }
	}

	$("#imgInp").change(function() {
	  readURL(this);
	});
</script>
<style>
.labelText{
font-size: large;
font-weight: bold;
font-family: Tahoma;
}

.vl {
    border-left: 3px solid black;
    height: 20%;
    position: absolute;
    left: 50%;
    margin-left: -3px;
    top: 68%;
}
.identity-card .card {
            border: 2px solid #000;
        }

        .student-image {
            width: 150px;
            height: 150px;
            border: 2px solid #000;
        }

        .student-image {
            float: left;
            margin-right: 10px;
            padding: 0px 0;
        }

        .input-fields label {
            font-size: 14px;
            margin: 0;
        }

        .input-fields input {
            border: none;
            border-bottom: 2px dotted #000;
            outline: none;
        }

        .signature {
            padding: 30px;
        }

        .identity-footer p {
            margin: 0;
            font-size: 14px;
        }

        .identity-right ul li {
            display: inline-block;
            list-style-type: none;
            margin: 0 20px;
        }
        
        .identity-right ul{
            padding-bottom: 150px;
        }
                
        .vertical-line{
            height: 100%;
            width: 2px;
            background: #000;
            position: absolute;
            top: 0;
            left: 50%;
        }
</style>
</html>