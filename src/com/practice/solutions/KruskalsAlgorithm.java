package com.practice.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;


/*
 @author Ronak Panchal
*/

public class KruskalsAlgorithm {


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNodes = 0;
        int numberOfEdges = 0;
        try {
            String[] input_prarms = reader.readLine().split(" ");
            numberOfNodes = Integer.parseInt(input_prarms[0]);
            numberOfEdges = Integer.parseInt(input_prarms[1]);
            LinkedList<Edge>[] adjacencyList = buildGraph(numberOfNodes, reader, numberOfEdges);
            int startVertex = Integer.parseInt(reader.readLine());
            int lengthOfTree = getMinimumSpanningTree(adjacencyList, startVertex, numberOfNodes);
            System.out.println(lengthOfTree);
        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static LinkedList<Edge>[] buildGraph(int numberOfNodes, BufferedReader reader, int numberOfEdges) {
        LinkedList<Edge>[] adjacencyList = (LinkedList<Edge>[]) new LinkedList[numberOfNodes + 1];
        int start = 0;
        int end = 0;
        int weight = 0;
        String inputString = new String();
        Edge edge = null;
        for (int i = 0; i < numberOfEdges; i++) {
            try {
                inputString = reader.readLine();
                start = Integer.parseInt(inputString.split(" ")[0]);
                end = Integer.parseInt(inputString.split(" ")[1]);
                weight = Integer.parseInt(inputString.split(" ")[2]);

                edge = new Edge(start, end, weight);

                if (adjacencyList[start] == null) {
                    adjacencyList[start] = new LinkedList<Edge>();
                    adjacencyList[start].add(edge);
                } else {
                    adjacencyList[start].add(edge);
                }
                if (adjacencyList[end] == null) {
                    adjacencyList[end] = new LinkedList<Edge>();
                    adjacencyList[end].add(edge);
                } else {
                    adjacencyList[end].add(edge);
                }
            } catch (IOException e) {

                e.printStackTrace();
            }


        }
        return adjacencyList;
    }


    private static class Edge implements Comparable<Edge> {

        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge [start=" + start + ", end=" + end + ", weight="
                    + weight + "]";
        }

        @Override
        public int compareTo(Edge otherEdge) {
            if (this.weight > otherEdge.weight) {
                return 1;
            } else if (this.weight < otherEdge.weight) {
                return -1;
            } else {
                return 0;
            }
        }


    }

    public static int getMinimumSpanningTree(LinkedList<Edge>[] adjacencyList, int startVertex, int numberOfVertices) {

        Set<Integer> setOfVertices = new HashSet<Integer>();
        PriorityQueue<Edge> listOfEdges = new PriorityQueue<Edge>();
        setOfVertices.add(startVertex);
        listOfEdges.addAll(adjacencyList[startVertex]);
        Edge edge;
        int sumOfWeight = 0;

        while (setOfVertices.size() < numberOfVertices) {
            edge = listOfEdges.poll();
            if (!(setOfVertices.contains(edge.start) && setOfVertices.contains(edge.end))) {
                if (!setOfVertices.contains(edge.start)) {
                    listOfEdges.addAll(adjacencyList[edge.start]);
                }
                if (!setOfVertices.contains(edge.end)) {
                    listOfEdges.addAll(adjacencyList[edge.end]);
                }
                setOfVertices.add(edge.start);
                setOfVertices.add(edge.end);

                sumOfWeight += edge.weight;
            }
        }
        return sumOfWeight;

    }


}
