package es.EstechDam;

import java.util.Random;

public class RabbitThread extends Thread {

    private int steps;

    public RabbitThread(String name){
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

        System.out.println(Thread.currentThread().getName() + " ha terminado la carrera.");
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
            case 2: steps += 0;
            break;
            case 3:
            case 4: steps += 9;
            break;
            case 5: steps -= 12;
            break;
            case 6:
            case 7:
            case 8: steps += 1;
            break;
            case 9:
            case 10: steps -= 2;
            break;
        }

        return steps;
    }
}
