Asioita, joita ei ole testattu automaattisesti
----------------------------------------------
- Deck-luokan createDeck() metodi. Pakan luomisen testasin printtaamalla deckin sen luonnin jälkeen.
- UicConclusion-luokan checkWinnerAndPayWins() ja payWins() metodit. Peliä pelaamalla ei sattunut yhtään poikkeustapausta, että olisi maksanut
  väärin tai antanut väärän voittajan. Pelikertoja tosin ei ole riittävästi, jotta voisi olla täysin varmistunut että bugeja ei olisi.
- UicBetting-luokan askForInsurance() metodi. Manuaalisesti painamalla erivaihtoehtoja (kymmeniä kertoja) näytti toimivan halutulla tavalla.
- Dealer-luokan shuffleDeckNTimes() metodi. Käytin valmista Collections rajapinnan shuffle metodia.


Bugeja
------
- Ainut bugi johon olen törmännyt, mutta ei ole vähään aikaa ilmennyt on että välillä peli päättyy heti aloita peli painikkeen jälkeen, vaikka
  kortteja ei ole jaettu. Koska uusimmassa versiossa bugia ei ole näkynyt niin se on luultavasti korjaantunut.
