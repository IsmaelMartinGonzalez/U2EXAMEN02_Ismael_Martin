public class Escalador extends Thread {
    private int identif;
    private Cima cima;

    public Escalador(int identif, Cima cima) {
        this.identif = identif;
        this.cima = cima;
    }

    @Override
    public synchronized void start() {
        cima.addScaler(identif);
    }
}
