package com.hidesec;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class Looper implements Runnable {
    private AtomicBoolean keepRunning;

    Robot robot = new Robot();

    public Looper() throws AWTException {
        keepRunning = new AtomicBoolean(true);
    }

    public void stop() {
        keepRunning.set(false);
    }

//    @Override
    public void run() {
        while (keepRunning.get()) {
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }
}
