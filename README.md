# Zadanie 1 - Strelené kačky lite
B-OOP 2022

Vašou úlohou je naprogramovať zjednodušenú verziu kartovej hry Strelené Kačky ako konzolovú JAVA aplikáciu.

## Úvod do hry
Kačky si plávajú v rybníku. Netušia však, že sa k rybníku približujú strelci, ktorý keď začnú stielať, tak sa nezastavia pokiaľ netrafia všetky kačky. Avšak niektorí strelci musia niektoré kačky chrániť a naopak snažiť sa streliť čo najviac súperových kačiek.

## Cieľ hry
Chránťe svoje vlastné kačky a zlikvidujte všetky kačky vašich súperov. Vyhráva hráč, ktorému ako jedinému prežili kačky (zjednodušene je, že každý hráč bude mať na začiatku 5 životov a za každú zastrelenú kačku príde o život).

## Karty
* 5 Kariet kačka pre každého hráča
* 5 Kariet vody
* 6 Kariet zameriavačov
* 34 Akčných kariet

## Príprava hry
Hru môže hrať 2-6 hráčov. Každý hráč dostane 5 kariet kačiek. Karty kačiek všetkých hráčov sa zamiešajú spolu s kartami vody a tento balíček si odložíme a budeme používať na vykladanie do Rybníka (Hracie pole o veľkosti 6).
Z balíčka, v ktorom sú zmiešané karty kačiek a vody, vyložíme 6 kariet na stôl. Prvá kačka sa nachádza Vľavo (prípadne Hore, pre zjednodušenie zobrazovania rybníka). Nad každou vyloženou kartou potrebujeme mať prázdne miesto, kde vieme vkladať zameriavače (Druhé hracie pole o velkosti 6).
Následne zamiešame balíček akčných kariet a každému hrácovi rozdáme 3.
Výpis hracieho poľa môže vyzerať nasledovne (Vertikálne zobrazenie hracieho pola):

Rybníček
1. - Nezamierené - Kačka hráča 1
2. - Zamierené - Kačka hráča 2
3. - Nezamierené - Kačka hráča 3
4. - Zamierené - Voda
5. - Nezamierené - Voda
6. - Nezamierené - Kačka hráča 1

Samozrejme hracie pole môže byť aj Horizontálne položené ako je to v pôvodnej hre, je pri ňom však tažšie udržať čitateľne, ktorý zameriavač patrí ku ktorému políčku v rybníku.

## Priebeh hry
Hru začína prvý hráč. Každý hráč musí vo svojom tahu zahrať práve jednu akčnú kartu. Poradie jednotlivých akcií v priebehu ťahu hráča je nasledovný:
* Najskôr hráč, ktorý je na ťahu, musí zahrať jednu kartu z ruky, a to i vtedy, pokiaľ by ho jeho karta poškodila.
* Vykoná akciu, ktorú určuje zahraná karta.
* Hráč, ktorý kartu zahral, si znova doberie kartu tak, aby mal na ruke 3 karty.

POZOR: Kartu musí zahrať aj v prípade, ak by musel zastreliť svoju kačku. Pokiaľ sa žiadna karta nedá logicky zahrať (hráč ma na ruke 3 karty Strieľaj ale nie je zamierené na žiadne políčko v rybníku), tak musí jednu kartu zahodiť na spodok balíčka akčných kariet , a vziať si z neho inú (v tomto kole hráč nehrá žiadnu kartu).

Vo chvíli, keď zastrelítie niekoho kačku, odstránite ju z rybníka a odoberiete život hráčovi, ktorému patrila (5 kačiek = 5 životov). Hráč, ktorý prišiel o všetky kačky je vyradený z hry.

## Koniec hry
Vyhráva hráč, ktorému ako jedinému prežily kačky (zjednodušenie je, že každý hráč bude mať na začiatku 5 životov a za každú zastrelenú kačku príde o život).

## Prehľad akčných kariet
### Zamierenie a streľba
#### Zamieriť - 10 kariet
Zahraním karty zamieriť si zvolíme, nad ktoré políčko v rybníku zamierime. Túto kartu vieme zahrať iba na políčko, nad ktorým ešte zameriavač nie je. Zamierime iba nad toto dané mieto v rybníku, nie na konkrétnu kačku. To znamená, že ak sa kačka z tohto miesta pohla, zameriavač stále ostáva na mieste, a zamierené bude na inú kačku alebo na kartu vody. Môžeme zamieriť aj na miesto, kde sa nachádza v rybníku voda.

#### Vystreliť - 12 kariet
Zahraním karty vystreliť vieme streliť na zamierené políčko. Nie je podstatné , ktorý hráč zamieril na dané políčko. Hociktorú kačku, ktorá sa nachádza na zamierenom políčku môže zasteliť hociktorý hráč. Zastrelená kačka je odstránená z hry. Všetky karty, ktoré sa nachádzajú za touto kačkou posunte o jedno pole dopredu, a na koniec doplne kartu z balíčka. Po vystrelení odstránte zameriavač. Kartu vystreliť ide zahrať aj keď je zamierené políčko s vodou. V tom prípade však karta vody ostáva na svojom mieste a odstránime iba zameriavač.

#### Divoký Bill - 2 karty
Funguje ako kombinácia kariet Zamieriť a Vystreliť. Odstráňte z rybníka ľubovoľnú kačku. Pokiaľ nad daným políčkom bol zameriavač, vráťte ho do kôpky. Kačice v rybníku sa musia posunúť aby zaplnili dieru, tak ako v prípade karty vystreliť.

### Pohyb Kačiek
#### Kačací pochod - 6 kariet
Posuňte všetky karty v rade o jedno políčko dopredu. Prvú kartu vráťte späť na koniec balíčka s kačicami, a voľné pole na konci rybníka doplňte kartou z vrchu balíčka s kačicami.

#### Turbokačka - 1 karta
Posuňte ľubovoľnú kačku na políčko najviac v predu rybníka. Kačky, ktoré predbehla, posuňte o jedno miesto dozadu.

#### Rošambo - 2 karty
Náhodne premiešajte pozície všetkých kariet v rybníku. Zameriavače ostávajú na svojich miestach (spravte shuffle na kartách v rybníku)

#### Kačací tanec - 1 karta
Zoberte karty z rybníka a zamiešajte ich s balíčkom s kačicami. Potom vyložte nových 6 kariet do rybníka.

## Hodnotenie

Zadanie je hodnotené 10 bodmi. 5 bodov je za funkčnosť zadania, 5 bodov za Princípy OOP. **Odovzdaný program musí byť skompilovateľný, inak je
hodnotený 0 bodmi**. Skompilovateľnosť zadania kontroluje aj github pipeline. Hlavný dôraz v hodnotení sa kladie na objektový prístup a princípy,
okrem iného:

* vhodné pomenovanie tried a metód v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* nepoužívajte nested classy,
* vo vašich triedach nevytvárajte statické metódy (v zadaní nie sú potrebné),
* v hlavnej triede (main) nevytvárajte žiadnu logiku, iba vytvorte nový objekt.

Niektoré z vecí, za ktoré sme minulý rok strhli po 0,5 - 1 bode:

* Rozhodovanie použitia kariet cez If/Switch (nato treba použiť dedenie)
* Neošetrené vstupy
* Kód v Main triede (máme tam len zavolať triedu, ktorou spustíme hru, nič viac)
* Nevyužité dedenie
* Statické premenné
* Zlý package naming
* Nepoužívanie konvencíí pomenovania tried a premenných
* new Scanner alebo Random (stále vytváranie novej a novej inštancie, treba vytvoriť len jednu a používať tú)
* Nested class
* Logika iba v jednej triede
* Nevyuzitie polymorfizmu
* Spadnutie hry na nejakej Exception
* Inicializácia objektov priamo v mieste ich vytvorenia a nie v ich konštruktoroch
* Nevhodné modifikátory prístupu
* Nevypísanei vítaza na konci hry

Prípadne sú pri nedostatočnej implementácií struhnuté body za OOP za nedostatočnú implementáciu.

**Pri zadaní sa kontroluje originalita zadaní, a všetky zadania so zhodou vyššou ako 80% sú hodnotené 0 bodmi.**

## Odovzdávanie
Zadanie si naklonujte z repozitára zadania výhradne pomocou poskytnutej linky cez GitHub Classroom (pokiaľ si vygenerujete vlastný repozitár pomocou tlačidla "Use this template" z template repozitára, my váš repozitár neuvidíme a nebudeme ho hodnotiť!). Svoje vypracovanie nahrajte do pre vás vytvoreného repozitára pre toto zadanie pomocou programu Git (git commit + git push).
Skontrolujte si, či sa váš repozitár nachádza pod skupinov **Interes-Group**, inak nemáme prístup ku vášmu repozitáru a zadanie sa nepovažuje za odovzdané. Vypracovanie môžete "pusho-vať" priebežne. Hodnotiť sa bude iba _master_ branch. Zadanie je nutné vypracovať do **25.3.2022 23:00**.

V projekte upravujte iba súbory v priečinku _src/main_ a jeho podpriečinkoch. Ostatné súbory je upravovať zakázané (predovšetkým súbory _pom.xml_, súbory obsahujúce github pipeline-y a súbory obsahujúce automatizované testy).

Vo svojom github účte si nastavte svoje meno alebo AIS login (settings > profile > name), aby bolo možné priradiť riešenie ku študentovy. **Pokiaľ nebude možné spárovať študenta s riešením je zadanie hodnotené 0 bodmi!**

## Zdroje (pre lepšie pochopenie zadania)
* [Pravidlá pôvodnej hry](https://hrajeme.cz/wp-content/uploads/Files/Strelenekachny.pdf)
* [Krátke video o pôvodnej hry](https://www.youtube.com/watch?v=6pQn0A1S6Eg)

# Assignment 1 - Duck hunt
B-OOP 2022

Your task is to create a simplified version of the card game "Duck hunt" in the form of a console JAVA aplication.

## Game introduction
Ducks are swimming peacefully in a pond. They have no idea that there are hunters nearby, and the hunters won't stop shooting until all the ducks are dead. Each of the hunters must protect some of the ducks and their goald is to shoot all the ducks of the other hunters.

## Goal of the game
Protect your own ducks and try to kill the ducks of the other players. The player who has the only surviving ducks wins (for simplification, each player has 5 lives at the start of the game and they will lose a life whenever one of their ducks dies).

## Cards
* 5 Ducks for each player
* 5 Empty water cards
* 6 Crosshair cards
* 34 Action cards

## Before the game starts
The game is played by 2-6 players. Each player has 5 ducks. The ducks and the empty water cards are shuffled together to create the deck of ducks. The top 6 cards of this deck are drawn and layed out side by side to create the pond (a game board with 6 spaces). The leftmost (or topmost, for simplification when printing the board) duck is in the first position. Above each space in the pond is a space for the crosshairs (a second game board with 6 spaces).
The action cards are shuffled together and each player gets 3 of them.
An example of how to print the game boards (verticaly) can be seen here:
Pond
1. - Not aimed at - Duck of player 1
2. - Aimed at - Duck of player 2
3. - Not aimed at - Duck of player 3
4. - Aimed at - Water
5. - Not aimed at - Water
6. - Not aimed at - Duck of player 1

The game board can be printed horizontaly as well (as in the original game), it might be more difficult however to align all the information in a readable way.

## During the game
The game begins with player 1. Each player must play one action card on their turn. The order of operations during a players turn is as follows:
* The player must play one card from their hand even if it should hurt them.
* The effect of the card takes place.
* A new card is drawn from the deck of action cards, so that the player ends their turn with 3 cards.

WARNING: A player must play a card even if it means killing their own duck. If the player has no legal moves (eg. the player has 3 Shoot cards, but no space is targeted) they must discard one of their cards and draw another one (they don't play a card during this turn).

When a duck is shot, remove it from the pond and remove one life from the player that owns it (5 ducks = 5 lives). When a player runs out of all ducks (lives) they no longer participate in the game.

## End of the game
The last player standing wins.

## Action cards
### Aim and Shoot
#### Aim - 10 cards
When played we target one space of the pond. We can only target a place that is not yet targeted. We do not target a specific duck but only the space of the pond it is sitting in. If the duck moves the targeted space remains in the same place and will target a new duck or water. A space that contains water may be targeted.

#### Shoot - 12 cards
When played we shoot at a targeted space. It does not matter which player targeted the space. Any duck that is currently sitting in a targeted space can be shot by any player. The shot duck is removed from the game. All the cards that are placed in the spaces to the right (down) of the duck move by one space to fill the gap. The last space in the pond is filled by the top card of the duck deck. The crosshair is removed from the space (it is no longer targeted). Shoot can be played on a targeted water space. The water is not removed in this case, only the crosshair is removed (the space is no longer targeted).

#### Wild Bill - 2 cards
Is a combination of the Aim and Shoot cards. Remove any duck from the pond. If the space it was sitting on was targeted, remove the crosshair. The ducks will move to fill the empty space in the pond, just like when the Shoot card is played.

### Duck movement
#### Duck march - 6 cards
All the ducks move one space forward. The duck in the first space is moved to the bottom of the duck deck, the empty space at the end is filled with the duck from the top of the duck deck.

#### Turboduck - 1 card
Move any duck to the first space in the pond. The ducks that were overtaken by it move one space backwards, to fill the gap.

#### Scatter - 2 cards
Randomly rearange the positions of all the cards in the pond. The targeted spaces do not change (perform a shuffle of the cards in the pond).

#### Duck dance - 1 card
Put the cards from the pond back into the duck deck, shuffle the deck and place 6 new cards into the pond.

## Evaluation
You can get 10 points for this assignment. 5 points are given for fulfilling the outlined rules of the game, 5 points are given for complying with OOP principles. **The program must be able to compile, otherwise 0 points are given for the assigment**.

The github pipeline checks whether the program can be compiled. The main focus during grading is put on object-oriented approach and OOP principles used by the solution.

Including, but not limited to:
* appropriate naming of classes, methods and variables in a single language (class names starting with a capital letter, method names starting with a lowercase letter),
* appropriate use of access modifiers (public, private, or protected) when restricting access to class methods and attributes, the use of inheritance and polymorphism,
* usage of exceptions when handling undesired behavior (do not catch or throw the instances of the generic Exception class),
* don't use nested classes,
* don't use static methods, or non-constant static variables (you don't need them to complete the assignment),
* don't put any logic into the main method and its class. The main method should only be used to create the game class,

Issues that resulted in a 0.5 - 1 point reduction last year:
* deciding the card effect with if/switch statements (should be done trough inheritance)
* unchecked inputs
* code in the Main class (we should only start the game here)
* no use of inheritance
* static variables
* bad package naming
* non-conventional naming of classes and variables
* new Scanner and Random (new instances were created with each call, only one instance should be created and re-used)
* nested classes
* the entire logic written in one class
* no use of polymorphism
* game crash caused by some Exception
* initialisation of objects in the place they were created and not in their constructors
* unsuitable access modifiers
* the winner was not printed at the end of the game

If the assignment lacks a substantial part of the specified functionality additional points are substracted.

**The originality of the code is checks, all assignments with a more than 80% match are awarded with 0 points.**

## Handing in the assigment

Clone the assignment from the repository created from this template by the provided link trough GitHub Classroom (if you create your own repository with the "use this template" button, we won't be able to see your repository, and we won't be able to grade it!). Upload your solutions to your repository using the Git version control system (git commit + git push).

Make sure, that your repository was created under the **Interes-Group** group, otherwise we won't be able to access your repository, and the assignment will not be graded.

You can push commits to the repository while you work - you don't have to push everything at once. Only the code in the _master_ branch will be graded. You have until **25.3.2022 23:00** to complete the assignment.

Only edit files in the _src/main_ folder or its sub-folders. You mustn't change any other files in the repository (especially the _pom.xml_ file, and the github pipeline files).

You have to have your name set in your github account (settings > profile > name), so that we can match students with their assignments. **If we are unable to match a student with their assignment, the student will receive 0 points for the assignment!**

## Resources (for better understanding of assignment, but only in CZ)
* [Rules of the original game](https://hrajeme.cz/wp-content/uploads/Files/Strelenekachny.pdf)
* [Short video about original game](https://www.youtube.com/watch?v=6pQn0A1S6Eg)