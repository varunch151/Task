package com.varun.airportbaggagerouting;




import java.util.List;

import com.varun.airportbaggagerouting.model.DirectedEdge;

public interface DijkstraAlgorithm {
    public String findShortestPath(String entry,String dest, List<DirectedEdge> graphEdges);
}
