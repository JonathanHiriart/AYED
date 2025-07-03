package TP3.EJ4;

public class AreaEmpresa {
    public int tardanza;
    public String identificacion;
    public AreaEmpresa(String iden,int lat){
        this.identificacion= iden;
        this.tardanza=lat;
    }
    public int getTardanza(){
        return tardanza;
    }
    public String getIdentificacion(){
        return identificacion;
    }
}
