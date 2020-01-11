package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%15s%20s%15s%15s%25s%15s%25s", "ME_ID", "ME_NAME", "ME_PRICE", "ME_ACTIVE",
				"ME_DATE_OF_LAUNCH", "ME_CATEGORY", "ME_FREE_DELIVERY");
		for (MenuItem menuItem : menuItemList) {
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), menuItem.getActive(), date, menuItem.getCategory(),
					menuItem.getFreeDelivery());
		}
	}

	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		System.out.println("\n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%15s%20s%15s%15s%25s%15s%25s", "ME_ID", "ME_NAME", "ME_PRICE", "ME_ACTIVE",
				"ME_DATE_OF_LAUNCH", "ME_CATEGORY", "ME_FREE_DELIVERY");
		for (MenuItem menuItem : menuItemList) {
			String date = sdf.format(DateUtil.convertToSqlDate(menuItem.getDateOfLaunch()));
			System.out.format("\n%15d%20s%15s%15s%25s%15s%25s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), menuItem.getActive(), date, menuItem.getCategory(),
					menuItem.getFreeDelivery());
		}

	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(1l, "Rasgulla", 100.00f, false, new DateUtil().convertToDate("04/01/2020"), "Dessert", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();	
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
		System.out.println("\n\n\t Menu Item List Modified Successfully");
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Connection connection = ConnectionHandler.getConnection();
		// System.out.println(connection);
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
//		testGetMenuItemListAdmin();

	}

}
