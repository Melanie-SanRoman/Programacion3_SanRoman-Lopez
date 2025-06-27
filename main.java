package tp_especial;

import java.io.IOException;
import java.util.List;

public class main {

    public static void main(String[] args) {
        try {
            // Cargar configuración desde archivo
            ConfigLoader.Configuracion config = ConfigLoader.cargarConfiguracion("tp_especial/config.txt");
            List<Maquina> maquinas = config.getMaquinas();
            int piezasTotales = config.getPiezasTotales();

            // Ejecutar algoritmos
            Backtracking bt = new Backtracking();
            Solucion solucionBT = bt.backtracking(maquinas, piezasTotales);

            Greedy greedy = new Greedy();
            Solucion solucionGreedy = greedy.greedy(maquinas, piezasTotales);

            // Imprimir resultados
            Utils.imprimirSolucion(solucionBT);
            Utils.imprimirSolucion(solucionGreedy);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración: " + e.getMessage());
        }
    }
}
