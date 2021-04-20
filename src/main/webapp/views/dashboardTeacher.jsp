<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
    <!-- AGAIN-->
    
    <style>
.dropbtn {
  background-color: #695681;
  
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #695681;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  right: 0;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: #695681;
}
</style>

  <!-- AGAIN-->


        <title>Teacher Home Page</title>
        <link rel="stylesheet" href="/css-res/dashboardTeacher-style.css"  type="text/css" />
        <script>
            function MockRequest(){
                location.assign("/createMock");
            }
            function ProctorRequest(){
                location.assign("/proctor");
            }
            function StudentsRequest(){
                location.assign("/createStudent");
            }
            function PerformanceRequest(){
                location.assign("/showResult");
            }
            function EditRequest(){
                location.assign("/editMock");
            }
            function viewMockRequest(){
                location.assign("/viewMock");
            }
             function logout(){
                var r = confirm("Are you sure you want to Logout?");
                if (r == true) {
  					location.replace("../logoutSuccess");
				} else {
 				 //do nothing....
				}
            }
            

        </script>
    </head>
    <body>
        <header>
            <div class="class1" >
                <img src="/images-res/dashboardTeacher-img avatar.png" >
                <p class="changePhoto">Change Photo</p>
                
            </div> 
            <div class="class2">
            
                <div class="subgroup1">
                    <p class="teacherName">${sessionScope.name}</p>
                        <div class="subsubgroup1" >
                            <img  class="logoutImage" src="/images-res/dashboardTeacher-logouticon.png" style="width: 25px;height: 25px;" onclick="logout()" hint="Logout"/>
                        </div>
                </div>
                <div class="subgroup2">
                    <p>${sessionScope.email}</p>
                    <div class="subsubgroup1">
                    
                    
                      <!--  <img class="accountSetting" src="/images-res/dashboardTeacher-seetingicon.png" style="width: 25px;height: 25px;" hint="Account Setting"/> -->
                   
                   
                   <!--CHANGES TILL HERE  -->
                   <div class="dropdown">
                   <img id="dropbtn" class="accountSetting" src="/images-res/dashboardTeacher-seetingicon.png" style="width: 25px;height: 25px;" hint="Account Setting"/>
                     <div class="dropdown-content">
  						<a href="../changeUsernameOfTeacher" style="">Change Username</a>
  						<a href="../changeEmailOfTeacher">Change Email</a>
  						<a href="../changePasswordOfTeacher">Change Password</a>
  						<a href="../sendStudentInvite">Send Student Invite</a>
  					</div>
                   </div>
                   <!--CHANGES TILL HERE  -->
                   
                    </div>
                </div>
                
                
            </div>
            
        </header>

        <nav>
            <div class="nav1" onclick="MockRequest()">
                <img class="mockImage" src="/images-res/dashboardTeacher-mocktest.png" >
                <p>Create Mock</p>
            </div>
            <div class="nav2" onclick="ProctorRequest()">
                <img class="mockImage" src="/images-res/dashboardTeacher-proctorImage.png" >
                <p>Proctor</p>
            </div>
            <div class="nav3" onclick="StudentsRequest()">
                <img class="mockImage" src="/images-res/dashboardTeacher-studentauthen.png" >
                <p> Students</p>
            </div>
        </nav>

        <nav>
            
            <div class="nav4" onclick="PerformanceRequest()">
                <img class="mockImage" src="/images-res/dashboardTeacher-performance.png" >
                <p>Performance</p>
            </div>
            <div class="nav5" onclick="EditRequest()">
                <img class="mockImage" src="/images-res/dashboardTeacher-edit.png" >
                <p>Edit Mock</p>
            </div>
            <div class="nav6" onclick="viewMockRequest()">
                <img class="mockImage" src="/images-res/dashboardTeacher-scheduled.png" >
                <p>View Mock</p>
            </div>
        </nav>


    </body>
</html>