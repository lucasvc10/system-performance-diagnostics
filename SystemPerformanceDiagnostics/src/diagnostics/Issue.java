package diagnostics;

public class Issue {

    private String endpoint;
    private IssueType type;
    private int count;
    private int severityScore;

    public Issue(String endpoint, IssueType type, int count) {
        this.endpoint = endpoint;
        this.type = type;
        this.count = count;
        this.severityScore = calculateSeverity();
    }

    private int calculateSeverity() {
        if (type == IssueType.ERROR) {
            return count * 2; // errors weighted higher
        }
        return count;
    }

    public String getEndpoint() { return endpoint; }
    public IssueType getType() { return type; }
    public int getCount() { return count; }
    public int getSeverityScore() { return severityScore; }
}
