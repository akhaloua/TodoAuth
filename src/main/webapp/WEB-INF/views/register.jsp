<%@ include file="common/header.jspf"%>
<link href="${pageContext.request.contextPath}/resources/Theme/css/login.css" rel="stylesheet">
 </head>
<body class="registration">
<div class="container" id="registration">

    <div class="row">
        <div class="col-md-4 col-md-offset-7">
            <div class="panel panel-default">
                <div class="panel-heading"> <strong class="">Registration</strong>

                </div>
                <div class="panel-body">
               <form:form method="post" commandName="user">
			<form:hidden path="id"/>
			<form:errors path="*" cssClass="text-warning" />
			<fieldset class="form-group">
				<form:label path="userName">UserName</form:label>
				<form:input path="userName" type="text" class="form-control" placeholder="Enter Username"
					required="required"/>
				<form:errors path="userName" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control" placeholder="Email@"
					required="required"/>
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password" class="form-control" placeholder="Password"
					required="required"/>
				<form:errors path="password" cssClass="text-warning" />
			</fieldset>
			<fieldset class="form-group">
				<form:label path="confirmpassword">Confirm Password</form:label>
				<form:input path="confirmpassword" type="password" class="form-control" placeholder="Confirm password"
					required="required"/>
				<form:errors path="*" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Submit</button>
			<input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/> 
		</form:form>
                </div>
                
                </div>
            </div>
        </div>
    </div>


<%@ include file="common/footer.jspf"%>