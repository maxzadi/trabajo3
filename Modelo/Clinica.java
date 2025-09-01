package Modelo;
import java.util.ArrayList;

public class Clinica {
    private ArrayList<Consulta> consultas;
    private ArrayList<Responsable> responsables;
    
    public Clinica(){
        consultas = new ArrayList<Consulta>();
        responsables = new ArrayList<Responsable>();
    }

    public ArrayList<Responsable> getClientes(){
        return responsables;
    }

    public ArrayList<Consulta> getConsultas(){
        return consultas;
    }

    public String generarReporte(){
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reporte de Consultas ===\n");
        for (Consulta c : consultas){
            for(String dato : c.getMascota().getInfo()) {
                sb.append(dato).append("\n");
            }
            for(String dato : c.getInfo()) {
                sb.append(dato).append("\n");
            }
            sb.append("---------------------------\n");
        }
        return sb.toString();
    }

}