package ParcialesGrafo.Temaiken;

public class sitios {
    private int _tiempo;
    private String _lugar;

    public sitios(String lugar,int tiempo) {
        this._tiempo = tiempo;
        this._lugar= lugar;
    }

    public String get_lugar() {
        return _lugar;
    }

    public void set_lugar(String _lugar) {
        this._lugar = _lugar;
    }

    public int getTiempo() {
        return _tiempo;
    }

    public void setTiempo(int tiempo) {
        this._tiempo = tiempo;
    }
}
