package src.file;

import java.util.ArrayList;

import src.obj.Node;

public class GraphTreatment {
	
	ArrayList<Node> ret = new ArrayList<Node>();
	int[][] matrixAdj;
	int[][] matrixTran;

	public GraphTreatment(ArrayList<Node> ret) {
		super();
		this.ret = ret;
		matrixAdj = new int[ret.size()][ret.size()];
		matrixTran = new int[ret.size()][ret.size()];
	}
	
	
	
	public void matrixAdj(){
		for (int i = 0; i < ret.size(); i++) {
			for (int j = 0; j < ret.get(i).getVoisins().size(); j++) {
				matrixAdj[ret.get(i).getNode_id()-1][ret.get(i).getVoisins().get(j)-1]=1;
			}
		}
	}

	public ArrayList<Node> getRet() {
		return ret;
	}

	public void setRet(ArrayList<Node> ret) {
		this.ret = ret;
	}

	public int[][] getMatrixAdj() {
		return matrixAdj;
	}

	public void setMatrixAdj(int[][] matrixAdj) {
		this.matrixAdj = matrixAdj;
	}

	public int[][] getMatrixTran() {
		return matrixTran;
	}

	public void setMatrixTran(int[][] matrixTran) {
		this.matrixTran = matrixTran;
	}
	
	public void printMatrix(){
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj[i].length; j++) {
				System.out.print(matrixAdj[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	
	

}
