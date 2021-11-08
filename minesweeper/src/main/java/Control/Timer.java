package Control;

import java.util.TimerTask;

public class Timer {
    int secondsPassed = 0;
    Timer myTimer =new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            System.out.println(secondsPassed);
        }
    };
    public void start(){
        myTimer.scheduleAtFixedRate(task,1000,1000);
    }

    private void scheduleAtFixedRate(TimerTask task, int i, int i1) {
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
    }
}
