import Modelo.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class Controlador {
    private Clinica clinica;

    public Controlador(Clinica clinica){
        this.clinica = clinica;
    }

    public void agregarResponsable(String nombre, String contacto){
        Responsable r = new Responsable(nombre, contacto);
        clinica.getClientes().add(r);
    }

    public void agregarMascota(String nombre, String especie, String raza, int edad, Responsable responsable){
        Mascota m = new Mascota(nombre, especie, raza, edad, responsable);
        responsable.agregarMascota(m);
    }

    public void registrarConsulta(Date fecha, String motivo, String tratamiento, Mascota mascota){
        Consulta c = new Consulta(fecha, motivo, tratamiento, mascota);
        clinica.getConsultas().add(c);
    }

    public ArrayList<Responsable> getResponsables(){
        return clinica.getClientes();
    }

    public String generarReporte(){
        return clinica.generarReporte();
    }

    public String generarReporteEstadistico() {
        ArrayList<Consulta> consultas = clinica.getConsultas();
        if (consultas.isEmpty()) return "No hay consultas registradas.";

        ArrayList<String> especies = new ArrayList<>();
        ArrayList<Integer> conteoEspecies = new ArrayList<>();

        ArrayList<String> nombresMascotas = new ArrayList<>();
        ArrayList<Integer> conteoMascotas = new ArrayList<>();

        ArrayList<String> meses = new ArrayList<>();
        ArrayList<Integer> conteoMeses = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        for (Consulta c : consultas) {
            String especie = c.getMascota().getDatos()[0];
            if (especies.contains(especie)) {
                int index = especies.indexOf(especie);
                conteoEspecies.set(index, conteoEspecies.get(index) + 1);
            } else {
                especies.add(especie);
                conteoEspecies.add(1);
            }

            String nombreMascota = c.getMascota().toString();
            if (nombresMascotas.contains(nombreMascota)) {
                int index = nombresMascotas.indexOf(nombreMascota);
                conteoMascotas.set(index, conteoMascotas.get(index) + 1);
            } else {
                nombresMascotas.add(nombreMascota);
                conteoMascotas.add(1);
            }

            String mes = sdf.format(c.getFecha());
            if (meses.contains(mes)) {
                int index = meses.indexOf(mes);
                conteoMeses.set(index, conteoMeses.get(index) + 1);
            } else {
                meses.add(mes);
                conteoMeses.add(1);
            }
        }

        int maxEspecie = 0, idxEspecie = 0;
        for (int i = 0; i < conteoEspecies.size(); i++) {
            if (conteoEspecies.get(i) > maxEspecie) {
                maxEspecie = conteoEspecies.get(i);
                idxEspecie = i;
            }
        }

        int maxMascota = 0, idxMascota = 0;
        for (int i = 0; i < conteoMascotas.size(); i++) {
            if (conteoMascotas.get(i) > maxMascota) {
                maxMascota = conteoMascotas.get(i);
                idxMascota = i;
            }
        }

        int totalConsultas = 0;
        for (int c : conteoMeses) totalConsultas += c;
        double promedio = (double) totalConsultas / conteoMeses.size();

        return "=== Reporte Estadístico ===\n"
            + "Especie más atendida: " + especies.get(idxEspecie) + "\n"
            + "Mascota más consultada: " + nombresMascotas.get(idxMascota) + "\n"
            + "Promedio de consultas por mes: " + String.format("%.2f", promedio);
    }

}