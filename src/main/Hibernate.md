#ORM - Object Relational Mapping
- Mapowanie (zamiana) danych z relacyjnej bazy danych na obiekty w języku obiektowym.
- Skraca czas wytwarzania oprogramowania
- Przeniesienie reprezentacji tabel bazodanowych oraz relacji między nimi do świata obiektowego
- Wykonywanie zapytań bez znajomości SQL (ale ta znajomość się mocno przydaje!!)

Encja - Tabela,
Obiekt - wiersz,
Pole - komuna,

##CRUD:
Create - INSERT,
Read - SELECT,
Update - UPDATE,
Delete - DELETE

##JPA - ava Persistence API - STANDARD
- Standard JPA jest elementem standardu EJB 3.0 zdefiniowanym w JSR 220.
- Wydane w 2006 roku.
- Standard JPA Bazuje na tym co stworzył Hibernate.
- Hibernate jest implementacją JPA

JPA - komponenty
- Entities – odwzorowane tabele w postaci klas.
- Object – Relational – Metadata – kolumny w tabeli to pola w klasie + adnotacje.
- Java Persistence Query Language – Język podobny do SQL. Jest zamieniany na SQL zgodny z silnikiem bazy danych na jakiej jest uruchomiony.

##Dependencje Hipernada do Mavena:

<dependency>
<groupId>org.hibernate</groupId>
<artifactId>hibernate-core</artifactId>
<version>5.4.9.Final</version>
</dependency>
<dependency>
<groupId>org.hibernate.javax.persistence</groupId>
<artifactId>hibernate-jpa-2.1-api</artifactId>
<version>1.0.0.Final</version>
</dependency>
<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.20</version>
</dependency>

##persistence.xml

Umieszczamy w src/main.resources/META-INF

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://java.sun.com/xml/ns/persistence
http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
version="2.0">
<persistence-unit name="default" transaction-type="JTA">
<jta-data-source>java:ds/demo</jta-data-source>
<properties>
<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />
<property name="hibernate.show_sql" value="true" />
<property name="hibernate.format_sql" value="true" />
<property name="hibernate.hbm2ddl.auto" value="create" />
<property name="hibernate.connection.characterEncoding" value="UTF 8" />
<property name="hibernate.cache.use_query_cache" value="false" />
</properties>
</persistence-unit>
</persistence>

##INFO persistance.xml
-Użyj dialektu dla Mysql 
<properties>
<property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect" />

- Za pomocą tej konfiguracji możemy sterować „ewolucją” bazy danych, zmieniamy tylko value=:
   <property name="hibernate.hbm2ddl.auto" value="create" />
•validate: validate the schema, makes no changes to the database.
•update: update the schema.
•create: creates the schema, destroying previous data.
•create-drop: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.
•none: does nothing with the schema, makes no changes to the database

## web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-
app_4_0.xsd"
version="4.0">
<display-name>Archetype Created Web Application</display-name>
<data-source>
<name>java:ds/demo</name>
<class-name>com.mysql.cj.jdbc.MysqlDataSource</class-name>
<url>jdbc:mysql://0.0.0.0:3307/contacts?useLegacyDatetimeCode=false&amp;
serverTimezone=Europe/Warsaw</url>
<user>root</user>
<password>toor</password>
</data-source>
</web-app>

## web.xml oraz persistence.xml

- W web.xml definiujemy data-source – źródło danych
- W persistence.xml używamy zdefioniowanego data-source i za jego pomocą serwer tworzy EntityManagera, za pomocą którego wykonujemy zapytania do bazy danych.

## ADNOTACJE

- Hibernate wymaga bezparametrowego konstruktora w klasie encyjnej

- @Entity – na klasie – tworzy klasę encyjną
- @Table – na klasie – klasa zostaje zmapowana na tabelę w bazie danych
- @Id – na polu – pole zostaje zmapowane na klucz główny
- @GeneratedValue – na polu z adnotacją @Id – klucz będzie automatycznie generowany przez hibernate/mysql
- @Column – na polu – pole zostaje zmapowane na kolumnę w bazie danych
- @OneToMany - "Aby zademonstrować relację One to Many (jeden do wielu) posłużę się powiązaniem encji User i Comment. User czyli użytkownik będzie mógł wprowadzać wiele komentarzy Comment jego autorstwa. "
- @ManyToOne - kiedy mamy pole posiadajace wiele postaci, mogacych nalezec do jednego obiektu
- @ManyToMany - "Zademonstruję relację Many to Many (wiele do wielu) na przykładzie encji Recipe i Ingridients. Każdy przepis (Recipe) może mieć wiele składników (Ingridients), ale każdy ze składników może występować w wielu przepisach."

- fetch = FetchType.LAZY/EAGER - Lazy pobieramy tylko to co jest potrzebne, Eager pobieramy cala czesc bazy danych. 
- nullable - czy w kolumnie moga byc puste wartosci, domyslnie moga
- unique - true/false - czy w komumnie moga sie powtarzac wartosci, domyslnie moga
- name = "" - kiedy chcemy nazwac kolumne inaczej niz zazwa pola, domyslnie jest nazwa pola
- columnDefinition - definiujemy typ danych, na typ SQLowyn np. TEXT to String. Domyslnie jest var char czyli wszystko, najbardziej ogolny typ. Lepiej tego nie robic poniewaz mozna zdefiniowac typ danych dla roznych silnikow SQL i w przypadku zmiany silnika trzeba bedzie zmieniac ustawienia column
- lenght - definiujemy pojemnosc pola w danej kolumnie, domyslnie jest 255 znakow
- precision oraz scala - okreslamyu dokladnosc wartosci liczbowych

- CascadeType w Hib. może być ODŚWIEŻENIE, ŁĄCZENIE, ..., WSZYSTKO, co umieścisz pod powiązaną jednostką, określa zachowanie powiązanej jednostki, jeśli bieżąca encja jest: odświeżona, zaktualizowana, usunięta itp. Tak więc za każdym razem, gdy wpływa na ciebie encja, CascadeType mówi czy podmiot powiązany również powinien zostać dotknięty.
 
- FetchType może mieć tylko 2: EAGER i LAZY. Ten, który również umieszczasz pod podmiotem powiązanym, określa, czy podmiot powiązany powinien zostać zainicjowany natychmiast po zainicjowaniu bieżącego podmiotu (EAGER), czy tylko na żądanie (LAZY).










