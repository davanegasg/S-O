class Proceso implements Comparable<Proceso> {
    private String nombre;
    private int duracion;
    private int prioridad;

    public Proceso(String nombre, int duracion, int prioridad) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public int compareTo(Proceso otroProceso) {
        return Integer.compare(this.prioridad, otroProceso.prioridad);
    }
}