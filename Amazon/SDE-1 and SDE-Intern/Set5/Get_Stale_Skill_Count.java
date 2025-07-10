/*
Get Stale Skill Count
📘 Problem Statement:

The Amazon Alexa development team wants to analyze request logs across numSkills different Alexa skills to ensure optimal 
performance and user engagement.

Each request is represented as [skill_ID, timeStamp] in the requestLogs array, meaning a request was made to skill skill_ID at time
 timeStamp.

You are given:

    An integer numSkills — the number of skills.

    A 2D array requestLogs — where requestLogs[i] = [skill_ID, timeStamp].

    An integer timeWindow — the lookback time window.

    An array queryTimes — each query specifies a timestamp.

🎯 Your Task:

For each queryTime[i], count how many skills did NOT receive any request in the interval:

[queryTime[i] - timeWindow, queryTime[i]]

Return an array of integers — one for each query.
🧾 Input Format:

    Integer: numSkills

    2D Integer Array: requestLogs[m][2]

    Integer: timeWindow

    Integer Array: queryTimes[q]

🔁 Output Format:

    Integer Array of length q: answers to each query.

🔍 Example:
Input:

numSkills = 3  
timeWindow = 5  
requestLogs = [[1, 3], [2, 6], [1, 5]]  
queryTimes = [10, 11]

Output:

[1, 2]

Explanation:

    queryTime = 10

        Interval = [5, 10]

        Skills with requests in this interval: skill 1 (at 5), skill 2 (at 6)

        Skill 3 did not get any requests → Answer = 1

    queryTime = 11

        Interval = [6, 11]

        Only skill 2 has a request (at 6)

        Skills 1 and 3 got none → Answer = 2
 */
public class Get_Stale_Skill_Count {
    
}
