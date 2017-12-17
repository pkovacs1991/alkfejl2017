INSERT INTO USER (username,email,password,role) VALUES ('alma','a@a.com','aaa','ADMIN');
INSERT INTO USER (username,email,password,role) VALUES ('barack','b@b.com','bbb','USER');
INSERT INTO USER (username,email,password,role) VALUES ('cseresznye','c@c.com','ccc','USER');
INSERT INTO USER (username,email,password,role) VALUES ('dio','d@d.com','ddd','USER');

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