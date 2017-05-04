# **Testausdokumentti ja jatkokehitystyön pohdintaa**

**Automaattisesti testatut ja testauksen ulkopuolelle jääneet luokat**

Checkstyle-testausta käytetään kaikkiin muihin luokkiin paitsi Main:iin.
Sen sijaan Pit-testausta käytetään vain luokkien "Polynomi", "SinCos" ja "Arpoja" testaamiseen.
Muut luokat ovat joko tapahtumankuuntelijoita, käyttöliittymäluokkia tai piirtäjiä.
Niiden tarjoama toiminnallisuus on testattu kokeilemalla lukuisia kertoja.

**Ohjelman heikkouksia**

Ohjelma pyöristää desimaaliluvut kyllä pyöristäen niinkuin pitääkin, 
mutta pyöristyksen jälkeen jäljelle jäävä merkitsevien numeroiden määrä
saattaa joissain tapauksissa olla suurempi kuin kerto- jakolaskun tuloksena kuuluisi.

Toinen heikkous on rajapintaluokan "Funktio" vähäinen käyttö, 
mikä lisää tarvittavien tapahtumankuuntelijoiden määrää. 
Ohjelmiston jatkokehityksessä tämän seikan tulisi ottaa huomioon.

**Jatkokehitysehdotuksia**

Ohjelma on ensimmäinen askel kohti oppimispeliä.
Seuraava askel on yhdistää tehtävä- tai treenausnäkymät johonkin peliin.