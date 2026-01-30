'''
Uno Game
Problem Description
It was a lazy Sunday, and Dhruv was feeling bored. He picked up his phone and sent a message in his group, inviting anyone interested in playing Uno to come over. Within a few minutes, N children from the neighbourhood arrived to join the fun.

Among the group, there are some friends-pairs and some rivals-pairs.

Friends: If one friend is selected, the other must also be selected into the game. Each friends pair always consists of exactly two members, and no person can belong to more than one friends pair. For example, if (A, B) is a friend pair, neither A nor B will appear in any other friend pair.
Rivals: Both members of a rival pair cannot be selected into the team.
Each player has a uno score representing their skill level. Dhruv sets a limit for the team's total uno score and tries to select the maximum number of players without exceeding that limit.

Dhruv wanted to start the game quickly, but he is unsure which players to pick. Can you help him choose the optimal team?

Constraints
1 <= length of player name <= 10

1 <= max limit Dhruv set <= 1000

1 <= skill level of each player <= 100

1 <= total number of players <= 25

1 <= number of friends + number of rival pairs <= 10

Input
The first line contains an integer N, the total number of players.

The second line contains N space-separated strings, representing the player's names.

The third line contains N space-separated integers, representing the skill level of each corresponding player.

The fourth line contains an integer N1, the number of friend pairs.

The next N1 lines each contain two space-separated names, representing a pair of friends.

The following line contains an integer N2, the number of rival pairs.

The next N2 lines each contain two space-separated names, representing a pair of rivals.

The last line contains a single integer, representing the skill limit set by Dhruv.

Output
Print the maximum number of players Dhruv can select obeying the friend, rival, and the skill limit rules.

Time Limit (secs)
1

Examples
Example 1

Input

10

Ram Raj Vishnu Teja Alekhya Keerti Ganesh Seetha Rakesh Latha

1 2 3 4 5 6 7 8 9 1

2

Ram Latha

Alekhya Keerti

3

Ram Teja

Raj Rakesh

Seetha Raj

10

Output

4

Explanation

Dhruv can form a team consisting of {Ram, Latha, Raj, Vishnu} that follows all the friends and rival rules. The combined skill value of this team is 1 + 1 + 3 + 4 = 9, which is within the limit of 10. Therefore, Dhruv can select a maximum of 4 players, and no other combination can include more people than this.

Example 2

Input

8

Aarav Maya Rohan Neha Karan Sana Vikram Isha

1 4 9 10 11 17 2 6

2

Aarav Isha

Maya Karan

2

Aarav Neha

Rohan Neha

80

Output

7

Explanation

Within the skill limit, 
Dhruv can select everyone except Neha. 
So, the maximum number of players he can select is 7, hence print the same.
'''



# Input
n = int(input())
names = input().split()
skills_level = list(map(int, input().split()))
skill_map = dict(zip(names, skills_level))

n1 = int(input())
friends = {}
for _ in range(n1):
    a, b = input().split()
    friends[a] = b
    friends[b] = a

n2 = int(input())
rivals = {name: set() for name in names}
for _ in range(n2):
    a, b = input().split()
    rivals[a].add(b)
    rivals[b].add(a)

limit = int(input())

res = 0

def backtrack(i, team_list, curr_skill):
    global res
    if curr_skill > limit:
        return
    if len(team_list) + (n - i) <= res:
        return

    res = max(res, len(team_list))

    if i == n:
        return

    name = names[i]

    backtrack(i + 1, team_list, curr_skill)

    valid = True

    if name in team_list:
        return  

    if name in friends:
        f = friends[name]
        
        if f in team_list:
            pair = [name]
        else:
            pair = [name, f]
    else:
        pair = [name]

    # check for rival conflicts
    for p in pair:
        for r in rivals[p]:
            if r in team_list:
                valid = False
                break
        if not valid:
            break

    if valid:
        total_skill = curr_skill + sum(skill_map[p] for p in pair)
        if total_skill <= limit:
            for p in pair:
                team_list.add(p)
            backtrack(i + 1, team_list, total_skill)
            for p in pair:
                team_list.remove(p)

backtrack(0, set(), 0)
print(res)
