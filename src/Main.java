public class Main {
    public static void main(String[] args) {
        // Crear un profesor
        Profesor prof = new Profesor(
                "Katerine",
                "Correa",
                "1990-06-01",
                "Femenino",
                1.65,
                60.0,
                "Matemáticas",
                10
        );

        // Mostrar los datos en consola
        prof.mostrarDatos();

        // Agregarlo al arreglo
        Profesor.agregarProfesor(prof);

        // Guardarlo en la base de datos
        prof.guardarEnBaseDeDatos();

        // Mostrar todos los profesores guardados en el arreglo
        Profesor.mostrarTodosLosProfesores();
    }
}
