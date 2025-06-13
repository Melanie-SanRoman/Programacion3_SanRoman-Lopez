package tp_especial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        
        String rutaArchivo = "tp_especial/config.txt";
        int piezasTotales = 0;
        ArrayList<Maquina> maquinas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            if (linea != null) {
                piezasTotales = Integer.parseInt(linea.trim());
            }

            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] partes = linea.split(",");
                    int id = Integer.parseInt(partes[0].replaceAll("[^0-9]", "")); 
                    int piezas = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(id, piezas));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato numérico: " + e.getMessage());
        }

        // Ejecutar el algoritmo backtracking
        Backtracking backtracking = new Backtracking();
        backtracking.backtracking(maquinas, piezasTotales);

        // Ejecutar el algoritmo greedy
        Greedy greedy = new Greedy();

        // Imprimir la solución encontrada
        System.out.println(backtracking.mejorSolucion.toString());
        System.out.println(greedy.greedy(maquinas, piezasTotales).toString());
    }
}
