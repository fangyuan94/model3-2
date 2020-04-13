<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>登陆</title>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script>
        $(function () {

            $("#tj").bind("click",function () {

                var userName = $("#userName").val();
                var password = $("#password").val();

                // 发送ajax请求
                $.ajax({
                    url: '/user/login?userName='+userName+'&password='+password,
                    type: 'GET',
                    contentType: 'application/json;charset=utf-8',
                    dataType: 'json',
                    success: function (data) {
                        if(data.success){
                            alert("登陆成功");
                            //跳转其它页面
                            window.location.href='list.jsp';
                        }else{
                            alert(data.errorMessage);
                        }
                    }
                })

            })
        })
    </script>


    <style>
        div{
            padding:10px 10px 0 10px;
        }
    </style>
</head>
<html>
<body>
<h2>欢迎登陆!</h2>

<div>
    <input type="text" id="userName" name="userName" value="admin">
</div>
<div>
    <input type="password" id="password" name="password" value="admin">
</div>
<div>
    <input type="button" id="tj" value="确认">
</div>

</body>
</html>
