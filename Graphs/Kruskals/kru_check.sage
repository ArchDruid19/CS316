G = Graph()
G.weighted = true
G.add_vertices([1, 2, 3, 4, 5, 6])

G.add_edge(1, 6, 10)
G.add_edge(1, 2, 28)

G.add_edge(6, 5, 25)

G.add_edge(2, 3, 16)
G.add_edge(2, 7, 14)

G.add_edge(5, 7, 24)
G.add_edge(5, 4, 22)

G.add_edge(3, 4, 12)

G.add_edge(4, 7, 18)




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
T.graphplot(edge_labels=True,layout='circular').show()
