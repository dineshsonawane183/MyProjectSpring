	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<div class="content">
			
   <div class="container">
    
   	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-danger fade in">${message}</div>
			</div>
		</div>

         </c:if>
         
   	<c:if test="${not empty logout}">
		<div class="row">
			<div class="col-xs-12 col-md-offset-2 col-md-8">
				<div class="alert alert-success">${logout}</div>
			</div>
		</div>
	</c:if>
       
    <div class="row">
     
     <div class="col-md-offset-3 col-md-6">
      
      <div class="panel panel-primary">
       
       <div class="panel-heading">
        <h4>Registration Form</h4>
       </div>
       
       <div class="panel-body">
        <form action="${contextRoot}/register" id="registerForm" method="POST" class="form-horizontal"
         id="registerForm"
        >
         <div class="form-group">
          <label for="username" class="col-md-4 control-label">Full Name: </label>
          <div class="col-md-8">
           <input type="text" name="name" id="name" class="form-control"/>
          </div>
         </div>
          <div class="form-group">
          <label for="username" class="col-md-4 control-label">UserName: </label>
          <div class="col-md-8">
           <input type="text" name="username" id="username" class="form-control"/>
          </div>
         </div>
         
         <div class="form-group">
          <label for="password" class="col-md-4 control-label">Password: </label>
          <div class="col-md-8">
           <input type="password" name="password" id="password" class="form-control"/>
          </div>
         </div>
         
           <div class="form-group">
          <label for="password" class="col-md-4 control-label">Type Of USER: </label>
          <div class="col-md-8">
          
          <input  type="radio" name="user" value="ADMIN"/> &nbsp;Admin
          
          &nbsp;&nbsp;&nbsp;
          <input type="radio" name="user" value="CUSTOMER"/>&nbsp;customer
            &nbsp;&nbsp;&nbsp;
          <input type="radio" name="user" value="USER"/>&nbsp;User
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          </div>
         </div>
         
         
              <div class="form-group">
          <label for=enabled class="col-md-4 control-label">Enabled: </label>
          <div class="col-md-8">
          
          <input  type="radio" name="enabled" value="true"/> &nbsp;True
          
          &nbsp;&nbsp;&nbsp;
          <input type="radio" name="enabled" value="false"/>&nbsp;False
            &nbsp;&nbsp;&nbsp;
          </div>
         </div>
         
         <div class="form-group">
          <div class="col-md-offset-4 col-md-8">
           <input type="submit" value="Register" class="btn btn-primary"/>
          </div>
         </div>
        </form>
       
       </div>
       <div class="panel-footer">
       	<div class="text-right">
       		Allready A User - <a href="${contextRoot}/login">Login Here</a>
       	</div>
       </div>
      
      </div> 
    
     </div>
     
    </div>    
   
   </div>

			
		</div>





