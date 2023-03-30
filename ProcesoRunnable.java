class ProcesoRunnable implements Runnable {
    private Proceso proceso;

    public ProcesoRunnable(Proceso proceso) {
        this.proceso = proceso;
    }

    @Override
    public void run() {
        System.out.format("%10s %15s %15s", proceso.getNombre(), Double.valueOf(proceso.getDuracion() / 1000), proceso.getPrioridad());
        System.out.println();
        try {
            Thread.sleep(proceso.getDuracion());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}