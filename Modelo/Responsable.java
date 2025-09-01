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

    public String getInfo(){
        String info="";
        info+="Nombre:"+nombre+"\n";
        info+="Contacto:"+contacto;

        return info;
    }

    public ArrayList<Mascota> getMascotas(){
        return mascotas;
    }

    public void agregarMascota(Mascota mascota){
        mascotas.add(mascota);
    }

}