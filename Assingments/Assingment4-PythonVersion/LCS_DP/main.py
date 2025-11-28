def main():
    print("Hi")
    first_string = "jello"
    second_string = "yellow"

    performLCS(first_string, second_string)


def createLCSTable(string_a, string_b):
    # Step 1.
    # Get the string lengths to make an n+1 X m+1 table as the first
    # row and column of the lcs table will always be 0's
    a_length = len(string_a)
    b_length = len(string_b)

    # Step 2.
    # Fill the table with all 0's
    lcs_table = []
    for i in range(a_length + 1):
        lcs_table.append([0] * (b_length + 1))

    # Step 3 (most important step)
    # Iterate through the table going from top down,
    # each iteration checking if the characters at the table indicies match. If they do, we add 1
    # from the cell diagonal and to the left of the current cell being examined or
    # if they dont match, we take the larger of two values: the cell from the left or the cell on top of the current cell being examined
    for i in range(1, len(lcs_table)):
        for j in range(1, len(lcs_table[i])):
            if string_a[i - 1] == string_b[j - 1]:
                lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1]
            else:
                lcs_table[i][j] = max(lcs_table[i - 1][j], lcs_table[i][j - 1])

    printTable(lcs_table)
    return lcs_table


def backTrackLCSTable(lcs_table, string_a, string_b):
    # Step 4.
    # Backtrack through the table starting at the most bottom-right value (which is [len(string_a), len(string_b)] bcs of 0 indexing)
    row = len(string_a)
    col = len(string_b)
    lcs_result = []
    print(lcs_table[row][col])
    print(row, col)
    print(string_a[row - 1], string_b[col - 1])

    # Iterate through the table until we get to the beginning
    while row != 0 and col != 0:
        if string_a[row - 1] == string_b[col - 1]:
            # If the characters match we must go diagonally to the left
            # This is what we do when the string match in the creation of the table: if string_a[i - 1] == string_b[j - 1] then we add 1 from the cell diagonally left (line 30)
            # insert every character that matches to the front of the lcs_result list
            lcs_result.insert(0, string_a[row - 1])
            row -= 1
            col -= 1
        # If the strings dont match, we check which cell gives a larger value: either the cell to the left or the cell above the one currently being examined
        # This is what we do in line 32: when we find the larger value we know thats the direction we came from
        elif lcs_table[row - 1][col] > lcs_table[row][col - 1]:
            # The value to the left is larger: Move left
            row -= 1
        else:
            # The value above is larger: Move up
            col -= 1
    print(lcs_result)
    return lcs_result


def performLCS(string_a, string_b):
    lcs_table = createLCSTable(string_a, string_b)
    lcs_result = backTrackLCSTable(lcs_table, string_a, string_b)


def printTable(table):
    print("-" * 50)
    for i in range(len(table)):
        for j in range(len(table[i])):
            print("%-5s" % (table[i][j]), end="")
        print("\n")
    print("-" * 50)


if __name__ == "__main__":
    main()
