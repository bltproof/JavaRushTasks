package com.javarush.task.task17.task1703;

import java.util.ArrayList;
import java.util.List;

/* 
Синхронизированные заметки
*/

public class Solution {

    public static void main(String[] args) {
        new Note().start();
    }

    public static class Note extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                addNote(i, "#" + i);
            }
            for (int i = 0; i < 10; i++) {
                removeNote(i);
            }

        }

        public final List<String> notes = new ArrayList<String>();

        public void addNote(int index, String note) {
            System.out.println("Сейчас будет добавлена заметка [" + note + "] На позицию " + index);
            synchronized (notes) { notes.add(index, note);}


            System.out.println("Уже добавлена заметка [" + note + "]");
        }

        public void removeNote(int index) {
            String note;
            System.out.println("Сейчас будет удалена заметка с позиции " + index);
            synchronized (notes){note = notes.remove(index); }

            System.out.println("Уже удалена заметка [" + note + "] с позиции " + index);
        }
    }

}
