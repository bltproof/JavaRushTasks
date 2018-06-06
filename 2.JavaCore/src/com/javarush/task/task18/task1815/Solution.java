package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        private ATableInterface component;

        public TableInterfaceWrapper(ATableInterface aTableInterface) {
            this.component = aTableInterface;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            component.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return component.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            component.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}