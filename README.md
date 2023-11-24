# BIBLIOTECA  - Proyecto desarrollo web para una biblioteca.

PARTE BACKEND ( Rama master de Git).
------------------------------------
users
-----
1. Tabla users, insertar registros nuevos en users, añadir código a application.properties.
2. Creado carpetas entity, repository, service, controller.
3. Desarrollo de las clases y interface java:
    (entity)     --> User.java
    (repository) --> UserRepository.java
    (service)    --> UserService.java, UserServiceImpl.java
    (controller) --> UserController.java
4. Instalar cliente, configurar y realizar pruebas con Hoppscotch.
5. Gestión de documentación, versión de git.
Total 10 horas de trabajo.


books
-----
1. Desarrollo de las clases y interface java:
       (entity)     --> Book.java
       (repository) --> BookRepository.java
       (service)    --> BookService.java, BookServiceImpl.java
       (controller) --> BookController.java
2. Crear la clase enum Availbility.
3. Pruebas y correcciones código tanto en programa como BD.

Total (1) 1:45 horas de trabajo.
Total (2) 1:30 horas de trabajo.
Total (3) 3:00 horas de trabajo.


issues
------
1. Desarrollo de las clases y interface java:
       (entity)     --> Issue.java
       (repository) --> IssueRepository.java
       (service)    --> IssueService.java, IssueServiceImpl.java
       (controller) --> IssueController.java
2. Pruebas y correcciones código tanto en programa como BD.

Total (1) 1:45 horas de trabajo.
Total (2) 2:00 horas de trabajo.


loans
-----
1. Desarrollo de las clases y interface java:
       (entity)     --> Loan.java
       (repository) --> LoanRepository.java
       (service)    --> LoanService.java, LoanServiceImpl.java
       (controller) --> LoanController.java
2. Corrección de código y pruebas.
Total (1) 1:45 horas de trabajo.
Total (2) 1:00 horas de trabajo.


Book - DTO, map, exception (implementación)
-------------------------------------------
Implementar para Book los siguientes elementos:
1. BookDTO.java (dto), Book.java (entity).
2. MapToDTO.java (map).
3. ApiError.java, BookNotFoundException.java, GlobalControlAdvice.java (exception).
4. Modificar las clases BookService.java, BookServiceImpl.java (service).
5. Modificar la clase BookController.java (controller).
6. Availability.java (entity) y modificar Book.java (entity).

Total 10:00 horas de trabajo.


Issues - DTO, map, exception (implementación)
-------------------------------------------
Implementar para Issues los siguientes elementos:
1. IssueDTO.java (dto), Issue.java (entity).
2. MapToDTO.java (map).
3. IssueNotFoundException.java, GlobalControlAdvice.java (exception).
4. Modificar las clases IssueService.java, IssueServiceImpl.java (service).
5. Modificar la clase IssueController.java (controller).

Total 03:00 horas de trabajo.


Users - DTO, map, exception (implementación)
-------------------------------------------
Implementar para Users los siguientes elementos:
1. UserDTO.java (dto), User.java (entity).
2. MapToDTO.java (map).
3. UserNotFoundException.java, GlobalControlAdvice.java (exception).
4. Modificar las clases UserService.java, UserServiceImpl.java (service).
5. Modificar la clase UserController.java (controller).

Total 03:00 horas de trabajo.




Book - DTO, map, exception (pruebas)
------------------------------------
Las pruebas realizadas son (solo en Book) - Partimos sin datos:
1. GET de la lista completa de todos los libros (OK, indica que no hay).
2. GET de un libro concreto (OK, inidica que no hay ese libro).
3. POST con todos los campos (OK, pero solo guarda los campos indicados por BookDTO).
En summary me puso null (no tuvo en cuenta el valor puesto) el resto de campos se pusieron NULL.
4. PUT, modifico el campo summary y authors. Modifica authors, pero summary lo pone a null.

DELETE, no se prueba porque es algo que no se modifico.

Total 01:30 hora de trabajo.




PROBLEMAS EN DTO.
-----------------
Book - El campo summary me lo pone a null y no hace caso del valor puesto.  RESUELTO
Book -

(Rama devjean de Git)
---------------------
1. Tabla book, insertar registros nuevos en book, añadir código a application.properties.
2. Creado carpetas entity, repository, service, controller.
3. Desarrollo de las clases y interface java: