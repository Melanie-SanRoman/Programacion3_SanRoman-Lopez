package tp_especial;

import java.io.*;
import java.util.*;

public class ConfigLoader {

    public static Configuracion cargarConfiguracion(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        int piezasTotales = Integer.parseInt(br.readLine().trim());

        List<Maquina> maquinas = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            int id = Integer.parseInt(partes[0].trim());
            int piezas = Integer.parseInt(partes[1].trim());
            maquinas.add(new Maquina(id, piezas));
        }
        br.close();

        return new Configuracion(maquinas, piezasTotales);
    }

    public static class Configuracion {
        private List<Maquina> maquinas;
        private int piezasTotales;

        public Configuracion(List<Maquina> maquinas, int piezasTotales) {
            this.maquinas = maquinas;
            this.piezasTotales = piezasTotales;
        }

        public List<Maquina> getMaquinas() {
            return maquinas;
        }

        public int getPiezasTotales() {
            return piezasTotales;
        }
    }
}

