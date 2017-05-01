# **Ohjelmoinnin harjoitustyö**

**Aihe:**
Erilaisten funktioiden integroiminen ja derivoiminen.

**Käyttäjät:**
Ohjelma on suunniteltu oppimisen avuksi opiskelijoille, jotka opiskelevat integroimista ja derivoimista.

**Käyttäjien toiminnot:**
* Ohjelman avulla opiskelijat voivat integroida ja derivoida erilaisia käyriä.
  * Käyrän integroiminen tapahtuu "Integroi" -näppäimellä.
  * Käyrän derivoiminen tapahtuu "Derivoi" -näppäimellä.
  * Opiskelija voi valita alussa käyrään haluamansa parametrit.
* Ohjelman avulla opiskelijat voivat nähdä käyrän kulun visuaalisesti.
  * Alkuperäisen funktion sekä sen integroidut ja derivoidut käyrät voi piirtää samaan kuvaan.
* Opiskelija voi treenata itse integroimista ja derivoimista ohjelman avulla.
  * Ohjelmaa voi pyytää arpomaan funktion sekä sen, integroidaanko funktio vai derivoidaanko.
  * Opiskelija voi tarkistaa tehtävän oikean vastauksen ohjelman avulla.

**Ohjelman rakennekuvaus:**
* Käyttäjät käyttävät ohjelmaa käyttöliittymänäkymien avulla. 
Käyttöliittymänäkymien painikkeet on toteutettu tapahtumankuuntelijoiden avulla. 
Kun kone arpoo tehtävän, arpomisessa käytetään Arpoja-olioita. Piirtämiseen tullaan käyttämään erikseen kaikille yhteistä Piirtaja-luokkaa.
* Eri Funktio-rajapinnan toteuttavia olioita on tähän valittu Polynomi ja sinin ja kosinin yhdistävä SinCos,
mutta niiden määrä voisi lisätä opetusohjelman päämäärän mukaan. Funktio-oliot voidaan 
integroida, derivoida ja tulostaa haluttuun muotoon. Rajapinnan käytön lisääminen tulee parantamaan ohjelman laajennettavuutta.

Määrittelyvaiheen luokkakaavio:
![Luokkakaavio](Luokkakaavio.jpg)

Sekvenssikaavio1:
![Sekvenssikaavio1](Sekvenssikaavio1.jpg)

Sekvenssikaavio2:
![Sekvenssikaavio2](Sekvenssikaavio2.jpg)


