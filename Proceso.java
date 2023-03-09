public class Proceso {
    private String nombre;
    private int duracion;

    public Proceso(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void reducirDuracion(int tiempo) {
        duracion -= tiempo;
    }
}
