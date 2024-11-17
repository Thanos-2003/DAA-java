public class FloydAlgorithm {
    final static int INF = 9999, nv =4;
    public void floydAlgorithm(int graph[][]){
        int matrix[][] = new int[nv][nv];
        int i,j,k;
        for (i = 0; i < nv; i++)
            for (j = 0; j < nv; j++)
                matrix[i][j] = graph[i][j];
        for( i=0;i<nv;i++){
            for (j = 0; j < nv; j++) {
                for ( k = 0; k < nv; k++) {
                    if(matrix[i][k]+matrix[k][j]<matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
        printMatrix(matrix);
    }
    public static void printMatrix(int matrix[][]){
        for (int i = 0; i < nv; i++) {
            for (int j = 0; j < nv; j++) {
                if(matrix[i][j]== INF)
                    System.out.print("INF\t");
                else
                    System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String []args){
        int graph[][]={{0, 3, INF, 5},{2, 0, INF, 4},{INF, 1, 0, INF},{ INF, INF, 2, 0}};
        FloydAlgorithm obj = new FloydAlgorithm();
        obj.floydAlgorithm(graph);
    }

}
