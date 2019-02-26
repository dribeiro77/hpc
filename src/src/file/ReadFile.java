package src.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import src.obj.*;

//Lecture du fichier contenant le graphe

public class ReadFile {
	ArrayList<Node> ret = new ArrayList<Node>();
	
	public ReadFile() {
		
	}
	
	public ArrayList<Node> readFile() throws FileNotFoundException {
		String[] line = new String[2];
		
		
		File file = new File("0.edges"); 
		 Scanner sc = new Scanner(file); 
		 while (sc.hasNextLine()) {
			 line = sc.nextLine().split(" ");
			 if(!ar_contains(Integer.parseInt(line[0]))) {
				 ret.add(new Node(Integer.parseInt(line[0])));	
				 ret.get(ret.size()-1).addNode(Integer.parseInt(line[1]));
			 }
			 else {
				 
			 }
		 }
		 return ret;
	}		     
	public boolean ar_contains(int n) {
		for (int i = 0; i < ret.size(); i++) {
			if (ret.get(i).getNode_id()==n) {
				return true;
			}
		}
		return false;
 
	}
}
