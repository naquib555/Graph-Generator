# Graph-Generator for parallel programming

Graph representation in the form of adjacency list.

The graph which is represented in the form of adjacency list takes less space compared to adjacency matrix representation.

Also because of variable size of edge list per vertex, the adjacency matrix representation may not be efficient under the GPU model.
CUDA allows arrays of arbitrary sizes to be created and hence can represent graph using adjacency list.

This module generates three arrays of vertices, edges and weights in three seperate arrays.
