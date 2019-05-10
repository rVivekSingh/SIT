<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Record</title>
 <link rel="stylesheet" href="bootstrap-4.0.0-dist/css/bootstrap.min.css">
 <script type="text/javascript" src="js/vue.js"></script>
</head>
<body class="container" id="studentDetails">
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
     <img src="images/test.png" alt="Smiley face" height="120" width="120"/>
    </div>
    <div class="form-group col-md-2">
    <label style="padding-top:30px;" class="labelText">Student Name</label>
    </div>
    <div class="form-group col-md-6" style="padding-top:30px;">
      <input  type="text" value="Example Name" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Student Id</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="Example Id" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Branch</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="Example Branch" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Father's Name</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="Example Father's Name" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
  <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Mobile Number</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="Example Mobile Number" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
 <div class="row">
  <div class="form-group col-md-4"></div>
  <div class="form-group col-md-2">
    <label class="labelText">Email</label>
    </div>
    <div class="form-group col-md-6">
      <input type="text" value="Example@Email" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
 
  <div class="row">
  <div class="form-group col-md-1">
   <label class="labelText">Courses</label> 
  </div>
  <div class="form-group col-md-2">
   <input type="text" value="Course" class="form-control" disabled id="inputPassword4"> 
  </div>
  <div class="form-group col-md-1"></div> 
  <div class="form-group col-md-2">
    <label class="labelText">Total Fee</label>
  </div>
    <div class="form-group col-md-4">
      <input type="number" value="102145" class="form-control" disabled id="inputPassword4">
    </div>
  </div>
 
  <br><br>
  <div class="row">
   <div class="container">
        <div class="identity-card">
            <div class="card">
                <div class="card-body row">
                    <div class="col-md-6">
                        <div class="identity-title text-center">
                            <p class="text-uppercase"><b>Student Identity Card</b></p>
                        </div>
                        <div class="identity-details">
                            <div class="student-image text-center">
                                <span>Photo</span>
                                <input type="file" name="pic" placeholder="Student Photo" accept="image/*"/>
                            </div>
                            <div class="input-fields">
                                <div class="form-group row">
                                    <div class="col-md-4">
                                        <label><b>Name:-</b></label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-4">
                                        <label><b>Student Id:-</b></label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" placeholder="sftnt/2018/dca">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-md-4">
                                        <label><b>Date:-</b></label>
                                    </div>
                                    <div class="col-md-8">
                                        <input type="text" placeholder="21/07/2018">
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
                        <div class="identity-right">
                            <ul>
                                <li>Course name</li>
                                <li>Start date</li>
                                <li>End date</li>
                            </ul>
                            <div class="identity-tnc">
                                <p>Terms & Condition</p>
                                <ol>
                                    <li>Students should carry ID Card</li>
                                    <li>Fees are not Refundable</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 
  </div>
 <hr>
  <div style="text-align: center;">
   <button type="submit" onclick="window.print()" class="btn btn-primary">Print Details</button>
  </div>
</form>


</body>
<script type="text/javascript" src="js/printDetails.js"></script>
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
            width: 100px;
            height: 100px;
            border: 2px solid #000;
        }

        .student-image {
            float: left;
            margin-right: 10px;
            padding: 35px 0;
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