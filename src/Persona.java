public class Persona {
    private String nombre;
    private String apellido;
    private String fechanacimiento;
    private String genero;
    private double estatura;
    private double peso;

    //Connstructor
    public Persona(String nombre, String apellido, String fechanacimiento, String genero, double estatura, double peso){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
    }

    //Getters

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public double getEstatura() {
        return estatura;
    }

    public double getPeso() {
        return peso;
    }
    //Metodo para poder imprimir los datos
    public void mostrarDatos(){
        System.out.println("Nombre: " +nombre+ "" +apellido);
        System.out.println("Fecha de Nacimiento: " + fechanacimiento);
        System.out.println("Género: " + genero);
        System.out.println("Estatura: " + estatura + "m");
        System.out.println("Peso: " + peso + "Kg");

    }
}
