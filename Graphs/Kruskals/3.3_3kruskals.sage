G = Graph(weighted=True)
G.weighted = true
G.add_vertices(["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"])

G.add_edge("K", "B", 1)

G.add_edge("A", "H", 2)

G.add_edge("D", "E", 3)
G.add_edge("A", "F", 3)
G.add_edge("A", "G", 3)
G.add_edge("F", "J", 3)
G.add_edge("J", "K", 3)
G.add_edge("B", "I", 3)

G.add_edge("D", "A", 4)
G.add_edge("H", "B", 4)
G.add_edge("H", "I", 4)

G.add_edge("F", "H", 5)
G.add_edge("J", "B", 5)
G.add_edge("G", "C", 5)
G.add_edge("E", "F", 5)

G.add_edge("H", "J", 6)
G.add_edge("C", "I", 6)

G.add_edge("G", "H", 7)




print("Diameter:", G.diameter())
print("Radius:", G.radius())
print("Center:", G.center())

print("Eccentricities:")
for v in G.vertices():
    ecc = G.eccentricity(v)
    print(f"{v}: {ecc}")

G.graphplot(edge_labels=True,save_pos=True,vertex_size=100,layout='spring').show()

from sage.graphs.spanning_tree import kruskal
E=kruskal(G, check=True);E

T=Graph(E)
T.set_pos(G.get_pos())
T.graphplot(edge_labels=True).show()

mst = G.spanning_tree(algorithm='Prim')

mst.plot()