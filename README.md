# Conversor de Moneda - Challenge ONE - Java - Back end

![entrepreneur-g25e9f1667_1280](https://media.licdn.com/dms/image/D4D12AQFq9CAlVcXr3g/article-cover_image-shrink_720_1280/0/1673980988900?e=2147483647&v=beta&t=g_VjCi_pbE-J4RQRh6xAUZsWh3HQ6jVpIJaw4tEsFaE)


## Descripción del proyecto

Sistema que permite convertir tipos de monedas haciendo uso de una API, esto permite realizar consultas actualizadas y de forma dinámica. Por otro lado el sistema contempla varias opciones para realizar el tipo de cambio.

## Funcionalidades

Este programa puede convertir diferentes monedas. Las tasas de cambio se obtienen mediante la API [Exchange Rates Data API](https://apilayer.com/marketplace/exchangerates_data-api). El funcionamiento interno consiste en obtener las equivalencias con respecto al dólar estadounidense, y mediante fórmulas obtener otras tasas.

## Cómo pueden usarlo los usuarios

Este proyecto está desarrollado con JavaSE 11.0.18, por lo que es necesario tener una versión de Java igual o mayor para ejecutar el programa. Para conocer la versión de Java instalada en su sistema, ingrese en el Símbolo del Sistema en Windows, o en cualquier terminal el siguiente comando.

>~~~
> java --version
>~~~

Siga esta liga para descargar la versión 11 del JDK: https://www.oracle.com/co/java/technologies/downloads/#java11-windows

Al ejecutar el proyecto se desplegará una ventana con el conversor de monedas. Cuenta con un campo para el ingreso de la cantidad a convertir, ademas de selectores de tipos de monedas.
Además, el usuario podra invertir la conversion realizada con un boton de intercambio.

Las pruebas anteriores se realizaron con las tasas de cambio del día 10 de octubre del 2024.

La construcción del programa se realizó con JavaSE 11 ya que se utilizó el método nativo `http` para la comunicación con la API. Así mismo se usó una librería externa más:

* [json-simple](https://code.google.com/archive/p/json-simple/) Para el manejo de String con formato JSON
* miglayout15-swing

Estas librerías están en la carpeta `lib/` listas para importar y ejecutar el proyecto en su IDE favorito.

## Donde los usuarios pueden encontrar ayuda sobre el proyecto

Ejemplo de conversor de moneda proporcionado por Alura [Alura](https://www.aluracursos.com/challenges/oracle-one-back-end/conversordemoneda/sprint01)

## Autor del proyecto

Yenmy Zuñiga Guisado [LinkedIn](https://www.linkedin.com/in/yenmy-zu%C3%B1iga-guisado-8258a643/?originalSubdomain=pe).

