LINK REPOSITORIO:
https://github.com/JorgeRomojaro11/Practica_Final_2.git

MEMORIA:
¿Cómo se han organizado y estructurado las clases y cuál es la responsabilidad de cada una?
El proyecto se divide en 4 paquetes:

-Celdas:
Este paquete contiene las clases Bacteria y Celda, que son las clases que contienen la informacion y las acciones que deben realizar las bacterias en el experimento, y también la informacion de las celdas para la creación de las matrices en la animación de la población.

-Interfaz:
Este paquete contiene las clases AnimacionExperimento e InterfazExperimento. Son las indicadas para crear tanto la interfaz principal como la animación de simulacion del experimento, y contienen la importacion de los demás códigos y el código de creación de los botones.

-Main:
Este paquete contiene la clase Main, que utilizo para ejecutar el proyecto entero.

-Simulación:
Este es el paquete más grande, y contiene 5 clases y 2 inner clases. dentro de estos encontramos:
AreaDeCultivo-Contiene el codigo de la creación del área de cultivo de las casillas de la simulación
EstrategiaSuministroComida-Es una inner class que calcula la comida restante
EstrategiaSuministroConstante-Es la clase donde se adhiere la inner class anterior
Experimento-Contiene la informacion de las bacterias, las celdas y el tiempo de simulación.
patronAlimentación-Calcula la comida
PatronIncrementoLineal-Tiene el código del incremento de la comida según la duración de los días del experimento
Simulación-Contiene el código con todas las acciones que tienen que ocurrir en la simulación de la población.

![UML PF 2](https://github.com/JorgeRomojaro11/Practica_Final_2/assets/147046165/6bf0a978-29e7-4a31-a898-2fa465851147)
