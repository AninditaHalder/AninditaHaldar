<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="js/script.js"></script>
<title>edit Menu Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="https://image.shutterstock.com/image-vector/knife-fork-vector-icon-flat-260nw-764792872.jpg">
		<a href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<h1>Edit Menu Item</h1>
	<div class="body-content-colour">
		<form action="EditMenuItem" onsubmit="return validateMenuItemForm()"
			name="menuItemForm" method="post">
			<div>
				<div class="form-field-spacing">
					<label for="title">Item</label>
					<div>
						<input type="text" class="text-box text-box-title" name="title"
							id="title" value="${menuItem.name}">
					</div>
				</div>
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id }">
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="price">Price</label>
					<div>
						<input type="text" class="text-box" name="price" id="gross"
							value="${menuItem.price}">
					</div>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="active">Active</label> <input class="radio" type="radio"
					name="active" value="Yes"
					<c:if test="${menuItem.active}">checked</c:if>>Yes <input
					class="radio" type="radio" name="active" value="No"
					<c:if test="${!menuItem.active}">checked</c:if>>No
			</div>
			<div class="form-field-spacing">
				<label for="dateOfLaunch">Date of Launch</label>
				<div>
					<input type="text" class="text-box" name="dateOfLaunch"
						value=<fmt:formatDate value="${menuItem.dateOfLaunch}"
                             pattern="dd/MM/yyyy" />>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="category">Category</label>
				<div>
					<select name="category" class="dropdown"
						value="${menuItem.category}">
						<option value="starters">Starters</option>
						<option value="maincourse">Main Course</option>
						<option value="dessert">Dessert</option>
						<option value="drinks">Drinks</option>
					</select>
				</div>
			</div>
			<div class="form-field-spacing">
				<c:if test="${menuItem.freeDelivery}">
					<input type="checkbox" name="freeDelivery" checked>
				</c:if>
				<c:if test="${!menuItem.freeDelivery}">
					<input type="checkbox" name="freeDelivery">
				</c:if>
				<label for="freeDelivery">Free Delivery</label>
			</div>
			<div>
				<input type="submit" class="button success-button" value="Save"
					onsubmit="validateForm">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>