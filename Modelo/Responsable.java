package Modelo;
import java.util.ArrayList;

public class Responsable {
    private String nombre;
    private String contacto;
    private ArrayList<Mascota> mascotas;    
    
    public Responsable(String nombre, String contacto){
        this.nombre = nombre;
        this.contacto = contacto;
        this.mascotas = new ArrayList<Mascota>();
    }

    public String[] getInfo(){
        String[] info=new String[2];
        info[0]=nombre;
        info[1]=contacto;

        return info;
    }

    public ArrayList<Mascota> getMascotas(){
        return mascotas;
    }

    public void agregarMascota(Mascota mascota){
        mascotas.add(mascota);
    }

    //Para poder mostrar el nombre en inputDialog
    @Override
    public String toString(){
        return nombre;
    }
}