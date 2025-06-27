package tp_especial;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    String nombreMetodo;
    String tipoMetrica;
    List<Maquina> maquinas;
    int piezasProducidas;
    int puestasFuncionamiento;
    int valorMetrica;

    public Solucion(String nombreMetodo, String tipoMetrica) {
        this.nombreMetodo = nombreMetodo;
        this.tipoMetrica = tipoMetrica;
        this.maquinas = new ArrayList();
        this.piezasProducidas = 0;
        this.puestasFuncionamiento = 0;
    }

    public Solucion(Solucion solucionMejor) {
        this.nombreMetodo = solucionMejor.nombreMetodo;
        this.tipoMetrica = solucionMejor.tipoMetrica;
        this.maquinas = new ArrayList<>(solucionMejor.maquinas);
        this.piezasProducidas = solucionMejor.piezasProducidas;
        this.puestasFuncionamiento = solucionMejor.puestasFuncionamiento;
    }

    public void addMaquina(Maquina m) {
        maquinas.add(m);
        piezasProducidas += m.getPiezas();
        puestasFuncionamiento++;
    }

    public void deleteMaquina() {
        Maquina m = maquinas.remove(maquinas.size() - 1);
        piezasProducidas -= m.getPiezas();
        puestasFuncionamiento--;
    }

    public boolean esMejor(Solucion mejorSolucion) {
        if (mejorSolucion.maquinas.size() == 0) return true;
        return this.maquinas.size() < mejorSolucion.maquinas.size();
    }

    public String getNombreMetodo() {
        return nombreMetodo;
    }

    public int getPiezasProducidas() {
        return piezasProducidas;
    }

    public int getPuestasFuncionamiento() {
        return puestasFuncionamiento;
    }

    // Recibe por parametro la candidad de estados generados en caso backtrackin, y de candidatos considerados en caso greedy
    public void setValorMetrica(int metrica) {
        this.valorMetrica = metrica;
    }

    public String getTipoMetrica() {
        return this.tipoMetrica;
    }

    public boolean esFactible(int piezasTotales, Maquina m) {
        return this.getPiezasProducidas() + m.getPiezas() <= piezasTotales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNombreMetodo()).append("\n");
        sb.append("Solución obtenida: secuencia de máquinas.\n");
        for (Maquina m : maquinas) {
            sb.append("Maquina ID: ").append(m.getId())
                    .append(" - Piezas: ").append(m.getPiezas()).append("\n");
        }
        sb.append(
                "Solución obtenida: cantidad de piezas producidas y cantidad de puestas en funcionamiento requeridas.\n");
        sb.append("Piezas producidas: ").append(piezasProducidas).append("\n");
        sb.append("Puestas en funcionamiento: ").append(puestasFuncionamiento).append("\n");
        sb.append("Metrica: " + this.getTipoMetrica() + ": ").append(this.valorMetrica).append("\n");
        return sb.toString();
    }
}
