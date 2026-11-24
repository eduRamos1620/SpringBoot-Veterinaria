# SpringBoot-Veterinaria

API REST desarrollada con Spring Boot para gestionar la información básica de una clínica veterinaria (dueños, mascotas, doctores, citas y pagos).

## Tecnologías utilizadas
* Java y Spring Boot
* Spring Web
* Spring Data JPA / Hibernate
* Maven
* Base de datos relacional (SQL)

## Estructura del proyecto
El proyecto está organizado por capas para separar responsabilidades:
* `controllers` y `dto`: endpoints REST y objetos de transferencia de datos.
* `services`: lógica de negocio.
* `persistence` y `repository`: acceso a datos.
* `entities`: modelos de base de datos.
