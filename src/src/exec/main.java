package src.exec;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SingleSelectionModel;

import src.file.GraphTreatment;
import src.file.ReadFile;
import src.obj.Node;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ReadFile read = new ReadFile();
		ArrayList<Node> ret = read.readFile();
		GraphTreatment grp = new GraphTreatment(ret);
		grp.matrixAdj();
		
		grp.printMatrix();
		
		 		
		 		
	}

}
