# ApplicationServices_Intro

Introduccion a la implementacion de la capa de servicios de aplicación, donde codificamos los casos de uso que ofrece nuestro dominio.

La implementacion de los casos se uso se realiza via controladores específicos para cada servicio.

Para este ejemplo se ha dado al estos controladores la responsabilidades de orquestar servicios como el de Serializacion a los formatos JSON-XML y el de recuperación de datos desde los servicios de persistencia implementados a través de JPA. 

Por simplificar se ha considerado que los datos procedentes de persistencia son totalmente coherentes con las reglas del dominio (no han sido modificados directamente en la BD despues de haber sido guardados).

Por último se puede observar la arquitectura adoptada para esta solución.

En esta introducción se presenta:

* El diseño de controladores de casos de uso en la capa de servicios de aplicación.

* El desacoplamiento via interfaces de servicio de nuestros controladores con servicios externos u ofrecidos por un framework como en el caso de JPA, para poder ofrecer dichos servicios a través de otro tipo de adaptadores a diferentes arquitecturas de persistencia.

* La inyeccion de dependencias proporcionada por Spring para entregar el objeto adecuado que debe ofrecer el servicio.

* La arquitectura utilizada en el proyecto para una correcta separación de responsabilidades por capa a la vez que separamos entidades en contextos. Los contextos nos permiten segmentar responsabilidades.

Queda pendiente la integración en esta arquitectura de la capa de presentacion implementandola a partir de servicios REST.
