import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

public class Cima {
    private Semaphore semaphore;
    private PriorityQueue<Integer> priorityQueue;


    public Cima() {
        this.semaphore = new Semaphore(1);
        this.priorityQueue = new PriorityQueue<Integer>();
    }


    public void addScaler(Integer number) {
        try {
            semaphore.acquire();
            priorityQueue.add(number);
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer finishRescue(Helicoptero helicoptero) throws Exception {
        if (isScalerRescue()) {
            semaphore.acquire();
            for (int i = 0; i < helicoptero.getPullScaler(); i++) {
                Integer es = priorityQueue.poll();
                if (es == null) {
                    throw new Exception("Ya no hay mas escaladores");
                }
                helicoptero.sumar();
            }
            Thread.sleep((long) (Math.random() * 2000 + 1000));
            semaphore.release();

        }

        return priorityQueue.size();
    }

    public boolean isScalerRescue() {
        return !priorityQueue.isEmpty();
    }
}
