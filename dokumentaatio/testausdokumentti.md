# **Testausdokumentti ja jatkokehitysty�n pohdintaa**

**Automaattisesti testatut ja testauksen ulkopuolelle j��neet luokat**

Checkstyle-testausta k�ytet��n kaikkiin muihin luokkiin paitsi Main:iin.
Sen sijaan Pit-testausta k�ytet��n vain luokkien "Polynomi", "SinCos" ja "Arpoja" testaamiseen.
Muut luokat ovat joko tapahtumankuuntelijoita, k�ytt�liittym�luokkia tai piirt�ji�.
Niiden tarjoama toiminnallisuus on testattu kokeilemalla lukuisia kertoja.

**Ohjelman heikkouksia**

Ohjelma py�rist�� desimaaliluvut kyll� py�rist�en niinkuin pit��kin, 
mutta py�ristyksen j�lkeen j�ljelle j��v� merkitsevien numeroiden m��r�
saattaa joissain tapauksissa olla suurempi kuin kerto- jakolaskun tuloksena kuuluisi.

Toinen heikkous on rajapintaluokan "Funktio" v�h�inen k�ytt�, 
mik� lis�� tarvittavien tapahtumankuuntelijoiden m��r��. 
Ohjelmiston jatkokehityksess� t�m�n seikan tulisi ottaa huomioon.

**Jatkokehitysehdotuksia**

Ohjelma on ensimm�inen askel kohti oppimispeli�.
Seuraava askel on yhdist�� teht�v�- tai treenausn�kym�t johonkin peliin.