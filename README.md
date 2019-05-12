# GDPR (Reglamento General de Protección de Datos)

Proyecto de desarrollo ágil basado en **SCRUM** para una aplicación web dedicada a la verificación del cumplimiento de la **GDPR** en proyectos de investigación.

### Equipo de desarrollo:

* Pablo Caraballo ([@paleloser](https://github.com/paleloser)) - Product Owner
* Pablo Sánchez ([@pablosyz](https://github.com/pablosyz)) - Scrum Master
* Jaime de Frutos ([@jaimedfc](https://github.com/jaimedfc)) - Developer
* Alexander de la Torre ([@poorscoot](https://github.com/poorscoot)) - Developer
* Miguel Ángel López ([@malopezmup](https://github.com/malopezmup)) - Developer


Aplicación Web desarrollada en **Java EE** gestionada con **Maven**. Pruebas desarrolladas con **JUnit** y **Selenium Web Driver**.

#### Requisitos:
* **Java 8**
* **Apache Maven 3.6.1**
* **Apache Tomcat 9**
* **H2 Database** (incluido en las dependencias de Maven)

Para ejecutar la aplicación, ejecutar un `cmd` desde la directorio del proyecto:

```shell 
//Generar el fichero de ejecución del proyecto
> mvn install

//Inicializar la base de datos
> java -jar C:\Users\your_username_here\.m2\repository\com\h2database\h2\1.4.197\h2-1.4.197.jar
```
Copiar el fichero `.war` generado, que se encontrará en `directorio_del_proyecto\target` al directorio `webapps` del directorio de instalación de Tomcat, y arrancar el servidor.
