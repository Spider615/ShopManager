<%@page import="com.etc.entity.Shop"%>
<%@page import="com.etc.daoimpl.ShopDaoImpl"%>
<%@page import="com.etc.dao.ShopDao"%>
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
    <style>
    	#queryName{
    		width:350px;
    		margin: 0 auto;
    	}
    </style>
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
      </span>
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
	    <div class="layui-row">
		    <div class="layui-form layui-col-md12 x-so" id='queryName'>
		          <input id='name-s' type="text" name="username"  placeholder="商品名称" autocomplete="off" class="layui-input">
		          <button id='btn-s' class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
      		</div>
      </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加商品','./member-add.jsp',600,400)"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px" id="count_"></span>
      </xblock>
      <table class="layui-table" id="shopTable">
        <thead>
          <tr>
            <th>商品编号</th>
            <th>商品类型</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品库存</th>
            <th>商品描述</th>
			<th>商品状态</th>
			<th>商品操作</th>
		  </tr>
        </thead>
        <tbody id="table-body">
        </tbody>
      </table>
      <div class="page" id="page">
        <div>
        </div>
      </div>

    </div>
    <script>
    var pageSize = 5;		//页码大小
  	var pageSum = 0;		//总页码数
    var url=location.search;
    var p = 1;
    if(url.indexOf("?")!=-1) {
        var str = url.indexOf("=");
        var len = url.length;
        p = url.substring(str + 1, len);
    }
    $("#btn-s").click(function(){
    	$("#table-body").empty();
    	$("#page").empty();
    	var nameS = $("#name-s").val();
    	var fuzzy_count = 0;
    	$.post("FuzzyQueryServlet",{shopName:nameS},function(res){
    		fuzzy_count = res[0].count;
    		for (let i=1;i<=res[0].count;i++){
      		  let tr = document.createElement("tr");
      		  tr.setAttribute('name','del-tr');
      		  document.getElementById('table-body').appendChild(tr);
      		  let t0 = document.createElement("td");
      		  t0.innerText = res[i].Id;		//商品id
      		  document.getElementById('table-body').appendChild(t0);
      		  let t2 = document.createElement("td");
      		  t2.innerText = res[i].typeName;		//商品类型
      		  document.getElementById('table-body').appendChild(t2);
      		  let t1 = document.createElement("td");
      		  t1.innerText = res[i].shopName;		//商品名称
      		  document.getElementById('table-body').appendChild(t1);
      		  let t3 = document.createElement("td");
      		  t3.innerText = res[i].shopPrice;		//商品价格
      		  document.getElementById('table-body').appendChild(t3);
      		  let t4 = document.createElement("td");
      		  t4.innerText = res[i].shopStock;		//商品库存
      		  document.getElementById('table-body').appendChild(t4);
      		  let t5 = document.createElement("td");
      		  t5.innerText = res[i].shopDesc;		//商品描述
      		  document.getElementById('table-body').appendChild(t5);
      		  let t6 = document.createElement("td");
      		  t6.innerText = '已上架'		//商品状态
      		  document.getElementById('table-body').appendChild(t6);
      		  //操作
      		  let t7 = document.createElement("td");
      		  t7.setAttribute('class','td-manage');
      		  let name_c = 'c'+i;
      		  t7.setAttribute('id',name_c);
      		  document.getElementById('table-body').appendChild(t7);
      		  $("#"+name_c).append("<a title='编辑'  onclick=\"x_admin_show('编辑','member-edit.jsp?shopId="+res[i].Id+"&shopName="+res[i].shopName+"&typeName="+res[i].typeName+"&shopPrice="+res[i].shopPrice+"&shopStock="+res[i].shopStock+"&shopDesc="+res[i].shopDesc+"',600,400)\" href='javascript:;'><i class='layui-icon'>&#xe642;</i></a>");
      		  $("#"+name_c).append("<a title='删除'  onclick=\"member_del(this,'要删除的id')\" href='javascript:;' id="+res[i].Id+"><i class='layui-icon'>&#xe640;</i></a>");
      	  }
    		/*	分页	*/
   	  		if (fuzzy_count%pageSize==0){
   	  			pageSum = fuzzy_count/pageSize;
   	  		}else{
   	  			pageSum = parseInt(Math.floor(fuzzy_count/pageSize))+1;
   	  		}
    	    for (let i=1;i<=pageSum;i++){
    	    	var href_address = "member-list.jsp?p="+i;
    	    	console.log(href_address);
    	    	let a = document.createElement("a");
    	    	a.setAttribute('class','num');
    	    	a.setAttribute('id',i);
    	    	a.setAttribute('href',href_address);
    			a.innerText = i;
    			document.getElementById('page').appendChild(a);
    	    }
    	},"json")
    });
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });
        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
      /*商品-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              var shopId = obj.id		//获取shopId
              $.post("DeleteShopServlet",{shopId:shopId},function(res){
            	  if (res == 'success'){
            		  $(obj).parents("tr").remove();
                      layer.msg('已删除!',{icon:1,time:1000});
                      window.location.replace("member-list.jsp");
            	  }else{
            		  alert('删除失败！');
            	  }
              },"text");
          });
      }
      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
      var countAll=0;
      var count=0;
      $.ajaxSettings.async = false;
      $.post("PageServlet",{p:p,pageSize:pageSize},function(res){
    	  countAll = res[0].countAll;
    	  count = res[0].count;
    	  $("#count_").replaceWith("<span class='x-right' style='line-height:40px' id='count_'>"+"共"+countAll+"条数据"+"</span>");
    	  for (let i=1;i<=res[0].count;i++){
    		  let tr = document.createElement("tr");
    		  document.getElementById('table-body').appendChild(tr);
    		  let t0 = document.createElement("td");
    		  t0.innerText = res[i].Id;		//商品id
    		  document.getElementById('table-body').appendChild(t0);
    		  let t2 = document.createElement("td");
    		  t2.innerText = res[i].typeName;		//商品类型
    		  document.getElementById('table-body').appendChild(t2);
    		  let t1 = document.createElement("td");
    		  t1.innerText = res[i].shopName;		//商品名称
    		  document.getElementById('table-body').appendChild(t1);
    		  let t3 = document.createElement("td");
    		  t3.innerText = res[i].shopPrice;		//商品价格
    		  document.getElementById('table-body').appendChild(t3);
    		  let t4 = document.createElement("td");
    		  t4.innerText = res[i].shopStock;		//商品库存
    		  document.getElementById('table-body').appendChild(t4);
    		  let t5 = document.createElement("td");
    		  t5.innerText = res[i].shopDesc;		//商品描述
    		  document.getElementById('table-body').appendChild(t5);
    		  let t6 = document.createElement("td");
    		  t6.innerText = '已上架'		//商品状态
    		  document.getElementById('table-body').appendChild(t6);
    		  //操作
    		  let t7 = document.createElement("td");
    		  t7.setAttribute('class','td-manage');
    		  let name_c = 'c'+i;
    		  t7.setAttribute('id',name_c);
    		  document.getElementById('table-body').appendChild(t7);
    		  $("#"+name_c).append("<a title='编辑'  onclick=\"x_admin_show('编辑','member-edit.jsp?shopId="+res[i].Id+"&shopName="+res[i].shopName+"&typeName="+res[i].typeName+"&shopPrice="+res[i].shopPrice+"&shopStock="+res[i].shopStock+"&shopDesc="+res[i].shopDesc+"',600,400)\" href='javascript:;'><i class='layui-icon'>&#xe642;</i></a>");
    		  $("#"+name_c).append("<a title='删除'  onclick=\"member_del(this,'要删除的id')\" href='javascript:;' id="+res[i].Id+"><i class='layui-icon'>&#xe640;</i></a>");
    	  }
    	  /*	分页	*/
    	  	if (countAll>=pageSize){
    	  		if (countAll%pageSize==0){
    	  			pageSum = countAll/pageSize;
    	  		}else{
    	  			pageSum = parseInt(Math.floor(countAll/pageSize))+1;
    	  		}
    	  	}
    	    for (let i=1;i<=pageSum;i++){
    	    	var href_address = "member-list.jsp?p="+i;
    	    	let a = document.createElement("a");
    	    	a.setAttribute('class','num');
    	    	a.setAttribute('id',i);
    	    	a.setAttribute('href',href_address);
    			a.innerText = i;
    			document.getElementById('page').appendChild(a);
    	    }
  	},"json")
  	
  	
    </script>
    
  </body>

</html>