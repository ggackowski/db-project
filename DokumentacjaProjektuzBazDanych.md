Projekt Bazy Danych

Dokumentacja

Łukasz Pitrus

Grzegorz Gackowski

* * * * *

Opis projektu 
=============

Projekt jest prostą aplikacją z przepisami napisaną w języku Java,
wykorzystującą technologie Hibernate, JavaFX oraz bazę danych SQLite.

Funkcjonalności aplikacji 
=========================

Aplikacja umożliwia przeglądanie znajdujących się w bazie przepisów, Po
rejestracji, można zalogować się i wystawiać oceny (w skali 1-5)
istniejącym przepisom, z pominięciem swoich przepisów. Zalogowany
użytkownik ma możliwość dodawania nowych przepisów. Dodane w ten sposób
przepisy wyświetlają się następnie wśród pozostałych. Autor danej
pozycji ma możliwość późniejszej edycji lub usunięcia przepisu.

Wykorzystane technologie 
========================

Aplikacja powstała z wykorzystaniem języka Java w wersji 11, środowisko
graficzne zostało zbudowane za pomocą JavaFX 14, Połączenie z bazą
danych utworzone zostało poprzez Hibernate 5.4. Baza SQLite wymaga
ponadto wykorzystania SQLite JDBC w wersji 3.7. Wszystkie te zależności
są zarządzane i pobierane dzięki narzędziu Maven.

 

Pracowaliśmy w środowisku Intellij IDEA Ultimate.

Diagram bazy danych 
===================

Baza danych znajduje się w pliku mydb.db.

Przewodnik po kodzie 
====================

Klasy podzielone są na następujące pakiety

1.  dataGeneration

-   DataGenerator

Klasa ta odpowiedzialna jest za generowanie przykładowych danych do
bazy. Wykorzystywana jest tylko podczas tworzenia nowej bazy danych, w
celu jej początkowego wypełnienia.

-   GeneratorMain

Klasa uruchamiająca generowanie danych do bazy.

2.  dataObjects

-   User

Zawiera imię, nazwisko, email i hasło użytkownika, a także listy
powiązanych przepisów, których jest autorem.

-   Recipe

Zawiera tytuł, składniki, opis przygotowania, sumę i liczbę ocen, a
także powiązanie do użytkownika, który jest autorem danego przepisu oraz
listę użytkowników, którzy wystawili ocenę temu przepisowi.

3.  JavaFX

-   HelloFX

Klasa, która uruchamia się wraz z programem. Konfiguruje środowisko
graficzne i otwiera ekran z listą przepisów.

-   ListScreen

Kontroler widoku listy przepisów. Pobiera z bazy danych dostępne
przepisy i wyświetla je na liście.

-   LoggingScreen

Kontroler widoku logowania. W przypadku nieistnienia użytkownika o
określonych danych stosowna informacja pojawi się na ekranie.

-   NewRecipeScreen

Kontroler widoku dodawania nowego przepisu. Jest dostępny tylko dla
zalogowanych użytkowników.

-   RegisterScreen

Kontroler widoku rejestracji. W bazie danych nie może pojawić się dwóch
użytkowników o takich samych adresach email.

-   ViewScreen

Kontroler widoku podglądu danego przepisu. Zalogowani użytkownicy

mogą tutaj oceniać przepisy, a autorzy usuwać lub edytować swoje dzieła.

-   EditRecipeScreen

Kontroler widoku edycji wybranego przepisu. Można edytować tytuł, listę
składników oraz opis wykonania.

-   ScenesManager

        Klasa obsługująca przełączanie się pomiędzy widokami.

4.  Utils

-   CurrentUser

Klasa odpowiadająca za aktualnie zalogowanego użytkownika i samo
logowanie użytkownika. Jest ona Singletonem.

-   CurrentRecipe

Klasa, będąca Singletonem, zawierająca aktualnie przeglądany przepis.

-   DatabaseProvider

Klasa odpowiadająca za komunikację z bazą będąca Singletonem. Odpowiada
ona za poprawność wprowadzanych i pobieranych danych.

Ponadto projekt wykorzystuje następujące pliki konfiguracyjne:

1.  Pliki opisujące strukturę scen JavaFX

-   EditRecipeScreen.fxml

        Opisuje strukturę widoku edycji przepisu.

-   ListScreen.fxml

        Opisuje strukturę widoku listy przepisów.

-   LogginScreen.fxml

        Opisuje strukturę widoku ekranu logowania.

-   NewRecipeScreen.fxml

        Opisuje strukturę widoku dodawania nowego przepisu.

-   ViewScreen.fxml

Opisuje strukturę widoku szczegółów przepisu.

-   RegisterScreen.fxml

Opisuje strukturę widoku ekranu rejestracji.

2.  Plik konfiguracyjny Hibernate

-   hibernate.cfg.xml

Zawiera informacje o dialekcie bazy danych oraz o lokalizacji pliku z
bazą. Informuje o mapowanych do bazy klasach

+--------------------------------------------------------------------------+
| \<?xml version='1.0' encoding='utf-8'?\>\                                |
| \<!DOCTYPE hibernate-configuration PUBLIC\                               |
|         "-//Hibernate/Hibernate Configuration DTD//EN"\                  |
|                                                                          |
|  "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd"\>\       |
| \<hibernate-configuration\>\                                             |
| \                                                                        |
|     \<session-factory\>\                                                 |
| \                                                                        |
|         \<property name="show\_sql"\>true\</property\>\                  |
|         \<property name="format\_sql"\>true\</property\>\                |
|                                                                          |
|  \<property name="dialect"\>org.hibernate.dialect.SQLiteDialect\</proper |
| ty\>\                                                                    |
|                                                                          |
|  \<property name="connection.url"\>jdbc:sqlite:mydb.db\</property\>\     |
|                                                                          |
|  \<property name="connection.driver\_class"\>org.sqlite.JDBC\</property\ |
| >\                                                                       |
|         \<!--\<property                                                  |
| name="hibernate.hbm2ddl.auto"\>create\</property\>--\>\                  |
| \                                                                        |
|         \<mapping class="dataObjects.Rating"/\>\                         |
|         \<mapping class="dataObjects.Recipe"/\>\                         |
|         \<mapping class="dataObjects.User"/\>\                           |
| \                                                                        |
|     \</session-factory\>\                                                |
| \</hibernate-configuration\>                                             |
+--------------------------------------------------------------------------+

Połączenie z bazą danych 
========================

Metody obsługujące bazę danych z klasy DatabaseProvider

Pobieranie danych z bazy

List\<Recipe\> getRecipes()

Zwraca listę wszystkich przepisów z bazy danych.

List\<User\> getUsers()

Zwraca listę wszystkich użytkowników bazy danych.

User getUserByName (String name, String surname)

Zwraca użytkownika o danym imieniu i nazwisku

User getUserByEmail (String email)

Zwraca użytkownika o danym adresie e-mail.

Recipe getRecipeByTitle (String title)

Zwraca przepis o danym tytule

Dodawanie do bazy

boolean addUser(User user)

Dodaje użytkownika do bazy.

boolean addRecipe(Recipe recipe)

Dodaje przepis do bazy.

Aktualizacja danych w bazie

void updateUser(User user)

Aktualizuje informacje o użytkowniku.

void updateRecipe(Recipe recipe)

Aktualizuje informacje o przepisie

Usunięcie obiektu z bazy

void removeUser (User user)

Usuwa użytkownika

void removeRecipe (Recipe recipe)

Usuwa przepis

Sposób uruchomienia 
===================

Jeśli jest to pierwsze uruchomienie aplikacji i nie jest ona wypełniona
danymi, należy w pliku konfiguracyjnym hibernate odkomentować poniższą
linijkę

\<property name="hibernate.hbm2ddl.auto"\>create\</property\>

i uruchomić main w klasie GeneratorMain. Zapełni ona bazę przykładowymi
danymi.

Przed uruchomieniem samej aplikacji z przepisami należy upewnić się, że
w pliku konfiguracyjnym hibernate ponownie zakomentowana jest poniższa
linijka

\<property name="hibernate.hbm2ddl.auto"\>create\</property\>

Aplikacja uruchamia się i można z niej korzystać w sposób opisany w
następnym punkcie.

Działanie programu 
==================

Po uruchomieniu programu wyświetla się lista dostępnych w bazie
przepisów

Skąd można przejść do ekranu logowania

Po kliknięciu w wybrany przepis możliwe jest przeczytanie dalszych
informacji o nim

Zalogowany użytkownik ma możliwość oceny przepisu

Może także dodawać własne przepisy

Link do repozytorium

[https://github.com/ggackowski/db-project]
(https://www.google.com/url?q=https://github.com/ggackowski/db-project&sa=D&ust=1591647312800000)
