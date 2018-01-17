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
                             <strong>Welcome User ! </strong> You Have No pending New Messages.
                        </div>
                       
                    </div>
                    </div>
                  <!-- /. ROW  --> 
                 <c:import url="main.jsp"/>
                   <div class="row">
                    <div class="col-lg-12 ">
                       <h5>Project Management</h5>
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#add" data-toggle="tab">Add Project</a>
                            </li>
                            <li class=""><a href="#Status" data-toggle="tab">Project Status</a>
                            </li>
                            <li class=""><a href="#broadcast" data-toggle="tab">Broadcast</a>
                            </li>
                            <li class=""><a href="#closure" data-toggle="tab">Project Closure</a>
                            </li>

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="add">
                                <h4>Add project in the system</h4>
                                <p>
                               display form to add new project<BR>
                               Ask for client details of the project <BR>
                               Ask for estimated completion duration and quotation budget of the project<BR>
                               display option to assign manager to the project <BR>
                               display option to assign employees to the project <BR>
		                               
                                   
                                </p>
                                <h1>Project form</h1>
								<h4>Personal details</h4>
								<hr>
								<sv:form action="${ pageContext.request.contextPath }/Add-project" method="POST" modelAttribute="project" >
									Name: <sv:input path="proj_name"/> <br><br>
									Project Start Date: <sv:input path="proj_start_date" type="date"/> <br><br>
									Project Estimated End Date: <sv:input path="proj_estimated_end_date" type="date"/> <br><br>
									Project End Date: <sv:input path="proj_end_date" type="date"/> <br><br>
									Client Name: <sv:input path="proj_client_name"/> <br><br>
									Client Budget:<sv:input path="budget"/><br><br>
									Project Status:<sv:input path="status"/><br><br>
									<input type="submit" value="Register Project" />
								</sv:form>
                                
                            </div>
                            
                            <div class="tab-pane fade" id="Status">
                                <h4>View detail project status</h4>
                                <p>
                                show all projects list with detail reports<BR>
                                employees, manager, client details, duration, budget, estimated salary on project etc   
                                </p>

                            </div>

                            <div class="tab-pane fade" id="broadcast">
                                <h4>Broadcast message to entire project team</h4>
                                <p>
                                Give option to select project from drop down<BR>
                                show text area for message and broadcast to entire team     
								</p>

                            </div>
                             <div class="tab-pane fade" id="closure">
                                <h4>Project closure</h4>
                                <p>
                                Update the project status (Active/Close) <BR>
                                Give option to add comments and save it in archives<BR>
                                    
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
  
   
   
</body>
</html>
