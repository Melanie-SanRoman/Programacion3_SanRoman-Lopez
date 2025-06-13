package tp_especial;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    List<Maquina> maquinasUtilizadas;
    List<Maquina> maquinasDisponibles;
    int piezasCreadas;
    int piezasTotales;

    public Estado(List<Maquina> maquinasDisponibles, int piezasTotales) {
        this.maquinasUtilizadas = new ArrayList<>();
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

    public void agregar(Maquina maquina) {
        maquinasUtilizadas.add(maquina);
        piezasCreadas += maquina.getPiezas();
    }

    public void quitar(Maquina maquina) {
        maquinasUtilizadas.remove(maquinasUtilizadas.size() - 1); // elimina la ultima maquina
        piezasCreadas -= maquina.getPiezas();
    }

}
