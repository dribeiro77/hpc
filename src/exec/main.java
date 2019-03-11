package exec;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

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
		int count = 0;

		NetworkGraph netGraph = new NetworkGraph(ret);
		Map<Integer, Double> scoreMap = netGraph.getSortedScoreMap();
		Map<Integer, Double> scoreMapCured = netGraph.getVIPCuredMap(scoreMap, 25);

		/*Iterator<Map.Entry<Integer, Double>> iterator =  scoreMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, Double> entry = iterator.next();
			count ++;
			System.out.println(entry.getKey() + " --- " + entry.getValue());
		}*/


		Iterator<Map.Entry<Integer, Double>> iterator =  scoreMapCured.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<Integer, Double> entry = iterator.next();
			count ++;
			System.out.println(entry.getKey() + " --- " + entry.getValue());
		}

		System.out.println("--> " + count);

		//System.out.println(ThreadLocalRandom.current().nextInt(0,100));

		GraphTreatment grp = new GraphTreatment(ret);
		
		grp.matrixAdj();
		/*grp.matrixTran();
		grp.printMatrixAdj();
		System.out.println();
		grp.printMatrixTran();*/

	}

}
