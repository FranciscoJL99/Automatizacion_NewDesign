#language: es

Característica: Programacion presentacion en New Desing


  Esquema del escenario: Programar una presentación de proyecto
    Dado Que me encuentro en la pagina de new Desing
    Cuando Solicito la programacion de una presentacion
    Y Selecciono la opcion de video llamada
    E Ingreso los datos necesarios
      | nombre   | correo   | celular   | dia   | mes   | hora   | rangoHora   | temporada   |
      | <nombre> | <correo> | <celular> | <dia> | <mes> | <hora> | <rangoHora> | <temporada> |
    Entonces Se realiza la programacion exitosa de la presentacion
      | dia   | mes   | hora   | rangoHora   |
      | <dia> | <mes> | <hora> | <rangoHora> |

    Ejemplos:
      | nombre    | correo                    | celular    | dia | mes       | temporada | hora | rangoHora |
      | Francisco | javiier.leoon15@gmail.com | 3004855663 | 10  | Diciembre | 2021      | 1    | PM        |


