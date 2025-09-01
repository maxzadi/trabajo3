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

    public String[] getInfo(){
        String[] info=new String[3];
        info[0]=fecha.toString();
        info[1]=motivo;
        info[2]=tratamiento;

        return info;
    }

    public Date getFecha(){
        return fecha;
    }
    public Mascota getMascota(){
        return mascota;
    }
    
}