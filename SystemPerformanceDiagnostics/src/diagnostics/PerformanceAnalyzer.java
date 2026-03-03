package diagnostics;

import java.util.*;

public class PerformanceAnalyzer {

    public static List<Issue> analyze(List<LogEntry> logs) {

        Map<String, Integer> errorMap = new HashMap<>();
        Map<String, Integer> latencyMap = new HashMap<>();

        for (LogEntry log : logs) {

            // Count errors
            if (log.isError()) {
                errorMap.put(
                        log.getEndpoint(),
                        errorMap.getOrDefault(log.getEndpoint(), 0) + 1
                );
            }

            // Count high latency (>700ms)
            if (log.getResponseTime() > 700) {
                latencyMap.put(
                        log.getEndpoint(),
                        latencyMap.getOrDefault(log.getEndpoint(), 0) + 1
                );
            }
        }

        List<Issue> issues = new ArrayList<>();

        // Convert error counts into Issue objects
        for (String endpoint : errorMap.keySet()) {
            issues.add(new Issue(endpoint, IssueType.ERROR, errorMap.get(endpoint)));
        }

        // Convert latency counts into Issue objects
        for (String endpoint : latencyMap.keySet()) {
            issues.add(new Issue(endpoint, IssueType.HIGH_LATENCY, latencyMap.get(endpoint)));
        }

        return issues;
    }
}