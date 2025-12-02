from sys import maxsize


def readAdjMatrixFromFile(file_path):
    adj_matrix = []
    # Open the file and loop through it, splitting each line and putting it into an array
    with open(file_path) as f:
        for items in f:
            # Split the items which gives an array of strings
            string_row = items.split()
            num_row = []
            # Iterate through the string and covert each entry into an integer
            for num in string_row:
                string_to_num = int(num)
                # append the converted string to a temporary array
                num_row.append(string_to_num)
            # append the temporary array to the adjaceny matrix
            adj_matrix.append(num_row)

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


def updateDistances(distance_arr, edge_neighbors):
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


def performDikjstra(adj_w_matrix):

    if len(adj_w_matrix) > 9:
        print("The maximum number of nodes that can be inputted is 9")
        return

    # Create a distance array of 'infinity' values where each index correspondes to a node in the graph
    distances = [maxsize] * len(adj_w_matrix)
    # Create a boolean array of visited nodes
    visited_nodes = [False] * len(adj_w_matrix)

    # Set the source node to be visited
    visited_nodes[0] = True

    # Set the source node to have 0 weight
    distances[0] = 0

    while True:
        # Break out of the loop once all nodes have been visited
        if all(visited_nodes):
            break
        # Create a list of ALL edges to other nodes that we have visited
        edges = getEdgeNeighbors(visited_nodes, adj_w_matrix)

        # Update (relax) distances from the list of edges
        updateDistances(distances, edges)

        print(distances)
        print(edges)

        # Find the smallest node that hasnt been visited
        next_node = pickSmallestEdgeDestination(visited_nodes, distances)

        # Mark that smallest node as visited
        visited_nodes[next_node] = True

    # Once the loop is complete the distance array will hold the smallest weights to each node from the source

    return distances


def printDistancesToNodes(distances):
    # If the number of nodes is greater than 9 the distance array will be None so we must check if it has values or else
    # the program has a runtime error
    if distances is None:
        return

    # Skip over the first node as it is the source
    for i in range(1, len(distances)):
        # We can map alphabetical letters to each node by using chr(ascii_value), so we start at 65 which is 'A'
        # and after each print statment add 1 more to get sequential alphabetical letters
        print("Source -> Node %s (%s): %s" % (i, chr(64 + i), distances[i]))


def main():
    adj_w_matrix = [
        [0, 8, 0, 0, 4],
        [0, 0, 1, 0, 2],
        [0, 0, 0, 4, 0],
        [12, 0, 6, 0, 0],
        [0, 3, 9, 2, 0],
    ]

    # adj_w_matrix = [
    #     [0, 2, 3, 3, 0, 0, 0],
    #     [2, 0, 4, 0, 3, 0, 0],
    #     [3, 4, 0, 5, 1, 6, 0],
    #     [3, 0, 5, 0, 0, 7, 0],
    #     [0, 3, 1, 0, 0, 8, 0],
    #     [0, 0, 6, 7, 8, 0, 9],
    #     [0, 0, 0, 0, 0, 9, 0]
    # ]

    # adj_w_matrix = [
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    #     [0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    # ]

    distances = performDikjstra(adj_w_matrix)
    printDistancesToNodes(distances)


if __name__ == "__main__":
    main()
