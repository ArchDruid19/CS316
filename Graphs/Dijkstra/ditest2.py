class Graph:
    def __init__(self, size):
        self.adj_matrix = [[0] * size for _ in range(size)]
        self.size = size
        self.vertex_data = [''] * size

    def add_edge(self, u, v, weight):
        if 0 <= u < self.size and 0 <= v < self.size:
            self.adj_matrix[u][v] = weight
            self.adj_matrix[v][u] = weight  # For undirected graph

    def add_vertex_data(self, vertex, data):
        if 0 <= vertex < self.size:
            self.vertex_data[vertex] = data

    def dijkstra(self, start_vertex_data):
        start_vertex = self.vertex_data.index(start_vertex_data)
        distances = [float('inf')] * self.size
        distances[start_vertex] = 0
        visited = [False] * self.size

        for _ in range(self.size):
            min_distance = float('inf')
            u = None
            for i in range(self.size):
                if not visited[i] and distances[i] < min_distance:
                    min_distance = distances[i]
                    u = i

            if u is None:
                break

            visited[u] = True

            for v in range(self.size):
                if self.adj_matrix[u][v] != 0 and not visited[v]:
                    alt = distances[u] + self.adj_matrix[u][v]
                    if alt < distances[v]:
                        distances[v] = alt

        return distances


g = Graph(7)

g.add_vertex_data(0, 'A')
g.add_vertex_data(1, 'B')
g.add_vertex_data(2, 'C')
g.add_vertex_data(3, 'D')
g.add_vertex_data(4, 'E')
g.add_vertex_data(5, 'F')
g.add_vertex_data(6, 'G')

g.add_edge(0, 3, 3)
g.add_edge(0, 1, 2)
g.add_edge(0, 2, 3)

g.add_edge(1, 2, 4)
g.add_edge(1, 4, 3)

g.add_edge(2, 3, 5)
g.add_edge(2, 4, 1)
g.add_edge(2, 5, 6)

g.add_edge(3, 5, 7)

g.add_edge(4, 5, 8)

g.add_edge(5, 6, 9)

# Dijkstra's algorithm from D to all vertices
print("\nDijkstra's Algorithm starting from vertex A:")
distances = g.dijkstra('A')
for i, d in enumerate(distances):
    print(f"Distance from A to {g.vertex_data[i]}: {d}")
