<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sv" uri="http://www.springframework.org/tags/form" %>


<body>
     <div id="wrapper">
         <c:import url="header.jsp"/>
        
       <c:import url="sidebar.jsp"/>
        
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-lg-12">
                     <h2>HR System - User Dashboard</h2>   
                    </div>
                </div>              
                 <!-- /. ROW  -->
                  <hr />
                <div class="row">
                    <div class="col-lg-12 ">
                        <div class="alert alert-info">
                             <strong>Welcome <c:out value="${pageContext.request.userPrincipal.name }"></c:out> ! </strong> You Have No pending New Messages.
                        </div>
                    </div>
                    </div>
                  <!-- /. ROW  --> 
                 <c:import url="main.jsp"/>
                   <div class="row">
                    <div class="col-lg-12 ">
                       <h5>Employee Management</h5>
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#add" data-toggle="tab">Add Employee</a>
                            </li>
                            <li class=""><a href="#record" data-toggle="tab">Employee Record</a>
                            </li>
                            <li class=""><a href="#assign" data-toggle="tab">Assign to Project</a>
                            </li>
                            <li class=""><a href="#message" data-toggle="tab">Send Message</a>
                            </li>

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="add">
                                <h4>Add Employee in the System</h4>
                                <p>
                                Display the form here to add employee in the system<br>
                                Set Employee Username/Password(oai202lbb) <BR>
                                Once Employee is added.. ask for assigning employee to the project<BR>
                                Send auto welcome message to employee by admin and prompt for password change
                                    
								</p>
								<h1>Employee form</h1>
								<h4>Personal details</h4>
								<hr>
								<sv:form action="${ pageContext.request.contextPath }/Add-employee" method="POST" modelAttribute="employee" >
									Name: <sv:input path="emp_name"/> <br><br>
									Address: <sv:input path="emp_address"/> <br><br>
								<h4>Company details</h4>
									<hr>
									User name: <sv:input path="username"/> <br><br>
									Password: <sv:input path="password"/> <br><br>
									Join Date: <sv:input path="emp_joindate" type="date"/> <br><br>
									Leave Date: <sv:input path="emp_leavedate" type="date"/> <br><br>
									Salary: <sv:input path="emp_salary" type="number"/> <br><br>
									<input type="submit" value="Register Employee" />
								</sv:form>
                            </div>
                            <div class="tab-pane fade" id="record">
                                <h4>View Employee Detail Record</h4>
                                <p>
								Show a text box to enter employee name or username or project and search the employee <BR>
								Show a link to display all employees of the firm.  <BR>	                                    
								Show details empl record with project details of past and present <BR>
								show salary details of employee with past increments	
                                </p>

                            </div>
                            <div class="tab-pane fade" id="assign">
                                <h4>Assign Employee to Project</h4>
                                <p>
                                Show Employee drop down to select employee   <BR>
                                Show project drop down to select project <BR>
                                Give option to unassign employee from existing or past project<BR> 
                                </p>

                            </div>
                             <div class="tab-pane fade" id="message">
                                <h4>Send Message to Employee</h4>
                                <p>
                                  Show Employee drop down to select employee   <BR>
                                  Show text area to write message to be sent to the employee <BR>  
								</p>

                            </div>
	
                       
                    </div>
                    </div>
              </div>
              
              
              <div class="col-lg-4 col-md-4">
                        
              </div>
              </div>
              </div>
             
              
    </div>
    </div>
  
   
   
</body>
</html>
