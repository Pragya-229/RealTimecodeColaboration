<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Real-Time Code Collaboration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
  <div class="container"> 
   <div class="card">
     <div class="card-body">
     
       <form action="createSession" method="post">
        <caption>
         <h2>Create Collaboration Session</h2>
        </caption>
        <fieldset class="form-group">
         <label>Session Name</label>
         <input type="text" class="form-control" name="sessionName" placeholder="Enter session name" required />
        </fieldset>
        
        <fieldset class="form-group">
         <label>Host Email</label>
         <input type="email" class="form-control" name="hostEmail" placeholder="Enter host email" required />
        </fieldset>
        
        <fieldset class="form-group">
         <label>Programming Language</label>
         <select class="form-control" name="language" required>
           <option value="Java">Java</option>
           <option value="Python">Python</option>
           <option value="JavaScript">JavaScript</option>
           <option value="C++">C++</option>
         </select>
        </fieldset>
         
        <fieldset class="form-group">
         <label>Access Code</label>
         <input type="password" class="form-control" name="accessCode" placeholder="Enter a secure access code" required />
        </fieldset>
        
        <button type="submit" class="btn btn-primary">Create Session</button>
       </form>
     </div>
   </div>
  </div>
</body>
</html>
