package diagnostics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Parse logs from CSV
        List<LogEntry> logs = LogParser.parse("logs.csv");

        // Analyze performance
        List<Issue> issues = PerformanceAnalyzer.analyze(logs);

        // Generate report
        ReportGenerator.generate(issues);
    }
}