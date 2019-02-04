package ru.kingsbot.command;

public class CommandPool extends Thread {

//    private Queue<Command> queue = new ConcurrentLinkedQueue();

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {

            }


        }
    }

}
