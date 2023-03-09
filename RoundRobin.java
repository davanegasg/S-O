import java.util.LinkedList;

public class RoundRobin {
    public static void main(String[] args) {
        LinkedList<Proceso> cola = new LinkedList<Proceso>();
        int quantum = 10; // Tiempo de quantum en milisegundos

        // Agregar procesos a la cola
        cola.add(new Proceso("P1", 20));
        cola.add(new Proceso("P2", 30));
        cola.add(new Proceso("P3", 10));
        cola.add(new Proceso("P4", 15));

        // Ejecutar procesos en la cola
        while (!cola.isEmpty()) {
            Proceso proceso = cola.poll();
            if (proceso.getDuracion() <= quantum) {
                // Ejecutar proceso completo
                System.out.println("Ejecutando proceso " + proceso.getNombre() + " durante " + proceso.getDuracion() + " milisegundos.");
                System.out.println("Proceso " + proceso.getNombre() + " terminado.\n");
                try {
                    Thread.sleep(proceso.getDuracion());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Ejecutar proceso parcialmente y agregarlo de nuevo a la cola
                System.out.println("Ejecutando proceso " + proceso.getNombre() + " durante " + quantum + " milisegundos.\n");
                proceso.reducirDuracion(quantum);
                cola.add(proceso);
                try {
                    Thread.sleep(quantum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}