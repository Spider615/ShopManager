<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
  </head>
  
  <body>
    <div class="x-body">
         <div class="layui-form-item">
             <label for="username" class="layui-form-label">
                 <span class="x-red">*</span>收货人
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="username" name="username" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label for="phone" class="layui-form-label">
                 <span class="x-red">*</span>手机号码
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                 autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label for="username" class="layui-form-label">
                 <span class="x-red">*</span>收货地址
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="orderAddress" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label class="layui-form-label" name="sentTypes">
                 <span class="x-red">*</span>配送物流
             </label>
             <div class="layui-input-inline">
                 <select id="sentTypes" >
                 
                 </select>
             </div>
         </div>
        <div class="layui-form-item">
             <label class="layui-form-label">
                 <span class="x-red">*</span>商品名称
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="orderName" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item">
             <label for="username" class="layui-form-label">
                 <span class="x-red">*</span>订单价格
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="orderPrice" required="" lay-verify="required"
                 autocomplete="off" class="layui-input">
             </div>
         </div>
         <div class="layui-form-item layui-form-text">
             <label class="layui-form-label">
                 备注
             </label>
             <div class="layui-input-block">
                 <textarea placeholder="请输入内容" id="orderDesc" class="layui-textarea"></textarea>
             </div>
         </div>
         <div class="layui-form-item">
             <label for="L_repass" class="layui-form-label">
             </label>
             <button  class="layui-btn" lay-filter="add" lay-submit="" id="btn">
                 增加
             </button>
         </div>
    </div>
    <script>
          /*//监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          
          
        });*/
    	//快递类型下拉菜单
    	  $.post("QueryOrderTypeServlet",{},function(res){
    		var str = res.split(",");
    		for (let i=0;i<str.length;i+=2){
    			let op = document.createElement("option");
    			op.setAttribute('value',str[i]);
    			op.innerText = str[i+1];
    			//console.log(str[i+1])
    			document.getElementById('sentTypes').appendChild(op);
    		}
    	  },"text")
    
    	  $("#btn").click(function(){
    		  var sel=document.getElementById('sentTypes');
    		  var sid=sel.selectedIndex;
    		  var sentType = sel[sid].value;		//获取option中的value
    		  var receive = $("#username").val();
    		  var phone = $("#phone").val();
    		  var re = checkMobile(phone);
    		  if (re == false){
    			  return ;
    		  }
    		  var orderAddress = $("#orderAddress").val();
    		  var orderName = $("#orderName").val();
    		  var orderPrice = $("#orderPrice").val();
    		  var orderDesc = $("#orderDesc").val();
    		  if (sentType=='' || receive=='' || phone=='' || orderAddress=='' || orderName=='' || orderPrice=='' || orderDesc==''){
    			  alert('请填写完成');
    			  return ;
    		  }
    		  $.post("AddOrderServlet",{sentType:sentType,receive:receive,phone:phone,orderAddress:orderAddress,orderName:orderName,orderPrice:orderPrice,orderDesc:orderDesc},function(res){
    			  if (res == 'success'){
    				  alert('添加成功！');
    			  }else if (res == 'false:orderName'){
    				  alert('没有此商品！');
    			  }else{
    				  alert('添加失败！');
    			  }
    		  },"text")
    	  });
        function checkMobile(phone)
		{
			let pattern=/^1\d{10}$/;
			if(!pattern.test(phone))
			{
				alert('手机号校验不通过');
				return false;
			}
			return true;
		}
    </script>
    
  </body>

</html>