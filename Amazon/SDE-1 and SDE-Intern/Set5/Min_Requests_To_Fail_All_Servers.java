/*
Minimum Requests to Fail All Servers
📘 Problem Statement:

There are n servers. Each server i has:

    request[i]: number of requests it can serve per second.

    health[i]: its starting health.

You can:

    Every second: send a total number of requests (sum of all servers' request[i]).

    Additionally: send a virus to one server, reducing its health by k units.

A server fails when its health becomes ≤ 0.
🎯 Your Task:

Find the minimum total number of requests needed to bring all servers down, and send one final request to conclude the failure.
🧾 Input Format:

    Integer n: number of servers

    Array request[n]: requests each server can serve per second

    Array health[n]: initial health of each server

    Integer k: virus damage

🔁 Output Format:

    Integer: minimum number of requests to shut down all servers and one final request.

🔍 Example 1:
Input:

n = 2  
request = [3, 4]  
health = [4, 6]  
k = 3

Output:

21

Explaination :- 
| Second | Requests Sent | Virus Target | Server Health            |
| ------ | ------------- | ------------ | ------------------------ |
| 1      | 3+4 = 7       | Server 1     | \[1, 6]                  |
| 2      | 3+4 = 7       | Server 1     | \[-2, 6] → server 1 dies |
| 3      | 4             | Server 2     | \[dead, 3]               |
| 4      | 4             | Server 2     | \[dead, 0]               |
| Final  | 1             | -            | All dead                 |

Total = 7 + 7 + 4 + 1 + 1 = 21

Example 2:
Input:

n = 3  
request = [1, 2, 3]  
health = [3, 2, 1]  
k = 2

Output:

12

Explanation:

You need 6 + 3 + 1 + 1 (final request) = 12 total requests as per the given trace.
 */
public class Min_Requests_To_Fail_All_Servers {

}
