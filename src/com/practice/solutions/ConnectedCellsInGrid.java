package com.practice.solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ronak on 9/16/2016.
 */
public class ConnectedCellsInGrid {

    public static void main(String[] args) {
        ConnectedCellsInGrid obj=new ConnectedCellsInGrid();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int m = 0;
        int[][] grid;
        try {

            n = Integer.parseInt(in.readLine());
            m = Integer.parseInt(in.readLine());
            grid = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] row = in.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(row[j]);
                }
            }
            System.out.println(obj.getMaxCellsRegion(grid));

        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public class Cell {

        private int i;
        private int j;

        public Cell(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public String toString() {
            return "Cell [i=" + i + ", j=" + j + "]";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + i;
            result = prime * result + j;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Cell other = (Cell) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (i != other.i)
                return false;
            if (j != other.j)
                return false;
            return true;
        }

        private ConnectedCellsInGrid getOuterType() {
            return ConnectedCellsInGrid.this;
        }


    }

    public int getMaxCellsRegion(int[][] grid){
        HashMap<Cell, ArrayList<Cell>> graph=buildGraph(grid);
        HashSet<Cell> visitedNodes=new HashSet<Cell>();
        Iterator<Cell> itr=graph.keySet().iterator();
        int max=0;
        while(itr.hasNext()){
            Cell cell=itr.next();
            if(!visitedNodes.contains(cell)){
                int count=getNoOfCellsInRegion(cell,graph,visitedNodes);
                if(count>max){
                    max=count;
                }
            }
        }

        return max;
    }


    public HashMap<Cell, ArrayList<Cell>> buildGraph(int[][] grid) {
        HashMap<Cell, ArrayList<Cell>> graph = new HashMap<Cell, ArrayList<Cell>>();

        int m=grid.length;
        int n=grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {

                    Cell cell =new Cell(i, j);
                    ArrayList<Cell> list = new ArrayList<Cell>();

                    if (isInGrid(i,j+1,m,n)) {
                        if(grid[i][j+1] == 1){
                            list.add(new Cell(i, j + 1));
                        }
                    }

                    if (isInGrid(i,j-1,m,n)) {
                        if(grid[i][j-1] == 1){
                            list.add(new Cell(i, j - 1));
                        }
                    }
                    if (isInGrid(i-1,j,m,n)) {
                        if(grid[i-1][j] == 1){
                            list.add(new Cell(i-1, j ));
                        }
                    }
                    if (isInGrid(i-1,j+1,m,n)) {
                        if(grid[i-1][j+1] == 1){
                            list.add(new Cell(i-1, j + 1));
                        }
                    }
                    if (isInGrid(i-1,j-1,m,n)) {
                        if(grid[i-1][j-1] == 1){
                            list.add(new Cell(i-1, j - 1));
                        }
                    }
                    if (isInGrid(i+1,j,m,n)) {
                        if(grid[i+1][j] == 1){
                            list.add(new Cell(i+1, j));
                        }
                    }
                    if (isInGrid(i+1,j-1,m,n)) {
                        if(grid[i+1][j-1] == 1){
                            list.add(new Cell(i+1, j -1));
                        }
                    }
                    if (isInGrid(i+1,j+1,m,n)) {
                        if(grid[i+1][j+1] == 1){
                            list.add(new Cell(i+1, j+1));
                        }
                    }
                    graph.put(cell,list);
                }
            }
        }
        return graph;
    }

    public boolean isInGrid(int i,int j,int m,int n){
        if(i<m && j<n && j>=0 && i>=0){
            return true;
        }
        else{
            return false;
        }
    }

    public int getNoOfCellsInRegion(Cell source,
                                    HashMap<Cell, ArrayList<Cell>> graph,
                                    HashSet<Cell> visitedNodes) {

        Stack<Cell> stack = new Stack<Cell>();
        stack.push(source);
        Set<Cell> cellsInComponent = new HashSet<Cell>();
        while (!stack.isEmpty()) {
            Cell cell = stack.pop();
            if (!visitedNodes.contains(cell)) {
                cellsInComponent.add(cell);
                ArrayList<Cell> list = graph.get(cell);
                for (Cell cel : list) {
                    if(!cellsInComponent.contains(cel)){
                        stack.push(cel);
                    }
                    cellsInComponent.add(cel);
                }
                visitedNodes.add(source);
            }
        }
        return cellsInComponent.size();

    }
}
