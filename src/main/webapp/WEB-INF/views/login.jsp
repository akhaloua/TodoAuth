
<%@ include file="common/header.jspf"%>
<link
	href="${pageContext.request.contextPath}/resources/Theme/css/login.css"
	rel="stylesheet">
</head>
<body class="login">
	<div class="container">

		<div class="row">
			<div class="col-md-4 col-md-offset-7">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong class="">Login</strong>

					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="/login" method="post">
							<c:if test="${not empty message }">
								<div class="row">

									<div class="alert alert-danger">${message}</div>

								</div>
							</c:if>
							<c:if test="${not empty success_reg }">
								<div class="alert alert-success alert-block fade in">
									<button data-dismiss="alert" class="close close-sm"
										type="button">
										<i class="fa fa-times"></i>
									</button>
									<h4>
										<i class="fa fa-ok-sign"></i> Success!
									</h4>
									<p>Congratulation!! You are now registered</p>
								</div>
							</c:if>
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label">UserName</label>
								<div class="col-sm-9">
									<input class="form-control" id="username" name="username"
										placeholder="Enter Username">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
								<div class="col-sm-9">
									<input type="password" class="form-control" id="password"
										name="password" placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-3 col-sm-9">
									<div class="checkbox">
										<label class=""> <input type="checkbox" class="">Remember
											me
										</label>
									</div>
								</div>
							</div>
							<div class="form-group last">
								<div class="col-sm-offset-3 col-sm-9">
									<button type="submit" class="btn btn-success btn-sm">Sign
										in</button>
									<button type="reset" class="btn btn-default btn-sm">Reset</button>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

						</form>
					</div>
					<div class="panel-footer">
						Not Registered? <a href="/register"> Register here </a>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="common/footer.jspf"%>
	<script type="text/javascript">
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>