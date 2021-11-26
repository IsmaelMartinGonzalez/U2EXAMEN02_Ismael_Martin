import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

/**
 * Clase que hace de union entre los escaladores y los helicoptero
 */
public class Cima {
    private final Semaphore semaphore;
    private final PriorityQueue<Integer> priorityQueue;


    public Cima() {
        this.semaphore = new Semaphore(1);
        this.priorityQueue = new PriorityQueue<Integer>();
    }

    //Metodo para añadir escaladores a la cima
    public void addScaler(Integer number) {
        try {
            semaphore.acquire();
            priorityQueue.add(number);
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo que emula la funcion de rescatar a los escaladores.
    public Integer finishRescue(Helicoptero helicoptero) throws Exception {
        //Comprobamos que aun hay escaladores en la cima
        if (isScalerRescue()) {
            semaphore.acquire();
            //Genearmos un bucle que iterara tantas vecesa como sitios tenga el helicoptero
            for (int i = 0; i < helicoptero.getPullScaler(); i++) {
                //Sacamos un escalador de la cima y comprobamos que no esta vacio en caso de que tengamos mas sitios que escaladores en la cima
                Integer es = priorityQueue.poll();
                if (es == null) {
                    throw new Exception("Ya no hay mas escaladores");
                }
                helicoptero.sumar();
            }
            //Emulamos el resacate con un tiempo de entre 10 y 20 segundos
            Thread.sleep((long) (Math.random() * 2000 + 1000));
            semaphore.release();
        }
        //Devolvemos los escaladores que quedan en la cima
        return priorityQueue.size();
    }

    public boolean isScalerRescue() {
        return !priorityQueue.isEmpty();
    }
}
