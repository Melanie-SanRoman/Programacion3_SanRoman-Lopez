package tp_especial;

import java.util.List;

public class Estado {
    List<Maquina> maquinasDisponibles;
    int piezasCreadas;
    int piezasTotales;

    public Estado(List<Maquina> maquinasDisponibles, int piezasTotales) {
        this.piezasCreadas = 0;
        this.piezasTotales = piezasTotales;
        this.maquinasDisponibles = maquinasDisponibles;
    }

    public List<Maquina> getMaquinasDisponibles() {
        return maquinasDisponibles;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public int getPiezasCreadas() {
        return piezasCreadas;
    }

    public void sumarPiezas(int piezas) {
        this.piezasCreadas += piezas;
    }

    public void restarPiezas(int piezas) {
        this.piezasCreadas -= piezas;
    }
}
