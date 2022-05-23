# Proxy Mercadopago APIs

[![N|Solid](https://http2.mlstatic.com/frontend-assets/ui-navigation/5.18.7/mercadopago/logo__large@2x.png)](https://www.mercadopago.com.ar/)

##Creación de una Preferencia
```sh
curl --location --request POST 'https://api.mercadopago.com/checkout/preferences' \
--header 'Authorization: Bearer <TOKEN>' \
--header 'Content-Type: application/json' \
--data-raw '{
  "items": [
    {
      "title": "Dummy Title",
      "description": "Dummy description",
      "picture_url": "http://www.myapp.com/myimage.jpg",
      "category_id": "car_electronics",
      "quantity": 1,
      "currency_id": "ARS",
      "unit_price": 10
    }
  ],
  "back_urls": {
      "success":"https://google.com",
      "pending":"https://google.com",
      "failure":"https://google.com"
  }
}'
```

A continuación pondremos a prueba:

- Consulta de preferencias 🎩

## Tecnologías

- Java 11 ♨
- Quarkus Framework (JVM) 💫

## Instalación

Es necesario tener instalado Java 11 y Gradlew 7.4.1.

Para levantarlo en desarrollo:
```shell script
./gradlew quarkusDev
```

Para buildearlo:
```shell script
./gradlew build
```

Y se levanta en el puerto 8080:
```sh
localhost:8080
```

## Uso de API
```sh
curl --location --request GET 'localhost:8080/preferences'
```

## Preguntas

> #### ¿Qué es una Preferencia de Pagos?
> Las preferencias son conjuntos de información sobre un producto y/o servicio que te permiten definir el nombre, el método de pago y otros atributos necesarios para obtener la URL para iniciar el flujo de pago al finalizar la compra.

> #### ¿Qué propiedad de la preferencia representa el ID del usuario vendedor?
> collector_id, representa el ID del usuario vendedor

> #### ¿Ves alguna relación del ID anterior y el Access Token utilizado para crearla?
> Si, al final del Access Token se encuentra el ID del vendedor.

## Pregunta botón de pago
> #### ¿Qué sucede tras realizar el pago, para cada estado de rechazo diferente que forzamos?
> Para generar un estado distinto de rechazo, basta con cambiar el nombre del titular de la tarjeta de crédito por:
> - OTHE:   Rechazado por error general.
> - CALL:	Rechazado con validación para autorizar.
> - FUND:	Rechazado por importe insuficiente.
> - SECU:	Rechazado por código de seguridad inválido.
> - EXPI:	Rechazado debido a un problema de fecha de vencimiento.
> - FORM:	Rechazado debido a un error de formulario.

## Pregunta URL de redirección

> #### ¿Qué son los datos que vuelven en la URL de retorno? Definir cada uno.
> collection_id: Es el id del pago generado al momento de la redirección
> collection_status: Es el estado generado del pago generado al momento de la redirección
> payment_id: Es el identificador único del pago.
> status: Es el estado temporal del pago
> external_reference: Identificador único que envía el vendedor para relacionar el payment_id generado por mercado pago, con el ID de tu sistema.
> payment_type: Tipo del medio de pago elegido
> merchant_order_id: El ID de la orden de Pago. 
> preference_id: El ID de la preferencia de Pago.
> site_id: País donde
> processing_mode: Modo de procesamiento. Existen dos tipos:
> Aggregator: El merchant utilizará los códigos de comercio de Mercado Pago y aprovechará las ventajas financieras que ofrecemos.
> Gateway: Para el merchant es necesario tener sus propios códigos de comercio para ventas online y tener convenio con cada uno de los medios de pago deseados.
> merchant_account_id: ID del código de comercio (merchant account ID).