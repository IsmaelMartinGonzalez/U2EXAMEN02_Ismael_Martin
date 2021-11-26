/**
 * Clase encagada de rescatar a los escaladores.
 */
public class Helicoptero extends Thread {
    private final int identif;
    private final Cima cima;
    private final int pullScaler;
    private int pasajeros;

    public Helicoptero(int identif, Cima cima, int pullScaler) {
        this.identif = identif;
        this.cima = cima;
        this.pullScaler = pullScaler;
    }

    //El metodo run comienza el rescate que hace un helicoptero.
    @Override
    public void run() {
        int totalCimaScaler;
        try {
            //Mientras tengamos escaladores en la cima los helicopteros seguiran rescatando a la gente
            while (cima.isScalerRescue()) {
                totalCimaScaler = cima.finishRescue(this);
                //En cada iteracion mostramos que helicoptero ha ido a la cima, cuanta gente se lleva y cuanta queda en la cima
                System.out.println("Helicoptero con ID " + identif + " lleva abordo a " + pasajeros + " escaladores. Quedan en la cima "
                        + totalCimaScaler + " escaladores.");
                pasajeros = 0;
            }
        } catch (Exception e) {
            //En caso de que ya no queden mas escaladores en la cima controlamos el error y mostramos el siguiente mensaje
            System.out.println("El helicoptero con ID " + identif + " se ha intentado llevar " + pullScaler + " escaladores y a conseguido llevarse a "
                    + pasajeros + " escaladores.\n" + e.getMessage());
        }
    }

    //Nos muestra cuanto pouede llevar un helicoptero
    public int getPullScaler() {
        return pullScaler;
    }

    //Contador de pasajeros en el helicptero.
    public void sumar() {
        pasajeros++;
    }
}
