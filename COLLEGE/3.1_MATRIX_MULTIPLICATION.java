class MATRIX_MULTIPLICATION
{
    public static void main(String[]args)
    {
        int a[][] = {{0,0,0},{4,5,6},{7,8,9}};
        int b[][] = {{0,0,0},{4,5,6},{7,8,9}}; 
        int c[][] = new int[3][3];    
        int i,j,k;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            {
                c[i][j] = 0;
                for(k=0;k<3;k++)
                {
                    c[i][j] += a[i][k]*b[k][j];
                }
                System.out.print(c[i][j]+" ");    
            }
            System.out.println();
        }
    }
}



