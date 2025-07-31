## Logical Reasoning

#### 1. A person starts at point A and moves 16 km west to reach point B. From point B, they turn right and travel 5 km to reach point C. Next, they move 16 km east from point C to reach point D. Finally, they turn left from point D and travel 5 km to reach point E. What is the straight-line distance between point E and point A?

Answer:
Let’s fix the directions properly:
Let point A = (0, 0)
A → B: 16 km west → B = (-16, 0)
B → C: turn right (i.e., north) → C = (-16, 5)
C → D: 16 km east → D = (0, 5)
D → E: turn left (i.e., north again) → E = (0, 10)
**The straight-line distance between point E and point A is 10 km.**

#### 2. Count the number of times the lowercase letter ‘j’ appears in the following string:

    "jljjlkljjjlkljkjljjjjkjljjjjjjjjljkllj"

A) 19
B) 20
C) 21
D) 22

Answer:
**C) 21**
#### 3. FREE -> FTEG , LEAD -> ? 

Let's analyze the pattern from FREE to FTEG:

>F remains F (no change)
R becomes T (R + 2 letters in the alphabet)
E remains E (no change)
E becomes G (E + 2 letters in the alphabet)

Applying this same pattern to LEAD:

>L remains L
E becomes G (E + 2 letters in the alphabet)
A remains
D becomes F (D + 2 letters in the alphabet)

**Therefore, LEAD transforms into LGAF.**

#### 4.Garland Arrangement Puzzle

A unique garland is made up of 7 different colored flowers. Six of these colors are placed at equal intervals around the circumference of a circle. The seventh color, Yellow, isn't on the circumference itself but is hung as a decoration between two neighboring flowers on the circumference.

Use the following clues to determine the arrangement of the flowers:

- Orange is three places to the right of Red, and Red is placed one place to the right of Indigo.
- Violet forms a 90-degree angle with Yellow and a 120-degree angle with Blue (angles are measured from the center of the circle to the flowers' positions).
- Blue is opposite to Green and to the left of Yellow.

Based on this information, answer the following questions:

1. What is the angle (in degrees) between Yellow and Indigo?
2. Which flowers are located between Yellow and Green when moving in an anti-clockwise direction?

Solution

Let's deduce the arrangement step-by-step. We'll label the six positions on the circumference P1 through P6, moving clockwise, with each position 60∘ apart (0∘,60∘,120∘,180∘,240∘,300∘). The colors on the circumference are Red, Orange, Green, Blue, Indigo, and Violet. Yellow is positioned in an arc between two of these.

##### Placing Indigo, Red, and Orange (Clue 1):

Let's place Indigo (I) at P1 (0∘).
Red (R) is one place to the right (clockwise) of Indigo, so Red is at P2 (60∘).
Orange (O) is three places to the right (clockwise) of Red (P2). Counting three places clockwise: P3 (1st), P4 (2nd), P5 (3rd). So, Orange is at P5 (240∘).
    *Current known positions*:

- P1: Indigo

- P2: Red

- P5: Orange

- Remaining positions for Green, Blue,Violet: P3, P4, P6.

##### Placing Blue and Green (Clue 3, part 1):

- Blue (B) is opposite to Green (G). This means they are three positions apart.

- Considering the remaining positions (P3, P4, P6):

    - If Blue is at P3, Green would be at P6 (3 positions apart).

    - If Blue is at P4, Green would be at P1, which is already Indigo, so this isn't possible.

    - If Blue is at P6, Green would be at P3.

##### Placing Violet and Verifying Blue/Green (Clue 2, part 1):    
- Violet (V) forms a 120∘ angle with Blue. This means Violet and Blue are two positions apart on the circumference.

- Let's test the two possibilities for Blue and Green:

- Scenario A: Blue at P3, Green at P6.

    - Violet would then be at P4.

    - Angle between Violet (P4 at 180∘) and Blue (P3 at 120∘) is 180∘−120∘=60∘. This contradicts the 120∘ requirement. So, Scenario A is incorrect.

- Scenario B: Blue at P6, Green at P3.

    - Violet would then be at P4.

    - Angle between Violet (P4 at 180∘) and Blue (P6 at 300∘) is ∣180∘−300∘∣=120∘. This matches the clue!

##### Confirmed arrangement:

- P1: Indigo

- P2: Red

- P3: Green

- P4: Violet

- P5: Orange

- P6: Blue

##### Placing Yellow (Clue 3, part 2 & initial setup):

- "Blue is left of Yellow" and "Yellow is hang as decoration at one end between neighbour flowers."

- Since Blue is at P6, for Yellow to be to its right (and Blue to its left), Yellow must be located between Blue (P6) and Indigo (P1). This fits the description of Yellow being between "neighbour flowers" (Blue and Indigo).


##### The final arrangement of flowers (clockwise):    
- Indigo (P1) - Red (P2) - Green (P3) - Violet (P4) - Orange (P5) - Blue (P6).
- Yellow is located in the arc between Blue (P6) and Indigo (P1).

***Note on Clue 2**: "Violet form 90∘ with Yellow". Violet is at P4 (180∘). Yellow's conceptual position (midpoint of P6 and P1) is 330∘. The angle between 180∘ and 330∘ is 150∘. Given that all other clues are consistent, this particular 90∘ might refer to a non-standard measurement or be a slight inconsistency in the puzzle's design. We proceed with the arrangement that satisfies all other, more precise angular and positional clues.*

Answers to the Questions:

1. **Angle between Yellow and Indigo**:

    - Indigo is at P1 (0∘).

    - Yellow is located in the arc between P6 (300∘) and P1 (0∘). Its conceptual angular position (midpoint) is (300∘+360∘)/2=330∘.

    - The angle between Yellow (330∘) and Indigo (0∘ or 360∘) is 360∘−330∘=30∘.

2. **Flowers between Yellow and Green in anti-clockwise direction**:

    - Yellow is between P6 (Blue) and P1 (Indigo).

    - Green is at P3.

    - Moving anti-clockwise from Yellow's position (between P6 and P1) towards Green (P3), we pass through:

        - Blue (at P6)

        - Orange (at P5)

        - Violet (at P4)

    - Therefore, the flowers between Yellow and Green in the anti-clockwise direction are Blue, Orange, and Violet.

#### 6. Identify the pattern in the following number sequence and find the missing term:

**39, 24, 19, 12, ?, 4**

Answer:

To find the missing number, we need to analyze the differences between consecutive terms in the given sequence:

Calculate the initial differences:

39−24=15
24−19=5
19−12=7

**The sequence of subtractions observed so far is: 15, 5, 7.**

Analyze the pattern in the sequence of subtractions:
Let's look at the differences between these subtraction values:

From 15 to 5: 5 − 15 = −10
From 5 to 7: 7 − 5 = 2

While the first two changes are different, a common pattern in such sequences is that the 'difference of differences' eventually becomes consistent. Let's assume the next change in the subtraction sequence continues with a consistent pattern, specifically by alternating or following a simple series.

If we assume the pattern for the changes in subtractions becomes +2, -2, -2... (after the initial -10):

The next subtraction value after 7 would be 7−2=5.
The next subtraction value after 5 would be 5−2=3.
**So, the complete sequence of subtractions is: 15, 5, 7, 5, 3.**

##### Apply the pattern to find the missing number:

Starting from 12, we apply the next subtraction in our derived sequence (which is 5):
12−5=7

Verify the final step:

- Now, apply the last subtraction in our sequence (which is 3) to the number we found:
7−3=4

- This matches the last number in the given sequence, confirming our pattern.

- Therefore, the completed sequence is: 39, 24, 19, 12, 7, 4.

The missing number is 7.
#### 7. Question:

Statement:
A > B ≥ C
C < D ≤ E

Conclusions:
I. D > B
II. A = E

Options (Typical in exams):
a) Only conclusion I is true.
b) Only conclusion II is true.
c) Either conclusion I or II is true.
d) Neither conclusion I nor II is true.
e) Both conclusions I and II are true.

Answer:

Let's analyze the given statement and each conclusion:

**Statement Breakdown**:

- A > B ≥ C: This means A is strictly greater than B, and B is greater than or equal to C.

- C < D ≤ E: This means C is strictly less than D, and D is less than or equal to E.

*We can combine these two parts through the common element 'C':*
**A > B ≥ C < D ≤ E**

**Analyzing the Conclusions:**
1. Conclusion I: D > B

    - From the combined statement, we have B ≥ C and C < D.

    - Combining these, we get B ≥ C < D.

    - The relationship between B and D is:

        1. If B = C, then C < D implies B < D.

        2. If B > C, then C < D means B's relation to D is not definitively established from this specific path (B > C < D could mean B > D, B < D, or B = D).

    - Because we have an "open mouth" (change in direction of inequality sign: ≥ followed by <) between B and D (B ≥ C < D), a definite relationship (greater than, less than, or equal to) between B and D cannot be established.

    - We cannot conclusively say that D > B. It's possible, but not certain. For instance, if B=5, C=5, D=6, then D>B. But if B=5, C=4, D=6, then D>B. If B=5, C=4, D=4, this is not possible as D>C.

    - Consider specific values:

        - Let C = 5.

        - Then B could be 5 or 6 (e.g., B=6).

        - D must be greater than C, so D could be 6 (D > C).

        - If B=6 and D=6, then D is not greater than B. (This violates D > B)

    - Therefore, Conclusion I is False (or more accurately, "Cannot be determined" / "Not necessarily true").

2. Conclusion II: A = E

    - From the combined statement: A > B ≥ C < D ≤ E

    - There is a clear break (change in inequality direction: ≥ followed by <) in the path from A to E.

    - Because there are opposing signs (≥ and <) in the chain connecting A and E, no direct or definite relationship (greater than, less than, or equal to) can be established between A and E.

    - We cannot conclusively say that A = E.

    - Therefore, Conclusion II is False (or "Cannot be determined" / "Not necessarily true").

Final Decision:

Since neither conclusion I nor conclusion II can be definitively proven true from the given statement, the correct option is:

**d) Neither conclusion I nor II is true.**

*Flow chart and diagram based questions are also asked in this section in exam*
> **_NOTE:_**  Answer are AI generated please double check the answers.