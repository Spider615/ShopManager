package com.etc.daoimpl;

import java.util.List;

import com.etc.dao.ShopDao;
import com.etc.entity.Shop;
import com.etc.util.DBUtil;

public class ShopDaoImpl implements ShopDao{

	@Override
	public boolean addShop(Shop shop) {
		String sql="insert into shop values(null,?,?,?,?,?)";
		boolean result=DBUtil.execUpdate(sql,shop.getTypeId(), shop.getShopName(), shop.getShopPrice(),shop.getStockNum(),shop.getShopDesc());
		return result;
	}

	@Override
	public Shop getShopById(int shopId) {
		String sql="select * from shop where shopId=?";
		Shop shop=(Shop)DBUtil.getFirst(sql, Shop.class, shopId);
		return shop;
	}

	//修改
	@Override
	public boolean modifiShop(Shop shop) {
		String sql="update shop set shopName=?, typeId=?,shopPrice=?,stockNum=?,shopDesc=? where shopId=?";
		boolean result=DBUtil.execUpdate(sql,shop.getShopName(),shop.getTypeId(),shop.getShopPrice(),shop.getStockNum(),shop.getShopDesc(),shop.getShopId() );
		return result;
	}

	@Override
	public boolean deleteShop(int shopId) {
		String sql="delete from shop where shopId=?";
		boolean result=DBUtil.execUpdate(sql, shopId);
		return result;
	}
	
	public boolean deleteShopByName(String shopName) {
		String sql="delete from shop where shopName=?";
		boolean result=DBUtil.execUpdate(sql, shopName);
		return result;
	}

	@Override
	public int countAll() {
		String sql="select count(1) from shop";
		int result=(int)((long)DBUtil.getFirst(sql,Object.class));
		return result;
	}

	//分页查询
	@Override
	public List<Shop> ListStudentByPage(int pageIndex, int pageSize) {
		String sql="select * from shop limit ?,?";
		int limitBegin=(pageIndex-1)*pageSize;
		List<Shop> list=(List<Shop>)DBUtil.selectList(sql,Shop.class,limitBegin,pageSize);
		return list;
	}
	
	//查询全部
	@Override
	public List<Shop> ShopAll() {
		String sql="select * from shop";
		List<Shop> list=(List<Shop>)DBUtil.selectList(sql,Shop.class);
		return list;
	}

	@Override
	public Shop getShopByName(String userName) {
		String sql="select * from shop where shopName=?";
		Shop shop=(Shop)DBUtil.getFirst(sql, Shop.class, userName);
		return shop;
	}

	//模糊查询
	@Override
	public List<Shop> getShopByDim(String userName) {
		String sql="select * from shop where shopName like concat('%',?,'%')";
		List<Shop> list=(List<Shop>)DBUtil.selectList(sql,Shop.class,userName);
		return list;
	}
	
	//通过商品id查询商品名称
	@Override
	public Shop getShopIdByName(String shopName) {
		String sql="select shopId from shop where shopName=?";
		Shop shop=(Shop)DBUtil.getFirst(sql, Shop.class, shopName);
		return shop;
	}

}
