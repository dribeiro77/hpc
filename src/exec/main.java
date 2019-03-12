package exec;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import obj.Simulation;
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
		Simulation sim = new Simulation(ret);


	}

}
