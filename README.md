# banamexIbm

Título del Proyecto

Este proyecto recrea un ambiente de microservicios donde la api principal Aplly for a credit card recibe datos personales y responde si puedes aplicar a una tarjeta de credito y las sucursales o cajeros donde puedes acudir, incluye descubridor de servicios y servidor de configuraciones.

Comenzando 🚀

Clona los 6 microservicios en el siguiente orden:

1) discoveryservices
2) configserver
3) creditcards
4) bankinformation
5) applyforacreditcard

Apply for a credit card es el microservicio principal, se le envia un payload con la siguiente estructura en formato JSON:

{
    "name": "Edgar",
    "age": "29",
    "phone": "2221021942",
    "monthlySalary": "34000",
    "yourPassion": "SHOOPING",
    "latitude": null,
    "longitude": null,
    "postalCode": "52929",
    "city": "Puebla",
    "estate": "Puebla"
}

La forma de proceder del micro esta basada en 6 pasos que a continuacion se describen:

1) Una vez enviada la solicitud en microservicio valida campos nulos, vacios, numericos, etc 
2) Se cominica con el servicio de tarjetas de credito para obtener los datos con los que se trabajara
3) Implementa la logica para seleccionar las tarjetas de credito que hagan "match"
4) Se cominica con el servicio que provee los datos de sucursale y atms, consumiendo una url que expone banamex: https://www.banamex.com/localizador/jsonP/json5.json para obtener los datos con los que se trabajara
5) Implementa la logica para seleccionar los cajeros y sucursales que hagan "match"
6) Crea la respuesta para ser devuelta al cliente.



Pre-requisitos 📋

1) Java 8
2) Maven
3 )intellij idea o el IDE de tu preferencia


Los puertos disponibles para ejecutar el ambiente se describen a continuacion y podremos revisar el repositorio llamado config-repo disponible tambien en este perfil:

1) Eureka discovery services: http://localhost:8761
2) Config server: http://localhost:8383/api/v1                   spring.application.name = configservice
3) Credit cards: http://localhost:8082/api/v1/creditCards        spring.application.name = creditcard
4) Banks information: http://localhost:8083/api/v1/locations     spring.application.name = bankInformation-
5) Apply for a credit card: http://localhost:8084/api/v1/apply   spring.application.name = applyforacreditcard


Construido con 🛠️
Spring Boot 2.5.4
Spring Cloud 2020.0.3

Autores ✒️
Edgar Omar Lopez Hernandez



Expresiones de Gratitud 🎁
📢Quiero hacer publica mi gratitud y agradecimiento a:

David Gonzales Esquivel (Mouse manager jaja ntc)
Ana Vialeny Mota Gomez
Abraham Velazquez Olmos
y a todos los instructores que compartieron su tiempo y conocimiento por esta gran oportunidad y aunque no pude dedicarme al 100 debido a mi trabajo y que a esta ultima semana cuide de mi hijo tiempo completo no quise dejar pasar la oportunidad de entregar el avance que hice.

Muchas gracias en verdad!!!!!!!!!!!!!!!!!!!

⌨️ con ❤️ por Edgar Lopez 😊
