'''Layout Wrap
Problem Description
In the town of Origamia, people do not use ordinary rectangular sheets to wrap gifts. Instead, they use wrapping sheets that come in a variety of unique shapes and layouts.

Origamia's gift sheets feature unique rectilinear cuts, such as cross or T-shapes, unlike standard wrapping paper. These layouts are carefully crafted so that, with the right sequence of folds, they can transform into beautiful, closed gift boxes.

Folding is allowed along the lines which ever passing on the sheet, and each fold must be a precise 90-degree bend, either upwards (a mountain fold) or downwards (a valley fold). If a fold brings two sheet edges together seamlessly, they are airtight and bonded with no gaps.

The challenge is to determine whether a given sheet layout, with its specific edges, can be folded into a perfectly closed 3D gift box. Some layouts fold into fully closed boxes, while others always leave open flaps or sides.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@3ad394e6:image1.png

Constraints
4 <= N <= 25

0 <= x, y <= 25

Input
The first line contains N, the total number of line segments provided.

The next N lines each contain four integers separated by spaces, representing the endpoints of a line segment as x1 y1 x2 y2.

Output
Print a single integer:

The volume of the box when a closed shape is formed.
Otherwise, print 0.
Time Limit (secs)
1

Examples
Example 1

Input

12

1 0 2 0

2 0 2 5

1 0 1 5

1 5 2 5

0 2 3 2

3 2 3 4

3 4 0 4

0 2 0 4

3 4 4 4

4 4 4 3

4 3 3 3

1 1 2 1

Output

2

Explanation

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@3ad394e6:image2.png

The input when processed forms a shape as depicted in the diagram.

It folds into a 1x1x2 cuboid. Hence the volume is 2 and output is 2.

Example 2

Input

13

0 0 2 0

2 0 2 1

2 1 0 1

0 1 0 0

2 4 3 4

3 4 3 1

3 1 2 1

2 1 2 4

2 0 3 0

3 0 3 1

1 1 1 0

2 2 3 2

2 3 3 3

Output

0

Explanation

The image below depicts input.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@3ad394e6:image3.png

The input when processed forms a shape as depicted in the diagram.

Folding this sheet results in a cube-like shape with one side left open.

Therefore, it is unable to form a closed figure, resulting in an output of 0.'''