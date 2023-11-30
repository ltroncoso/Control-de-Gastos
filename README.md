# Control de Gastos
Viáticos es una aplicación desarrollada utilizando Spring Boot con una arquitectura multicapa. En la capa de datos, se emplea JPA (Java Persistence API) junto con Hibernate para la conexión con bases de datos relacionales. La lógica de negocio se implementa en la capa de negocio utilizando el Spring Framework. Para la capa de presentación, se sigue el patrón de diseño MVC (Modelo-Vista-Controlador) mediante el uso de Thymeleaf y plantillas Bootstrap.

Además, la aplicación cuenta con medidas de seguridad implementadas a través de Spring Security. El despliegue de la aplicación se realiza mediante el servidor de aplicaciones Tomcat.

La aplicación tiene como objetivo principal el registro de gastos de viáticos generados durante la ejecución de proyectos. El acceso a la pantalla principal está restringido a Usuarios, Coordinadores de Proyectos y el administrador, quienes deben autenticarse previamente.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/b1bd4747-7a08-4800-849d-5904a604d494)

En la pantalla principal, se visualizan los gastos registrados, detallando tipo, descripción, monto, proyecto y usuario responsable de la imputación.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/443e0e28-9a1c-42a5-97b0-784a7ffe1503)

Al hacer clic en el botón de agregar, se despliega una ventana modal que permite a los usuarios registrar un nuevo gasto completando los campos correspondientes. El registro se asocia automáticamente al usuario autenticado. Además, los Coordinadores de Proyectos o el administrador tienen la capacidad de editar o eliminar registros.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/b9a627ad-aa22-4a97-88e5-bb3d27fc4266)

En caso de que el usuario autenticado sea un Coordinador de Proyectos (o el administrador), se habilita la visualización de las cartas de proyectos. Estas cartas contienen información clave, como número de proyecto, razón social del cliente, presupuesto y gastos calculados a partir de los registros realizados por los Usuarios. El Coordinador también puede agregar nuevos proyectos.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/1af92742-6b7d-409a-88d5-22c67581b8cc)

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/65c06ca8-7d22-4e71-acec-41ea7a3b355c)

El administrador tiene la facultad de eliminar proyectos y, además, puede agregar nuevos usuarios especificando nombre, apellido, nombre de usuario, contraseña, domicilio, datos de contacto y área dentro de la empresa.La contraseña introducida se encriptará a partir de la funcion BCryptPasswordEncoder.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/7f4dc9cc-c159-44fa-bf09-23494f7845f0)

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/150eca7b-5f3d-44a8-af04-8eb897864645)


Los nuevos usuarios son asignados automáticamente al rol de usuario, aunque existe la opción de otorgarles autorizaciones como Coordinador de Proyecto o Administrador. También es posible revocar estos permisos según sea necesario.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/bac10f48-8070-482d-b9a7-f4ec9475a034)

La aplicación cuenta con capacidades de internacionalización, lo que permite la visualización del contenido en los idiomas español e inglés.

![image](https://github.com/ltroncoso/Control-de-Gastos/assets/152342565/cdd9cf9f-cb5a-43f9-b9b0-f547e07ce189)



