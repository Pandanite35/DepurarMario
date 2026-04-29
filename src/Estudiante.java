public class Estudiante {
    private String nombre;
    private int edad;
    private double[] notas;

    public Estudiante(String nombre, int edad, double[] notas) {
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double[] getNotas() {
        return notas;
    }
}