<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                       <h5>Salary Record Management</h5>
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#record" data-toggle="tab">Current Salary</a>
                            </li>
                            <li class=""><a href="#increment" data-toggle="tab">Increments</a>
                            </li>
                            <li class=""><a href="#estimate" data-toggle="tab">Project Estimates</a>
                            </li>
                           

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade active in" id="record">
                                <h4>Current Salary Record</h4>
                                <p>
                                <a href="${pageContext.request.contextPath }/Give_Salary">Give details of all employees current salary</a> <BR>
                                Give option for selecting each employee for details with increments<BR>
                                    
								</p>
								<!-- Iterate for loop -->
								<c:forEach var="s" items="${list }">
								Record No:<c:out value="${s.getRecord_id() }" /><br>
								Employee Id:<c:out value="${s.getEmp_id() }"></c:out><br>
								Salary:<c:out value="${s.getSalary() }"></c:out><br><Br>
								</c:forEach>
								
                            </div>
                            <div class="tab-pane fade" id="increment">
                                <h4>Increments Management</h4>
                                <p>
                                Select employee from drop down and give increment <BR>
                                Select manager from drop down for increments <BR>
                                give option for static increments     
								</p>

                            </div>
                            <div class="tab-pane fade" id="estimate">
                                <h4>Project wise salary estimates</h4>
                                <p>
                                    give option for batch increments to entire project team including manager<BR>
                                    
                                </p>
s
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
