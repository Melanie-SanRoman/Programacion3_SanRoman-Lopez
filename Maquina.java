package tp_especial;

public class Maquina {
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

}
