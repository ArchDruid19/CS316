def createLCSTable(string_a, string_b):
    # Step 1 - Get the string lengths to make an (n+1 X m+1) table
    # The first row and column of the lcs table will always be 0's
    a_length = len(string_a)
    b_length = len(string_b)

    # Step 2.
    # Fill the table with all 0's
    lcs_table = []
    for i in range(a_length + 1):
        lcs_table.append([0] * (b_length + 1))

    # Step 3 - Fill the LCS Table (most important step)
    # Iterate through the table starting at idx=[1, 1] (as the first row and col will always be 0's),
    # each iteration we check if the characters match. If they do, we add 1
    # from the cell diagonal and to the left of the current cell being examined or
    # if they dont match, we take the larger of two values: the cell from the left or the cell on above the current cell being examined
    for i in range(1, len(lcs_table)):
        for j in range(1, len(lcs_table[i])):
            if string_a[i - 1] == string_b[j - 1]:
                lcs_table[i][j] = 1 + lcs_table[i - 1][j - 1]
            else:
                lcs_table[i][j] = max(lcs_table[i - 1][j], lcs_table[i][j - 1])

    return lcs_table


def backTrackLCSTableHelper(lcs_table, string_a, string_b, row, col, lcs_result):
    # Step 4 - Backtrack through the table starting at the most bottom-right value
    # When either the row or column of the table is 0, we know we are done backtracking
    if row == 0 or col == 0:
        return

    # If the characters match, we move diagonally left
    # This is the opposite movement of what happends when we construct the table; if they match we must go backwards diagonally
    if string_a[row - 1] == string_b[col - 1]:
        # Insert the matching character into an array of strings
        # We must add each new character to the front of the array (like a stack) or else the string will be reversed at the end
        lcs_result.insert(0, string_a[row - 1])

        # Call the function again, this time moving diagonally left
        backTrackLCSTableHelper(
            lcs_table, string_a, string_b, row - 1, col - 1, lcs_result
        )
    elif lcs_table[row - 1][col] > lcs_table[row][col - 1]:
        # If the cell to the left of the one currently being examined is less than the cell directly above the one being examined
        # we move left
        backTrackLCSTableHelper(lcs_table, string_a, string_b, row - 1, col, lcs_result)
    else:
        # If the cell directly above is larger, we move up
        backTrackLCSTableHelper(lcs_table, string_a, string_b, row, col - 1, lcs_result)


def backTrackLCSTable(lcs_table, string_a, string_b):
    # Step 5 - Create an empty array that will contain the characters in the LCS
    lcs_result = []
    # Fill the array with the characters in the LCS
    backTrackLCSTableHelper(
        lcs_table, string_a, string_b, len(string_a), len(string_b), lcs_result
    )

    # Join the characters in the array and return it as 1 string
    return "".join(lcs_result)


def performLCS(string_a, string_b):
    lcs_table = createLCSTable(string_a, string_b)

    lcs_result = backTrackLCSTable(lcs_table, string_a, string_b)
    # printTable(lcs_table)
    return lcs_result


def printTable(table):
    # Print the table for visual and debugging purposes
    print("-" * (len(table) * 3))
    for i in range(len(table)):
        for j in range(len(table[i])):
            print("%-5s" % (table[i][j]), end="")
        print("\n")
    print("-" * (len(table) * 3))


def printLCSString(string_a, string_b, lcs_string):
    print("The LCS of '%s' and '%s' is: %s" % (string_a, string_b, lcs_string))


def main():
    first_string = input("Please enter the first string: ")
    second_string = input("Please enter the second string: ")
    lcs_string = performLCS(first_string, second_string)

    printLCSString(first_string, second_string, lcs_string)


if __name__ == "__main__":
    main()
