package diagnostics;

import java.util.*;

public class ReportGenerator {

    public static void generate(List<Issue> issues) {

        // Sort issues by severity (highest first)
        issues.sort((a, b) -> b.getSeverityScore() - a.getSeverityScore());

        System.out.println("\n=== System Diagnostics Report ===\n");

        int limit = Math.min(3, issues.size());

        for (int i = 0; i < limit; i++) {
            Issue issue = issues.get(i);

            System.out.println((i + 1) + ". Endpoint: " + issue.getEndpoint());
            System.out.println("   Type: " + issue.getType());
            System.out.println("   Occurrences: " + issue.getCount());
            System.out.println("   Severity Score: " + issue.getSeverityScore());
            System.out.println();
        }
    }
}