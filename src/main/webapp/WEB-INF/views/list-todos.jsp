<%@ include file="common/header.jspf"%>
<link href="${pageContext.request.contextPath}/resources/Theme/css/bootstrap-reset.css" rel="stylesheet">
 </head>
<%@ include file="common/navigation.jspf"%>


	<div class="container">
	<div class="col-md-12">
                      <section class="panel tasks-widget">
                          <header class="panel-heading">
                              Todo list
                          </header>
                          <div class="panel-body">
                              <div class="task-content">
                                  <ul id="sortable" class="task-list ui-sortable">
                                  <c:forEach items="${todos}" var="todo">
					  <li class="list-primary">
                                          <i class=" fa fa-ellipsis-v"></i>
                                          <div class="task-checkbox">
                                              <input type="checkbox" class="list-child" value="">
                                          </div>
                                          <div class="task-title">
                                              <span class="task-title-sp">${todo.desc}</span>
                                              <span class="badge badge-sm label-success">${todo.targetDate}</span>
                                              <div class="pull-right hidden-phone">
                                                  <button class="btn btn-success btn-xs fa fa-check"></button>
                                                 <button class="btn btn-danger btn-xs fa fa-trash-o" onclick="location.href='/delete-todo?id=${todo.id}'"></button></td>
		<td><button class="btn btn-primary btn-xs fa fa-pencil" onclick="location.href='/update-todo?id=${todo.id}'"></button>
                                              </div>
                                          </div>
                                      </li>

						
				</c:forEach>
                                    
                                  </ul>
                              </div>
                              <div class=" add-task-row">
                                  <a class="btn btn-success btn-sm pull-left" href="/add-todo">Add New Tasks</a>
                                  <a class="btn btn-default btn-sm pull-right" href="#">See All Tasks</a>
                              </div>
                          </div>
                      </section>
                  </div>
		
	</div>

	
<%@ include file="common/footer.jspf"%>
