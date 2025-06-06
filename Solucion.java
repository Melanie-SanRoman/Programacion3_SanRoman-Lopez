package tp_especial;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    String metodo;
    List<Maquina> maquinas;
    int piezasProducidas;
    int puestasFuncionamiento;
    //  Métrica para analizar el costo de la solución (cantidad de estados generados)


    public Solucion(String metodo) {
        this.metodo = metodo;
        this.maquinas = new ArrayList();
        this.piezasProducidas = 0;
        this.puestasFuncionamiento = 0;
    }

    public void addMaquina(Maquina m) {
        maquinas.add(m);
    }

    public String getMetodo() {
        return metodo;
    }

    public int getPiezasProducidas() {
        return piezasProducidas;
    }

    public void setPiezasProducidas(int piezasProducidas) {
        this.piezasProducidas = piezasProducidas;
    }

    public int getPuestasFuncionamiento() {
        return puestasFuncionamiento;
    }

    public void setPuestasFuncionamiento(int puestasFuncionamiento) {
        this.puestasFuncionamiento = puestasFuncionamiento;
    }
    
    
    
}
