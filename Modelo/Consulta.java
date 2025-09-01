package Modelo;
import java.util.Date;

public class Consulta {
    private Date fecha;
    private String motivo;
    private String tratamiento;
    private Mascota mascota;

    public Consulta(Date fecha, String motivo, String tratamiento, Mascota mascota){
        this.fecha = fecha;
        this.motivo = motivo;
        this.tratamiento = tratamiento;
        this.mascota = mascota;
    }

    public String getInfo(){
        String info="";
        info+="Fecha:"+fecha+"\n";
        info+="Motivo:"+motivo+"\n";
        info+="Tratamiento:"+tratamiento+"\n";

        return info;
    }

    public Mascota getMascota(){
        return mascota;
    }
    
}