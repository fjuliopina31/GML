Proyecto de Aplicación Java

Este proyecto es una aplicación Java que requiere la ejecución de Docker Compose para configurar la base de datos. A continuación, se describen los pasos necesarios para ejecutar la aplicación correctamente.

Requisitos previos
Asegúrate de tener instalados los siguientes componentes antes de ejecutar la aplicación:

Docker Compose
Java Development Kit (JDK)
Java version: 11
Dependencias del proyecto (ver archivo de configuración)

Configuración de la base de datos
Abre una terminal y navega hasta la raíz del proyecto.

Ejecuta el siguiente comando para levantar los contenedores de Docker Compose:

copy code
docker-compose up -d
Esto iniciará los servicios necesarios para la base de datos.

Ejecución de la aplicación
Una vez que los contenedores de Docker Compose estén en funcionamiento, puedes ejecutar el proyecto Java.
La aplicación se encargará automáticamente de crear la entidad si aún no existe en la base de datos. Si la entidad ya existe, solo revisará si hay cambios en la estructura y los aplicará si es necesario.
¡Eso es todo! Ahora puedes ejecutar y utilizar la aplicación Java sin problemas.
