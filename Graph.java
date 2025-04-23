/******************************************************************
 *
 *   Malia Kuykendall / COMP 272/400C-001
 *
 *   Note, additional comments provided throughout this source code
 *   is for educational purposes
 *
 ********************************************************************/

 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.List;
 
 
 /**
  *  Graph traversal exercise
  *
  *  The Graph class is a representing an oversimplified Directed Graph of vertices
  *  (nodes) and edges. The graph is stored in an adjacency list
  */
 
 public class Graph {
   int numVertices;                  // vertices in graph
   LinkedList<Integer>[] adjListArr; // Adjacency list
   List<Integer> vertexValues;       // vertex values
 
   // Constructor 
   public Graph(int numV) {
     numVertices = numV;
     adjListArr = new LinkedList[numVertices];
     vertexValues = new ArrayList<>(numVertices);
 
     for (int i = 0; i < numVertices; i++) {
       adjListArr[i] = new LinkedList<>();
       vertexValues.add(0);
     }
   }
 
   /*
    * method setValue
    * 
    * Sets a vertex's (node's) value.
    */ 
   
   public void setValue(int vertexIndex, int value) {
     if (vertexIndex >= 0 && vertexIndex < numVertices) {
       vertexValues.set(vertexIndex, value);
     } else {
       throw new IllegalArgumentException(
              "Invalid vertex index: " + vertexIndex);
     }
   }
 
 
   public void addEdge(int src, int dest) {
     adjListArr[src].add(dest);
   }
 
   /*
    * method printGraph
    * 
    * Prints the graph as an adjacency matrix
    */ 
   
   public void printGraph() {
     System.out.println(
          "\nAdjacency Matrix Representation:\n");
     int[][] matrix = new int[numVertices][numVertices];
 
     for (int i = 0; i < numVertices; i++) {
       for (Integer dest : adjListArr[i]) {
         matrix[i][dest] = 1;
       }
     }
 
     System.out.print("  ");
     for (int i = 0; i < numVertices; i++) {
       System.out.print(i + " ");
     }
     System.out.println();
 
     for (int i = 0; i < numVertices; i++) {
       System.out.print(i + " ");
       for (int j = 0; j < numVertices; j++) {
         if (matrix[i][j] == 1) {
           System.out.print("| ");
         } else {
           System.out.print(". ");
         }
       }
       System.out.println();
     }
   }
 
 
   /**
    * method findRoot
    *
    * This method returns the value of the root vertex, where root is defined in
    * this case as a node that has no incoming edges. If no root vertex is found
    * and/or more than one root vertex, then return -1.
    * 
    */
   
   public int findRoot() {
        int rootVertex = -1;
        int countRoots = 0;

        int[] countDegrees = new int[numVertices];
        // create array to store degrees of each vertex/node

        for (int i = 0; i < numVertices; i++) {
          for (int n : adjListArr[i]) {
            countDegrees[n]++;
          }
        }
        // iterate through the adjacency list,
        // add corresponding degrees for each node into the array 

        for (int i = 0; i < numVertices; i++) {
          if (countDegrees[i] == 0) {
            rootVertex = i;
            countRoots++;
          }
        } // in the array of degrees, check degrees for each node
        // if no incoming edges (degrees is 0), then save index of node
        // and increment the count of amount of root vertexes

        if (countRoots == 1) {
          return vertexValues.get(rootVertex);
        } 
        // if there's only one root vertex, return the value of this vertex

        // get degrees of each node, check amount of edges for each node
     // ADD YOUR CODE HERE - DO NOT FORGET TO ADD YOUR NAME/SECTION AT TOP OF FILE
     return -1;
     // if there is either no root vertex, or multiple, return -1
   } 
 }
