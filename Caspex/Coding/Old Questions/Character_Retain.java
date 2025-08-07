/*
A University named "XYZ" sends the question papers for the different  subjects to different colleges in a zipped file 
along with a secret key to access them.

The Dean appoints squad to different colleges and gives them the following cipher algorithm to be used to find out the 
password required to open the zip file:

i)Take the question paper’s name P and the secret key K (which can be positive or negative).
ii)Displace all the lowercase English alphabets present in P by K.All the uppercase alphabets, numbers, spaces, and
special characters are retained as it is.
iii)If K is positive, displace to the right and if K is negative, displace to the left.
iV)The lower limit and upper limit of the character's ASCII value generated after K displacement is 65 and 126.
V)During right displacement, if the value exceeds 126,then start again from 65. while during left displacement, if the 
value goes back from 126.

The squads perform these steps to find out the password required to open the file and take out the printouts to conduct
the examination.

write a program by reading the input from STDIN and the output from STDOUT you should not write arbitary strings while
reading the input and while printing as these contribute to the standard output.

Constraints:
-------------
i)P should not contain more than 50 characters.
iI)-50 ≤ K ≤ 50

Input Format:
-------------
The first line contains the question paper's name P.
The second line contains the secret key K.

Output Format:
--------------
The output contains a single string which is the password required to open the zip file.

Sample Input 1:
---------------
Operating Systems
-40

Sample Output 1:
----------------
OH(JwLAF) SQKL(EK

Explanation-1:
--------------
Given question paper name P is "Operating Systems" and k Value is -40


consider the the table given below:

| Character | ASCII (Before)  | ASCII (After) | Result Character | Remarks                                  |           
| --------- | --------------- | --------------|------------------|------------------------------------------|
| O         | No displacement | -             | O                | Uppercase alphabet, retained as it is    |
| p         | 112             | 72            | H                |                                          |
| e         | 101             | 61            | {                | It is below 65, so going back from 126   |
| r         | 114             | 74            | J                |                                          |
| a         | 97              | 57            | W                | It is below 65, so going back from 126   |
| t         | 116             | 76            | L                |                                          |
| i         | 105             | 65            | A                |                                          |
| n         | 110             | 70            | F                |                                          |
| g         | 103             | 63            | }                | It is below 65, so going back from 126   |
|           | No displacement | -             |                  | White space                              |
| S         | No displacement | -             | S                | Uppercase alphabet, retained as it is    |
| y         | 121             | 81            | Q                |                                          |
| s         | 115             | 75            | K                |                                          |
| t         | 116             | 76            | L                |                                          |
| e         | 101             | 61            | {                |                                          |
| m         | 109             | 69            | E                |                                          |
| s         | 115             | 75            | K                |                                          |



Sample Input 2:
--------------
X@DF*
20

Sample Output 2:
---------------
X@DF*


Explanation 2:
--------------

From the same input2, the given question paper name is "X@DF*" and the K value is 20.
Here X is an Upper case alphabet, @ is a specila character ,D, F is upper case alphabets and * is aspecial character.
so, all the characters are retained as it is.
 */
public class Character_Retain {
    
}
