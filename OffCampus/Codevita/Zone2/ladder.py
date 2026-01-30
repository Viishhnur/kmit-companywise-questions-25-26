''' Ladder Problem
Problem Description
Shyam is tasked with relocating a lengthy ladder within his residence. The substantial presence of various household items throughout the house presents significant challenges when attempting to manoeuvre the ladder through confined areas.

The house is represented as a grid of M rows and N columns. Each cell in the grid can contain:

'l' - part of the current position of the ladder (source).
'L' - part of the destination where the ladder needs to go.
'B' - a household item (Block).
'E' - an empty cell where the ladder can move.
The ladder has a fixed length and is placed either horizontally or vertically in the grid. It must always remain in a straight line unless it is being rotated.

Movement Rules
The ladder can be moved one cell at a time in any of the four directions (up/down/left/right), maintaining its orientation.
The ladder can be rotated by 90 degrees (from horizontal to vertical or vice versa) only if all cells in the square area formed by both the current and rotated positions are empty (no B or walls).
Each move or rotation counts as 1 step.
Goal is to find the minimum number of steps required to move the ladder from the source ('l') to the destination ('L').
If it is not possible, print "Impossible".

Constraints
0 <= M, N <= 15

2 <= Length of ladder <= 6

Input
First line: Two integers M and N, the dimensions of the grid.

Next M lines: N space-separated characters representing the grid ('l', 'L', 'B', or 'E').

Output
A single integer representing the minimum number of steps, or the string "Impossible".

Time Limit (secs)
1

Examples
Example 1

Input

5 5
llEEE
EBEEB
EBEBB
EBEEB
EEELL

Output

8

Explanation

The input is diagrammatically represented as depicted below.

The sequence of diagrams shows the movement of ladder to the required place.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@3b0f7d9d:image1.png

After two moves, the ladder occupies a 2x2 area of free cells, allowing it to be rotated. Following this process, the ladder has been moved to its destination in 8 steps, which represents the minimum required.

Example 2

Input

6 6
lllEEE
EBEEEE
EEEEEE
EEEEBE
EEEEEE
LLLEBE

Output

7

Explanation

Below diagrams shows the movement of ladder to the required place.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@3b0f7d9d:image2.png

As you can see that 7 steps are required to move the ladder to its destination.'''
