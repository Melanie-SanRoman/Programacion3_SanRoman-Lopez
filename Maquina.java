package tp_especial;

public class Maquina {
    int piezas;

    public Maquina() {
        this.piezas = 0;
    }

    public Maquina(int p) {
        this.piezas = p;
    }

    public int getPiezas(){
        return this.piezas;
    }

    public void setPiezas(int p) {
        this.piezas = p;
    }
}
