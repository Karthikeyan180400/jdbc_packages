package databasecrud;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import helperpackage.HelperClass;
import property.Products;

public class ProductsCrud {
	HelperClass helperClass = new HelperClass();

	public void saveProducts(List<Products> list) {
		Connection con = helperClass.getConnection();
		String sql = "INSERT INTO product values(?,?,?,?,?)";
		try {

			PreparedStatement preparedStatement = con.prepareStatement(sql);
			for(Products products:list) {
			preparedStatement.setInt(1, products.getId());
			preparedStatement.setString(2, products.getName());
			preparedStatement.setString(3, products.getBrand());
			preparedStatement.setString(4, products.getType());
			preparedStatement.setDouble(5, products.getCost());
			
			preparedStatement.addBatch();
			
			}
			preparedStatement.executeBatch();

			System.out.println("Products Inserted");
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	public List<Products> printProductsByBrand(String brand) {
		Connection con = helperClass.getConnection();
		String sql = "SELECT * from product where brand=?";
		List<Products> list = new ArrayList<Products>();
		Products products =null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, brand);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				products = new Products();
				products.setId(resultSet.getInt(1));
				products.setName(resultSet.getString(2));
				products.setBrand(resultSet.getString(3));
			    products.setType(resultSet.getString(4));
			    products.setCost(resultSet.getDouble(5));
				
			    list.add(products);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return list;

	}

	public List<Products> printProductsByTypeAndBrand(Products products) {
		Connection con = helperClass.getConnection();
		String sql = "SELECT * from product where type=? AND brand=?";
		
		List<Products> list = new ArrayList<Products>();
		Products products1 = null;

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, products.getType());
			preparedStatement.setString(2, products.getBrand());
 
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				products1 = new Products();
				products1.setId(resultSet.getInt(1));
				products1.setName(resultSet.getString(2));
				products1.setBrand(resultSet.getString(3));
				products1.setType(resultSet.getString(4));
				products1.setCost(resultSet.getDouble(5));
				
				list.add(products1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Products> printProductsById(int id) {
		Connection con = helperClass.getConnection();
		String sql = "SELECT * from product where id=?";
		
		List<Products> list = new ArrayList<Products>();
		Products products = null;
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				products = new Products();
				products.setId(resultSet.getInt(1));
				products.setName(resultSet.getString(2));
				products.setBrand(resultSet.getString(3));
			    products.setType(resultSet.getString(4));
			    products.setCost(resultSet.getDouble(5));
			    
			    list.add(products);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public void deleteProductsById(int id) {
		Connection con = helperClass.getConnection();
		String sql = "DELETE from product where id=" + id;

		try {
			Statement s = con.createStatement();
			s.execute(sql);
			con.close();
			System.out.println("Products Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProducts(int id, String type, double cost) {
		Connection con = helperClass.getConnection();
		String sql = "UPDATE product set type=?,cost=? where id=" + id;

		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, type);
			preparedStatement.setDouble(2, cost);

			preparedStatement.execute();
			con.close();
			System.out.println("Product Updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
