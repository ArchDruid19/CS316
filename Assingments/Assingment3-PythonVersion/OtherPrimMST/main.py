from sys import maxsize

def getEdgeNeighbors(visited_nodes, adj_matrix):
    edges = []
    for i in range(len(adj_matrix)):
        # Skip over nodes we are not finding edge neighbors for
        if not visited_nodes[i]:
            continue
        for j in range(len(adj_matrix)):
            # Only consider edges that have non zero weights (0 weights mean there is NO connection between nodes)
            if adj_matrix[i][j] != 0:
                # Make each edge have the source, destination and weight and add it to an edges list
                edge = [i, j, adj_matrix[i][j]]
                edges.insert(0, edge)

    return edges


def findValidEdges(edges, visited_nodes):
    valid_edges = []
    for edge in edges:
        # If the index at visited_nodes is the destination, we must skip it as we have already visited it
        # For example, if v_nodes is {True, True, False, False, False}, then we will only consider edges whos destination vertex isnt 0 or 1
        if not visited_nodes[edge[1]]:
            valid_edges.insert(0, edge)
    print(valid_edges)

    return valid_edges

def findValidEdgeWithMinimumWeight(valid_edges):
    print("Loading")
    # We start the minimum weight as the largest possible value so
    # on the first iteration we make the min_weight the first examined edge and then keep comparing from their
    min_weight = maxsize


def performPrimMST(adj_matrix):
    # Create a boolean array of nodes that have already been visited
    v_nodes = [False] * len(adj_matrix)
    v_nodes[0] = True
    v_nodes[1] = True
    edges = getEdgeNeighbors(v_nodes, adj_matrix)
    findValidEdges(edges, v_nodes)


def main():
    adj_matrix = [
        [0, 4, 0, 0, 0, 8],
        [4, 0, 7, 0, 0, 11],
        [0, 7, 0, 2, 3, 0],
        [0, 0, 2, 0, 6, 7],
        [0, 0, 3, 6, 0, 1],
        [8, 11, 0, 7, 1, 0],
    ]

    performPrimMST(adj_matrix)


if __name__ == "__main__":
    main()
