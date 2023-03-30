import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PriorityQThreads{
    public static void main(String[] args) {
        // Crear cola de procesos con prioridad
        PriorityQueue<Proceso> cola = new PriorityQueue<>();

        // Agregar procesos a la cola
        cola.add(new Proceso("P1", 1000, 7));
        cola.add(new Proceso("P2", 10000, 2));
        cola.add(new Proceso("P3", 1000, 5));
        cola.add(new Proceso("P4", 1000, 4));
        cola.add(new Proceso("P5", 1000, 10));
        cola.add(new Proceso("P6", 10000, 3));
        cola.add(new Proceso("P7", 10000, 1));
        cola.add(new Proceso("P8", 2000, 8));
        cola.add(new Proceso("P9", 2000, 7));
        cola.add(new Proceso("P10", 2000, 1));

        int cont=0, tTotal =0;
        double tProm;

        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("%10s %15s %15s %15s", "PROCESO", "SEGUNDOS", "PRIORIDAD", "Tiempo");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");

        ExecutorService pool = Executors.newFixedThreadPool(3);
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();
            Runnable tarea = new ProcesoRunnable(proceso);
            long inicio = System.currentTimeMillis();
            pool.execute(tarea);
            long fin = System.currentTimeMillis();
            tTotal += proceso.getDuracion();
            cont++;
            System.out.format("%10s %15s %15s %15s", proceso.getNombre(), Double.valueOf(proceso.getDuracion()/1000), proceso.getPrioridad(), (fin-inicio));
            System.out.println();
        }

        pool.shutdown();

        while (!pool.isTerminated()) {
            Thread.yield();
        }

        System.out.println("---------------------------------------------------------------------------");
        tProm = tTotal/cont;
        System.out.println("TIEMPO PROMEDIO DE EJECICIÓN: " + (tProm/1000) + " SEGUNDOS");
        System.out.println("---------------------------------------------------------------------------");
    }
}
