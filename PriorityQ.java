import java.util.PriorityQueue;

public class PriorityQ{
    public static void main(String[] args) {
        // Crear cola de procesos con prioridad
        PriorityQueue<Proceso> cola = new PriorityQueue<>();

        // Agregar procesos a la cola
        cola.add(new Proceso("P1", 20, 2));
        cola.add(new Proceso("P2", 30, 1));
        cola.add(new Proceso("P3", 10, 3));
        cola.add(new Proceso("P4", 15, 2));

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
