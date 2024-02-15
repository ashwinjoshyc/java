import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    private int hour;
    private int minute;

    public Alarm(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void setAlarm() {
        Timer timer = new Timer();
        long alarmTime = (hour * 60 + minute) * 60 * 1000;

        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("Time to wake up!");
            }
        }, alarmTime);
    }

    public void visualize() {
        System.out.println("Current alarm time: " + String.format("%02d:%02d", hour, minute));
    }

    public void register(int newHour, int newMinute) {
        this.hour = newHour;
        this.minute = newMinute;
        System.out.println("Alarm time updated.");
    }

    public static void main(String[] args) {
        Alarm myAlarm = new Alarm(7, 30);
        myAlarm.visualize();
        myAlarm.register(8, 0);
        myAlarm.visualize();
        myAlarm.setAlarm();
    }
}