edges=[
    ("A", "B", 2), ("A", "D", 3), ("A", "C", 3),
    ("B", "C", 4), ("B", "E", 3),
    ("C", "D", 5), ("C", "E", 1), ("C", "F", 6),
    ("E", "F", 8),
    ("D", "F", 7),
    ("F", "G", 9)
    ]
G=Graph(edges)
G.weighted(True)
G.graphplot(edge_labels=True,save_pos=True,vertex_size=100,layout='circular').show()

from sage.graphs.spanning_tree import kruskal
E=kruskal(G, check=True);E

T=Graph(E)
T.set_pos(G.get_pos())
T.graphplot(edge_labels=True).show()
