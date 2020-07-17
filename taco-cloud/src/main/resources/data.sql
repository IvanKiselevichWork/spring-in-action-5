delete from Taco_Order_Tacos;
delete from Taco_Ingredients;
delete from Taco;
delete from Taco_Order;
delete from Ingredient;
insert into Ingredient (id, name, type)
    values ('FLTO', 'Flour Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
    values ('COTO', 'Corn Tortilla', 'WRAP');
insert into Ingredient (id, name, type)
    values ('GRBF', 'Ground Beef', 'PROTEIN');
insert into Ingredient (id, name, type)
    values ('CARN', 'Carnitas', 'PROTEIN');
insert into Ingredient (id, name, type)
    values ('TMTO', 'Diced Tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
    values ('LETC', 'Lettuce', 'VEGGIES');
insert into Ingredient (id, name, type)
    values ('CHED', 'Cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
    values ('JACK', 'Monterrey Jack', 'CHEESE');
insert into Ingredient (id, name, type)
    values ('SLSA', 'Salsa', 'SAUCE');
insert into Ingredient (id, name, type)
    values ('SRCR', 'Sour Cream', 'SAUCE');
insert into Taco (id, name, created_at)
    values (1, 'Veg-Out', '2005-12-31 23:59:59');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (1, 'FLTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (1, 'COTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (1, 'TMTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (1, 'LETC');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (1, 'SLSA');
insert into Taco (id, name, created_at)
    values (2, 'Veg-Out2', '2005-12-31 23:59:59');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (2, 'FLTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (2, 'COTO');
insert into Taco (id, name, created_at)
    values (3, 'Veg-Out3', '2005-12-31 23:59:59');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (3, 'FLTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (3, 'COTO');
insert into Taco (id, name, created_at)
    values (4, 'Veg-Out4', '2005-12-31 23:59:59');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (4, 'FLTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (4, 'COTO');
insert into Taco (id, name, created_at)
    values (5, 'Veg-Out5', '2005-12-31 23:59:59');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (5, 'FLTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (5, 'COTO');
insert into Taco (id, name, created_at)
    values (6, 'Veg-Out6', '2005-12-31 23:59:59');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (6, 'FLTO');
insert into Taco_Ingredients (taco_id, ingredients_id)
    values (6, 'COTO');
--insert into Users (username, password, enabled)
--    values ('1', '$2a$10$qPYtVO0mPlPq1F15JOxPLOdLwfuonkeaAp0dRgPfQHO/rn2CM1C4i', true);