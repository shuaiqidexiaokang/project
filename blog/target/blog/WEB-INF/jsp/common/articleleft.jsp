<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-6 col-md-2 sidebar-offcanvas" id="sidebar">
    <div class="list-group-item list-group-title">内容</div>
    <div class="list-group">
        <a href="${pageContext.request.contextPath}/article/list" class="list-group-item active" data-title="article">文章管理</a>
        <a href="${pageContext.request.contextPath}/type/list" class="list-group-item none">分类管理</a>
    </div>
    <div class="list-group-item list-group-title">设置</div>
    <div class="list-group">
        <a href="#" class="list-group-item none" data-title="blogsetting">博客设置</a>
    </div>
</div>