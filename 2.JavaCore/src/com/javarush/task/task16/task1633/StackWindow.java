package com.javarush.task.task16.task1633;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class StackWindow extends JFrame
        implements Thread.UncaughtExceptionHandler {

    private JTextArea textArea;

    public StackWindow(
            String title, final int width, final int height) {
        super(title);
        setSize(width, height);
        textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        textArea.setEditable(false);
        getContentPane().add(pane);
    }

    public void uncaughtException(Thread t, Throwable e) {
        addStackInfo(e);
    }

    public void addStackInfo(final Throwable t) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
                toFront();
                StringWriter sw = new StringWriter();
                PrintWriter out = new PrintWriter(sw);
                t.printStackTrace(out);
                textArea.append(sw.toString());
            }
        });
    }
}
