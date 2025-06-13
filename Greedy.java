package tp_especial;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Greedy {

    /*
     * Estrategia de resolución por Greedy:
     * 
     * - Candidatos: todas las máquinas disponibles, cada una con su capacidad de
     * producción (piezas).
     * 
     * - Estrategia de selección: se ordenan las máquinas de forma descendente según
     * la cantidad de piezas que producen.
     * Es decir, se prioriza siempre usar primero la máquina que produce más.
     * 
     * - En cada iteración, se elige la máquina actual (más productiva disponible) y
     * se la añade a la solución tantas veces
     * como sea factible sin exceder el total de piezas requeridas.
     * 
     * - Se continúa evaluando las siguientes máquinas en el orden de mayor a menor
     * producción, hasta alcanzar el total deseado.
     * 
     * - Consideraciones sobre la solución:
     * - No garantiza encontrar la solución óptima, ya que es una estrategia voraz
     * que no explora todas las combinaciones posibles.
     * - Si no se puede llegar exactamente a la cantidad de piezas requeridas con
     * las combinaciones disponibles, se retorna 'null'.
     */

    public Solucion greedy(List<Maquina> maquinasDisponibles, int piezasTotales) {
        Solucion solucion = new Solucion("Greedy");
        Collections.sort(maquinasDisponibles, Comparator.comparingInt(Maquina::getPiezas).reversed());

        if (solucion.getPiezasProducidas() != piezasTotales) {
            for (Maquina m : maquinasDisponibles) {

                while (solucion.esFactible(piezasTotales, m)) {
                    solucion.addMaquina(m);
                    solucion.setPiezasProducidas(m, '+');
                    solucion.setPuestasFuncionamiento('+');
                }
            }
        }
        if (solucion.getPiezasProducidas() == piezasTotales) {
            return solucion;
        } else {
            return null;
        }
    }
}
