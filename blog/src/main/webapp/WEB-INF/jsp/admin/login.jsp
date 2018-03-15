<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@include file="../common/bscss.jsp"%>
    <title>登录</title>
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/resources/img/background.jpg");
        }
        .context{
            margin-top: 190px;

        }
        .login-part{
            background: #fefefe;
            /*border: 1px solid #d5dce5;*/
            border-radius: 5px;margin-left: 305px;
        }
        .logging{
            background: #c90a16;
            display: block;
            height: 34px;
            line-height: 34px;
            color: #fff;
            text-align: center;
            font-size: 1.5em;
            text-decoration: none;
            clear: both;
            width: 351.38px;
            border: solid 1px #c90000;
            border-radius: 3px;
            box-shadow: 0 0 3px #fff inset;
            margin-bottom: 20px;
        }
        .error-mess{
            clear: both;
            background: #fff0f0;
            border: 1px solid #ffd2d2;
            line-height: 26px;
            color: #b74d46;
            width: 100%;
            padding: 0 5px;
            word-break: break-all;
        }
        .error-icon{
            display: inline-block;
            background: url("${pageContext.request.contextPath}/resources/img/login-logic-icons.png") no-repeat 0 0;
            width: 16px;
            height: 16px;
            vertical-align: middle;
            margin: -4px 5px -2px 0px;
        }
        .error-message{
            line-height: 26px;
            color: #b74d46;
            word-break: break-all;
        }
    </style>
</head>
<body>
<div class="row context">
    <div class="col-md-4 col-md-offset-2 login-part">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/user/login" method="post">
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <h3>账号密码</h3>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <input type="text" class="form-control" placeholder="输入用户名" name="username" id="username">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <input type="password" class="form-control" placeholder="输入密码" name="password" id="password">
                </div>
            </div>
            <c:if test="${msg==null}">
                <div class="form-group" id="error" style="display: none">
            </c:if>
            <c:if test="${msg!=null}">
                <div class="form-group" id="error" style="display: block">
            </c:if>
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="error-mess">
                            <span class="error-icon"></span>
                            <span class="error-message">${msg}</span>
                        </div>
                    </div>
                </div>
            <div class="form-group">
                <div class="col-sm-10 col-sm-offset-1">
                    <button type="submit" class="logging">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="../common/bsjq.jsp"%>
<script type="text/javascript">
    $(function(){
        $('.logging').click(function(){
            $('#error').hide();
            var username = $('#username').val();
            var password=$('#password').val();
            var msg = "";
            if(username.length!=0){
                if(password.length!=0)
                    return true;
                else
                    msg="请输入密码";
            }else{
                msg="请输入用户名";
            }
            $('.error-message').html(msg);
            $('#error').show();
            return false;
        });
    })
</script>
</body>
</html>