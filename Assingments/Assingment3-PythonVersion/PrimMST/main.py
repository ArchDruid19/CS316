from sys import maxsize

def getEdgeNeighbors(visited_nodes, adj_matrix):
    # Create a list of edges from each node that has been visited
    edges = []
    for i in range(0, len(adj_matrix)):
        # skip over nodes that are not in the visited list
        if not visited_nodes[i]:
            print(not visited_nodes[i])
            continue
        for j in range(0, len(adj_matrix)):
            # Get the weight from the adj matrix
            weight = adj_matrix[i][j]
            # Dont consider destination verticies that we have already been visited or edges that have a 0 weight
            if weight != 0 and not visited_nodes[j]:
                # For each edge: add its source vertex, destination vertex and weight
                edges.append([i, j, weight])
    return edges


def pickEdge(edges, visited_nodes, mst_edges):
    # Set minimum weight to be the largest possible value
    min_weight = maxsize
    # From all neighbor edges; find the edge with the smallest weight
    for edge in edges:
        if edge[2] < min_weight:
            min_weight = edge[2]
            best_edge = edge

    print(best_edge)
    visited_nodes[best_edge[1]] = True
    print(visited_nodes)
    mst_edges.append(best_edge)
    print(mst_edges)
    return best_edge

def createAdjMatrixFromMSTList(mst_list):
    # The MST list will contain V-1 edges, so we need to add 1 more row & col to get the orignal 2d matrix size
    num_of_rows = len(mst_list) + 1
    num_of_cols = len(mst_list) + 1
    empty_adj_matrix = []

    # Fill the empty matrix with 0's
    for i in range(num_of_rows):
        empty_adj_matrix.append([0] * num_of_cols)

    # Each edge in the mst follows (source, desintation, weight)
    # and becaause the adjmatrix is symmetrical, we can do
    # adjmatrix[source][desination] = weight &
    # adjmatrix[destination][source] = weight
    # for each edge in the mst list
    for edges in mst_list:
        empty_adj_matrix[edges[0]][edges[1]] = edges[2]
        empty_adj_matrix[edges[1]][edges[0]] = edges[2]
    printAdjMatrix(empty_adj_matrix)

    return empty_adj_matrix

def printAdjMatrix(adj_matrix):
    num_row = len(adj_matrix)
    num_col = len(adj_matrix)
    for i in range(num_row):
        for j in range(num_col):
            print(adj_matrix[i][j], end=" ")
        print("\n")

def main():
    adj_matrix = [
        [0, 4, 0, 0, 0, 8],
        [4, 0, 7, 0, 0, 11],
        [0, 7, 0, 2, 3, 0],
        [0, 0, 2, 0, 6, 7],
        [0, 0, 3, 6, 0, 1],
        [8, 11, 0, 7, 1, 0],
    ]

    mst_edges = []
    v_nodes = [False] * len(adj_matrix)

    # Set the first node to visited to start the algorithm (you can pick any arbirarty node but the first is picked for ease)
    v_nodes[0] = True

    while True:
        edges = getEdgeNeighbors(v_nodes, adj_matrix)
        min_weight = maxsize
        # From all neighbor edges; find the edge with the smallest weight
        for edge in edges:
            if edge[2] < min_weight:
                min_weight = edge[2]
                best_edge = edge

        print(best_edge)
        v_nodes[best_edge[1]] = True
        print(v_nodes)
        mst_edges.append(best_edge)
        print(mst_edges)
        
        # Once all nodes in the visited list have been visited we know the algorithm is done
        if all(v_nodes):
            break
    createAdjMatrixFromMSTList(mst_edges)       

if __name__ == "__main__":
    main()
