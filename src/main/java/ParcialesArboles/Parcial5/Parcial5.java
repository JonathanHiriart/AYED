package ParcialesArboles.Parcial5;
import TP2.EJ1.BinaryTree;
public class Parcial5 {
    public static Personaje princesaAccesible(BinaryTree<Personaje> arbol){
        if(arbol!=null && (!arbol.isEmpty())){
            Personaje princesa = new Personaje();
            if(buscandoPrincesa(arbol,princesa)) {
                return princesa;
            }
        }
        return new Personaje();
    }
    private static boolean buscandoPrincesa(BinaryTree<Personaje> a, Personaje princesa) {
        if (a.isLeaf()) {
            if (a.getData().esPrincesa()) {
                princesa.setNombre(a.getData().nombre);
                princesa.setTipo(a.getData().tipo);
                return true;
            }
            return false;
        }
        if (a.hasLeftChild()) {
            if (!a.getLeftChild().getData().esDragon()){
                return buscandoPrincesa(a.getLeftChild(), princesa);
            }
        }
        if (a.hasRightChild()) {
            if (!a.getRightChild().getData().esDragon()){
                return buscandoPrincesa(a.getRightChild(), princesa);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        BinaryTree<Personaje> ab = new BinaryTree<Personaje>(new Personaje("X", "Prueba"));
        ab.addLeftChild(new BinaryTree<Personaje>(new Personaje("Dragon", "Roberto")));
        ab.getLeftChild().addLeftChild(new BinaryTree<Personaje>(new Personaje("Princesa", "Roxanne")));
        ab.getLeftChild().addRightChild(new BinaryTree<Personaje>(new Personaje("Y", "Prueba")));
        ab.addRightChild(new BinaryTree<Personaje>(new Personaje("Z", "Prueba")));
        ab.getRightChild().addRightChild(new BinaryTree<Personaje>(new Personaje("W", "Prueba")));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Personaje>(new Personaje("Princesa", "Diana")));
        Personaje resultado =  princesaAccesible(ab);
        System.out.println(resultado);
        System.out.println(ab);
    }
}
class Personaje {
    String nombre;
    String tipo;

    public Personaje() {
        this.nombre = "";
        this.tipo = "";
    }

    public Personaje(String tipo,String nombre) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean esPrincesa() {
        return tipo.equals("Princesa");
    }

    public boolean esDragon() {
        return tipo.equals("Dragon");
    }

    @Override
    public String toString() {
        return "Personaje{nombre='" + nombre + "', tipo='" + tipo + "'}";
    }
}

