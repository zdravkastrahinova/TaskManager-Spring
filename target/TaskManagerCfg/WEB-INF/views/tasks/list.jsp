<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../shared/header.jsp"/>

<div class="container body-content">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><strong>List tasks</strong></div>
                <div align="right"><a href="/tasks/edit" class="btn btn-default">Add new task</a></div>
            </h3>
        </div>
    </div>

    <div class="jumbotron">
        <c:if test="${empty model.getTasks()}">
            <div class="alert alert-success">There are no tasks</div>
        </c:if>
        <c:if test="${not empty model.getTasks()}">
        <div class="panel panel-default">
            <table class="table table-bordered table-hover">
                <thead class="thead-inverse">
                <tr>
                    <th class="text-center">Title</th>
                    <th class="text-center">Content</th>
                    <th class="text-center">User</th>
                    <th class="text-center">Status</th>
                    <th class="text-center">Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${model.getTasks()}" var="modelItem">
                    <tr>
                        <td class="text-center"><c:out value="${modelItem.title}"/></td>
                        <td class="text-center"><c:out value="${modelItem.content}"/></td>
                        <td class="text-center"><c:out value="${modelItem.user.username}"/></td>
                        <td class="text-center"><c:out value="${modelItem.status}"/></td>
                        <td class="text-center">
                            <a class="btn btn-edit" href="/tasks/edit?id=<c:out value='${modelItem.id}'/>">Edit</a>
                            <a class="btn btn-delete" href="/tasks/delete?id=<c:out value='${modelItem.id}'/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </c:if>
    </div>
</div>

<jsp:include page="../shared/footer.jsp"/>