package com.example.savvato.pomidorroapplication;

/**
 * Created by Savvato on 01.09.2016.
 */
public class PomodorroController {
    //private static final long MINUTE_5 = 1000 * 60 * 5;
    //private static final long MINUTE_25 = 1000 * 60 * 25;
    private static final long MINUTE_5 = 5000; // 5 seconds for debugging
    private static final long MINUTE_25 = 10000; //10 seconds for debugging


    private long targetTime;
    private int currentPomidorroNumber;

    public PomodorroController() {
        this.targetTime = MINUTE_25;
        currentPomidorroNumber = 1;
    }

    public void next() {
        if (this.currentPomidorroNumber < 8) {
            this.currentPomidorroNumber++;
        }
        else {
            this.currentPomidorroNumber = 1;
        }
    }

    public String getPomidorroStatus() {
        if (this.currentPomidorroNumber % 2 == 1) {
            return "Work";
        }
        else {
            return "Break";
        }
    }

    public long getTargetTime() {
        //Нечетные номера - работы по 25 минут
        // Четные номера - перерывы по 5 минут, последний перерыв - 25 минут
        if (this.currentPomidorroNumber % 2 == 1) {
            this.targetTime = MINUTE_25;
        }
        else {
            if (this.currentPomidorroNumber < 8) {
                this.targetTime = MINUTE_5;
            }
            else {
                this.targetTime = MINUTE_25;
            }
        }
        return this.targetTime;
    }
}
