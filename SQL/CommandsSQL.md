#SQL - komendy

## Tworzenie bazy danych

### CREATE DATABASE db_name;   
###(Stwórz bazę o nazwie db_name)
### use db_name;               
###(Teraz wszystkie komendy idą do db_name)

## Tworzenie tabeli

### CREATE TABLE table_name 
###   	column1 datatype,
###   	column2 datatype,
###   	column3 datatype,
###   	....
###   );
###   (Stwórz tabelę table_name z kolumnami column1, column2 … każda o wskazanym typie datatype.)

## Usuwanie tabeli

### DROP TABLE table_name;
### (Usuwa tabele table_name wraz z wszystkimi danymi)

## Klucz główny Primary Key (PK)

###CREATE TABLE table_name (
####  	id INT NOT NULL,
#### 	...
####   	PRIMARY KEY(id)
####   );

####   ▪ Unikalny
####   ▪ Najcześciej INT/UINT lub UUID
####   ▪ Niezmienny
####   ▪ Baza pilnuje integralności
####   ▪ Dla INT, zostawmy bazie jego ustawianie: AUTO_INCREMENT

### Przyklad: 
###                create table pracownicy(
####               id int auto_increment,  
####               surname varchar(30),
####               staz tinyint,
####               ocena tinyint,
####               stanowisko varchar(15),
####               pensja smallint,
####               premia smallint,
####               primary key(id)  
####              );
###

###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###
###

