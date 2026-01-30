'''
lets move onto next one:

Make Hands
Problem Description
Vaishnavi and Suraj, two close friends, have invented a fun two-player card game using a standard 52-card deck. The gameplay revolves around smart moves, winning hands, and strategically rearranging cards.

Game Setup:

A standard 52-card deck is used, consisting of 13 cards from each of the 4 suits:
Spades (1), Hearts (2), Clubs (3), Diamonds (4).

Initially, the deck is shuffled and divided between the two players. (The players will have same number of cards with them, although it is not guaranteed that they will have 26 cards each).
Each player rearranges their shuffled cards before the game starts based on the card arrangement rules described below.
A custom priority order for suits is provided. The suit number written first have higher priority as compared to that written at last. E.g., If the priority order is - "2, 1, 3, 4" - This means Hearts (2) have highest priority and Diamonds (4) have lowest priority.
Card Values:

'A' represents 1.

'J' represents 11.

'Q' represents 12.

'K' represents 13.

Remaining numeric values are same as that on the cards.

Gameplay Rules:

Vaishnavi plays first.
On each turn, the player removes the top card from their deck and places it on the central stack, called as hand.
From the second turn onwards:
The newly drawn card is compared with the top card of the hand.
The new card wins if it has same value with higher priority.
If the new card wins:
The player claims the entire hand.
The hand is rearranged based on rearrangement rules (described below).
The rearranged hand is then added to the bottom of the winner's deck.
The winning player takes the next turn.
If the new card does not win, it is simply placed on the top of the hand and play continues with the other player.
Card Rearrangement Rule:

Whenever a player wins the hand, they must rearrange the stack before adding it to their deck (this will also be done at the start):

Cards are primarily sorted by non-decreasing card value.
If multiple cards have the same value, they are sorted among themselves by suit priority (lower priority suit comes first).
Game End Situation:

The game continues until one of the players runs out of cards.
The player who still has cards left is declared the winner.
If both the players run out of cards at the same time, the result is TIE.
Your Task:

Given the starting deck of both players and suit priority, determine whether Vaishnavi wins the game or not if both players play optimally.

Note: There will be no such case where the game is stuck in a never-ending loop. The game will always have end.

Constraints
5 <= N <= 26

C1, C2 € (A, J, Q, K, 2 .. 10)

S1, S2 € (1, 2, 3, 4)

Input
The first line has an integer N, indicating the number of cards in each player's deck.

Lines 2 to N+1 each have four integers: C1, S1, C2, and S2, separated by spaces, where

C1 is the value for the card which is distributed to player 1
S1 is the suit number for the card which is distributed to player 1
C2 is the value for the card which is distributed to player 2
S2 is the suit number for the card which is distributed to player 2
Line N+2 lists four integers that set suit priorities from highest to lowest.

Output
{WINNER, LOSER, TIE}

Time Limit (secs)
1

Examples
Example 1

Input

5

K 2 Q 4

A 4 4 1

2 2 Q 1

4 2 3 1

6 1 5 2

1 2 3 4

Output

TIE

Explanation

Vaishnavi (Player 1) and Suraj (Player 2) have the following cards when arranged -

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6e4ea0bd:image1.png

Here, when players play optimally starting with Vaishnavi, 
there is one situation where the cards need to be checked. 
This is when the hand contains 4 of Spades. When Vaishnavi's turn, she draws 4 of Hearts but cannot win the hand since Hearts have less priority as compared to Spades. Till the end, no one of two wins the hand and remains with zero cards in their respective decks. Hence the answer - "TIE".
Example 2

Input

5

K 2 Q 4

A 4 4 1

2 2 Q 1

4 2 3 1

5 1 5 2

3 2 1 4

Output

WINNER

Explanation

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6e4ea0bd:image2.png

Here, there will be one situation when the hand will contain 4 of Spades and Vaishnavi will draw 4 of Hearts. Here, Hearts have greater priority as compared to Spades, hence, the hand belongs to Vaishnavi, and she will now have 7 cards in here deck. Next, when Vaishnavi's turn, she draws 5 of Spades whereas Suraj draws 5 of Hearts. This hand will be claimed by Suraj for the greater priority of Hearts than Spades and thus, Suraj will have 4 cards with him. When the game continues, there will be no situation where either of both can win and eventually they will lose their cards. At last, when Suraj loses his all cards, Vaishnavi will have 2 with her. Hence she will be the "WINNER".

Example 3

Input

5

K 2 Q 4

A 4 4 1

6 2 Q 1

4 2 3 1

5 1 5 2

2 4 3 1

Output

LOSER

Explanation

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6e4ea0bd:image3.png

Here, there comes one situation where cards will be checked. 
This is when the hand contains 4 of Hearts and Suraj draws 4 of Spades. 
But because of the priorities, Suraj cannot claim the hand and the game continues. 
Next situation will contain 5 of Spades at the top of the hand and Suraj draws 5 of Hearts. 
Here, Suraj claims the hand and the hand will be added to his deck. 
At last, Vaishnavi runs out of her cards and Suraj will have some with him. 
This situation leads Vaishnavi to lose and hence the answer - "LOSER".
'''
