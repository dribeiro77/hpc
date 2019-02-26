package src.obj;

import java.util.ArrayList;

public class Node {
		int node_id;
		ArrayList<Integer> voisins;
		
		
		public Node(int node_id) {
			super();
			this.node_id = node_id;
			voisins = new ArrayList();
		}


		public Node() {
			super();
		}


		public int getNode_id() {
			return node_id;
		}


		public void setNode_id(int node_id) {
			this.node_id = node_id;
		}


		public ArrayList<Integer> getVoisins() {
			return voisins;
		}


		public void setVoisins(ArrayList<Integer> voisins) {
			this.voisins = voisins;
		}
		
		public void addNode(int n) {
			voisins.add(n);
		}
		
		public void removeNode(int n) {
			voisins.remove(n);
		}


		@Override
		public String toString() {
			return "Node [node_id=" + node_id + "]";
		}
		
		
		
		

}
