'''
Path Finder
Problem Description
Lilly, being wise and clever, always thinks in the most optimal way. One day, feeling bored, she drew a grid filled with random values. She then set herself a goal to achieve using this grid.

Lilly starts at the source cell and wants to reach the destination cell. From any given cell, she can move to one of its 8 neighbouring cells that has the maximum value. Lily can move to the neighbouring cell if and only if the neighbour cell has the max value. If it does not have the max value, first she must make it maximum by adding some value and then move to it. Additionally, there are K blocked cells that she cannot enter, and she will not consider these at all for stepping in and the blocked cells cannot be considered for calculating the maximum value among the neighbours. Note that if the current cell has the maximum value among all its neighbours, then she will try to move to a neighbouring cell by increasing its value beyond the current cell's value. Also, note that the values we add are temporary i.e., after adding some value and moving to that cell, the value of that cell becomes the original value.

Lilly named this challenge as "Path Finder" since it tests both her strategic thinking and ability to find the most efficient path through the grid.

Note: Current cell must have only one highest-value neighbor i.e., the cell Lilly wants to shift.

Constraints
2 <= N, M <= 20

0 <= K <= 10

1 < Units of data in containers < 100

Source and destination cells will never be blocked.

Input
First line consists of two space separated integers N and M representing the size of the grid.

Next N lines, each consists of M space separated integers, representing numbers in the grid cells.

Line N+1 consist of two space separated integers, indicating Lilly's current location.

Line N+2 consists of two space separated integers, specifying the destination cell where Lilly want to reach.

Next line consists of an integer K denoting the number of blocked cells.

Next K lines each consists of two space separated integers denoting the indices of blocked cells.

The indexes are one basis.

Output
Print a single integer denoting the minimum value Lilly must add to reach the destination cell.

Time Limit (secs)
1

Examples
Example 1

Input

4 4

1 2 3 4

5 6 7 8

9 10 11 12

13 14 15 16

2 2

4 1

2

3 1

1 4

Output

5

Explanation

Lilly's current location is at cell (2, 2), and she needs to reach cell (4, 1). Consider two possible paths -

Path 1: (2, 2) -> (3, 2) -> (4, 1) and Path 2: (2, 2) -> (3, 1) -> (4, 1)

To move from (2, 2) to (3, 2), the next cell must have a value greater than all its neighbours, so we need to add 2. Then, moving from (3, 2) to (4, 1) requires adding 3 more, giving a total of 5. Similarly, the other path also requires a total value addition of 5. However, since cell (3, 1) is blocked, Lilly must take the first path, which still results in the minimum total value added.

Example 2

Input

6 6

1 17 18 20 11 10

3 17 15 18 16 15

10 11 20 6 8 3

18 18 5 11 4 16

3 4 8 17 18 20

3 17 15 18 16 15

1 1

3 4

3

2 1

2 2

5 5

Output

18

Explanation

Lilly starts at cell (1, 1) and needs to reach cell (3, 4). One possible path she can take is (1, 1) -> (1, 2) -> (1, 3) -> (1, 4) -> (2, 4) -> (3, 4), which results in a minimum total value addition of 18.

Break up of calculations -

For moving from (1, 1) to (1, 2) nothing must be added, because among those unblocked neighbours of (1, 1), the neighbour (1, 2) is having maximum. So simply move to it.

Again, moving from (1, 2) to (1, 3) and then to (1, 4) costs nothing as they are already largest neighbours.

Moving from (1, 4) to (2, 4) results in a cost of 3 and finally moving from (2, 4) to (3, 4) results in a cost of 15.

Hence the total value to be added is 3 + 15 = 18.
'''

import heapq

directions = [
        (-1, 0), (1, 0), (0, -1), (0, 1),  
        (-1, -1), (-1, 1), (1, -1), (1, 1) 
    ]


def find_min_path(grid, start, end, blocked_set):
    n, m = len(grid), len(grid[0])
    
    start_r, start_c = start[0] - 1, start[1] - 1
    dest_r, dest_c = end[0] - 1, end[1] - 1

    pq = [(0, start_r, start_c)]
    dist = [[float('inf')] * m for _ in range(n)]
    dist[start_r][start_c] = 0

    while pq:
        cost, i, j = heapq.heappop(pq)
        
        if (i, j) == (dest_r, dest_c):
            return cost  

        if cost > dist[i][j]:
            continue  

        curr_val = grid[i][j]

        for dx, dy in directions:
            ni, nj = i + dx, j + dy
            
            if not (0 <= ni < n and 0 <= nj < m):
                continue
            
            if (ni + 1, nj + 1) in blocked_set:
                continue 
            
            next_val = grid[ni][nj]

            max_other_neighbor = -1
            
            for dx_o, dy_o in directions:
                onr, onc = i + dx_o, j + dy_o
                
                if (onr, onc) != (ni, nj) and 0 <= onr < n and 0 <= onc < m and (onr + 1, onc + 1) not in blocked_set:
                    max_other_neighbor = max(max_other_neighbor, grid[onr][onc])

            blocking_value = max(curr_val, max_other_neighbor)
            
            required_value = blocking_value + 1
            
            add_cost = max(0, required_value - next_val)

            new_cost = cost + add_cost

            if new_cost < dist[ni][nj]:
                dist[ni][nj] = new_cost
                heapq.heappush(pq, (new_cost, ni, nj))

    return -1 

N, M = map(int, input().split())
grid = []
for _ in range(N):
    grid.append(list(map(int, input().split())))
start_r, start_c = map(int, input().split())
dest_r, dest_c = map(int, input().split())
K = int(input())
blocked = set()
for _ in range(K):
    r, c = map(int, input().split())
    blocked.add((r, c))
print(find_min_path(grid, (start_r, start_c), (dest_r, dest_c), blocked))