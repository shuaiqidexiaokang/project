<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>类别管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/typelist.css">
</head>
<body>
<%@include file="../common/articlehead.jsp"%>
<!--articleRight start-->

<!--articleRight end-->
<main role="main" class="container">
    <div class="row row-offcanvas row-offcanvas-right main-wrapper">
        <div class="col-6 col-md-2 sidebar-offcanvas" id="sidebar">
            <div class="list-group-item list-group-title">内容</div>
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/article/list" class="list-group-item none" data-title="article">文章管理</a>
                <a href="${pageContext.request.contextPath}/type/list" class="list-group-item active">分类管理</a>
            </div>
            <div class="list-group-item list-group-title">设置</div>
            <div class="list-group">
                <a href="#" class="list-group-item none" data-title="blogsetting">博客设置</a>
            </div>
        </div>

        <div class="col-12 col-md-10" id="content-body">
            <div class="main-crumbs">个人分类管理</div>
            <div class="categorie-content">
                <div class="add-categorie-box">
                    <div class="form-group row d-flex align-items-center">
                        <div class="txt-box">
                            <input type="text" class="form-control form-control-sm feedback-icon" id="txtAdd">
                        </div>
                        <button class="btn-online c-blue btn-add">添加分类</button>
                    </div>
                </div>
                <ul class="categorieList" style="display:block">
                    <li class="d-flex title">
                        <div class="sort">排序</div>
                        <div class="categorie">类别</div>
                        <div class="article-count">文章数</div>
                        <div class="operate">操作</div>
                    </li>
                    <c:forEach var="type" items="${types}">
                        <li class="d-flex align-items-center" data-id="${type.typeId}">
                            <div class="sort d-flex flex-column justify-content-center">
                                <button class="btn-online btn-sort btn-sort-up" title="上移" data-type="up">
                                    <svg class="icon icon-sort" data-type="up">
                                        <polygon data-type="up" class="st0" points="5,0 0,6 10,6 " />
                                    </svg>
                                </button>
                                <button class="btn-online btn-sort btn-sort-down" title="下移" data-type="down">
                                    <svg class="icon icon-sort" data-type="down">
                                        <polygon data-type="down" class="st0" points="5,6 10,0 0,0 " />
                                    </svg>
                                </button>
                            </div>
                            <div class="categorie d-flex align-items-center">
                                <input type="text" class="edit-box" name="" data-value="${type.typeName}" value="${type.typeName}" disabled />
                                <span class="opt-box">
                                    <a class="btn-online c-blue bd-right btn-save" data-type="save">保存</a>
                                    <a class="btn-online c-blue btn-cancle-edit">取消</a>
                                </span>
                            </div>
                            <div class="article-count"><a target="_blank" href="#">${type.number}</a></div>

                            <div class="operate d-flex justify-content-center">
                                <a class="btn-online c-blue bd-right btn-edit" data-type="edit">编辑</a>
                                <a class="btn-online c-red btn-delete" data-type="delete">删除</a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <!--确认之后如何跳转？？？-->
                <div class="confirm-box" style="display: none">
                    <div class="content">
                        <div class="pos-box">
                            <a class="btn-close">
                                <img src="${pageContext.request.contextPath}/resources/img/delete.png" width="20px" height="20px">&ensp;
                            </a>
                            <h2 class="title c-red">提示</h2>
                            <div class="txt-box">
                                是否确定要删除当前分类？
                            </div>
                            <div class="opt-box d-flex align-items-center float-right">
                                <button class="btn-online c-blue mr24 btn-close">取消</button>
                                <button class="btn-online c-red btn-confirm-delete">确认删除</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%@include file="../common/bsjq.jsp" %>
<script>
    $(function () {
        var typeId;
        var editTypeName;
        var $item;
        var $input;
        //添加类型操作
        $('.btn-add').click(function(){
            var typeName = $('#txtAdd').val();
            var url = "/blog/type/add";
            $.post(url,{typeName:typeName},function(result){
                console.log(result);
                if(result.success){
                   window.location.href = "/blog/type/list";
                }
            })
        });

        //编辑类型操作
        $('.btn-edit').click(function(){
            $input = $(this).parent().parent().find('input');
            editTypeName = $input.val();
            $input.removeAttr("disabled");
        });

        $('.btn-save').click(function(){
            $input = $(this).parent().parent().find('input');
            editTypeName = $input.val();
            $input.attr("disabled","");
            typeId = $(this).parent().parent().parent().attr('data-id');
            var url = "/blog/type/edit";
            var typeName = $('.edit-box').val();
            $.post(url,{typeId:typeId,typeName:editTypeName},function(result){
                console.log(result);
            });
        });

        $('.btn-cancle-edit').click(function(){
            $input = $(this).parent().parent().find('input');
            $input.val(editTypeName);
            $input.attr("disabled","");
        });

        //删除类型操作
        $('.btn-delete').click(function(){
            $item = $(this).parent().parent();
            typeId = $item.attr('data-id');
            $('.confirm-box').show();
        });

        $('.btn-close').click(function(){
            $('.confirm-box').hide();
        });

        $('.btn-confirm-delete').click(function(){
            $('.confirm-box').hide();
            var url = "/blog/type/delete";
            $.post(url,{typeId:typeId},function(result){
                console.log(result);
                if(result.success){
                    $item.remove();
                }
            });
        });
    })
</script>
</body>
</html>