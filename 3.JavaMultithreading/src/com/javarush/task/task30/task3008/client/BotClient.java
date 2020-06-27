package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String userName = "";
            String text = "";

            if (message.contains(": ")) {
                userName = message.substring(0, message.indexOf(":"));
                text = message.substring(message.indexOf(":") + 2);

            }

            SimpleDateFormat dateFormat = null;

            if ("дата".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("d.MM.YYYY");
            } else if ("день".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("d");
            } else if ("месяц".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("MMMM");
            } else if ("год".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("YYYY");
            } else if ("время".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("H:mm:ss");
            } else if ("час".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("H");
            } else if ("минуты".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("m");
            } else if ("секунды".equalsIgnoreCase(text)) {
                dateFormat = new SimpleDateFormat("s");
            }

            if (dateFormat != null) {
                sendTextMessage("Информация для " + userName + ": " + dateFormat.format(Calendar.getInstance().getTime()));
            }
        }
    }

    public static void main(String[] args) {
        new BotClient().run();
    }
}