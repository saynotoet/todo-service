<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
Welcome ${user.username}

<a href="/todo/listTodos">Manage</a> Your todos.
</div>
<%@ include file="common/footer.jspf" %>