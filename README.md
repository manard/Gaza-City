
<h1>Dijkstra's Shortest Path Algorithm for Maps</h1>

<h2>Overview</h2>

This project implements Dijkstra's shortest path algorithm optimized for maps, specifically designed for geographic information systems (GIS) applications such as MapQuest and GPS-based car navigation systems. 
The algorithm efficiently finds the lowest-cost route between two cities on a map.

</hr>

<h2>Features</h2>

<h3>Map Representation</h3>
The map is represented as a graph with vertices corresponding to cities and edges representing roads, with weights as Euclidean distances.

<h3>Dijkstra's Algorithm</h3>
The classic Dijkstra's algorithm is implemented to find the shortest path between two cities on the map.

<h3>Optimization</h3>
The algorithm is optimized to process thousands of shortest path queries efficiently, achieving sublinear time complexity.

<h3>Dynamic Path Update</h3>
Instead of re-initializing all distances to infinity for each query, only the necessary values are updated, reducing computation time significantly.

<h2>Usage</h2>

<h3>Input Map</h3>
The map is provided in a file format specifying the vertices (cities) and edges (connections between cities).
<h3>Query</h3>
Users input two cities to find the shortest path between them.
<h3>Output</h3>
The program returns the lowest-cost route and Distance between the two cities 





![s](https://github.com/manard/Gaza-City/assets/106376651/35b0cfaf-880a-48ec-a55b-38cedd655846)
