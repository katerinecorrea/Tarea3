import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profesor extends Persona {
    private String materia;
    private int añosExperiencia;

    // Arreglo para almacenar hasta 50 profesores
    private static Profesor[] listaProfesores = new Profesor[50];
    private static int contador = 0;

    // Constructor
    public Profesor(String nombre, String apellido, String fechanacimiento, String genero,
                    double estatura, double peso, String materia, int añosExperiencia) {
        super(nombre, apellido, fechanacimiento, genero, estatura, peso);
        this.materia = materia;
        this.añosExperiencia = añosExperiencia;
    }

    // Getters
    public String getMateria() {
        return materia;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    // Agregar profesor al arreglo
    public static void agregarProfesor(Profesor profesor) {
        if (contador < listaProfesores.length) {
            listaProfesores[contador] = profesor;
            contador++;
        } else {
            System.out.println("No se pueden agregar más profesores.");
        }
    }

    // Mostrar datos del profesor
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Materia: " + materia);
        System.out.println("Años de experiencia: " + añosExperiencia);
    }

    // Mostrar todos los profesores almacenados en el arreglo
    public static void mostrarTodosLosProfesores() {
        for (int i = 0; i < contador; i++) {
            System.out.println("\nProfesor #" + (i + 1));
            listaProfesores[i].mostrarDatos();
        }
    }

    // Guardar el profesor en la base de datos MySQL
    public void guardarEnBaseDeDatos() {
        String url = "jdbc:mysql://localhost:3306/universidad";
        String usuario = "root";
        String contraseña = "123456789Num";

        String sql = "INSERT INTO profesor (nombre, apellido, fecha_nacimiento, genero, estatura, peso, materia, anios_experiencia) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, getNombre());
            stmt.setString(2, getApellido());
            stmt.setString(3, getFechanacimiento());
            stmt.setString(4, getGenero());
            stmt.setDouble(5, getEstatura());
            stmt.setDouble(6, getPeso());
            stmt.setString(7, materia);
            stmt.setInt(8, añosExperiencia);

            stmt.executeUpdate();
            System.out.println("✅ Profesor guardado correctamente en la base de datos.");

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar en la base de datos: " + e.getMessage());
        }
    }
}


