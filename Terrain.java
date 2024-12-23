package com.kingdomsofearth;

public class Terrain {
    private String[][] grid;

    public Terrain(int rows, int cols) {
        this.grid = new String[rows][cols];
    }

    public void generateTerrain() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                double rand = Math.random();
                if (rand < 0.3) {
                    grid[i][j] = "water";
                } else if (rand < 0.6) {
                    grid[i][j] = "land";
                } else {
                    grid[i][j] = "mountain";
                }
            }
        }
    }

    public void updateTerrain(int x, int y, String newTerrain) {
        grid[x][y] = newTerrain;
    }

    public String[][] getGrid() {
        return grid;
    }
}

