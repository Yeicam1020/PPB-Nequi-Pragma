# PPB-Nequi-Pragma
Desarrollo prueba práctica backend nequi.

Franquicias

Se requiere construir un API para manejar una lista de franquicias. Una franquicia se compone por un nombre y un listado de sucursales y, a su vez, 
una sucursal está compuesta por un nombre y un listado de productos ofertados en la sucursal. Un producto se compone de un nombre y una cantidad de stock.

Criterios de Aceptación
El proyecto debe ser desarrollado en Spring Boot.
Exponer endpoint para agregar una nueva franquicia.
Exponer endpoint para agregar una nueva sucursal a una franquicia.
Exponer endpoint para agregar un nuevo producto a una sucursal.
Exponer endpoint para eliminar un nuevo producto de una sucursal.
Exponer endpoint para modificar el stock de un producto.
Exponer endpoint que permita mostrar cuál es el producto que más stock tiene por sucursal para una franquicia puntual. Debe retornar un listado de productos 
que indique a qué sucursal pertenece. Utilizar sistemas de persistencia de datos como Redis, MySQL, MongoDB, Dynamo en algún proveedor de Nube. Queda abierto a libre escogencia.

Puntos Extra

✅ Plus si se empaqueta la aplicación con Docker.

✅ Plus si utiliza programación funcional, reactiva.

✅ Plus si se expone endpoint que permita actualizar el nombre de una franquicia.

✅ Plus si se expone endpoint que permita actualizar el nombre de una sucursal.

✅ Plus si se expone endpoint que permita actualizar el nombre de un producto.

✅ Plus si se aprovisiona la persistencia de datos con infraestructura como código como Terraform, Cloudformation, etc.

✅ Plus si toda la solución se despliega en la nube.

Notas Importantes:
Se tendrá en cuenta el flujo de trabajo usando Git.
La prueba debe ser presentada en algún repositorio de código con acceso público (GitHub, Bitbucket, etc.).
Se debe incluir documentación que permita entender cómo desplegar la aplicación desde un entorno local. Se sugiere utilizar un archivo README.md.

## Requerimientos para su uso
- Java 17
- Maven
- Docker

## Configuración entorno local
- clonar: https://github.com/Yeicam1020/PPB-Nequi-Pragma.git
- Dentro del directorio: mvn clean install
- Todo listo, a correr

### Nota adicional
El proyecto está ya configurado desde el archivo de propiedad para conectarse a una RDS, sin embargo, le comparto credenciales de acceso a la BD MySQL:
- HOST: pruebas-yeicam.c1qsigweaaa9.us-east-2.rds.amazonaws.com
- PORT: 3306
- NOMBRE BASE DE DATOS: franquicias_database
- USER: root
- PASS: root2025

## Configuración para Docker (copiar y pegar)
- Construir imagen: docker build -t franquicias-app .
- Ejecutar el contenedor : docker run -d -p 8080:8080 franquicias-app

## Puede utilizar Postman o su herramienta de preferencia para consumir los endpoints, collections en el resources
