package tp_especial;

public class Maquina implements Comparable<Maquina> {
    int id;
    int piezas;

    public Maquina(int id, int p) {
        this.id = id;
        this.piezas = p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPiezas(){
        return this.piezas;
    }

    public void setPiezas(int p) {
        this.piezas = p;
    }

    @Override
    public int compareTo(Maquina otra) {
        return Integer.compare(otra.piezas, this.piezas); // mayor a menor
    }

}
