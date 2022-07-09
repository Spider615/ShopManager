<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>购物车的实现</title>
	<link rel="stylesheet" href="./css/font.css">
	<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="./css/layui.css">
	<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
	<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script src="./js/angular.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body ng-app>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">刷新</a>
        
      </span>
    </div>
	<div style="margin-left:auto; margin-right:auto; width:600px; padding-top:30px">
    	<input  type="text" name="" value=""  ng-model="abc" placeholder="输入关键字快速查找">
    </div>
	<button class="layui-btn" onclick="x_admin_show('添加库存商品','./add.jsp',600,400)"><i class="layui-icon"></i>添加</button>
	<div ng-controller="cartController" class="container">
		<table class="table" ng-show="cart.length">
			<thead>
				<tr>
					<th>商品名称</th>
					<th align="center">库存数量</th>
					<th>总库存量</th>
				</tr>
			</thead>
			<tbody id="table-body">
				<tr ng-repeat="item in cart| filter:abc">
					<td ng-bind="item.id"></td>
					<!--<td ng-bind="item.name"></td>-->
					<td>
						<button type="button" ng-click="reduce(item.id)" class="btn btn-primary btn-sm">-</button>
						<input type="text" ng-model="item.quantity" style="text-align: center;">
						<button type="button" ng-click="add(item.id)" class="btn btn-primary btn-sm">+</button>
					</td>
					<td ng-bind="item.stockNum+item.quantity"></td>
				</tr>
				<tr>
					<td>&nbsp</td>
					<td >&nbsp</td>
					<td>&nbsp</td>
					<td >&nbsp</td>
				</tr>
			</tbody>				
		</table>
	</div>

	<script type="text/javascript">
	var cartController = function($scope){
		/* 显示商品的库存信息 */
		var a = [];
		var countAll;
		$.ajaxSettings.async = false;
		$.post("QueryStockShopServlet",{},function(res){
			countAll = res[0].countAll;
			for (let i=1;i<=res[0].countAll;i++){
				let b = {};
				b['id'] = res[i].stockName;
				b['quantity'] = 1;
				b['stockNum'] = res[i].stockNum;
				a.push(b);
			}
		},"json")
		$scope.cart = a;
		//总购买数量
		$scope.totalQuantity = function(){
			var total = 0;
			angular.forEach($scope.cart,function(item){
				total += parseInt(item.quantity);
			});
			return total;
		};
		//总购买价格
		$scope.totalPrice = function(){
			var total = 0;
			angular.forEach($scope.cart,function(item){
				total += parseInt(item.quantity*item.price);
			});
			return total;
		};
		//找一个项目
		$scope.findItem = function(id){
			var index = -1;
			angular.forEach($scope.cart, function(item, key){
				if(item.id === id){
					index = key;
					return;
				};
			});
			return index;
		};
		//移除table
		$scope.remove = function(id){
			var index = $scope.findItem(id);
			if(index !== -1){
				$scope.cart.splice(index,1);	
			};
		};
		//减少一个商品数量
		$scope.reduce = function(id){
			var index = $scope.findItem(id);
			if(index !== -1){
				var item = $scope.cart[index]
				if(item.quantity>1){
					let n = --item.quantity;
					var shopStock;var quantity;
					for (let i=0;i<$scope.cart.length;i++){
						if (id == $scope.cart[i].id){
							quantity = $scope.cart[i].quantity;
							shopStock = $scope.cart[i].stockNum;
							shopStock -= quantity;
						}
					}
					$.post("UpdateShopStockNumServlet",{shopName:id,shopStock:shopStock,quantity:quantity},function(res){
						if (res=='false'){
							alert('库存修改失败！');
						}
					},"text")
				} else{
					var returnKey = confirm("是否从购物车中删除该产品！");
					if(returnKey){
						$.post("DeleteStockShopServlet",{stockName:$scope.cart[index].id},function(res){
							if (res=='success'){
								$scope.remove(id);
								alert('删除成功！');
							}else{
								alert('删除失败！');
							}
						},"text")
					}
				}	
			}
		};
		//增加一个商品数量
		$scope.add = function(id){
			var index = $scope.findItem(id);
			if(index !== -1){
				let n = ++$scope.cart[index].quantity;
				var shopStock;var quantity;
				for (let i=0;i<$scope.cart.length;i++){
					if (id == $scope.cart[i].id){
						quantity = $scope.cart[i].quantity;
						shopStock = $scope.cart[i].stockNum;
						shopStock += quantity;
					}
				}
				$.post("UpdateShopStockNumServlet",{shopName:id,shopStock:shopStock,quantity:quantity},function(res){
					if (res=='false'){
						alert('库存修改失败！');
					}
				},"text")
			};	
		};
		$scope.$watch('cart',function(newvalue,oldvalue){
			angular.forEach(newvalue, function(item, key){
				if(item.quantity < 1 && item.quantity!==''){
					var returnKey = confirm("是否从购物车中删除该产品！");
					if(returnKey){
						$scope.remove(id);
					}else{
						item.quantity = oldvalue[key].quantity;
					};
				};
			});
		},true);
	};
	</script>
</body>
</html>