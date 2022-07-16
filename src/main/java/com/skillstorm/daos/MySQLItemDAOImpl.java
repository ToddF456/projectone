package com.skillstorm.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.model.Item;
import com.skillstorm.conf.WarehouseDbCreds;

public class MySQLItemDAOImpl implements ItemDAO{

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findByWarehouseID(int warehouseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item save(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateWarehouse(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateName(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePrice(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMany(int[] ids) {
		// TODO Auto-generated method stub
		
	}

}
