<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../shared/header.jsp"/>

<div class="container body-content">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <c:choose>
                    <c:when test="${model.id==0}">Add new task</c:when>
                    <c:otherwise>Edit task</c:otherwise>
                </c:choose>
            </h3>
        </div>
    </div>

    <div class="jumbotron">
        <form:form method="post" action="edit" modelAttribute="model" class="form-horizontal">
            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <form:errors path="*" class="text-danger"/>
                </div>
            </div>

            <form:hidden path="id" value="${model.id}"/>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="title">Title</form:label></div>
                <div class="col-md-8">
                    <form:input type="text" path="title" value="${model.title}" class="form-control"
                                required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="content">Content</form:label></div>
                <div class="col-md-8">
                    <form:input type="text" path="content" value="${model.content}" class="form-control"
                                required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="control-label col-md-2"><form:label path="status">Task Status</form:label></div>
                <div class="col-md-8">
                    <form:select path="status" class="form-control">
                        <form:options statusItems="${TaskStatusEnum.values()}"></form:options>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <input type="submit" class="btn btn-success" value="Save"/>
                    <a href="/tasks/list" class="btn btn-default">Back to list</a>
                </div>
            </div>
        </form:form>
    </div>
</div>

<jsp:include page="../shared/footer.jsp"/>