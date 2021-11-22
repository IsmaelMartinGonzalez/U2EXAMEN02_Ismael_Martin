//TODO Comentar todo el documento, revisar control de errores.
public class Main {
    public static void main(String[] args) {
        Cima cima = new Cima();
        Helicoptero[] helicopteros = new Helicoptero[3];
        helicopteros[0] = new Helicoptero(1, cima, 5);
        helicopteros[1] = new Helicoptero(2, cima, 3);
        helicopteros[2] = new Helicoptero(3, cima, 1);

        Escalador[] escaladores = new Escalador[86];
        for (int i = 0; i < escaladores.length; i++) {
            escaladores[i] = new Escalador(i + 1, cima);
            escaladores[i].start();
        }
        for (int i = 0; i < helicopteros.length; i++) {
            helicopteros[i].start();
        }
        try {
            for (int i = 0; i < helicopteros.length; i++) {
                helicopteros[i].join();
            }

            for (int i = 0; i < escaladores.length; i++) {
                escaladores[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
