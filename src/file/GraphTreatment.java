package file;

import obj.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.jgrapht.* ;

public class GraphTreatment {
	
	ArrayList<Node> ret = new ArrayList<Node>();
	int[][] matrixAdj;
	float[][] matrixTran;

	public GraphTreatment(ArrayList<Node> ret) {
		super();
		this.ret = ret;
		matrixAdj = new int[getRetMax()][getRetMax()];
		matrixTran = new float[getRetMax()][getRetMax()];
	}
	
	
	//Rempli la matrice d'adjacence

	public void matrixAdj(){
		for (int i = 0; i < ret.size(); i++) { //Pour tous les noeuds
			for (int j = 0; j < ret.get(i).getVoisins().size(); j++) { //pour tous les voisins  de chaque noeud
				matrixAdj[ret.get(i).getNode_id()-1][ret.get(i).getVoisins().get(j)-1]=1;
			}
		}
	}

	//Rempli la matrice de transition
	//Note : la matrice de transition est transposée
	public void matrixTran(){
		int count=0;
		for (int i = 0; i < matrixAdj.length; i++) {
			count=0;
			for (int j = 0; j < matrixAdj.length; j++) {
				if(matrixAdj[j][i]==1){
					count++;
				}
			}
			
			for (int j = 0; j < matrixAdj.length; j++) {
				if(matrixAdj[j][i]==1){
					matrixTran[j][i]= (float) ((float)1/count);
				}
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

	public float[][] getMatrixTran() {
		return matrixTran;
	}

	public void setMatrixTran(float[][] matrixTran) {
		this.matrixTran = matrixTran;
	}
	
	public void printMatrixAdj(){
		for (int i = 0; i < matrixAdj.length; i++) {
			for (int j = 0; j < matrixAdj[i].length; j++) {
				System.out.print(matrixAdj[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public void printMatrixTran(){
		for (int i = 0; i < matrixTran.length; i++) {
			for (int j = 0; j < matrixTran[i].length; j++) {
				System.out.print(matrixTran[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public int getRetMax(){
		int max=0;
		
		for (int i = 0; i < ret.size(); i++) {
			if (ret.get(i).getNode_id()>max){
				max=ret.get(i).getNode_id();
			}
		}
		return max;
	}
	
	

}
