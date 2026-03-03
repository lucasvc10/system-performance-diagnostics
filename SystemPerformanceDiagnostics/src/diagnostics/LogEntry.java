package diagnostics;

public class LogEntry {

    private String timestamp;
    private String endpoint;
    private int responseTime;
    private int statusCode;

    public LogEntry(String timestamp, String endpoint, int responseTime, int statusCode) {
        this.timestamp = timestamp;
        this.endpoint = endpoint;
        this.responseTime = responseTime;
        this.statusCode = statusCode;
    }

    public String getTimestamp() { return timestamp; }
    public String getEndpoint() { return endpoint; }
    public int getResponseTime() { return responseTime; }
    public int getStatusCode() { return statusCode; }

    public boolean isError() {
        return statusCode >= 400;
    }
}