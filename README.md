# Alkalmazások fejlesztése projekt: Recept TO-DO

A projekt célja egy receptek feltöltésére használható webes alkalmazás elkészítése.

## 1. Projektötlet

### 1.1 Funkcionális Követelmények:

**Minden felhasználóra** vonatkozóan:

* Regisztráció
* Bejelentkezés
* Kijelentkezés
* Recept kedvencekhez adása
* Kedvencekből recept törlése
* Receptek létrehozása
* Receptek törlése
* hozzászólás a receptekhez
* hozzászólás szerkesztése, törlése

**Adminisztrátor(ok)ra** vonatkozóan:

* Bármely felhasználó receptjeinek módosítása
* Bármely felhasználó receptjeinek törlése
* Bármely felhasználó hozzászólásának módosítása
* Bármely felhasználó hozzászólásának törlése
* Bármely felhasználó törlése
* Recept kedvencekhez adása
* Kedvencekből recept törlése
* Receptek létrehozása
* Receptek törlése
* Kategória létrehozása
* Kategória módosítása
* Kategória törlése

### 1.2 Nem Funkcionális Követelmények:

- Biztonság:
  - jelszavak hashelése
        
- Kezelhetőség:
  - csak a felhasználó részére érdekes dolgok jelennek meg
  - Intuitív felhasználói felület

### 1.3 Szakmai Fogalmak:

* **Kategória:** Egy recept kategóriája pl: Leves,Pizza,Tésztaétel
* **Recept:** Egy kategóriába besorolható étel.
* **Hozzávaló:** Egy recept elkészítéséhez való hozzávaló pl: Só,cukor,liszt

* Recept felépítése:
  - Kategória
  - Felhasználó aki feltöltötte
  - Hozzávaló (több is lehet)
  - Leírás
  - Hozzászólások
		

### 1.4 Szerepkörök

* **Adminisztrátor:** Kezeli a kategóriákat, ellenőrzi a recepteket, hozzászólásokat, ha baj van velük törölheti őket.
* **Felhasználó:** Feltölthet új recepteket, sajátjait módosíthatja, törölheti, illetve hozzászólhat, a saját hozzászólásait törölheti, módosíthatja.
* **Nem bejelentkezett felhasználó:** Böngészheti a recepteket, elolvashatja a hozzászólásokat.

## 2. Backend megvalósítása

### 2.1 Fejlesztői környezet

#### Felhasznált eszközök

* [Git](https://git-scm.com/) verziókezelő
* [Java](https://www.java.com/) [Spring Boot](https://projects.spring.io/spring-boot/) technológia használata
* [H2](http://www.h2database.com/) adatbázis használata
* [MAVEN](https://maven.apache.org/) a projekt menedzseléséhez és a build folyamat automatizálásához
* [Github](https://github.com/) a projekt közzétételéhez

#### Fejlesztőkörnyezet felállítása

1. [Git](https://git-scm.com/) verziókezelő telepítése  
   *A [Githubon](https://github.com/) történő regisztráció ajánlott!*
2. Projekt klónozása lokális gépre: `git clone https://github.com/pkovacs1991/alkfejl2017.git`
3. A projektkönyvtárban a [Spring Boot](https://projects.spring.io/spring-boot/) függőségek beállítása:  
   `pom.xml`  
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>org.springframework</groupId>
	<artifactId>name-of-the-app</artifactId>
	<version>0.1.0</version>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.6.RELEASE</version>
	</parent>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

   </project>
   ```
4. Adatbázis felépítése példaadatokkal: `import.sql` fájlban  
   pl: `INSERT INTO USER (username,email,password,role) VALUES ('alma','a@a.com','aaa','ADMIN');`  
   *Fontos ezt beállítani, ugyanis a H2 adatbázis csak a memóriában tárol az adatokat. Enélkül üres tábláink lennének.*
5. App indítása: `pom.xml` -> `Run Maven...` -> `Goals: spring-boot:run`  
   vagy  
   `mvn spring-boot:run`  
6. Ezek után a `http://localhost:8080/` címen el tujdjuk érni a szerverünket

### 2.2 Adatbázis-terv

### 2.3 Könyvtárstruktúra

- main
  - java
    - recipes
      - config
	    - `AuthInterceptor.java`
      - controller
	    - `CategoryController.java`
		- `CommentController.java`
		- `RecipeController.java`
		- `UserController.java`
      - entity
	    - `Category.java`
		- `Comment.java`
		- `Recipe.java`
		- `User.java`
      - repository
	    - `CategoryRepository.java`
		- `CommentRepository.java`
		- `RecipeRepository.java`
		- `UserRepository.java`
      - service
	    - annotation
		  - `Role.java`
		- exception
		  - `NotFoundException.java`
		  - `NotOwnCommentException.java`
		  - `NotOwnRecipeException.java`
		  - `UserNotValidException.java`
	    - `CategoryService.java`
		- `CommentService.java`
		- `RecipeService.java`
		- `UserService.java`
      - `Application.java`
  - resources
    - `application.properties`
	- `import.sql`

### 2.4 Végpontok

- `GET/`
  - `/`: Főoldal
  - `/api/user/`
    - `/`: Saját felhasználói fiók elérése
	- `/login`: Bejelentkezés
	- `/logout`: Kijelentkezés
  - `/api/recipes/`
    - `/`: Az összes recept lekérdezése
	- `/my`: Saját receptek lekérdezése
	- `/{id}`: Egy recept lekérdezése
  - `/api/category/`
    - `/`: Az összes kategória lekérdezése
	- `/{id}`: Egy kategória lekérdezése
	- `/recipes/{id}`: Egy kategória alapján az összes recept lekérdezése
  - `/api/comments/`
    - `/`: Az összes hozzászólás lekérdezése
	- `/my`: Az összes saját hozzászólás lekérdezése
	- `/{id}`: Egy hozzászólás lekérdezése
- `POST/`
  - `/api/user/`
    - `/register`: Regisztráció
  - `/api/recipes/`
    - `/`: Recept létrehozása
	- `/favourites/{id}`: Recept hozzáadása a kedvencek közé
  - `/api/category/`
    - `/`: Kategória létrehozása
  - `/api/comments/`
    - `/`: Hozzászólás létrehozása
- `PUT/`
  - `/api/recipes/`
    - `/{id}`: Recept módosítása
  - `/api/category/`
    - `/{id}`: Kategória módosítása
  - `/api/comments/`
    - `/{id}`: Hozzászólás módosítása
- `DELETE/`
  - `/api/user/`
    - `/{id}`: Felhasználó törlése
  - `/api/recipes/`
    - `/{id}`: Recept törlése
	- `/favourites/{id}`: Recept törlése a kedvencek közül
  - `/api/category/`
    - `/{id}`: Kategória törlése
  - `/api/comments/`
    - `/{id}`: Hozzászólás törlése

####Szekvenciadiagram

### 2.5 Fontosabb specifikumok bemutatása (ha van ilyen)
