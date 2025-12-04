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
        # Skip over nodes we are not finding edge neighbors for as they have already been visited
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


def relaxVerticies(distance_arr, edge_neighbors):
    for edges in edge_neighbors:
        if distance_arr[edges[0]] + edges[2] < distance_arr[edges[1]]:
            # Update the new distance as the distance from source + distance of the edge as long as the new weight is smaller
            distance_arr[edges[1]] = distance_arr[edges[0]] + edges[2]


def pickSmallestEdgeDestination(visited_nodes, distances):
    min_dist = maxsize
    next_node = -1
    # Find the smallest weight to get the next node to place in the visited list
    for i in range(len(distances)):
        # We only consider the smallest edge of nodes that have NOT been visited yet so we dont create cycles
        # in practice, we would use a modififed version of the Union Find (Disjoint Set Union) data structure to do
        # this MUCH more efficently (Data Structures and Algorithms pg. 415)
        if visited_nodes[i] is False:
            if distances[i] < min_dist:
                min_dist = distances[i]
                next_node = i
    print(next_node)

    return next_node


def performDikjstra(adj_w_matrix, source_node):

    matrix_length = len(adj_w_matrix)

    # Determine if the matrix is valid by checking if the length is (0 <= length(matrix) <= 9)
    if matrix_length > 9:
        print("ERROR: Too many nodes have been added (maximum is 9)")
        return
    elif matrix_length <= 0:
        print("ERROR: The matrix is empty")
        return
    
    # Determin if the source node is valid by checking if it is (0 <= source_node <= len(adj_matrix) - 1)
    if source_node < 0 or source_node > len(adj_w_matrix) - 1:
        print("ERROR: invalid source node")
        return

    # Create a distance array of 'infinity' values where each index correspondes to a node in the graph
    distances = [maxsize] * matrix_length

    # Create a boolean array of visited nodes
    visited_nodes = [False] * matrix_length

    # Set the source node to be visited
    visited_nodes[source_node] = True

    # Set the source node to have 0 weight
    distances[source_node] = 0

    while True:
        # Break out of the loop once all nodes have been visited
        if all(visited_nodes):
            break

        # Create a list of ALL edges to other nodes that we have visited
        edges = getEdgeNeighbors(visited_nodes, adj_w_matrix)

        # Rrelax verticies from the list of edges
        relaxVerticies(distances, edges)

        print(distances)
        print(edges)

        # Find the next smallest node that hasnt been visited
        next_node = pickSmallestEdgeDestination(visited_nodes, distances)

        # Mark that smallest node as visited
        visited_nodes[next_node] = True

    # Once the loop is complete the distance array will hold the smallest weights to each node from the source

    return distances


def printDistancesToNodes(distances, source_node):
    # If the number of nodes is greater than 9 the distance array will be None so we must check if it has values or else
    # the program has a runtime error
    if distances is None:
        return

    # Print each distance from the source to all other nodes
    for i in range(0, len(distances)):
        print("Source (%s) -> Node %s : %s" % (source_node, i, distances[i]))


def main():
    # Set a source node to start the 
    source_node = 0
    adj_matrix = readAdjMatrixFromFile("DijkstraShortestPath/matrices/adj_matrix_2.txt")
    distances = performDikjstra(adj_matrix, source_node)
    printDistancesToNodes(distances, source_node)


if __name__ == "__main__":
    main()
