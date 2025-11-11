import networkx as nx


def printEdges(edges):
    for u, v, data in edges.edges(data=True):
        print(u, "->", v, data, end="\n")

def readEdgesFromFile(file_name):
    print("Loading file")
    

def getEdges(algorithm_type):
    G = nx.Graph()

    G.add_weighted_edges_from(
        [
            (1, 6, 10),
            (1, 2, 28),
            (6, 5, 25),
            (2, 3, 16),
            (2, 7, 14),
            (5, 7, 24),
            (5, 4, 22),
            (3, 4, 12),
            (4, 7, 18),
        ]
    )

    T = nx.minimum_spanning_tree(G, algorithm=algorithm_type)

    printEdges(T)

    return T


def main():
    edges = getEdges("prim")


if __name__ == "__main__":
    main()
