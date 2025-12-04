from sys import maxsize


def readAdjMatrixFromFile(file_path):
    adj_matrix = []
    try:
        # Open the file and loop through it, splitting each line and putting it into an array
        with open(file_path) as f:
            for items in f:
                # Split the items which gives an array of strings
                string_row = items.split()
                num_row = []
                # Iterate through the string array and covert each entry into an integer
                for num in string_row:
                    string_to_num = int(num)
                    # append the converted string to a temporary array
                    num_row.append(string_to_num)
                # append the temporary array to the adjaceny matrix
                adj_matrix.append(num_row)
    # If the file cannot be found, print an error messege
    except FileNotFoundError:
        print("File could not be located (check if the file path is correct)")

    return adj_matrix


def getEdgeNeighbors(visited_nodes, adj_matrix):
    edges = []
    for i in range(len(adj_matrix)):
        # Skip over nodes we are not finding edge neighbors for
        if visited_nodes[i] is False:
            continue
        for j in range(len(adj_matrix)):
            # Only consider edges that have non zero weights (0 weights mean there is NO connection between nodes)
            if adj_matrix[i][j] != 0:
                # Make each edge have the source, destination and weight and add it to an edges list
                edge = [i, j, adj_matrix[i][j]]
                # Insert the edge into an edge list
                edges.insert(0, edge)

    return edges


def findValidEdges(visited_nodes, edges):
    valid_edges = []
    for edge in edges:
        # If the index at visited_nodes is the destination, we must skip it as we have already visited it
        # For example, if v_nodes is {True, True, False, False, False}, then we will only consider edges whos destination vertex isnt 0 or 1
        if visited_nodes[edge[1]] is False:
            valid_edges.insert(0, edge)
    # print(valid_edges)
    return valid_edges


def findValidEdgeWithMinimumWeight(valid_edges):
    # We start the minimum weight as a very large value
    # on the first iteration we make the min_weight the first examined edge (under the implication that it cant have a weight greater than maxsize)
    # and then keep comparing from there
    min_weight = maxsize
    best_edge = []
    for edges in valid_edges:
        # index 2 will always be the weight from a source to a destination
        if edges[2] < min_weight:
            min_weight = edges[2]
            best_edge = edges
    # print(best_edge)
    return best_edge


def createPrimAdjMatrix(mst_list, original_adj_matrix_size):
    prim_adj_matrix = []

    # We will pass through the length of the original adj matrix in order to create a new matrix that holds the mst
    # First, we will create the n x n matrix and fill it all with 0's
    for i in range(original_adj_matrix_size):
        prim_adj_matrix.append([0] * original_adj_matrix_size)

    # For each edge in the mst list, we will set prim_adj_matrix[source][destination] to be the weight of the edge along with
    # prim_adj_matrix[destination][source] as it is an undirected graph (meaning the matrix is symmetric)
    for edges in mst_list:
        prim_adj_matrix[edges[0]][edges[1]] = edges[2]
        prim_adj_matrix[edges[1]][edges[0]] = edges[2]

    return prim_adj_matrix


def findTotalMSTWeight(mst_edge_list):
    # Simply add up all of the weights in the mst list
    total_weight = 0
    for edges in mst_edge_list:
        total_weight += edges[2]
    return total_weight


def printMatrix(matrix):
    # Check to make sure the matrix actually exists before attempting to print it
    if matrix is None:
        return
    
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            print("%-5s" % (matrix[i][j]), end=" ")
        print()
    print()


def performPrimMST(adj_matrix):

    if len(adj_matrix) <= 0:
        print("ERROR: Matrix is empty")
        return
    elif len(adj_matrix) > 10:
        print("ERROR: Too many nodes have been used (maximum is 10)")
        return

    # Create a boolean array of nodes that have already been visited
    v_nodes = [False] * len(adj_matrix)

    # Mark the first node as true (visited) so we can start the algorithm.
    # It is possible to start from ANY node, but for simplicity we will always start at the first node
    v_nodes[0] = True

    # Create an edge list of the mst where each edge is [source, destination, weight]
    # This will be later used to create the mst adjaceny matrix and find the total weight of the tree
    mst_edge_list = []

    while True:
        # Once all nodes have been visited (all entries in v_nodes are True), break out of the while loop
        if all(v_nodes):
            break
        # Get all edge neighbors of nodes we have visited
        edges = getEdgeNeighbors(v_nodes, adj_matrix)

        # Take only the edges whos destination is not in the visited array
        valid_edges = findValidEdges(v_nodes, edges)

        # Find the valid edge with the smallest weight
        edge_with_min_weight = findValidEdgeWithMinimumWeight(valid_edges)

        # Add the best edge to the mst edge list
        mst_edge_list.append(edge_with_min_weight)

        # Mark the destination vertex of the best edge as visited
        v_nodes[edge_with_min_weight[1]] = True

    # Create an adjaceny matrix from the results of the MST
    mst_adj_matrix = createPrimAdjMatrix(mst_edge_list, len(adj_matrix))

    # Find the total weight of the MST
    total_mst_weight = findTotalMSTWeight(mst_edge_list)
    print("The total weight of the MST is: %s" % (total_mst_weight))

    return mst_adj_matrix


def main():
    # Read an adjaceny matrix from a file
    adj_matrix = readAdjMatrixFromFile("PrimMST/matrices/adj_matrix.txt")

    # Get the MST as an adjaceny matrix
    adj_matrix_mst = performPrimMST(adj_matrix)
    
    printMatrix(adj_matrix_mst)


if __name__ == "__main__":
    main()
