# System Performance Diagnostics (Java)

A Java CLI tool that parses request logs from a CSV file and generates a performance report, highlighting:

* High latency endpoints
* Error-heavy endpoints
* Severity scoring per issue type

## How to run

1. Open the project in Eclipse.
2. Ensure `logs.csv` is included in the project root.
3. Run `Main.java` (Run As → Java Application).

## Input format (logs.csv)

Columns:

* timestamp
* endpoint
* response_time
* status_code

Example:
timestamp,endpoint,response_time,status_code
14:01,/login,120,200
