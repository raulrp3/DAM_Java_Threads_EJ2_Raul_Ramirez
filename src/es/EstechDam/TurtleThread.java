package es.EstechDam;

import java.util.Random;

public class TurtleThread extends Thread {

    private int steps;

    public TurtleThread(String name){
        super(name);
        steps = 0;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " ha empezado la carrera.");
        while (steps != 70){
            this.sleep(1);
            Random rnd = new Random();
            int random = rnd.nextInt(9) + 1;
            steps = calculateSteps(random);

            if (steps < 1){
                steps = 1;
            }else if(steps > 70){
                steps = 70;
            }

            System.out.println(Thread.currentThread().getName() + ": " + steps);
        }
        System.out.print(Thread.currentThread().getName() + " ha terminado la carrera.");
    }

    private void sleep(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    private int calculateSteps(int random){
        switch (random){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: steps += 3;
            break;
            case 6:
            case 7: steps -= 6;
            break;
            case 8:
            case 9:
            case 10: steps += 1;
            break;
        }

        return steps;
    }
}
