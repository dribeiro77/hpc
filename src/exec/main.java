package exec;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import file.GraphTreatment;
import file.ReadFile;
import obj.Node;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ReadFile read = new ReadFile();
		ArrayList<Node> ret = read.readFile();
		GraphTreatment grp = new GraphTreatment(ret);
		grp.matrixAdj();
		grp.matrixTran();
		grp.printMatrixAdj();
		System.out.println();
		grp.printMatrixTran();
		 		
		 		
	}

}
