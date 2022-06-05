<h2> Hi, Practica 2! <img src="https://i.imgur.com/jbvlrax.gif" width="50"></h2>

<!--# Fase 0-->
# Ejecucion de la aplicacion No TDD

Al ejecutar la aplicación  de gestión de vuelos no TDD, el pasajero VIP se ha agregado al vuelo de negocios y el pasajero regular se ha agregado al vuelo económico.
Los códigos de la carpeta Anterior.Produccion nos muestra los siguientes resultados:

<img src="https://github.com/CarlosMoscol/Practica2PDD/blob/master/PruebasImagenes/Fase0.png">

Cesar, un pasajero VIP, se agrego al vuelo de negocios y no pudimos eliminarlo.
Jessica, una pasajera regular no se pudo agregar al vuelo de negocios, pero si pudimos agregarlo al vuelo económico.

<!--# Fase 1-->
# Gestion de Vuelos
## Pregunta 1
### ¿Cuáles son los resultados que se muestran?

Al ejecutar las pruebas de cobertura vemos que los resultados nos muestran una Exception ya que en el código original el tipo de vuelo Busineess no se encuentra declarado es por ello que se ejecutan solo las pruebas de la lógica de negocio de los vuelos económicos y no las pruebas de los vuelo de negocios.

Al cambiar el tipo de vuelo de Businees a Negocios las pruebas se ejecutan correctamente sin embargo no se realizan al 100% de cobertura, arrojándonos un 66% de cobertura en las clases, 50% en los métodos y el 44% de las líneas de código escritas.
El resultado de ejecutar las pruebas de vuelos económicos y de negocios con cobertura mediante IntelliJ IDEA: la clase Airport está descubierta (contiene el método main; no lo probamos) y la clase flight tiene una cobertura inferior al 100 %.
Si ejecutamos las pruebas con cobertura desde IntelliJ IDEA, obtenemos los resultados que se muestran en la siguiente figura.

<img src="https://github.com/CarlosMoscol/Practica2PDD/blob/master/PruebasImagenes/Fase1.png">

### ¿Por qué crees que la cobertura del código no es del 100%?

El trabajo realizado proporciona conclusiones adicionales. La clase Airport no se prueba; sirvió como cliente para las clases Passenger y Flight. Las pruebas ahora funcionan como clientes, por lo que se puede eliminar Airport. Además, la cobertura del código no es del 100%. El método getFlightType no se utiliza y el caso predeterminado, cuando un vuelo no es económico ni de tipo de negocios, no está cubierto. 

## Pregunta 2
### ¿Por qué John tiene la necesidad de refactorizar la aplicación?

John la necesidad de refactorizar la aplicación porque así puede eliminar los elementos que no se utilizan. Confía en hacer esto porque la aplicación ahora está cubierta con pruebas y además que TDD nos permite ganar confianza en nuestro código con el tiempo.

<!--# Fase 2-->

# Refactoring the flight-management application

Al ejecutar el AirportTest de la Fase 2 la cobertura del código es del 100% dado que se ha eliminado elementos que no se utilizaban y se añadido nuevas clases de vuelo en base a la jerarquía, están son una extensión de la clase principal Flight.

<img src="https://github.com/CarlosMoscol/Practica2PDD/blob/master/PruebasImagenes/Fase2.png">

## Pregunta 3

### ¿Cuál es la cobertura del código?

La cobertura de código después de refactorizar la aplicación de gestión de vuelos, en especifico la clase AirportTest nos lleva a un 100%.

### ¿La refactorización de la aplicación TDD ayudó tanto a mejorar la calidad del código?

La refactorización de código ayuda a mejorar la calidad del código y la cobertura del código en un 100%.
Se reemplaza las instancias Flight previas con nuevas instancias EconomyFlight y BusinnesFlight
Se elimino la clase Airport que no sirvió para servir como cliente para las clases Passenger y Flight

<!--# Fase 3-->
<img src="https://github.com/CarlosMoscol/Practica2PDD/blob/master/PruebasImagenes/Fase3.png">
