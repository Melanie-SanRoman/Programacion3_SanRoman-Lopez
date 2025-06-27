package tp_especial;

import java.util.List;

public class Backtracking {

    Solucion mejorSolucion;
    private int estadosGenerados;

    public Backtracking() {
        mejorSolucion = new Solucion("Backtracking", "Cantidad de estados generados");
        this.estadosGenerados = 0;
    }

    /*
     * Estrategia de resolución por Backtracking:
     * 
     * - Se genera un árbol de exploración donde cada nodo representa un estado
     * del sistema, es decir, una combinación de máquinas en funcionamiento y
     * la cantidad de piezas producidas hasta ese momento.
     * 
     * - El algoritmo parte de un estado inicial (sin máquinas en uso y con 0 piezas
     * creadas) y explora recursivamente las distintas combinaciones posibles de máquinas,
     * siempre que la suma de piezas no supere el total requerido.
     * 
     * - Los estados finales (hojas del árbol) son aquellos en los que la cantidad
     * de piezas creadas coincide exactamente con la cantidad total a producir.
     * 
     * - En cada paso, se verifica si la solución parcial ('solucionActual') es mejor que la mejor
     * solución conocida hasta el momento ('mejorSolucion').
     * 
     * - Poda implementada: si la solución parcial actual ya no es mejor que la mejor
     * solución guardada, se interrumpe la exploración de esa rama. Esto evita recorrer
     * combinaciones que no pueden superar la solución óptima ya hallada, mejorando
     * considerablemente el rendimiento del algoritmo.
     * 
     * - Se utiliza un enfoque de deshacer/rehacer (backtrack) para quitar las
     * máquinas una vez explorada una opción y continuar con el resto.
     * 
     * - Esta estrategia asegura encontrar la mejor combinación posible de máquinas,
     * evaluando todas las combinaciones válidas, pero evitando caminos que ya
     * no pueden superar la solución óptima encontrada.
     */

    public Solucion backtracking(List<Maquina> maquinasDisponibles, int cantPiezas) {
        Estado estado = new Estado(maquinasDisponibles, cantPiezas);
        backtracking(estado, new Solucion("Backtracking", "Cantidad de estados generados"));
        mejorSolucion.setValorMetrica(estadosGenerados);
        return mejorSolucion;
    }

    private void backtracking(Estado estado, Solucion solucionActual) {
        // incrementa la metrica seleccionada
        estadosGenerados++;
        // estado de corte, si las piezas que creamos, es igual a las que tenemos que crear
        if (estado.getPiezasCreadas() == estado.getPiezasTotales()) {
            if (solucionActual.esMejor(mejorSolucion)) { // la solucionActual es mejor que mejorSolucion?
                mejorSolucion = new Solucion(solucionActual); // la mejor solucion se vuelve la solucion actual
            }
        }
        for (Maquina m : estado.getMaquinasDisponibles()) {
            // si las que cree, mas las piezas de esa maquina son menor o igual a las piezas totales
            if (estado.getPiezasCreadas() + m.getPiezas() <= estado.getPiezasTotales()) {
                // poda
                if (!solucionActual.esMejor(mejorSolucion)) return;

                // agrega la maquina actual e incrementa las piezas
                solucionActual.addMaquina(m);
                estado.sumarPiezas(m.getPiezas());

                backtracking(estado, solucionActual);

                // quita la ultima maquina y resta las piezas de la ultima maquina
                solucionActual.deleteMaquina();
                estado.restarPiezas(m.getPiezas());
            }
        }
    }
}
