package Modelo;
public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Responsable responsable;

    public Mascota(String nombre, String especie, String raza, Integer edad, Responsable responsable){
        this.nombre=nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
        this.responsable = responsable;
    }

    public String[] getInfo(){
        String[] info=new String[4];
        info[0]=nombre;
        info[1]=especie;
        info[2]=raza;
        info[3]=edad.toString();

        return info;
    }

    public String[] getDatos(){
        String[] datos= {especie, raza};
        return datos;
    }

    //Para poder mostrar el nombre en inputDialog
    @Override
    public String toString(){
        return nombre;
    }
}