# Alkalmazások fejlesztése projekt: Recept TO-DO

A projekt célja egy receptek feltöltésére használható webes alkalmazás elkészítése.

### Funkcionális Követelmények:

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

### Nem Funkcionális Követelmények:

- Biztonság:
  - jelszavak hashelése
        
- Kezelhetőség:
  - csak a felhasználó részére érdekes dolgok jelennek meg
  - Intuitív felhasználói felület

### Szakmai Fogalmak:

- **Kategória:** Egy recept kategóriája pl: Leves,Pizza,Tésztaétel
- **Recept:** Egy kategóriába besorolható étel.
- **Hozzávaló:** Egy recept elkészítéséhez való hozzávaló pl: Só,cukor,liszt

- Recept felépítése:
  - Kategória
  - Felhasználó aki feltöltötte
  - Hozzávaló (több is lehet)
  - Leírás
  - Hozzászólások
		

### Szerepkörök

* **Adminisztrátor:** Kezeli a kategóriákat, ellenőrzi a recepteket, hozzászólásokat, ha baj van velük törölheti őket.
* **Felhasználó:** Feltölthet új recepteket, sajátjait módosíthatja, törölheti, illetve hozzászólhat, a saját hozzászólásait törölheti, módosíthatja.
* **Nem bejelentkezett felhasználó:** Böngészheti a recepteket, elolvashatja a hozzászólásokat.
