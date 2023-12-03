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


Relaciones entre tablas usando JPA.
-----------------------------------
1. Se implementa las relaciones entre las entidades (entity), modificamos las clases java:
User.java, Book.java, Issue.java, Loan.java.
2. Verificar desde mysql que las tablas mantenga las relaciones definidas con @OneToMany / @ManyToOne / OneToOne.

Total 00:30 horas de trabajo.

3. Añadimos caracteristicas y definiciones JPA a las clases del contenedor entity.
Tamaño de cada campo, Null, nombre de indices, constraints de Foreign key
Book.java, User.java, Issue.java, Loan.java

Total 03:00 horas de trabajo


Creamos entorno para trabajadores de la biblioteca (separado de las funcionalidades de los usuarios).
-----------------------------------------------------------------------------------------------------
Se crea a parte un entorno solo para los trabajadores de la biblioteca (aunque implique duplicar pero servira para la seguridad):

1. DTO: BookAdminDTO.java, IssueAdminDTO.java, UserAdminDTO.java, LoanAdminDTO.java

2. Exception:  BookNotSaveException.java, UserNotSaveException.java, IssueNotSaveException.java, LoanNotSaveException.java

3. Service: BookAdminService.java / BookAdminServiceImpl.java, IssueAdminService.java / IssueAdminServiceImpl.java
            UserAdminService.java / pendiente,  LoanAdminService.java / pendiente

4. Controller:  BookAdminController.java, IssueAdminController.java, resto pendiente.

5. Pruebas:  Pendiente de esta parte.

Total 08:00 horas de trabajo.


# PENDIENTE.
-------------
Se tiene pendiente los siguientes puntos:

1. Aplicar seguridad.  Ver estos videos sobre el tema:
https://www.youtube.com/watch?v=pmSJTrOWi7w (1 capitulo)
https://www.youtube.com/watch?v=aeCotM2DORo (2 capitulo, continuación del 1)
https://www.youtube.com/watch?v=nwqQYCM4YT8&t=10s (crear un login spring Boot 3)

Para ver token:
https://www.youtube.com/watch?v=uKaDrojacqw (Crear login con Angular + Spring Boot + JWT)

2. Implementar esta solución monolitica en microservicios.

3. Implementar el Front end en Angular.






# PRUEBAS DE BACKEND.
-----------------------

Book - DTO, map, exception (pruebas)
------------------------------------
Las pruebas realizadas son (solo en Book) - Partimos sin datos:
1. GET de la lista completa de todos los libros (OK, indica que no hay).
2. GET de un libro concreto (OK, inidica que no hay ese libro).
3. POST con todos los campos (OK, pero solo guarda los campos indicados por BookDTO).
4. PUT, modifico el campo summary y authors.
5. DELETE, se borra un elemento de la tabla books.
6. DELETE, se intenta borrar un registro que no existe.
7. PUT, hacer un cambio en un registro que no existe, el sistema lo detecta.

Total 01:30 hora de trabajo.

Issue - DTO, map, exception (pruebas)
------------------------------------
Las pruebas realizadas son (solo en Issue) - Partimos sin datos:
1. GET de la lista completa de todos los generos o issues (OK, indica que no hay).
2. GET de un genero concreto (OK, inidica que no hay ese genero).
3. POST con todos los campos (OK, pero solo guarda los campos indicados por IssueDTO).
4. PUT, modifico el campo issue y subtopic.
5. DELETE, se borrar un elemento de la tabla issues.
6. DELETE, se intenta borrar un registro que no existe.
7. PUT, hacer un cambio en un registro que no existe, el sistema lo detecta.

Total 00:45 hora de trabajo.



User - DTO, map, exception (pruebas)
------------------------------------
Las pruebas realizadas son (solo en User) - Partimos sin datos:
1. GET de la lista completa de todos los users (OK, indica que no hay).
2. GET de un user concreto (OK, inidica que no hay ese genero).
3. POST con todos los campos (OK, pero solo guarda los campos indicados por UserDTO).
4. PUT, modifico todos los campos que hay en UserDTO.
5. DELETE, se borrar un elemento de la tabla users.
6. DELETE, se intenta borrar un registro que no existe.
7. PUT, hacer un cambio en un registro que no existe, el sistema lo detecta.

Total 00:35 hora de trabajo.



PROBLEMAS EN DTO.
-----------------
Book - El campo summary me lo pone a null y no hace caso del valor puesto.  RESUELTO
Issue, User - Error en el update (PUT).  RESUELTO.



(Rama devjean de Git)
---------------------
1. Tabla book, insertar registros nuevos en book, añadir código a application.properties.
2. Creado carpetas entity, repository, service, controller.
3. Desarrollo de las clases y interface java: