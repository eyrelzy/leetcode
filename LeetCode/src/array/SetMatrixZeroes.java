package array;

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix={{1,2,3,4},{5,0,5,2},{8,9,2,0},{5,7,2,1}};
		printMatrix(matrix);
		setZeroes(matrix);
		printMatrix(matrix);
	}
	public static void printMatrix(int[][] matrix){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	//solution 1: in place
	//use space the matrix already has
	//first, see if line 0, col 0 has zeros and flag true;
	//second, see if other has zeros and assign them into the line 0 or col 0
	//third, make them all zeros right for the cells except in line 0 or col 0
	//fourth, see if the line 0 col 0 flag is true or not
	//if true check if its original zero or not!!!!!
	public static void setZeroes(int[][] matrix){
		boolean rowflag=false,colflag=false;
		for(int i=0;i<matrix.length;i++)
		{
			if(matrix[i][0]==0)
				colflag=true;
		}
		for(int j=0;j<matrix[0].length;j++){
			if(matrix[0][j]==0)
				rowflag=true;
		}
		for(int i=1;i<matrix.length;i++){
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
		System.out.println("======1=====");
		printMatrix(matrix);
		System.out.println("=====1======");
		for(int i=1;i<matrix.length;i++)
		{
			if(matrix[i][0]==0){
				//this line is assigned to zero
				for(int j=1;j<matrix[0].length;j++){
					matrix[i][j]=0;
				}
			}
		}
		for(int j=1;j<matrix[0].length;j++){
			if(matrix[0][j]==0){
				for(int i=1;i<matrix.length;i++){
					matrix[i][j]=0;
				}
			}
		}
		System.out.println("====2=======");
		printMatrix(matrix);
		System.out.println("======2=====");
		if(rowflag){
//			boolean flag=false;
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[0][j]==0){
					boolean flag=false;
					for(int i=1;i<matrix.length;i++){
						if(matrix[i][j]!=0){
							flag=true;
							break;
						}
					}
					if(flag){
						for(int i=1;i<matrix.length;i++){
							matrix[i][j]=0;
						}
					}
				}
			}
			for(int j=0;j<matrix[0].length;j++){
				matrix[0][j]=0;
			}
		}
		if(colflag){
			for(int i=1;i<matrix.length;i++){
				if(matrix[i][0]==0){
					boolean flag=false;
					for(int j=1;j<matrix[0].length;j++){
						if(matrix[i][j]!=0){
							flag=true;break;
						}
					}
					if(flag){
						for(int j=1;j<matrix[0].length;j++){
							matrix[i][j]=0;
						}
					}
				}
			}
			for(int i=0;i<matrix.length;i++){
				matrix[i][0]=0;
			}
		}
		
	}

}
