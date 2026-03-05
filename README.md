# Lab_modularizacion
Laboratorio de Programacion

##Trabajo en pareja:
 
 Alumnas : Carlin Alondra Argueta Espino 0905-25-13150 y Joselyn Marleni Lòpez y Lòpez 0905-25-18082

Ejercicio de Modularización en Java
Parte 1 – Análisis del programa
Identificación de tareas repetitivas
Las tareas que pueden convertirse en métodos son:

Agregar estudiante
Mostrar lista de estudiantes
Calcular promedio de calificaciones
Mostrar estudiante con la calificación más alta
Dividir el programa en métodos mejora la organización, facilita la lectura del código y permite reutilizar funcionalidades.

Variables locales vs globales
Las variables globales son:

estudiantes
calificaciones
Estas variables se declaran como static porque deben ser utilizadas por varios métodos.

Las variables locales son:

nombre
calificacion
suma
promedio
Las variables locales solo existen dentro del método donde se usan, lo que reduce errores.

Parte 2 – Modularización del programa
El programa fue dividido en los siguientes métodos:

mostrarMenu()
agregarEstudiante()
mostrarEstudiantes()
calcularPromedio()
mostrarMejorEstudiante()
Cada método tiene una responsabilidad específica.

Parte 3 – Validaciones
Se verificó que existan estudiantes antes de mostrar la lista o calcular el promedio.

Esto evita errores cuando las listas están vacías.

Parte 4 – Reflexión
¿Qué ventajas tiene dividir el código en métodos?
Permite organizar mejor el programa, facilita su mantenimiento y hace que el código sea más fácil de entender.

¿Por qué no es recomendable usar muchas variables globales?
Porque pueden ser modificadas por cualquier método, lo que puede provocar errores inesperados.

¿Cómo mejora la modularización la legibilidad del código?
El código se vuelve más claro porque cada método tiene una tarea específica.
