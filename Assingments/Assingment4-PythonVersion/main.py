from sys import maxsize


def getEdgeNeighbors(visited_nodes, adj_matrix):
    # Create a list of edges from each node that has been visited
    edges = []
    for i in range(0, len(adj_matrix)):
        # skip over nodes that are not in the visited list
        if not visited_nodes[i]:
            continue
        for j in range(0, len(adj_matrix)):
            weight = adj_matrix[i][j]
            if weight != 0 and not visited_nodes[j]:
                # For each edge, add its source, destination and weight
                edges.append([i, j, weight])
    return edges


def pickEdge(edges, visited_nodes):
    for i in range(0, len(visited_nodes)):
        print(visited_nodes[i])


def main():
    adj_matrix = [
        [0, 4, 0, 0, 0, 8],
        [4, 0, 7, 0, 0, 11],
        [0, 7, 0, 2, 3, 0],
        [0, 0, 2, 0, 6, 7],
        [0, 0, 3, 6, 0, 1],
        [8, 11, 0, 7, 1, 0],
    ]

    v_nodes = [False] * len(adj_matrix)

    # Set the first node to visited to start the algorithm (you can pick any arbirarty node but the first is picked for ease)
    v_nodes[0] = True

    edges = getEdgeNeighbors(v_nodes, adj_matrix)

    min_weight = maxsize
    for edge in edges:
        if edge[2] < min_weight:
            min_weight = edge[2]

    print(min_weight)


if __name__ == "__main__":
    main()
