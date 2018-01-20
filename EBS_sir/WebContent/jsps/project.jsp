<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.DateFormat"  import="java.util.Date" %>

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
                            <li class=""><a href="#status" data-toggle="tab">Project Status</a>
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
                              <form>
                              Project Name: <input type="text" name="pname" class="form-control" >
                              Project Start Date :<input type="text" name="name" class="form-control" value="<%=DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) %>"> 
                              Estimated End Date: <input type="text" name="name" class="form-control" value="<%=DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) %>"> 
                              End Date: <input type="text" name="end_date" class="form-control" disabled>
                              Client Name: <input type="text" name="cname" class="form-control" >
                              Total Project Budget: <input type="text" name="budget" class="form-control" placeholder="Enter total budget of the project">
                              Status: <input type="text" name="status" class="form-control" value="active"><BR>
                               <input type="submit" value="Add Project" class="btn btn-warning">
                              </form>
                               
                               display form to add new project<BR>
                               Ask for client details of the project <BR>
                               Ask for estimated completion duration and quotation budget of the project<BR>
                               display option to assign manager to the project <BR>
                               display option to assign employees to the project <BR>
                               
                                   
                                </p>
                            </div>
                            <div class="tab-pane fade" id="status">
                                <h4>View detail project status</h4>
                                <p>
                               <h2>All Active Projects</h2>
                                show all projects list with detail reports<BR>
                                employees, manager, client details, duration, budget, estimated salary on project etc   
                                <hr>
                                <a href="#">All Past/Completed Projects </a>
                                </p>

                            </div>
                            <div class="tab-pane fade" id="broadcast">
                                <h4>Broadcast message to entire project team</h4>
                               <p>
                                   <select name="project" class="form-control">
                               <option>All projects from DB</option>
                               </select><BR>  
                                  Message: <textarea name="message" class="form-control"> </textarea>
                                   <BR><input type="submit" value="Broadcast Message" class="btn btn-primary">
								</p>

                            </div>
                             <div class="tab-pane fade" id="closure">
                                <h4>Project closure</h4>
                                <p>
                                   <select name="project" class="form-control">
                               <option>All projects from DB</option>
                               </select><BR>  
                                  Comments: <textarea name="comments" class="form-control"> </textarea>
                                   <BR><input type="submit" value="Add Project to Archives" class="btn btn-primary">
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
