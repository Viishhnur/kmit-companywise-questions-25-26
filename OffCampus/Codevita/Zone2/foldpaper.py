''' 
Folded Sheet
Problem Description
Codesheeta is a renowned manufacturer of bed sheets. Will the branding team play a role in supporting an environment with reduced pollution?

All sheets produced by codesheeta will feature the company's branding logo in multiple locations. As a result, regardless of how the sheet is folded, the logo will remain visible at both the top and bottom.

As part of Codesheeta' s initiative to promote a low-pollution environment, the branding team has opted to determine the optimal method for folding the sheet. Their goal is to identify precise locations for logo placement so that, upon folding, the logo appears on both the top and bottom surfaces, thereby minimizing unnecessary duplication and reducing excess printing.

A sheet is described as consisting of rows and columns with unit-sized cells. Each cell is numbered,starting from top left, going rightwards on each row. Horizontal lines separating the rows are referred to as h1, h2, ..., hn from top to bottom, while vertical lines separating the columns are designated as v1, v2, ..., vn from right to left. The sheet may be folded along either the vertical or horizontal lines. It is important to note that these folding lines are relative rather than absolute, meaning their order may change following a fold. During a vertical fold, the right section of the sheet is placed over the left, whereas a horizontal fold involves moving the bottom section over the top.

The following images illustrate a complete sheet and demonstrate its folding along various lines.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6c451c9c:image1.png

A detailed folding instruction will be provided outlining the process used to fold and package the bed sheet.

Based on the dimensions and folding guidelines of the sheet, identify the specific cells designated for logo placement.

Constraints
3<= R, C <= 25

Input
The first line contains two integers, R and C, for the bed sheet's rows and columns.

Next line consists of instruction sequence to be applied sequentially, as explained above. Refer examples section for better understanding.

Output
Print two integers, representing the Top and bottom cells where logo needs to be printed.

Time Limit (secs)
1

Examples
Example 1

Input

4 4

v2 h3 v1 h2 h1

Output

5 1

Explanation

The full sheet will be depicted as below.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6c451c9c:image2.png

Applying the folding instructions.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6c451c9c:image3.png

From above we can see that cells 5 are at top and 1 at bottom. Printing logo on them is enough. So, the output 5 1

Example 2

Input

4 2
h1 v1 h2 h1

Output

5 7

Explanation

Below image depicts the sheet and the folding instruction applied.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6c451c9c:image4.png

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@6c451c9c:image5.png

The images above indicate that cells 5 and 7 will be positioned at the top and bottom, respectively; therefore, the output will be 5 7.

4 4
v1 h3 v2 v1 h2 h1
'''


R, C = map(int, input().split())
instructions = input().split()
sheet = []
count = 1
for i in range(R):
    row = []
    for j in range(C):
        row.append([count])   # each cell is a list: [top, ..., bottom]
        count += 1
    sheet.append(row)

for inst in instructions:
    typ = inst[0]
    idx = int(inst[1:])

    if typ == 'v':  # right over left
        left = [row[:idx] for row in sheet]
        right = [row[idx:] for row in sheet]

        # flip right half horizontally (columns mirror)
        for r in right:
            r.reverse()

        # print("  Left:")
        # for row in left:
        #     print("   ", row)
        # print("  Right:")
        # for row in right:
        #     print("   ", row)

        
        new_left = []
        for i in range(len(sheet)):
            new_row = left[i].copy() 
            for j in range(len(right[0])):
                target_col = idx - j - 1
                right_cell = right[i][j]
                rotated = right_cell[::-1]
                if target_col >= 0:
                    
                    new_row[target_col] = rotated + new_row[target_col]
                else:
                    
                    new_row.insert(0, rotated)
            new_left.append(new_row)
        sheet = new_left

    elif typ == 'h': 
        top = sheet[:idx]
        bottom = sheet[idx:]

        # flip bottom vertically (rows mirror)
        bottom.reverse()

        # print("  Top:")
        # for row in top:
        #     print("   ", row)
        # print("  Bottom:")
        # for row in bottom:
        #     print("   ", row)

        # merge bottom onto top, handling extra rows in bottom
        new_top = []
        
        for i in range(len(bottom)):
            target_row = idx - i - 1
            bottom_row = bottom[i]
            if target_row >= 0:
                # merge each cell in that row
                merged_row = []
                for j in range(len(bottom_row)):
                    rotated_cell = bottom_row[j][::-1]  # rotate cell stack
                    merged_row.append(rotated_cell + top[target_row][j])
              
     
        final_rows = max(len(top), len(bottom))
        result_rows = []
        for r_index in range(final_rows):
           
            top_row_idx = r_index - (final_rows - len(top))
            
            bottom_row_idx = r_index - (final_rows - len(bottom))
            
            cols = len(sheet[0]) if sheet else (len(top[0]) if top else len(bottom[0]))
            row_cells = []
            for c in range(cols):
                top_cell = None
                bottom_cell = None
                if 0 <= top_row_idx < len(top):
                    top_cell = top[top_row_idx][c]
                if 0 <= bottom_row_idx < len(bottom):
                    
                    bottom_cell = bottom[bottom_row_idx][c][::-1]  
                if bottom_cell is not None and top_cell is not None:
                    row_cells.append(bottom_cell + top_cell)
                elif bottom_cell is not None:
                    row_cells.append(bottom_cell)
                else:
                    row_cells.append(top_cell)
            result_rows.append(row_cells)
        sheet = result_rows

    # print(f"    After folding {inst}:")
    # for row in sheet:
    #     print("        ", row)
    # print("-----")

# After all folds, final sheet should be 1x1
final_stack = sheet[0][0]
top_cell = final_stack[0]
bottom_cell = final_stack[-1]
print(top_cell, bottom_cell)
