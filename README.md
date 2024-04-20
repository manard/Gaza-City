
Dijkstra's Shortest Path Algorithm for Maps
Overview
This project implements Dijkstra's shortest path algorithm optimized for maps, specifically designed for geographic information systems (GIS) applications such as MapQuest and GPS-based car navigation systems. 
The algorithm efficiently finds the lowest-cost route between two cities on a map.

Features
Map Representation: The map is represented as a graph with vertices corresponding to cities and edges representing roads, with weights as Euclidean distances.
Dijkstra's Algorithm: The classic Dijkstra's algorithm is implemented to find the shortest path between two cities on the map.
Optimization: The algorithm is optimized to process thousands of shortest path queries efficiently, achieving sublinear time complexity.
Dynamic Path Update: Instead of re-initializing all distances to infinity for each query, only the necessary values are updated, reducing computation time significantly.

Usage
Input Map: The map is provided in a file format specifying the vertices (cities) and edges (connections between cities).
Query: Users input two cities to find the shortest path between them.
Output: The program returns the lowest-cost route between the two cities

![s](https://github.com/manard/Gaza-City/assets/106376651/35b0cfaf-880a-48ec-a55b-38cedd655846)
