<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>文章管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/articlelist.css">
</head>
<body>
<%@include file="../common/articlehead.jsp"%>
<!--articleRight start-->

<!--articleRight end-->

<main role="main" class="container">
    <div class="row row-offcanvas row-offcanvas-right main-wrapper">
        <%@include file="../common/articleleft.jsp"%>

        <div class="col-12 col-md-10" id="content-body">
            <div class="main-crumbs">文章管理</div>
            <div class="main-nav-tabs">
                <ul class="nav nav-pills" id="pills-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active"
                           href="#" role="tab" aria-controls="pills-home"
                           aria-selected="true" id="all">全部(${count})</a>
                    </li>
                </ul>
                <form class="mt-2 mt-md-0 main-nav-tab-search search_input" action="${pageContext.request.contextPath}/article/seachArticle" method="GET">
                    <input class="form-control mr-sm-2" id="key" type="text" name="key" value="" aria-label="Search"/>
                    <a class="search_link">
                        <img src="${pageContext.request.contextPath}/resources/img/search.png" width="20px"
                             height="20px">
                    </a>
                </form>
            </div>
            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show article-list active" id="pills-home" role="tabpanel"
                     aria-labelledby="pills-home-tab">
                    <c:forEach var="article" items="${articles}">
                        <div class="article-list-item">
                            <div class="list-item-title">
                                <p class="article-list-item-txt">
                                    <a href="${pageContext.request.contextPath}/article/editArticle/${article.articleId}">${article.title}</a>
                                </p>
                            </div>
                            <div class="article-list-item-info">
                                <div class="item-info-left">
                                    <span><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    <span>
                                        <img src="${pageContext.request.contextPath}/resources/img/book.png" width="20px" height="20px">&ensp;
                                        ${article.readNumber}
                                    </span>
                                </div>
                                <div class="item-info-oper">
                                    <a href="${pageContext.request.contextPath}/article/editArticle/${article.articleId}"><span>查看</span></a>
                                    <a data-aid="${article.articleId}" class="article-delete"><span class="del">删除</span></a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>

<%@include file="../common/bsjq.jsp" %>
<script type="text/javascript">
    $(function(){
        $('.article-delete').click(function () {
            var $item = $(this).parent().parent().parent();
            var articleId = $(this).data("aid");
            $.ajax({
                url:"/blog/article/deleteArticle",
                data:{articleId:articleId},
                type:"post",
                dataType:"json",
                success:function(result) { //回调函数 ,成功时返回的数据存在形参data里
                    $item.remove();
                    var text = $('#all').text();
                    text = parseInt(text.slice(text.indexOf('(')+1,text.indexOf(')'))) - 1;
                    $('#all').text("全部(" + text+ ")");
                }
            });
        });
    })
</script>
</body>
</html>