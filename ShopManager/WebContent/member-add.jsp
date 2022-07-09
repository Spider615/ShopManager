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
              <label class="layui-form-label" name="shoptype">
                  <span class="x-red">*</span>商品类型
              </label>
              <div class="layui-input-inline">
                  <select id="shoptypes">
                  	
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label" name="shopname">
                  <span class="x-red">*</span>商品名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" class="layui-input" id="shopName">
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label">
                  <span class="x-red">*</span>商品价格
              </label>
              <div class="layui-input-inline">
                  <input type="text" class="layui-input" id="shopPrice">
              </div>
          </div>
          <div class="layui-form-item">
              <label  class="layui-form-label" name="stockNum">
                  <span class="x-red">*</span>商品库存
              </label>
              <div class="layui-input-inline">
                  <input type="text"  class="layui-input" id="shopStock">
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label" name="shopdesc">
                  <span class="x-red">*</span>商品描述
              </label>
              <div class="layui-input-inline">
                  <input type="text" class="layui-input" id="shopDesc">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label"></label>
              <button  class="layui-btn" lay-filter="add" lay-submit="" id="btn">增加</button>
          </div>
    </div>
  </body>
  <script type="text/javascript">
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
	  });*/
  		//商品类型下拉菜单
  	  $.post("QueryTypeNameServlet",{},function(res){
  		var str = res.split(",");
  		for (let i=0;i<str.length;i+=2){
  			let op = document.createElement("option");
  			op.setAttribute('value',str[i]);
  			op.innerText = str[i+1];
  			document.getElementById('shoptypes').appendChild(op);
  		}
  	  },"text")
  
  	  $("#btn").click(function(){
  		  var sel=document.getElementById('shoptypes');
  		  var sid=sel.selectedIndex;
  		  var shopType = sel[sid].value;		//获取option中的value
  		  var shopName = $("#shopName").val();
  		  var shopPrice = $("#shopPrice").val();
  		  var shopStock = $("#shopStock").val();
  		  var shopDesc = $("#shopDesc").val();
  		  if (shopType=='' || shopName=='' || shopPrice=='' || shopStock=='' || shopDesc==''){
  			  alert('请填写完成');
  			  return ;
  		  }
  		  $.post("AddShopServlet",{shopType:shopType,shopName:shopName,shopPrice:shopPrice,shopStock:shopStock,shopDesc:shopDesc},function(res){
  			  if (res == 'success'){
  				  alert('添加成功！');
  			  }else{
  				  alert('库存不足！');
  			  }
  		  },"text")
  	  });
  </script>

</html>