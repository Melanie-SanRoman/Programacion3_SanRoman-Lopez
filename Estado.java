package tp_especial;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    List<Maquina> maquinasUtilizadas;
    int piezasCreadas;
    int piezasTotales;

    public Estado(int piezasTotales) {
        this.maquinasUtilizadas = new ArrayList<>();
        this.piezasCreadas = 0;
        this.piezasTotales = piezasTotales;
    }
}
