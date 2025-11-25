# 3. ApplicationServices_Intro

Introduccion a la implementacion de la capa de servicios de aplicación, donde codificamos los casos de uso que ofrece nuestro dominio.

La implementacion de los casos se uso se realiza via controladores de servicio específicos para cada entidad.

Para este ejemplo se ha dado al estos controladores la responsabilidades de orquestar servicios como el de Serializacion a los formatos JSON-XML y el de recuperación de datos desde los servicios de persistencia implementados a través de JPA. 

Por simplificar se ha considerado que los datos procedentes de persistencia son totalmente coherentes con las reglas del dominio (no han sido modificados directamente en la BD despues de haber sido guardados).

Por último se puede observar la arquitectura adoptada para esta solución.

En esta introducción se presenta:

* El diseño de controladores de casos de uso en la capa de servicios de aplicación.

* Desacoplamiento, via interfaces, de los controllers/adapters específicos tanto de casos de uso como de servicios externos como los ofrecidos por el framework (JPA)

* Es posible utilizar diferentes implementaciones en función del contexto: diferentes formas de servicio, arquitecturas de persistencia, etc.

* Para ello se traslada la interfaz JPA a la capa de infraestructura (supcapa persistencia/jpa). Y se exponer los casos de uso a través de una interfaz, para permitir inyectar una implementación específica.

* La inyeccion de dependencias proporcionada por Spring se responsabiliza de la entrega del objeto adecuado que debe ofrecer el servicio.

* La arquitectura utilizada en el proyecto permite una correcta separación de responsabilidades por capa a la vez que separamos entidades en contextos. Los contextos nos permiten segmentar responsabilidades. 

Queda pendiente la integración en esta arquitectura de la capa de presentacion implementandola a partir de servicios REST.
