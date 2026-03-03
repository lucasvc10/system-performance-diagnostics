package diagnostics;

import java.io.*;
import java.util.*;

public class LogParser {

    public static List<LogEntry> parse(String filePath) {

        List<LogEntry> logs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String timestamp = parts[0];
                String endpoint = parts[1];
                int responseTime = Integer.parseInt(parts[2]);
                int statusCode = Integer.parseInt(parts[3]);

                logs.add(new LogEntry(timestamp, endpoint, responseTime, statusCode));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return logs;
    }
}