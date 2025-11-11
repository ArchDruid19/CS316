import networkx as nx


def main():
    print("Hi")
    G = nx.DiGraph()
    G.add_weighted_edges_from(
        [
            ("S", "E", 8),
            ("S", "A", 10),
            ("E", "D", 1),
            ("A", "C", 2),
            ("D", "A", -4),
            ("D", "C", -1),
            ("B", "A", 1),
            ("C", "B", -2),
        ]
    )

    lengths, paths = nx.single_source_bellman_ford(G, source="S")

    print(lengths)
    print(paths)


if __name__ == "__main__":
    main()
