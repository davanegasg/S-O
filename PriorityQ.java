import java.util.PriorityQueue;

public class PriorityQ{
    public static void main(String[] args) {
        // Crear cola de procesos con prioridad
        PriorityQueue<Proceso> cola = new PriorityQueue<>();

        // Agregar procesos a la cola
        cola.add(new Proceso("P1", 100, 7));
        cola.add(new Proceso("P2", 100, 2));
        cola.add(new Proceso("P3", 100, 5));
        cola.add(new Proceso("P4", 100, 4));
        cola.add(new Proceso("P5", 100, 10));
        cola.add(new Proceso("P6", 200, 3));
        cola.add(new Proceso("P7", 200, 1));
        cola.add(new Proceso("P8", 200, 8));
        cola.add(new Proceso("P9", 200, 7));
        cola.add(new Proceso("P10", 200, 1));

        int cont=0, tTotal =0;
        double tProm;

        // Ejecutar procesos en la cola
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();
            tTotal += proceso.getDuracion();
            cont++;
            System.out.println("Ejecutando proceso " + proceso.getNombre() + " (prioridad " + proceso.getPrioridad() + ") durante " + proceso.getDuracion() + " unidades de tiempo.");
            try {
                Thread.sleep(proceso.getDuracion());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tProm = tTotal/cont;
        System.out.println("Tiempo promedio de ejecución: " + (tProm/1000) + " Segundos");
    }
}
