package Modelo;
public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Responsable responsable;

    public Mascota(String especie, String raza, Integer edad, Responsable responsable){
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.responsable = responsable;
    }

    public String getInfo(){
        String info="";
        info+="Nombre:"+nombre+"\n";
        info+="Especie:"+especie+"\n";
        info+="Raza:"+raza+"\n";
        info+="Edad:"+edad;

        return info;
    }

    public String[] getDatos(){
        String[] datos= {especie, raza};
        return datos;
    }
}