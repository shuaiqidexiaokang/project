<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="../common/bscss.jsp" %>
    <title>帅气小康的博客</title>
</head>
<body>
<div class="container">
    <!-- head start-->
    <%@include file="../common/head.jsp" %>
    <!-- head end-->

    <!-- context start -->
    <!-- context left start -->
    <div class="row">
        <div class="col-md-8">
            <div class="text-center">
                <p>${article.title}</p>
                <p>类别：${article.typeId}&emsp;阅读：${article.readNumber}&emsp;发布时间：<fmt:formatDate
                        value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
            </div>
            <p>${article.context}</p>
            <p>关键字：${article.keyword}</p>
            <c:if test="${preArticle!=null}">
                <p>上一篇：<a
                        href="${pageContext.request.contextPath}/article/${preArticle.articleId}/details">${preArticle.title}</a>
                </p>
            </c:if>
            <c:if test="${nextArticle!=null}">
                <p>下一篇：<a
                        href="${pageContext.request.contextPath}/article/${nextArticle.articleId}/details">${nextArticle.title}</a>
                </p>
            </c:if>
        </div>
        <!-- context left end -->

        <!-- context right start -->
        <%@include file="../common/right.jsp" %>
        <!-- context right end -->
    </div>
    <!-- context end -->

    <!-- foot start -->
    <%@include file="../common/foot.jsp" %>
    <!-- foot end -->
</div>

<%@include file="../common/bsjq.jsp" %>
</body>
</html>