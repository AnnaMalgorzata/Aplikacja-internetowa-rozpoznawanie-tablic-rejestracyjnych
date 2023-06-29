# Aplikacja internetowa umożliwiająca rozpoznawanie tablic rejestracyjnych

W projekcie zostały wykorzystane: Spring Boot, Thymeleaf, Bootstrap, Maven, Marvin, OpenCV, Tesseract, baza danych H2.
Cały projekt składa się z dwóch aplikacji. Pierwsza z nich to web service, druga natomiast jest aplikacją frontową, w której wykorzystany został wzorzec MVC.

- Do rozpoznawania tablic rejestracyjnych został opracowany i zaimplementowany prosty algorytm, który jest dostępny tylko dla konta z uprawnieniami administratora. 
- Pozostała część aplikacji stanowi przykład wykorzystania. 
  - **Użytkownik** może założyć konto, podać swoje dane i informacje na temat samochodu. Najważniejszą z nich jest numer tablicy rejestracyjnej, połączony on zostanie z wybranym abonamentem parkingowym. Po poprawnym zarejestrowaniu się informacje zapisywane są w bazie danych. Użytkownik ma dostęp jedynie do swoich danych oraz informacji dostępnych dla wszystkich, które znajdują się na stronie głównej. 
  - **Administrator** (login: admin; hasło: password) ma podgląd całej bazy danych, możliwość sprawdzenia na podstawie zdjęcia czy dany samochód posiada przypisany abonament (na podstawie przesłania zdjęcia i odczytania tablicy), dostępna jest również dla niego historia wczytanych zdjęć.
