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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>收货人
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="receiver" class="layui-input"/>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>收货人联系电话
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" class="layui-input" />
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>收货地址
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="orderAddress" class="layui-input" />
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>快递方式
              </label>
              <div class="layui-input-inline">
                  <select id="orderType">
                  	
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="" id="btn">
                  确定
              </button>
          </div>
    </div>
    <script>
    var url=location.search;
    var strArr;
    if(url.indexOf("?")!=-1) {
        var str = url.indexOf("?");
        var len = url.length;
        var str = url.substring(str + 1, len);
        strArr = str.split('&');
    }
    var orderId = strArr[0].split('=')[1];
    var orderName = decodeURI(strArr[1]).split('=')[1];
    var orderRecevie = decodeURI(strArr[2]).split('=')[1];
    var orderPrice = strArr[3].split('=')[1];
    var orderPhone = decodeURI(strArr[4]).split('=')[1];
    var orderAddress = decodeURI(strArr[5]).split('=')[1];
    var orderSentMethod = decodeURI(strArr[6]).split('=')[1];
    var orderTime = decodeURI(strArr[7]).split('=')[1];
    var orderDesc = decodeURI(strArr[8]).split('=')[1];
    document.getElementById('receiver').value = orderRecevie;
    document.getElementById('phone').value = orderPhone;
    document.getElementById('orderAddress').value = orderAddress;
    var typeId;		//更改之前快递类型id
    $.post("QueryOrderTypeServlet",{},function(res){
  		var str = res.split(",");
  		for (let i=0;i<str.length;i+=2){
  			let op = document.createElement("option");
  			op.setAttribute('value',str[i]);
  			op.innerText = str[i+1];
  			if (str[i+1] == orderSentMethod){
  				typeId = str[i];
  				op.setAttribute('selected','selected');
  			}
  			document.getElementById('orderType').appendChild(op);
  		}
  	  },"text")
    $("#btn").click(function(){
    	var sel=document.getElementById('orderType');
    	var sid=sel.selectedIndex;
    	var orderTypeId = sel[sid].value;		//更改之后快递类型id
    	var orderMethod = sel[sid].innerHTML;
    	var orderRecevie = $("#receiver").val();
    	var orderPhone = $("#phone").val();
    	var orderAddress = $("#orderAddress").val();
    	$.post("UpdateOrderServlet",{orderId:orderId,orderRecevie:orderRecevie,orderPhone:orderPhone,orderAddress:orderAddress,orderTypeId:orderTypeId,orderMethod:orderMethod},function(res){
        	if (res == 'success'){
        		alert('修改成功！');
        	}else{
        		alert('修改失败！');
        	}
       	},"text")
    });
    
    
      layui.use(['form','layer'], function(){
          $ = layui.jquery;
        var form = layui.form
        ,layer = layui.layer;
      
        //自定义验证规则
        form.verify({
          nikename: function(value){
            if(value.length < 5){
              return '昵称至少得5个字符啊';
            }
          }
          ,pass: [/(.+){6,12}$/, '密码必须6到12位']
          ,repass: function(value){
              if($('#L_pass').val()!=$('#L_repass').val()){
                  return '两次密码不一致';
              }
          }
        });

        /*//监听提交
        form.on('submit(add)', function(data){
          console.log(data);
          //发异步，把数据提交给php
          layer.alert("修改成功", {icon: 6},function () {
              // 获得frame索引
              var index = parent.layer.getFrameIndex(window.name);
              //关闭当前frame
              parent.layer.close(index);
          });
          return false;
        });*/
        
        
      });
  </script>
    
  </body>

</html>