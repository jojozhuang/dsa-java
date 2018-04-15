package johnny.datastructure.graph;

/*
 * A directed graph, implemented using an adjacency matrix.
 */
public class DirectedGraph {
    private int MAX_VERTS = 0;
    private Vertex[] vertexList; // array of vertices
    private int[][] adjMatrix; // adjacency matrix
    private int nVerts; // current number of vertices
    private String[] sortedArray;

    public DirectedGraph(int maxverts)
    {
        MAX_VERTS = maxverts; // maximum number of vertices
        vertexList = new Vertex[MAX_VERTS];
        adjMatrix = new int[MAX_VERTS][MAX_VERTS];
        sortedArray = new String[MAX_VERTS];
        nVerts = 0;

        // initialize matrix
        for(int i=0; i<MAX_VERTS; i++) {
            for(int j=0; j<MAX_VERTS; j++) {
                adjMatrix[i][j] = 0;
            }
        }
    }

    public void addVertex(String name) {
        int index = nVerts++;
        vertexList[index] = new Vertex(index, name);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
    }

    public Vertex[] getVertices() {
        return vertexList;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void displayVertex(int index) {
        System.out.print(vertexList[index].name);
    }

    // topological sort
    public void topo() {
        int orig_nVerts = nVerts; // remember how many verts
        while(nVerts > 0) {
            // get a vertex with no successors, or -1
            int currentVertex = noSuccessors(); 
            if(currentVertex == -1) // must be a cycle
            {
                System.out.println("ERROR: Graph has cycles"); 
                return;
            }
            // insert vertex label in sorted array (start at end) 
            sortedArray[nVerts-1] = vertexList[currentVertex].name;
            deleteVertex(currentVertex); // delete vertex
        }
        // vertices all gone; display sortedArray 
        for(int j=0; j<orig_nVerts; j++) {
            System.out.print( sortedArray[j] ); 
        }
        System.out.println("");
    }

    public int noSuccessors() {
        boolean isEdge; // edge from row to column in adjMat
        for(int row=0; row<nVerts; row++) {
            isEdge = false;
            for(int col=0; col<nVerts; col++) {
                if( adjMatrix[row][col] > 0 ) {
                    isEdge = true;
                    break;
                }
            }
            if( !isEdge ) {
                return row;
            }
        }
        return -1;
    }

    public void deleteVertex(int delVert) {
        if(delVert != nVerts-1) // if not last vertex,
        {
            for (int j=delVert; j<nVerts-1; j++) {
                vertexList[j] = vertexList[j+1]; // delete row from adjMat
            }
            for (int row=delVert; row<nVerts-1; row++) {
                moveRowUp(row, nVerts); // delete col from adjMat
            }
            for (int col=delVert; col<nVerts-1; col++) {
                moveColLeft(col, nVerts-1);
            }
        }
        nVerts--; // one less vertex
    }

    private void moveRowUp(int row, int length) {
        for (int col=0; col<length; col++) {
            adjMatrix[row][col] = adjMatrix[row+1][col];
        }
    }
    
    private void moveColLeft(int col, int length) {
        for (int row=0; row<length; row++) {
            adjMatrix[row][col] = adjMatrix[row][col+1];
        }
    }

}
