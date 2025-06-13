# Resolución de Problema de Producción con Máquinas

Este proyecto implementa dos estrategias para resolver un problema de asignación de máquinas a la producción de piezas, utilizando algoritmos de **Backtracking** y **Greedy**.

## Descripción del problema

Dada una cantidad total de piezas a producir y un conjunto de máquinas, cada una con una capacidad fija de producción, se busca encontrar la combinación de máquinas que logre exactamente la producción deseada.

El archivo `config.txt` contiene la configuración inicial, en el siguiente formato:

- **Primera línea**: cantidad total de piezas a producir.
- **Líneas siguientes**: cada una representa una máquina con su ID y cantidad de piezas que puede producir, separadas por coma.

### Formato esperado:
```
PiezasTotales
Máquina1,Piezas
Máquina2,Piezas
...
MáquinaN,Piezas
```

### Ejemplo:
```
12
1, 3
2, 7
3, 1
4, 4
```

---

## Estrategia de resolución por Backtracking

- Se genera un árbol de exploración donde cada nodo representa un estado del sistema (combinación de máquinas activas y piezas producidas).
- Desde un estado inicial sin producción, se exploran todas las combinaciones posibles mientras no se exceda el total de piezas.
- Si se alcanza el total exacto, se considera un **estado solución**.
- Se utiliza **poda**: si una solución parcial no es mejor que la mejor encontrada, se descarta para optimizar el recorrido.
- El algoritmo garantiza encontrar la mejor solución posible.

---

## Estrategia de resolución por Greedy 

- Se ordenan las máquinas de mayor a menor capacidad de producción.
- Se prioriza siempre usar primero la máquina que más produce, mientras sea factible.
- El proceso continúa hasta alcanzar el total de piezas o agotar las opciones.
- **No garantiza** una solución óptima, pero es más rápida computacionalmente.
- Si no se puede alcanzar el total exacto, la solución es `null`.

---

## Autoras

**Melanie** y **Micaela**  
Carrera: Tecnicatura Universitaria en Desarrollo de Aplicaciones Informáticas (TUDAI)  
Materia: Programación 3  
Año: 3° año

---

¡Gracias por leer! 💻✨
