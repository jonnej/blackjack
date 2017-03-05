Blackjack ohjeet
================

WelcomeGUI-ikkuna
-----------------
Ohjelman käynnistyttyä, käyttäjälle aukeaa tervetuloa-ikkuna, jossa käyttäjä voi syöttää nimensä ja haluamansa rahamäärän (maksimi 999). Painamalla OK, jos vaaditut syötteet on oikein syötetty, ohjelma käynnistää GameGUI:n, jossa itse peli tapahtuu. Painamalla nollaa, painike poistaa syötteen nimi kentästä ja muuttaa rahakentän arvon 0. Exit painike sulkee ohjelman.

GameGUI-ikkuna
--------------
Käyttäjän syötettyä oikein WelcomeGUI:ssa syötteen, aukeaa GameGUI-ikkuna. Aluksi valittavina on panospainikkeet 1, 5. Näitä painamalla käyttäjä voi muuttaa panoksensa haluamaksi. Panos ei voi kuitenkaan olla suurempi kuin käyttäjän sen hetkinen rahamäärä. Rahamäärä vähenee reaaliajassa kun panosta muutetaan. Nollaa panos painike nollaa panoksen ja palauttaa käyttäjälle panoksen, joka oli asetettu. Aloita peli painike aloittaa blackjack jaon. Nollaa panos ja Aloita peli painikkeet eivät ole painettavissa, jos panos on 0.

Pelin alkaessa Ota ja jää painikkeet ovat painettavissa ja tuplaa painike, jos pelaajalla on vähintään panoksen verran rahaa saldossa ja vain kaksi korttia. Ota painikkeesta käyttäjä saa kortin käteensä. Jos käden arvo ei ylitä 21, käyttäjä voi jatkaa joko korttien ottamista tai voi jäädä jää painiketta painamalla. Jos käyttäjän käden arvo ylittää ota tai tuplaa painikkeen painamisen jälkeen 21, käyttäjä häviää panoksensa ja jos käyttäjällä on rahaa vähintään 1, niin tulee dialog-ikkuna, joka kysyy haluaako käyttäjä uuden pelin. Kyllä painamalla alkaa uusi peli ja ei tai ruksia painamalla tulee message-window, joka kiittää pelaamisesta ja antaa käyttäjän viimeisimmän rahamäärän. Jos taas käyttäjän rahamäärä on pelin loputtua pienempi kuin 1, niin tulee message-window, jossa ilmoitetaan että rahat loppuivat. Jää painiketta painaessa jakaa ohjelma jakajalle käden ja ilmoittaa miten pelissä kävi ja rahamäärän riittäessä kysyy uudesta pelistä. Tuplaa painiketta painaessa käyttäjä saa yhden kortin, panos tuplataan ja jos käden arvo ei ylitä 21, tapahtuu sama kuin jää painiketta painaessa.

Jos aloita peli painikkeen painamisen jälkeen jakajan ensimmäinen kortti on ässä, ilmestyy dialog-window (JOS käyttäjällä on vähintään puolet panoksesta rahaa), joka kysyy haluaako käyttäjä vakuutuksen. Kyllä ostaa vakuutuksen, muut eivät.

Pelin säännöt
-------------
Blackjack pelin tarkoituksena on pelata taloa vastaan ja voittaa. Pelissä on yksi korttipakka ja korttien arvot ovat: Ässä on 1 tai 11, riippuen tilanteesta,
kuvakortit 10 ja numerokortit oman arvonsa verran. Pelissä pyritään mahdollisimman lähelle korttien yhteisarvoa 21. Erikoissääntönä jos saat 21 eli yhden ässän
ja kuvakortin tai kympin, niin kutsutaan tilannetta blackjackiksi. Tällöin jos jakajalla ei ole blackjackia voitat panoksesi 2.5kertaisena takaisin.
Pelaajalle jaetaan alussa 2 korttia ja pelaaja näkee talon yhden kortin ennen kuin pelaaja päättää alkaako ottaa lisää kortteja "ota" napilla. Jos pelaajan
korttien summa menee yli 21, pelaaja häviää suoraan ja jakajalle ei jaeta lisää kortteja. Jakajan pitää vuorollaa ottaa kortteja niin kauan kunnes
jakajan korttien summa on 17 tai yli. Jos jakaja menee yli 21, niin pelaaja voittaa.

Panostus tapahtuu ennen jakoa ja enempää kuin sen hetkinen rahamäärä ei voi panostaa. Halutun panoksen asettelun jälkeen "aloita peli" painike aloittaa pelin,
jonka jälkeen on mahdollista ottaa kortti (ota), jäädä (jää) jolloin kortteja ei oteta enään ja tuplaus (tuplaa). Tuplauksessa pelaaja saa vain yhden kortin ja panos tuplataan. Pelaajan paineuttua jää tai tuplaa nappia alkaa jakajan vuoro.

Erikoissääntö: Jos jakajan ensimmäinen kortti on ässä, niin pelaaja voi ostaa vakuutuksen. Vakuutuksen hinta on puolet panoksesta. Tämän jälkeen peli jatkuu normaalisti. Jos pelaaja menee yli 21, menettää hän vakuutusmaksunsa panosmaksun lisäksi. Jos pelaaja ei mene yli ja jakaja saa blackjackin eli jakajan toinen kortti on arvoltaan 10, niin pelaaja saa panoksen ja vakuutusmaksun takaisin.

Aina kun pelaaja voittaa ilman blackjackia, niin pelaaja saa panoksensa kaksinkertaisena takaisin. Jos tulee tasapeli jakajan kanssa, niin panos
palautuu pelaajalle. Pelaajan hävitessä panos jää talolle.

Pelin loputtua tulee ilmoitus, jossa kerrotaan kuinka pelissä kävi ja kysytään haluaako pelaaja pelaa uuden pelin. Jos pelaajan rahat loppuivat
edellisessä pelissä, tulee ilmoitus että rahat loppu ja näkemiin!
