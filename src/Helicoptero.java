public class Helicoptero extends Thread {
    private int identif;
    private Cima cima;
    private int pullScaler;
    private int pasajeros;

    public Helicoptero(int identif, Cima cima, int pullScaler) {
        this.identif = identif;
        this.cima = cima;
        this.pullScaler = pullScaler;
    }

    @Override
    public void run() {
        int totalCimaScaler;
        try {
            while (cima.isScalerRescue()) {
                totalCimaScaler = cima.finishRescue(this);
                System.out.println("Helicoptero con ID " + identif + " lleva abordo a " + pasajeros + " escaladores. Quedan en la cima "
                        + totalCimaScaler + " escaladores.");
                pasajeros = 0;
            }
        } catch (Exception e) {
            System.out.println("El helicoptero con ID " + identif + " se ha intentado llevar " + pullScaler + " escaladores y a conseguido llevarse a "
                    + pasajeros + " escaladores.\n" + e.getMessage());
        }
    }

    public int getPullScaler() {
        return pullScaler;
    }

    public void sumar() {
        pasajeros++;
    }
}
