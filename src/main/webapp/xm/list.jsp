<%--
  Created by IntelliJ IDEA.
  User: fangyuan
  Date: 2020/4/13
  Time: 8:07 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>jQuery+Bootstrap表格内容修改删除编辑插件</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/demo.css">
<style type="text/css">
    .box{
        width: 20px;
        height: 20px;
        padding: 2px;
        border:1px solid #ccc;
        border-radius: 2px;
    }
</style>

</head>
<body>
<title>列表</title>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script>

        $(function () {

            //若session中不存在用户信息 跳转到登陆界面
            if($.trim("${sessionScope.userInfo}") == "")
            {
                top.location.href="login.jsp";

            }else {
                // 获取
                getall();
            }


            $("#tj").bind("click",function () {

                var name = $("#name").val();
                var address = $("#address").val();
                var phone = $("#phone").val();

                // 发送ajax请求
                $.ajax({
                    url: '/resume/addNewResume',
                    type: 'POST',
                    data: '{"name":"'+name+'","address":"'+address+'","phone":"'+phone+'"}',
                    contentType: 'application/json;charset=utf-8',
                    dataType: 'json',
                    success: function (data) {
                        if(data.success){
                            alert("添加成功")
                            getall();
                        }else{
                            alert(data.errorMessage);
                        }
                    }
                })

            })
            $("#xg").bind("click",function () {

                var id = $("#ysid").val();
                var name = $("#name_new").val();
                var address = $("#address_new").val();
                var phone = $("#phone_new").val();

                // 发送ajax请求
                $.ajax({
                    url: '/resume/updateResume',
                    type: 'POST',
                    data: '{"id":"'+id+'","name":"'+name+'","address":"'+address+'","phone":"'+phone+'"}',
                    contentType: 'application/json;charset=utf-8',
                    dataType: 'json',
                    success: function (data) {
                        if(data.success){
                            alert("修改成功")
                            getall();
                        }else{
                            alert(data.errorMessage);
                        }
                    }
                })

            })

        })

        function getall(){
            $.ajax({
                url: '/resume/queryAll',
                type: 'GET',
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',
                success: function (data) {
                    if(data.success){
                        var data = data.data;
                        $("#list").html('');
                        for(var i=0;i<data.length;i++){
                            var d = data[i];
                            $("#list").append('<tr><td>'+d.name+'</td><td>'+d.address+'</td> <td>'+d.phone+'</td>' +
                                '<td><i  onclick="updateData('+d.id+',\''+d.name+'\',\''+d.address+'\',\''+d.phone+'\')" class="fa fa-pencil box"></i>' +
                                '<i onclick="delData('+d.id+')" class="fa fa-trash-o box"></i></td>' +
                                '</tr>');
                        }

                    }else{
                        alert(data.errorMessage);
                    }
                }
            })
        }

        function delData(id){
            // 发送ajax请求
            $.ajax({
                url: '/resume/delResume?id='+id,
                type: 'POST',
                contentType: 'application/json;charset=utf-8',
                dataType: 'json',
                success: function (data) {
                    if(data.success){
                        alert("删除成功")
                        getall();
                    }else{
                        alert(data.errorMessage);
                    }
                }
            })
        }

        function updateData(id,name,address,phone){
            // 发送ajax请求
            $("#ysid").val(id);
           $("#name_new").val(name);
            $("#address_new").val(address);
             $("#phone_new").val(phone);
        }
    </script>



<div class="container">
    <div class="row">
        <div class="col-md-12" style="padding:2em 0;">
            <p>点击 <i   class="fa fa-pencil box"></i> 按钮可以对表格进行编辑，点击 <i  class="fa fa-trash-o box"></i>按钮可以将该表格行删除。</p>
            <div class="table-responsive">
                <table class="table table-bordered table-striped" id="mytable" >
                    <thead>
                    <tr>
                        <td>姓名</td>
                        <td>地址</td>
                        <td>手机号</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <tbody id="list">

                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12"  style="padding-bottom:2em;">

            <div>
              姓名：<input id="name" type="text" >
            </div>
            <div>
               地址： <input id="address" type="text" >
            </div>
                <div>
                手机号：<input id="phone" type="text" >
                </div>


            <button class="btn btn-info" id="tj"><i class="fa fa-plus"></i> 添加新的表格行</button>
        </div>

        <div class="col-md-12"  style="padding-bottom:2em;">
        修改元素<input id="ysid" type="hidden" >

            <div>
                姓名：<input id="name_new" type="text" >
            </div>
            <div>
                地址： <input id="address_new" type="text" >
            </div>
            <div>
                手机号：<input id="phone_new" type="text" >
            </div>


            <button class="btn btn-info" id="xg"><i class="fa fa-plus"></i> 修改</button>
        </div>
    </div>
</div>

<script src="/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script type="/text/javascript" src="/js/bootstable.js"></script>


</body>
</html>
