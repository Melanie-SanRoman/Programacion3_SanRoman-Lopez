package tp_especial;

public class Utils {
    public static void imprimirSolucion(Solucion solucion) {
        if (solucion != null) {
            System.out.println(solucion.toString());
        } else {
            System.out.println("No se encontró una solución para este método.");
        }
    }
}

