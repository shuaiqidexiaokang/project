<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<html lang="zh-CN">
<head>
    <title>写博客</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/commons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/editor.css">
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
    <style>
        #txtKeyword {
            display: block;
            width: 100%;
            height: 40px;
            line-height: 40px;
            box-sizing: border-box;
            padding: 0 16px;
            border: none;
            background-color: #efefef;
            color: #4f4f4f;
        }
    </style>
</head>
<body>
<%@include file="../common/articlehead.jsp"%>
<!--articleRight start-->

<!--articleRight end-->
<main role="main" class="container">
    <div class="row row-offcanvas row-offcanvas-right main-wrapper">
        <%@include file="../common/articleleft.jsp"%>

        <form class="col-12 col-md-10" id="content-body" method="post" action="${pageContext.request.contextPath}/article/addArticle">
            <div class="title-box clearfix d-flex">
                <input type="text" id="txtTitle" maxlength="100" name="title" placeholder="输入文章标题">
            </div>

            <div class="title-box clearfix d-flex">
                <input type="text" id="txtKeyword" maxlength="100" name="keyword" placeholder="输入文章关键字">
            </div>

            <div class="section">
                <%-- style="height: 400px"--%>
                <script id="content" type="text/plain" name="context"></script>
            </div>

            <div id="moreDiv">
                <div class="pos-box">
                    <div class="form-group row form-control-sm">
                        <label class="labTitle col-form-label">博客分类：</label>
                        <div class="txt-box">
                            <select class="droBlogType" id="radChl" name="typeId">
                                <option value="0">选择分类</option>
                            </select>
                        </div>
                    </div>

                    <div class="opt-box row unfull">
                        <label class="labTitle col-form-label"></label>
                        <div class="txt-box">
                            <button id="btnPublish" type="submit" class="btn btn-outline-danger">发布博客</button>
                            <input id="btnCancel" type="button" class="btn btn-outline-secondary ml-24 btn-shanchu" title="返回列表页" value="返回">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</main>

<%@include file="../common/bsjq.jsp" %>
<script>
    $(function () {
        getTypeList();

        //添加文章的点击按钮（额外添加数据,还有数据的检测是否为空）
        $("#btnPublish").click(function () {
            if($('#txtTitle').val().length == 0){
                alert("请输入标题");
                return false;
            }
            if($('#txtKeyword').val().length == 0){
                alert("请输入关键字");
                return false;
            }

            if(getContent().length == 0){
                alert("请输入内容");
                return false;
            }
            if($('#radChl').val() == 0){
                alert("请选择类别");
                return false;
            }
            var myform = $('#content-body');
            var tmpInput=$("<input type='text' name='summary'/>");
            tmpInput.attr("value", getPlainTxt());
            myform.append(tmpInput);
            myform.submit();
        });
    })

    //获取所有类型
    function getTypeList(){
        var url = "/blog/type/list"
        $.post(url,{},function(result){
            console.log(result);
            if(result.success){
                $.each(result.data,function(index,value){
                    $('#radChl').append("<option value='" + value.typeId + "'>" + value.typeName+ "</option>");
                })
            }
        });
    };

    var ue = UE.getEditor('content');
    //获得编辑器的内容
    function getContent() {
        return ue.getContent();
    }

    //获得纯文本内容
    function getPlainTxt(){
        return ue.getPlainTxt();
    }
</script>
</body>
</html>