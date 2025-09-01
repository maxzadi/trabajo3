import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
    private static Clinica clinica = new Clinica();
    private static Controlador controlador = new Controlador(clinica);

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clínica Veterinaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnAgregarDueño = new JButton("Agregar nuevo dueño");
        JButton btnAgregarMascota = new JButton("Agregar nueva mascota");
        JButton btnGenerarConsulta = new JButton("Generar consulta");
        JButton btnGenerarReporte = new JButton("Generar reporte");
        JButton btnGenerarReporteEs = new JButton("Generar reporte Estadístico");

        frame.add(btnAgregarDueño);
        frame.add(btnAgregarMascota);
        frame.add(btnGenerarConsulta);
        frame.add(btnGenerarReporte);
        frame.add(btnGenerarReporteEs);

        btnAgregarDueño.addActionListener(e -> agregarDueño());
        btnAgregarMascota.addActionListener(e -> agregarMascota());
        btnGenerarConsulta.addActionListener(e -> generarConsulta());
        btnGenerarReporte.addActionListener(e -> generarReporte());
        btnGenerarReporteEs.addActionListener(e -> generarReporteEs());

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void agregarDueño() {
        String nombre = JOptionPane.showInputDialog("Nombre del dueño:");
        String contacto = JOptionPane.showInputDialog("Contacto del dueño:");
        if (nombre != null && contacto != null && !nombre.isEmpty() && !contacto.isEmpty()) {
            controlador.agregarResponsable(nombre, contacto);
            JOptionPane.showMessageDialog(null, "Dueño agregado correctamente.");
        }
    }

    private static void agregarMascota() {
        if (controlador.getResponsables().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Primero agregue un dueño.");
            return;
        }

        String nombreMascota = JOptionPane.showInputDialog("Nombre de la mascota:");
        String especie = JOptionPane.showInputDialog("Especie:");
        String raza = JOptionPane.showInputDialog("Raza:");
        int edad;
        try {
            edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Edad inválida.");
            return;
        }

        Responsable[] responsablesArray = controlador.getResponsables().toArray(new Responsable[0]);
        Responsable responsable = (Responsable) JOptionPane.showInputDialog(
                null,
                "Seleccione dueño:",
                "Dueños",
                JOptionPane.QUESTION_MESSAGE,
                null,
                responsablesArray,
                responsablesArray[0]
        );

        if (responsable != null) {
            controlador.agregarMascota(nombreMascota, especie, raza, edad, responsable);
            JOptionPane.showMessageDialog(null, "Mascota agregada correctamente.");
        }
    }

    private static void generarConsulta() {
        ArrayList<Mascota> mascotasDisponibles = new ArrayList<>();
        for (Responsable r : controlador.getResponsables()) {
            mascotasDisponibles.addAll(r.getMascotas());
        }

        if (mascotasDisponibles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay mascotas registradas.");
            return;
        }

        Mascota[] mascotasArray = mascotasDisponibles.toArray(new Mascota[0]);
        Mascota mascota = (Mascota) JOptionPane.showInputDialog(
                null,
                "Seleccione mascota:",
                "Mascotas",
                JOptionPane.QUESTION_MESSAGE,
                null,
                mascotasArray,
                mascotasArray[0]
        );

        if (mascota != null) {
            String motivo = JOptionPane.showInputDialog("Motivo de la consulta:");
            String tratamiento = JOptionPane.showInputDialog("Tratamiento:");
            controlador.registrarConsulta(new Date(), motivo, tratamiento, mascota);
            JOptionPane.showMessageDialog(null, "Consulta registrada correctamente.");
        }
    }

    private static void generarReporte() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reporte de Consultas ===\n\n");

        ArrayList<Consulta> consultas = clinica.getConsultas();
        if (consultas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay consultas registradas.");
            return;
        }

        for (Consulta c : consultas) {
            for (String dato : c.getMascota().getInfo()) {
                sb.append(dato).append("\n");
            }
            for (String dato : c.getInfo()) {
                sb.append(dato).append("\n");
            }
            sb.append("---------------------------\n");
        }

        JTextArea area = new JTextArea(sb.toString(), 20, 30);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, scroll, "Reporte de Consultas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void generarReporteEs(){
        String reporte = controlador.generarReporteEstadistico();
        JOptionPane.showMessageDialog(null, reporte, "Reporte Estadístico", JOptionPane.INFORMATION_MESSAGE);
    }
}
