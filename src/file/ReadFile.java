package file;

import obj.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Lecture du fichier contenant le graphe

public class ReadFile {
	ArrayList<Node> ret = new ArrayList<Node>(); //contient la liste des noeuds du graphe
	
	public ReadFile() {
		
	}
	
	public ArrayList<Node> readFile() throws FileNotFoundException {
		String[] line = new String[2];
		
		
		File file = new File("1.edges");
		 Scanner sc = new Scanner(file); 
		 while (sc.hasNextLine()) {
			 line = sc.nextLine().split(" ");
			 if(!ar_contains(Integer.parseInt(line[0]))) {
				 ret.add(new Node(Integer.parseInt(line[0])));	//ajoute le noeud à la liste
				 ret.get(ret.size()-1).addNode(Integer.parseInt(line[1]));
			 }
			 else {
				 getNodeFromInt(Integer.parseInt(line[0])).addNode(Integer.parseInt(line[1]));
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
	
	public Node getNodeFromInt(int nb){
		for (int j = 0; j < ret.size(); j++) {
			if(ret.get(j).getNode_id()==nb){
				return ret.get(j);
			}
		}
		return null;
	}
	
	
	
}
