/**
 * Clase que emula ser un escalador
 */
public class Escalador extends Thread {
    private final int identif;
    private final Cima cima;

    public Escalador(int identif, Cima cima) {
        this.identif = identif;
        this.cima = cima;
    }

    //Metodo que emula como los escaladores se quedan en la cima
    @Override
    public synchronized void start() {
        cima.addScaler(identif);
    }
}
