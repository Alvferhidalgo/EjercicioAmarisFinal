Estas son las instrucciones para que el proyecto compile correctamente.

Este proyecto utiliza un toolkit llamado GreyHawk que hace comprobaciones de código y arquitectura de paquetes.
Es necesario compilar previamente los diferentes módulos en un orden específico para poder compilar el ejercicio.
Por favor, siga estas instrucciones:
Haga un Clean-Install de los siguientes módulos en el orden descrito a continuación:

1º- hexa-layers-demo

2º- greyhawk-setup

3º- greyhawk-core-setup

4º- greyhawk-core-setup

5º- greyhawk-rest (Ejecuta este ignorando los test)

6º- ejercicioFinalSetUp

7º- ejercicioFinal

8º- kafkaProducerExercise

Si alguno de los pasos de 1º a 5º, no compila, continúe hasta llegar al 8º y vuelva a empezar, a veces eso arregla el problema.

Kafka está configurado desde el docker-compose.
MongoDB está configurado en local, sus especificaciones están en el application-properties.

Los módulos que se han pedido en el ejercicio son los siguientes:

	- ejercicioFinal: Contiene la gran mayoría del código. Es necesario quitar los comentarios y ejecutar un test para dar valores iniciales a la BBDD
	- kafkaProducerExercise: contiene un producer y un consumer que trabaja en conjunto con el módulo Ejerciciofinal.
