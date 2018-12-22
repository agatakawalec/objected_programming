import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosopherProblem {
    public static class ChopStick {
        Lock up = new ReentrantLock();
        private final int id;

        public ChopStick(int id) {
            this.id = id;
        }

        public boolean pickUp(Philosopher who, String where) throws InterruptedException {
            if (up.tryLock(10, TimeUnit.MILLISECONDS)) {
                System.out.println(who + " picked up " + where + " " + this);
                return true;
            }
            return false;
        }

        public void putDown(Philosopher who, String name) {
            up.unlock();
            System.out.println(who + " put down " + name + " " + this);
        }

        @Override
        public String toString() {
            return "Chopstick-" + id;
        }
    }

    public static class Philosopher implements Runnable {
        private final int id;
        private final ChopStick leftChopStick;
        private final ChopStick rightChopStick;
        volatile boolean isTummyFull = false;
        private Random randomGenerator = new Random();
        private int noOfTurnsToEat = 0;


        public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
            this.id = id;
            this.leftChopStick = leftChopStick;
            this.rightChopStick = rightChopStick;
        }

        @Override
        public void run() {

            try {
                while (!isTummyFull) {
                    think();
                    if (leftChopStick.pickUp(this, "left")) {
                        if (rightChopStick.pickUp(this, "right")) {
                            eat();
                            rightChopStick.putDown(this, "right");
                        }
                        leftChopStick.putDown(this, "left");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void think() throws InterruptedException {
            System.out.println(this + " is thinking");
            Thread.sleep(randomGenerator.nextInt(1000));
        }

        private void eat() throws InterruptedException {
            System.out.println(this + " is eating");
            noOfTurnsToEat++;
            Thread.sleep(randomGenerator.nextInt(1000));
        }

        public int getNoOfTurnsToEat() {
            return noOfTurnsToEat;
        }

        @Override
        public String toString() {
            return "Philosopher-" + id;
        }
    }

    private static final int NO_OF_PHILOSOPHER = 50;
    private static final int SIMULATION_MILLIS = 1000 * 10;

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = null;

        Philosopher[] philosophers = null;
        try {

            philosophers = new Philosopher[NO_OF_PHILOSOPHER];

            ChopStick[] chopSticks = new ChopStick[NO_OF_PHILOSOPHER];

            for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
                chopSticks[i] = new ChopStick(i);
            }

            executorService = Executors.newFixedThreadPool(NO_OF_PHILOSOPHER);

            for (int i = 0; i < NO_OF_PHILOSOPHER; i++) {
                philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % NO_OF_PHILOSOPHER]);
                executorService.execute(philosophers[i]);
            }

            Thread.sleep(SIMULATION_MILLIS);

            for (Philosopher philosopher : philosophers) {
                philosopher.isTummyFull = true;
            }

        } finally {
            executorService.shutdown();

            while (!executorService.isTerminated()) {
                Thread.sleep(1000);
            }

            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher + " => No of Turns to Eat ="
                        + philosopher.getNoOfTurnsToEat());
            }
        }
    }
}
