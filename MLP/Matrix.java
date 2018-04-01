package Multilayer_Perceptron;

public class Matrix {
	public double[][] Index;
	
	private	int rows_m;
	private int cols_m;
	
	public Matrix(int rows, int cols) {
		Index = new double[rows][cols];
		
		rows_m = rows;
		cols_m = cols;
	}
	
	public void randomize() {
		for (int x = 0; x < rows_m; x++) {
			for (int y = 0; y < cols_m; y++) {
				Index[x][y] = 0 + (int)(Math.random() * 100);
			}
		}
	}
	
	public void print() {
		for (int x = 0; x < rows_m; x++) {
			for (int y = 0; y < cols_m; y++) {
				System.out.print(Index[x][y] + "    ");
			}
			System.out.println(" ");
		}
	}
	
	public void scalar(double scalar) {
		for (int x = 0; x < rows_m; x++) {
			for (int y = 0; y < cols_m; y++) {
				Index[x][y] = Index[x][y] * scalar; 
			}
		}
	}
	
	public void add(double term) {
		for (int x = 0; x < rows_m; x++) {
			for (int y = 0; y < cols_m; y++) {
				Index[x][y] += term; 
			}
		}
	}
	
	public void subtract(double term) {
		for (int x = 0; x < rows_m; x++) {
			for (int y = 0; y < cols_m; y++) {
				Index[x][y] -= term; 
			}
		}
	}
	
	
}