package net.backdoorinc.bungeesystem.util;

import java.io.*;

public class Logger {

    private File file = new File("bungee/logger.txt");

    public static void writeLog(LoggerEnum Type,String message) throws IOException {

        switch (Type) {
            case LOG:
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("logger.txt")));
                printWriter.println("[LOG]" + message);
                printWriter.println("\n");
                printWriter.close();
            case INFO:
                PrintWriter printWriter1 = new PrintWriter(new BufferedWriter(new FileWriter("logger.txt")));
                printWriter1.println("[INFO]" + message);
                printWriter1.println("\n");
                printWriter1.close();
            case ERROR:
                PrintWriter printWriter2 = new PrintWriter(new BufferedWriter(new FileWriter("logger.txt")));
                printWriter2.println("[ERROR]" + message);
                printWriter2.println("\n");
                printWriter2.close();
            case FATAL:
                PrintWriter printWriter3 = new PrintWriter(new BufferedWriter(new FileWriter("logger.txt")));
                printWriter3.println("[FATAL]" + message);
                printWriter3.println("\n");
                printWriter3.close();
        }
    }
    public void createFile() {
        if(!file.exists()) {
            file.mkdirs();
        }else {
            return;
        }
    }

}
