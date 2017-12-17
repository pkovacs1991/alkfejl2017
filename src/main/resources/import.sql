INSERT INTO USER (username,email,password,role) VALUES ('alma','a@a.com','7e240de74fb1ed08fa08d38063f6a6a91462a815','ADMIN');
INSERT INTO USER (username,email,password,role) VALUES ('barack','b@b.com','5cb138284d431abd6a053a56625ec088bfb88912','USER');
INSERT INTO USER (username,email,password,role) VALUES ('cseresznye','c@c.com','f36b4825e5db2cf7dd2d2593b3f5c24c0311d8b2','USER');
INSERT INTO USER (username,email,password,role) VALUES ('dio','d@d.com','9c969ddf454079e3d439973bbab63ea6233e4087','USER');

INSERT INTO CATEGORY (name) VALUES ('PASTA');
INSERT INTO CATEGORY (name) VALUES ('PIZZA');
INSERT INTO CATEGORY (name) VALUES ('SOUP');

INSERT INTO RECIPE (recipe_name,owner_id, ingredients,description,CATEGORY_ID  ) VALUES ('almas pite',1,'alma, liszt, cukor','Mindenbele aztan a tepsibe bele!',1);
INSERT INTO RECIPE (recipe_name,owner_id, ingredients,description,CATEGORY_ID  ) VALUES ('barackos pizza',2,'barack, liszt cukor','Mindenbele, megkeverjuk, aztan a tepsibe bele!',2);
INSERT INTO RECIPE (recipe_name,owner_id, ingredients,description,CATEGORY_ID  ) VALUES ('cseresznyeleves',3,'cseresznye, 1 l viz, cukor, so','Egy labosba beletesszuk a vizet, hozzaadjuk a tobbi hozzavalot, aztan forralasig csinaljuk',3);
INSERT INTO RECIPE (recipe_name,owner_id, ingredients,description,CATEGORY_ID  ) VALUES ('dios lepeny',4,'dio, liszt, cukor','Mindenbele aztan a tepsibe bele!',1);

INSERT INTO COMMENT (user_id,recipe_id,comment) VALUES (1,1,'A legjobb almas pite valaha!');
INSERT INTO COMMENT (user_id,recipe_id,comment) VALUES (3,1,'Ettem mar jobbat is...');
INSERT INTO COMMENT (user_id,recipe_id,comment) VALUES (4,2,'5*!!!');
INSERT INTO COMMENT (user_id,recipe_id,comment) VALUES (2,4,'Anyukam levesenel semmi se finomabb!');
INSERT INTO COMMENT (user_id,recipe_id,comment) VALUES (1,2,'Kolaval elment');