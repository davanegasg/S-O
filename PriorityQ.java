import java.util.PriorityQueue;

public class PriorityQ{
    public static void main(String[] args) {
        // Crear cola de procesos con prioridad
        PriorityQueue<Proceso> cola = new PriorityQueue<>();

        // Agregar procesos a la cola
        cola.add(new Proceso("P1", 2000, 7));
        cola.add(new Proceso("P2", 3000, 2));
        cola.add(new Proceso("P3", 1000, 5));
        cola.add(new Proceso("P4", 1500, 4));
        cola.add(new Proceso("P5", 2000, 10));
        cola.add(new Proceso("P6", 3500, 3));
        cola.add(new Proceso("P7", 1500, 1));
        cola.add(new Proceso("P8", 5000, 8));
        cola.add(new Proceso("P9", 4000, 7));
        cola.add(new Proceso("P10", 2000, 1));
        // Ejecutar procesos en la cola
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();
            System.out.println("Ejecutando proceso " + proceso.getNombre() + " (prioridad " + proceso.getPrioridad() + ") durante " + proceso.getDuracion() + " unidades de tiempo.");
            try {
                Thread.sleep(proceso.getDuracion());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
