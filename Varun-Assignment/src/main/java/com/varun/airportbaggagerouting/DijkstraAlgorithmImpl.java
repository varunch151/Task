package com.varun.airportbaggagerouting;


import java.util.List;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;



import com.varun.airportbaggagerouting.model.DirectedEdge;

import com.varun.airportbaggagerouting.model.DijkstraGraphMap;
import com.varun.airportbaggagerouting.model.Vertex;


public class DijkstraAlgorithmImpl implements DijkstraAlgorithm {

    private final static String SINGLE_WHITE_SPACE=" ";

    Map<String, DijkstraGraphMap> visitedMap=new ConcurrentHashMap<>(); // Visited map with the sourceName as the key

  
    public String findShortestPath(String entryGate, String destGate, List<DirectedEdge> edges) {
        DijkstraGraphMap dijkstraGraphMap;
        if(visitedMap.containsKey(entryGate)){
            dijkstraGraphMap = visitedMap.get(entryGate);
        }else {
            dijkstraGraphMap = new DijkstraGraphMap(edges);
            dijkstraGraphMap.dijkstra(entryGate);
            visitedMap.put(entryGate,dijkstraGraphMap);
        }

        List<Vertex> shortestPath= dijkstraGraphMap.getShortestPath(destGate);
        return generatePathLine(shortestPath);
    }

    private String generatePathLine(List<Vertex> path){
        StringBuffer line = new StringBuffer();

        for(Vertex vertex:path){
            line.append(vertex.getName()).append(SINGLE_WHITE_SPACE);
        }
        line.append(": ").append(path.get(path.size()-1).getTime());
        return line.toString();
    }

}
