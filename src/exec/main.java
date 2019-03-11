package exec;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;

import file.GraphTreatment;
import file.ReadFile;
import obj.NetworkGraph;
import obj.Node;
import sun.security.provider.certpath.Vertex;

public class main {

	public static void main(String[] args) throws FileNotFoundException {

		ReadFile read = new ReadFile();
		ArrayList<Node> ret = read.readFile();

		NetworkGraph netGraph = new NetworkGraph(ret);
		Map<Integer, Double> scoreMap = netGraph.getSortedScoreMap();
		Iterator<Map.Entry<Integer, Double>> iterator =  scoreMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, Double> entry = iterator.next();
			System.out.println(entry.getKey() + " --- " + entry.getValue());
		}

		/*Set<Integer> testSet = netGraph.getGraph().vertexSet();
		Iterator<Integer> iterator =  testSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}*/

		GraphTreatment grp = new GraphTreatment(ret);
		
		grp.matrixAdj();
		/*grp.matrixTran();
		grp.printMatrixAdj();
		System.out.println();
		grp.printMatrixTran();*/

	}

}
