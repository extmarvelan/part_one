# Proxy Mercadopago APIs

[![N|Solid](https://http2.mlstatic.com/frontend-assets/ui-navigation/5.18.7/mercadopago/logo__large@2x.png)](https://www.mercadopago.com.ar/)

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