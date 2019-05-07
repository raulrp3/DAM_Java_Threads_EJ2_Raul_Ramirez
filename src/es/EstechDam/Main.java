package es.EstechDam;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long timeTurtle,timeRabbit;

        timeRabbit = 0;
        timeTurtle = 0;

        TurtleThread turtle = new TurtleThread("T");
        RabbitThread rabbit = new RabbitThread("L");

        turtle.start();
        rabbit.start();

        while (turtle.isAlive() || rabbit.isAlive()){
            long time = System.currentTimeMillis() - startTime;
            if (turtle.isAlive()){
                timeTurtle = time;
            }

            if (rabbit.isAlive()){
                timeRabbit = time;
            }
        }

        System.out.println();
        if (timeRabbit == timeTurtle){
            System.out.println("¡Han empatado!");
        }else if(timeTurtle > timeRabbit){
            System.out.println("¡Ha ganado la liebre!");
        }else{
            System.out.println("¡Ha ganado la tortuga!");
        }
    }
}
