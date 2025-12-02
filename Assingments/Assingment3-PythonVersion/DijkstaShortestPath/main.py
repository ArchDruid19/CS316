from sys import maxsize


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
        # We only consider the smallest edge of nodes that have NOT been visited yet
        if visited_nodes[i] is False:
            if distances[i] < min_dist:
                min_dist = distances[i]
                next_node = i
    print(next_node)

    return next_node


def performDikjstra(adj_w_matrix):
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
    # Skip over the first node as it is the source
    for i in range(1, len(distances)):
        print("Source -> Node %s: %s" % (i, distances[i]))


def main():
    adj_w_matrix = [
        [0, 8, 0, 0, 4],
        [0, 0, 1, 0, 2],
        [0, 0, 0, 4, 0],
        [12, 0, 6, 0, 0],
        [0, 3, 9, 2, 0],
    ]

    distances = performDikjstra(adj_w_matrix)
    printDistancesToNodes(distances)


if __name__ == "__main__":
    main()
