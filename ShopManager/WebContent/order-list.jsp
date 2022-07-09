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
    </div>
    <div class="x-body">
    <div class="layui-row">
      <div class="layui-form layui-col-md12 x-so" id='queryName'>
          <input type="text" id="msg" name="username"  placeholder="请输入订单号" autocomplete="off" class="layui-input">
          <button class="layui-btn" id="btn-s" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
      </div>
      </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./order-add.jsp')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px" id="count_"></span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>订单编号</th>
            <th>商品名称</th>
            <th>收货人</th>
            <th>商品价格</th>
            <th>收货人联系电话</th>
            <th>收货地址</th>
            <th>快递方式</th>
            <th>下单时间</th>
            <th>订单备注</th>
            <th>操作</th>
            </tr>
        </thead>
        <tbody id="table-body">
          
        </tbody>
      </table>

    </div>
    <script>
    $("#btn-s").click(function(){
    	$("#table-body").empty();
    	var msg = $("#msg").val();
    	$.post("FuzzyQueryOrderServlet",{msg:msg},function(res){
    	  let tr = document.createElement("tr");
  		  document.getElementById('table-body').appendChild(tr);
  		  let t0 = document.createElement("td");
  		  t0.innerText = res.orderId;		//订单id
  		  document.getElementById('table-body').appendChild(t0);
  		  let t2 = document.createElement("td");
  		  t2.innerText = res.orderName;		//商品名称
  		  document.getElementById('table-body').appendChild(t2);
  		  let t1 = document.createElement("td");
  		  t1.innerText = res.orderReceive;		//收货人
  		  document.getElementById('table-body').appendChild(t1);
  		  let t3 = document.createElement("td");
  		  t3.innerText = res.orderPrice;		//商品价格
  		  document.getElementById('table-body').appendChild(t3);
  		  let t4 = document.createElement("td");
  		  t4.innerText = res.orderPhone;		//收货人联系电话
  		  document.getElementById('table-body').appendChild(t4);
  		  let t5 = document.createElement("td");
  		  t5.innerText = res.orderAddress;		//收货地址
  		  document.getElementById('table-body').appendChild(t5);
  		  let t6 = document.createElement("td");
  		  t6.innerText = res.orderSentMethod;		//快递方式
  		  document.getElementById('table-body').appendChild(t6);
  		  let t7 = document.createElement("td");
  		  t7.innerText = res.orderTime;		//下单时间
  		  document.getElementById('table-body').appendChild(t7);
  		  let t8 = document.createElement("td");
  		  t8.innerText = res.orderDesc;		//订单备注
  		  document.getElementById('table-body').appendChild(t8);
  		  //操作
  		  let t9 = document.createElement("td");
  		  t9.setAttribute('class','td-manage');
  		  let name_c = 'c0';
  		  t9.setAttribute('id',name_c);
  		  document.getElementById('table-body').appendChild(t9);
  		  $("#"+name_c).append("<a title='编辑'  onclick=\"x_admin_show('编辑','order-edit.jsp?orderId="+res.orderId+"&orderName="+res.orderName+"&orderReceive="+res.orderReceive+"&orderPrice="+res.orderPrice+"&orderPhone="+res.orderPhone+"&orderAddress="+res.orderAddress+"&orderSentMethod="+res.orderSentMethod+"&orderTime="+res.orderTime+"&orderDesc="+res.orderDesc+"',600,400)\" href='javascript:;'><i class='layui-icon'>&#xe642;</i></a>");
  		  $("#"+name_c).append("<a title='删除'  onclick=\"order_del(this,'要删除的id')\" href='javascript:;' id="+res.orderId+"><i class='layui-icon'>&#xe640;</i></a>");
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

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*订单-删除*/
      function order_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
        	  var orderId = obj.id		//获取shopId
              $.post("DeleteOrderServlet",{orderId:orderId},function(res){
            	  if (res == 'success'){
            		  $(obj).parents("tr").remove();
                      layer.msg('已删除!',{icon:1,time:1000});
                      window.location.replace("order-list.jsp");
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
      
      var countAll;
      $.post("QueryOrderServlet",{},function(res){
    	  countAll = res[0].countAll;
    	  $("#count_").replaceWith("<span class='x-right' style='line-height:40px' id='count_'>"+"共"+countAll+"条数据"+"</span>");
    	  for (let i=1;i<=res[0].countAll;i++){
    		  let tr = document.createElement("tr");
    		  document.getElementById('table-body').appendChild(tr);
    		  let t0 = document.createElement("td");
    		  t0.innerText = res[i].orderId;		//订单id
    		  document.getElementById('table-body').appendChild(t0);
    		  let t2 = document.createElement("td");
    		  t2.innerText = res[i].orderName;		//商品名称
    		  document.getElementById('table-body').appendChild(t2);
    		  let t1 = document.createElement("td");
    		  t1.innerText = res[i].orderReceive;		//收货人
    		  document.getElementById('table-body').appendChild(t1);
    		  let t3 = document.createElement("td");
    		  t3.innerText = res[i].orderPrice;		//商品价格
    		  document.getElementById('table-body').appendChild(t3);
    		  let t4 = document.createElement("td");
    		  t4.innerText = res[i].orderPhone;		//收货人联系电话
    		  document.getElementById('table-body').appendChild(t4);
    		  let t5 = document.createElement("td");
    		  t5.innerText = res[i].orderAddress;		//收货地址
    		  document.getElementById('table-body').appendChild(t5);
    		  let t6 = document.createElement("td");
    		  t6.innerText = res[i].orderSentMethod;		//快递方式
    		  document.getElementById('table-body').appendChild(t6);
    		  let t7 = document.createElement("td");
    		  t7.innerText = res[i].orderTime;		//下单时间
    		  document.getElementById('table-body').appendChild(t7);
    		  let t8 = document.createElement("td");
    		  t8.innerText = res[i].orderDesc;		//订单备注
    		  document.getElementById('table-body').appendChild(t8);
    		  //操作
    		  let t9 = document.createElement("td");
    		  t9.setAttribute('class','td-manage');
    		  let name_c = 'c'+i;
    		  t9.setAttribute('id',name_c);
    		  document.getElementById('table-body').appendChild(t9);
    		  $("#"+name_c).append("<a title='编辑'  onclick=\"x_admin_show('编辑','order-edit.jsp?orderId="+res[i].orderId+"&orderName="+res[i].orderName+"&orderReceive="+res[i].orderReceive+"&orderPrice="+res[i].orderPrice+"&orderPhone="+res[i].orderPhone+"&orderAddress="+res[i].orderAddress+"&orderSentMethod="+res[i].orderSentMethod+"&orderTime="+res[i].orderTime+"&orderDesc="+res[i].orderDesc+"',600,400)\" href='javascript:;'><i class='layui-icon'>&#xe642;</i></a>");
    		  $("#"+name_c).append("<a title='删除'  onclick=\"order_del(this,'要删除的id')\" href='javascript:;' id="+res[i].orderId+"><i class='layui-icon'>&#xe640;</i></a>");
    	  }
  	},"json")
  	
    </script>
    
  </body>

</html>