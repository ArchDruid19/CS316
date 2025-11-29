from sys import maxsize


def getNeighborNodes(node, adj_matrix):
    edges = []
    for i in range(len(adj_matrix)):
        if adj_matrix[node][i] != 0:
            edge = [node, i, adj_matrix[node][i]]
            edges.insert(0, edge)
    print(edges)
    return edges

def pickSmallestEdgeWeight(edges):
    min_weight = maxsize
    best_edge = []
    for edge in edges:
        if edge[2] < min_weight:
            min_weight = edge[2]
            best_edge = edge
    return best_edge[1]

def main():
    print("Loading")
    adj_w_matrix = [
        [0, 8, 0, 0, 4],
        [0, 0, 1, 0, 2],
        [0, 0, 0, 4, 0],
        [12, 0, 6, 0, 0],
        [0, 3, 9, 2, 0],
    ]

    distances = [maxsize] * len(adj_w_matrix)
    visited_nodes = [False] * len(adj_w_matrix)

    visited_nodes[0] = True
    distances[0] = 0

    edges = getNeighborNodes(0, adj_w_matrix)

    x = pickSmallestEdgeWeight(edges)
    print(x)


if __name__ == "__main__":
    main()
