Backend  : Esta desarrollado bajo servicios rest api con lenguaje de programacion Java version 17. Con tecnologia spring boot 3 y spring jpa, para el manejo de base de datos utilizamos hibernate y como base de datos utilice H2 en memory. Por otra parte no quise utilizar php con laravel por que lo vi mas optimo hacerlo con Java que es mi fuerte he implemente arquitectura hexagonal con patro de diseno builder. Otras de las tecnolgias que use para el proyecto de prueba fue mapStruct para el manejo de los Dto y transformaciones de obtjetos.
Tambien utilizamos manejo de excepciones en backend customizando las salidas, con controller Advice 


Generar JAR
./mvnm package

El archivo mvnm lo genera el IDE (por ejemplo Itellij IDEA) pero puede sustituirse por el comando maven. Al final de la salida se mostrará el directorio donde se genera el JAR (usualmente es en target/).

Correr la aplicación
Suponiendo que el archivo JAR generado se encuentra en target/server.jar:

Opción 1: java -jar target/server.jar
Opción 2: java -jar target/server.jar --spring.config.location=config\app.properties
Opción 3: java -jar target/server.jar --spring.config.location=config\app.properties --server.port=8081
El parámetro --spring.config.location=config\app.properties le indica a Spring Boot de donde tomar las configuraciones .properties, por defecto se colocan en src/main/resources/application.properties. Tanto para compilar como para correr, es necesario tener configurada la variable de entorno JAVA_HOME con la ruta donde se encuentra instalada la JDK (Jave Development Kit) que se va a utilizar.

Importante:

Configurar variable de entorno para que apunte a la versión 8 de la JDK. Por ejemplo en Linux/macOS :

export JAVA_HOME=/directorio/jdk