# Reto New Design :x:

[![gradle](https://img.shields.io/badge/gradle-v6.8.X-yellow.svg)](https://gradle.org/install/)   :computer:

## Prerequisites 

Necesitarás las siguientes herramientas debidamente instaladas en tu ordenador. 

* [Gradle](https://gradle.org)
* [Java JDK 1.8](https://www.oracle.com/java/technologies/downloads/)


## Descripción

En este proyecto se desarrolló la automatización de la funcionalidad de programación de agenda en la página New Design. Se buscó parametrizar la mayor cantidad de funciones y localizadores posibles para poder expandir la automatización a diferentes casos con respecto a la funcionalidad.

## Ejecución

Para ejecutar este proyecto, se recomienda reemplazar el chromedriver.exe por uno compatible con la versión de su navegador Chrome. Configure el archivo serenity.properties como considere necesario en caso de querer usar otro navegador, ubicación de driver, etc. Los comandos usados para generar el reporte fueron:

`gradle clean test aggregate`

## Consideraciones

* Recuerde que el comando clean limpia el reporte ya presente en el proyecto. Tenga esto presente antes de ejecutar.

* Adicional si desea ingresar nuevos valores a la ejecución, dirijase al archivo `Test.feature` y cambie los datos que quiera modificar o agregue una nueva fila de datos.
* La fecha es trabajable con cualquier rango. Es importante aclarar que la fecha a ingresar debe ser mayor al día actual de la ejecución, ya que no es posible agendar al pasado. Así como que la hora a ingresar debe cumplir con los rangos trabajados por la página.  
