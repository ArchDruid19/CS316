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
            # Update the new distance as the original distance + the distance of the edge
            distance_arr[edges[1]] = distance_arr[edges[0]] + edges[2]



def main():
    adj_w_matrix = [
        [0, 8, 0, 0, 4],
        [0, 0, 1, 0, 2],
        [0, 0, 0, 4, 0],
        [12, 0, 6, 0, 0],
        [0, 3, 9, 2, 0],
    ]

    # Set all distances to 'infinity' (which is just a VERY large number provided by maxsize)
    distances = [maxsize] * len(adj_w_matrix)
    visited_nodes = [False] * len(adj_w_matrix)

    # Set the source node to be visited
    visited_nodes[0] = True

    # Set the source node to have 0 weight
    distances[0] = 0

    edges = getEdgeNeighbors(visited_nodes, adj_w_matrix)

    updateDistances(distances, edges)

    print(distances)

    print(edges)

    visited_nodes[4] = True

    other_test = getEdgeNeighbors(visited_nodes, adj_w_matrix)

    updateDistances(distances, other_test)

    print(distances)

    print(other_test)


if __name__ == "__main__":
    main()
