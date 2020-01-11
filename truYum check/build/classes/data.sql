/* Menu Item table Details */

INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'Sandwich', '99.00', '1', '2019-12-21', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'Burger', '129.00', '1', '2019-12-26', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'Pizza', '149.00', '1', '2020-01-01', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'French Fries', '57.00', '0', '2020-01-02', 'Starters', '1');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'Chocolate Browine', '32.00', '1', '2020-01-03', 'Dessert', '1');

/* User table Details */

insert into truyum.user(us_id,us_name) values (1,'Siva');
insert into truyum.user(us_id,us_name) values (2,'Ajay');

use truyum;
/* Cart table Details */

insert into truyum.cart(ct_us_id,ct_me_id) values (1,1);
insert into truyum.cart(ct_us_id,ct_me_id) values (1,3);
insert into truyum.cart(ct_us_id,ct_me_id) values (1,5);

-- View Menu Item List Admin (TYUC001)
select me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item;

-- View Menu Item List Customer (TYUC002)
select  me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item where me_active= '1' and me_date_of_launch > (select CURDATE());

-- Edit Menu Item (TYUC003)
select  me_id, me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from truyum.menu_item where me_id=1;
update truyum.menu_item
set 
me_name= 'Fried Rice', 
me_price= '150.00', 
me_active= '1', 
me_date_of_launch= '2020-01-05', 
me_category= 'Main Course', 
me_free_delivery = '0'
where me_id=5;

-- Add to Cart (TYUC004)
insert into truyum.cart(ct_us_id,ct_me_id) values (1,1);
insert into truyum.cart(ct_us_id,ct_me_id) values (1,3);
insert into truyum.cart(ct_us_id,ct_me_id) values (1,5);

-- View Cart (TYUC005)
select me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from
truyum.menu_item
inner join
truyum.cart on ct_me_id=me_id
where ct_us_id=1;

select sum(me_price) as total from truyum.menu_item
inner join cart
on ct_me_id=ct_us_id;

-- Remove Item from Cart (TYUC006)
delete from truyum.cart
where ct_us_id=1 and ct_me_id=1;




