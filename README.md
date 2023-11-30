# Control de Gastos
Viáticos es una aplicación desarrollada utilizando Spring Boot con una arquitectura multicapa. En la capa de datos, se emplea JPA (Java Persistence API) junto con Hibernate para la conexión con bases de datos relacionales. La lógica de negocio se implementa en la capa de negocio utilizando el Spring Framework. Para la capa de presentación, se sigue el patrón de diseño MVC (Modelo-Vista-Controlador) mediante el uso de Thymeleaf y plantillas Bootstrap.

Además, la aplicación cuenta con medidas de seguridad implementadas a través de Spring Security. El despliegue de la aplicación se realiza mediante el servidor de aplicaciones Tomcat.

La aplicación tiene como objetivo principal el registro de gastos de viáticos generados durante la ejecución de proyectos. El acceso a la pantalla principal está restringido a Usuarios, Coordinadores de Proyectos y el administrador, quienes deben autenticarse previamente.

En la pantalla principal, se visualizan los gastos registrados, detallando tipo, descripción, monto, proyecto y usuario responsable de la imputación.

Al hacer clic en el botón de agregar, se despliega una ventana modal que permite a los usuarios registrar un nuevo gasto completando los campos correspondientes. El registro se asocia automáticamente al usuario autenticado. Además, los Coordinadores de Proyectos o el administrador tienen la capacidad de editar o eliminar registros.

En caso de que el usuario autenticado sea un Coordinador de Proyectos (o el administrador), se habilita la visualización de las cartas de proyectos. Estas cartas contienen información clave, como número de proyecto, razón social del cliente, presupuesto y gastos calculados a partir de los registros realizados por los Usuarios. El Coordinador también puede agregar nuevos proyectos.
    
El administrador tiene la facultad de eliminar proyectos y, además, puede agregar nuevos usuarios especificando nombre, apellido, nombre de usuario, contraseña, domicilio, datos de contacto y área dentro de la empresa.

Los nuevos usuarios son asignados automáticamente al rol de usuario, aunque existe la opción de otorgarles autorizaciones como Coordinador de Proyecto o Administrador. También es posible revocar estos permisos según sea necesario.

