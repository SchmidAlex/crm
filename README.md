# 223 Multi-User-Applikationen objektorientiert realisieren


Ziel der Applikation ist es, Kundendaten, und zu jedem Kunden eine Liste von Gesprächsnotizen zu verwalten. Diese Daten sollen in einem Webbrowser angezeigt und verwaltet werden können.

## Handlungsziele

<b>1</b> Einschätzen, ob eine Datenbank die Anforderungen der MultiUser-Fähigkeit erfüllt und allfällige Anpassungen
dokumentieren.<br>
<b>2</b> Applikation entwerfen und mittels Transaktionen Multi- UserFähigkeit sicherstellen.<br>
<b>3</b> User Interfaces, Datenbankanpassungen und Transaktionen
implementieren.<br>
<b>4</b> Testspezifikation für funktionale und nicht-funktionale
Aspekte der Multi-User-Fähigkeit definieren, Applikation
testen und Tests protokollieren.<br>
<b>5</b> Transaktionen dokumentieren und dabei auf Wartbarkeit und
Nachvollziehbarkeit achten.<br>

## Getting Started

### Links

Auflistung Users in JSON
* http://localhost:8080/api/v0/users

Auflistung Users UI
* http://localhost:8080/web/users

Auflistung Customers UI
* http://localhost:8080/web/customers

Auflistung Customers in JSON
* http://localhost:8080/api/v0/customers

Anzeige User 1 spezifisch in JSON
* http://localhost:8080/api/v0/users/1

Anzeige Customer 1 spezifisch in JSON
* http://localhost:8080/api/v0/customers/1

### Starting the Application
Eclipse Run oder F5

### Usage
Verwaltung von Users und Customers

### Initializing
Die Daten der Datenbank werden in einem Init-Ordner eingefügt. Diese Daten wurden nur für Testzwecken verwendet.

### Using the CRM
Wenn das CRM läuft, kann man sich mit einem User auf * http://localhost:8080/login anmelden. Anschliessend kann man auf die Seite * http://localhost:8080/web/users oder * http://localhost:8080/web/customers gehen um entweder die Users oder Customers einzusehen.

Von dort aus, hat man Verlinkungen um einzelne Customers oder Users einzusehen. Ebenfalls kann man neue hinzufügen.

Um einen Customer oder User zu löschen, gibt es eine Verlinkung auf der Single-Ansicht.
