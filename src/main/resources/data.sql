insert into category (id, name, description)
values (1, 'Beverages', 'Soft drinks, coffees, teas, beers, and ales');
insert into category (id, name, description)
values (2 , 'Condiments', 'Sweet and savory sauces, relishes, spreads, and seasonings');
insert into category (id, name, description)
values ( 3, 'Confections', 'Desserts, candies, and sweet breads');
insert into category (id, name, description)
values ( 4, 'Dairy Products', 'Dairy Products');
insert into category (id, name, description)
values ( 5, 'Grains/Cereals', 'Breads, crackers, pasta, and cereal');
insert into category (id, name, description)
values ( 6, 'Meat/Poultry', 'Prepared meats');
insert into category (id, name, description)
values ( 7, 'Produce', 'Dried fruit and bean curd');
insert into category (id, name, description)
values ( 8, 'Seafood', 'Seaweed and fish');


insert into supplier (id, company_name, contact, address)
values (1, 'Exotic Liquids', 'Charlotte Cooper', '49 Gilbert St.');
insert into supplier (id, company_name, contact, address)
values (2, 'New Orleans Cajun Delights', 'Shelley Burke', 'P.O. Box 78934');
insert into supplier (id, company_name, contact, address)
values (3, 'Grandma Kellys Homestead', 'Regina Murphy', '707 Oxford Rd.');
insert into supplier (id, company_name, contact, address)
values (4, 'Tokyo Traders', 'Yoshi Nagase', '9-8 Sekimai Musashino-shi');
insert into supplier (id, company_name, contact, address)
values (5, 'Cooperativa de Quesos Las Cabras', 'Antonio del Valle Saavedra', 'Calle del Rosal 4');
insert into supplier (id, company_name, contact, address)
values (6, 'Mayumis', 'Mayumi Ohno', '92 Setsuko Chuo-ku');
insert into supplier (id, company_name, contact, address)
values (7, 'Pavlova, Ltd.', 'Ian Devling', '74 Rose St. Moonie Ponds');
insert into supplier (id, company_name, contact, address)
values (8, 'Specialty Biscuits, Ltd.', 'Peter Wilson', '29 Kings Way');
insert into supplier (id, company_name, contact, address)
values (9, 'Peterson', 'Lars Peterson', 'Kaloadagatan 13');
insert into supplier (id, company_name, contact, address)
values (10, 'Refrescos Americanas LTDA', 'Carlos Diaz', 'Av. das Americanas 12.890');
insert into supplier (id, company_name, contact, address)
values (11, 'Heli Subwaren GmbH & Co. KG', 'Petra Winkler', 'Tiergartenstrave 1');
insert into supplier (id, company_name, contact, address)
values (12, 'Plutzer Lebensmittelgro', 'Martin Bein', 'Bogenallee 51');
insert into supplier (id, company_name, contact, address)
values (13, 'Nord-Ost-Fisch Handelsgesellschaft mbH', 'Sven Petersen', 'Frahmredder 112a');
insert into supplier (id, company_name, contact, address)
values (14, 'Formaggi Fortini s.r.l.', 'Elio Rossi', 'Viale Dante, 75');
insert into supplier (id, company_name, contact, address)
values (15, 'Norske Meierier', 'Beate Vileid', 'Hatlevegen 5');
insert into supplier (id, company_name, contact, address)
values (16, 'Bigfoot Breweries', 'Cheryl Saylor', '3400 - 8th Avenue Suite 210');
insert into supplier (id, company_name, contact, address)
values (17, 'Svensk Sjofoda AB', 'Michael Björn', 'Brovallavägen 231');
insert into supplier (id, company_name, contact, address)
values (18, 'Aux joyeux ecclesiastiques', 'Guylene Nodier', '203, Rue des Francs-Bourgeois');
insert into supplier (id, company_name, contact, address)
values (19, 'New England Seafood Cannery', 'Robb Merchant', 'Order Processing Dept. 2100 Paul Revere Blvd.');
insert into supplier (id, company_name, contact, address)
values (20, 'Leka Trading', 'Chandra Leka', '471 Serangoon Loop, Suite #402');
insert into supplier (id, company_name, contact, address)
values (21, 'Lyngbysild', 'Niels Petersen', 'Lyngbysild Fiskebakken 10');
insert into supplier (id, company_name, contact, address)
values (22, 'Zaanse Snoepfabriek', 'Dirk Luchte', 'Verkoop Rijnweg 22');
insert into supplier (id, company_name, contact, address)
values (23, 'Karkki Oy', 'Anne Heikkonen', 'Valtakatu 12');
insert into supplier (id, company_name, contact, address)
values (24, 'Gday, Mate', 'Wendy Mackenzie', '170 Prince Edward Parade Hunters Hill');
insert into supplier (id, company_name, contact, address)
values (25, 'Ma Maison', 'Jean-Guy Lauzon', '2960 Rue St. Laurent');
insert into supplier (id, company_name, contact, address)
values (26, 'Pasta Buttini s.r.l.', 'Giovanni Giudici', 'Via dei Gelsomini, 153');
insert into supplier (id, company_name, contact, address)
values (27, 'Escargots Nouveaux', 'Marie Delamare', '22, rue H. Voiron');
insert into supplier (id, company_name, contact, address)
values (28, 'Gai paturage', 'Eliane Noz', 'Bat. B 3, rue des Alpes');
insert into supplier (id, company_name, contact, address)
values (29, 'Forets derables', 'Chantal Goulet', '148 rue Chasseur');


insert into product (id, name, supplier_id, category_id, unit_price)
values (1, 'Chai', 1, 1, 18.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (2, 'Chang', 1, 1, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (3, 'Aniseed Syrup', 1, 2, 15.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (4, 'Chef Anton Cajun Seasoning', 2, 2, 16.23);
insert into product (id, name, supplier_id, category_id, unit_price)
values (5, 'Chef Anton Gumbo Mix', 2, 2, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (6, 'Grandma Boysenberry Spread', 3, 2, 32.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (7, 'Uncle Bobs Organic Dried Pears', 3, 7, 23.65);
insert into product (id, name, supplier_id, category_id, unit_price)
values (8, 'Northwoods Cranberry Sauce', 3, 2, 40.8);
insert into product (id, name, supplier_id, category_id, unit_price)
values (9, 'Mishi Kobe Niku', 4, 6, 12.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (10, 'Ikura', 4, 8, 60.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (11, 'Queso Cabrales', 5, 4, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (12, 'Queso Manchego La Pastora', 5, 4, 32.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (13, 'Konbu', 6, 8, 22.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (14, 'Tofu', 6, 7, 22.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (15, 'Genen Shouyu', 6, 2, 22.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (16, 'Pavlova', 7, 3, 34.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (17, 'Alice Mutton', 7, 6, 34.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (18, 'Carnarvon Tigers', 7, 8, 34.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (19, 'Teatime Chocolate Biscuits', 8, 3, 34.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (20, 'Sir Rodneys Marmalade', 8, 3, 34.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (21, 'Sir Rodney Scones', 8, 3, 15.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (22, 'Gustafs Knäckebröd', 9, 5, 15.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (23, 'Tunnbröd', 9, 5, 15.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (24, 'Guaraná Fantástica', 10, 1, 15.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (25, 'NuNuCa Nuß-Nougat-Creme', 11, 3, 15.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (26, 'Gumbär Gummibärchen', 11, 3, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (27, 'Schoggi Schokolade', 11, 3, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (28, 'Rössle Sauerkraut', 12, 7, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (29, 'Thüringer Rostbratwurst', 12, 6, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (30, 'Nord-Ost Matjeshering', 13, 8, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (31, 'Gorgonzola Telino', 14, 4, 17.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (32, 'Mascarpone Fabioli', 14, 4, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (33, 'Geitost', 15, 4, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (34, 'Sasquatch Ale', 16, 1, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (35, 'Steeleye Stout', 16, 1, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (36, 'Inlagd Sill', 17, 8, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (37, 'Gravad lax', 17, 8, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (38, 'Cote de Blaye', 18, 1, 28.9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (39, 'Chartreuse verte', 18, 1, 9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (40, 'Boston Crab Meat', 19, 8, 9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (41, 'Jacks New England Clam Chowder', 19, 8, 9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (42, 'Singaporean Hokkien Fried Mee', 20, 5, 9);
insert into product (id, name, supplier_id, category_id, unit_price)
values (43, 'Ipoh Coffee', 20, 1, 38.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (44, 'Gula Malacca', 20, 2, 38.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (45, 'Rogede sild', 21, 8, 38.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (46, 'Spegesild', 21, 8, 38.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (47, 'Zaanse koeken', 22, 3, 38.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (48, 'Chocolade', 22, 3, 38.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (49, 'Maxilaku', 23, 3, 44.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (50, 'Valkoinen suklaa', 23, 3, 44.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (51, 'Manjimup Dried Apples', 24, 7, 44.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (52, 'Filo Mix', 24, 5, 44.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (53, 'Perth Pasties', 24, 6, 44.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (54, 'Tourtiere', 25, 6, 44.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (55, 'Pate chinois', 25, 6, 87.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (56, 'Gnocchi di nonna Alice', 26, 5, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (57, 'Ravioli Angelo', 26, 5, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (58, 'Escargots de Bourgogne', 27, 8, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (59, 'Raclette Courdavault', 28, 4, 87.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (60, 'Camembert Pierrot', 28, 4, 87.0);
insert into product (id, name, supplier_id, category_id, unit_price)
values (61, 'Sirop derable', 29, 2, 17.2);
insert into product (id, name, supplier_id, category_id, unit_price)
values (62, 'Tarte au sucre', 29, 3, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (63, 'Vegie-spread', 7, 2, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (64, 'Wimmers gute Semmelknodel', 12, 5, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (65, 'Louisiana Fiery Hot Pepper Sauce', 2, 2, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (66, 'Louisiana Hot Spiced Okra', 2, 2, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (67, 'Laughing Lumberjack Lager', 16, 1, 17.2);
insert into product (id, name, supplier_id, category_id, unit_price)
values (68, 'Scottish Longbreads', 8, 3, 17.2);
insert into product (id, name, supplier_id, category_id, unit_price)
values (69, 'Gudbrandsdalsost', 15, 4, 17.2);
insert into product (id, name, supplier_id, category_id, unit_price)
values (70, 'Outback Lager', 7, 1, 22.1);
insert into product (id, name, supplier_id, category_id, unit_price)
values (71, 'Flotemysost', 15, 4, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (72, 'Mozzarella di Giovanni', 14, 4, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (73, 'Rod Kaviar', 17, 8, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (74, 'Longlife Tofu', 4, 7, 13.6);
insert into product (id, name, supplier_id, category_id, unit_price)
values (75, 'Rhonbrau Klosterbier', 12, 1, 17.2);
insert into product (id, name, supplier_id, category_id, unit_price)
values (76, 'Lakkalikoori', 23, 1, 17.2);
insert into product (id, name, supplier_id, category_id, unit_price)
values (77, 'Original Frankfurter grune Sobe', 12, 2, 17.2);