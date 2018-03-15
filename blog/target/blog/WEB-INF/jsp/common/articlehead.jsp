<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="bg-white">
    <nav class="navbar navbar-expand-md navbar-light container">
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item header-mod">
                    <a class="nav-link header-mod-txt" style="cursor: pointer;"
                       href="${pageContext.request.contextPath}/article/list">帅气的小康的博客</a>
                </li>
            </ul>
            <a class="btn btn-bd-red d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3 btn-pencil" href="${pageContext.request.contextPath}/addArticle">
                <img src="${pageContext.request.contextPath}/resources/img/write.png" width="20px" height="20px">&ensp;写博客
            </a>
            <ul class="navbar-nav">
                <li class="nav-item header-ucenter">
                    <div class="user-info">
                        <a class="header-ucenter-uname" href="#">${username}</a>
                        <a class="header-ucenter-logout" href="${pageContext.request.contextPath}/user/logout">注销</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
</header>