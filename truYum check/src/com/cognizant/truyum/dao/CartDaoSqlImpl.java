package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	public static final String ADD_MENU_ITEM_TO_CART = "insert into cart(ct_us_id,ct_me_id)values(?,?)";
	public static final String GET_MENU_ITEM_FROM_CART = "select * from menu_item inner join cart on ct_me_id=me_id where ct_us_id=?";
	public static final String GET_TOTAL = "select sum(me_price) as total from menu_item inner join cart on ct_me_id=me_id where ct_us_id=?";
	public static final String DELETE_FROM_CART = "delete  from cart where ct_us_id=? and ct_me_id=? limit 1";

	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MENU_ITEM_TO_CART);
			// ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {

			}
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = new Cart();
		ArrayList<MenuItem> menuCartItem = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		MenuItem menuItem = null;
		try {
			preparedStatement = connection.prepareStatement(GET_MENU_ITEM_FROM_CART);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			cart.setMenuItemList(menuCartItem);
			ps = connection.prepareStatement(GET_TOTAL);
			ps.setLong(1, userId);
			resultSetTotal = ps.executeQuery();
			while (resultSet.next()) {
				menuItem = new MenuItem();
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItem.setActive(resultSet.getString("me_active").equals("1"));
				menuItem.setDateOfLaunch(resultSet.getDate("me_date_of_launch"));
				menuItem.setCategory(resultSet.getString("me_category"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("1"));
				menuCartItem.add(menuItem);
			}
			
			if (menuCartItem.size() == 0) {
				throw new CartEmptyException();
			}
			while (resultSetTotal.next()) {
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement!=null)
				preparedStatement.close();
				if(resultSet!=null)
				resultSet.close();
				if(ps!=null)
				ps.close();
				if(resultSetTotal!=null)
				resultSetTotal.close();
				if(connection!=null)
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cart;
	}

	@Override
	public void removeCartItem(long userID, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(DELETE_FROM_CART);
			preparedStatement.setLong(1, userID);
			preparedStatement.setLong(2, menuItemId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
