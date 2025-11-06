G = Graph()
G.weighted = true
G.add_vertices([1, 2, 3, 4, 5, 6])

G.add_edge(7,0,1)
G.add_edge(0,3,1)
G.add_edge(4,6,1)

G.add_edge(2,1,2)
G.add_edge(1,4,2)

G.add_edge(7,2,3)
G.add_edge(0,1,3)
G.add_edge(5,6,3)

G.add_edge(2,0,4)
G.add_edge(1,3,4)
G.add_edge(0,4,4)

G.add_edge(3,5,5)




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