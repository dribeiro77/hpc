package obj;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Simulation {

    int numberInfected;
    int numberVaccinated;
    int numberVaccinatedFlat;
    private Set<Integer> infectedPeople;
    private Set<Integer> vaccinatedPeople;
    private ArrayList<Integer> infectedDataNoVaccination = new ArrayList<>();
    private ArrayList<Integer> infectedDataRandomVaccination = new ArrayList<>();
    private ArrayList<Integer> infectedDataPagerankVaccination = new ArrayList<>();

    NetworkGraph networkGraph;

    public Simulation(ArrayList<Node> ret){

        networkGraph = new NetworkGraph(ret);
        numberInfected = ThreadLocalRandom.current().nextInt(0,ret.size());
        numberVaccinated = ThreadLocalRandom.current().nextInt(0,ret.size());
        numberVaccinatedFlat = 100;

        System.out.println("Simulation sans vaccin en cours:\n");
        simulationNoVaccination();
        System.out.println("Simulation vaccin random en cours:\n");
        simulationRandomVaccination();
        System.out.println("Simulation vaccin Pagerank en cours:\n");
        simulationPagerankVaccination();

        System.out.println(infectedDataNoVaccination + "\n" + infectedDataRandomVaccination + "\n" + infectedDataPagerankVaccination);

    }

    public void simulationNoVaccination(){

        vaccinatedPeople = new HashSet<>(); //no vaccination
        infectedPeople = startInfectPeople(networkGraph.graph);

        for(int iteration = 0; iteration < 500; iteration++){
            infectedPeople = infectNeighbor();
            //infectedPeople = infectDistant();
            infectedPeople = curePeople();
            infectedDataNoVaccination.add(infectedPeople.size());
        }
    }

    public void simulationRandomVaccination(){

        vaccinatedPeople = startVaccinateRandomPeople(networkGraph.graph);
        infectedPeople = startInfectPeople(networkGraph.graph);

        for(int iteration = 0; iteration < 500; iteration++){
            infectedPeople = infectNeighbor();
            //infectedPeople = infectDistant();
            infectedPeople = curePeople();
            infectedDataRandomVaccination.add(infectedPeople.size());
        }
    }

    public void simulationPagerankVaccination(){

        vaccinatedPeople = startVaccinatePagerankPeople(networkGraph.graph);
        infectedPeople = startInfectPeople(networkGraph.graph);

        for(int iteration = 0; iteration < 500; iteration++){
            infectedPeople = infectNeighbor();
            //infectedPeople = infectDistant();
            infectedPeople = curePeople();
            infectedDataPagerankVaccination.add(infectedPeople.size());
        }
    }

    public Set<Integer> startVaccinateRandomPeople(Graph<Integer, DefaultEdge> graph) {
        Set<Integer> people = new HashSet<>(graph.vertexSet());
        List<Integer> shufflePeople = new ArrayList<>(people);
        Collections.shuffle(shufflePeople);
        return new HashSet<>(shufflePeople.subList(0, numberVaccinatedFlat));
    }

    public Set<Integer> startVaccinatePagerankPeople(Graph<Integer, DefaultEdge> graph){
        Set<Integer> vaccinated = new HashSet<>();
        Map<Integer, Double> toBeVaccinate = networkGraph.getVaccinateMap(numberVaccinated);
        for(Integer key : toBeVaccinate.keySet()){
            vaccinated.add(key);
        }
        return vaccinated;
    }


    public Set<Integer> startInfectPeople(Graph<Integer, DefaultEdge> graph) {
        Set<Integer> people = new HashSet<>(graph.vertexSet());
        people.removeAll(vaccinatedPeople);
        List<Integer> shufflePeople = new ArrayList<>(people);
        Collections.shuffle(shufflePeople);
        return new HashSet<>(shufflePeople.subList(0, numberInfected));
    }

    public Set<Integer> infectNeighbor(){
        Set<Integer> afterInfectPeople = new HashSet<>(infectedPeople);
        for(Integer infected : infectedPeople){
            for(Integer targetPeople : Graphs.successorListOf(networkGraph.graph, infected)) {
                if (!vaccinatedPeople.contains(targetPeople) && Math.random() < 0.2){
                    afterInfectPeople.add(targetPeople);
                }
            }
        }
        return afterInfectPeople;
    }

    public Set<Integer> infectDistant(){
        Set<Integer> afterInfectPeople = new HashSet<>(infectedPeople);
        for(Integer infected : infectedPeople){
            if(Math.random() < 0.2){
                for(Integer targetPeople : Graphs.successorListOf(networkGraph.graph, infected)) {
                    for(Integer targetNextPeople : Graphs.successorListOf(networkGraph.graph, targetPeople)) {
                        if(!vaccinatedPeople.contains(targetNextPeople)) afterInfectPeople.add(targetNextPeople);
                    }
                }
            }
        }
        return afterInfectPeople;

    }

    public Set<Integer> curePeople(){
        Set<Integer> afterCurePeople = new HashSet<>(infectedPeople);
        for(Integer infected : infectedPeople){
            if(Math.random() < 0.24){
                afterCurePeople.remove(infected);
            }
        }
        return afterCurePeople;
    }

    public ArrayList<Integer> getInfectedDataNoVaccination(){
        return infectedDataNoVaccination;
    }

}
