Alkalmazások fejlesztése projekt: Recept TO-DO

A projekt célja egy receptek feltöltésére használható webes alkalmazás elkészítése.
Funkcionális Követelmények:
Minden felhasználóra vonatkozóan:

    Regisztráció
    Bejelentkezés
    Kijelentkezés
    Recept kedvencekhez adása
    Kedvencekből recept törlése
    Receptek létrehozása
    Receptek törlése

Adminisztrátor(ok)ra vonatkozóan:

    
    Báremly felhasználó receptjeinek módosítása
    Báremly felhasználó receptjeinek törlése
    Bármely felhasználó törlése
    Recept kedvencekhez adása
    Kedvencekből recept törlése
    Kategóría létrehozása
	Kategóría módosítása
	Kategóría törlése

Nem Funkcionális Követelmények:

    Biztonság:
        jelszavak hashelése
        
    Kezelhetőség:
        csak a felhasználó részére érdekes dolgok jelennek meg
        Intuitiv felhasználói felület

Szakmai Fogalmak:

	Kategória: Egy recept kategóriája pl: Leves,Pizza,Tésztaétel
    Recept: Egy kategóriába besorolható étel.
	Hozzávaló: Egy recept elkészítéséhez való hozzávaló pl: Só,cukor,liszt
    Recept felépítése:
        Kategória
		Felhasználó aki feltöltötte
		Hozzávaló (több is lehet)
		Leírás
		

Szerepkörök

    Adminisztrátor: Kezeli a kategóriákat, ellenőrzi a recepteket ha baj van vele törölheti
    Felhasználó: Feltölthet új recepteket, sajátjait módosíthatja, törölheti.
	Nem bejelentkezett felhasználó: Böngészheti a recepteket.
