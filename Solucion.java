package tp_especial;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    String metodo;
    List<Maquina> maquinas;
    int piezasProducidas;
    int puestasFuncionamiento;
    int estadosGenerados;

    public Solucion(String metodo) {
        this.metodo = metodo;
        this.maquinas = new ArrayList();
        this.piezasProducidas = 0;
        this.puestasFuncionamiento = 0;
    }

    public Solucion(Solucion solucionMejor) {
        this.metodo = solucionMejor.metodo;
        this.maquinas = new ArrayList<>(solucionMejor.maquinas);
        this.piezasProducidas = solucionMejor.piezasProducidas;
        this.puestasFuncionamiento = solucionMejor.puestasFuncionamiento;
    }

    public void addMaquina(Maquina m) {
        this.maquinas.add(m);
    }

    public void deleteMaquina() {
        this.maquinas.remove(maquinas.size() - 1); // elimina la ultima maquina
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

    public void setPuestasFuncionamiento(char operacion) {
        if (operacion == '+') {
            this.puestasFuncionamiento++;
        } else {
            this.puestasFuncionamiento--;
        }
    }

    public boolean esMejor(Solucion mejorSolucion) {
        if (mejorSolucion.maquinas.size() == 0) {
            return true;
        }
        return this.maquinas.size() < mejorSolucion.maquinas.size();
    }

    public void setEstados(int estadosGenerados) {
        this.estadosGenerados = estadosGenerados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(metodo).append("\n");
        sb.append("Solución obtenida: secuencia de máquinas.\n");
        for (Maquina m : maquinas) {
            sb.append("Maquina ID: ").append(m.getId())
                    .append(" - Piezas: ").append(m.getPiezas()).append("\n");
        }
        sb.append(
                "Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento requeridas.\n");
        sb.append("Piezas producidas: ").append(piezasProducidas).append("\n");
        sb.append("Puestas en funcionamiento: ").append(puestasFuncionamiento).append("\n");
        sb.append("Cantidad de estados generados: ").append(estadosGenerados).append("\n");
        return sb.toString();
    }
}
