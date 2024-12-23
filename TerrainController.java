package com.kingdomsofearth;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/terrain")
public class TerrainController {

    private Terrain terrain;

    public TerrainController() {
        terrain = new Terrain(10, 10); // 10x10 grid
        terrain.generateTerrain();
    }

    @GetMapping("/generate")
    public String[][] generateTerrain() {
        return terrain.getGrid();
    }

    @PostMapping("/update")
    public String[][] updateTerrain(@RequestBody TerrainUpdateRequest request) {
        terrain.updateTerrain(request.getX(), request.getY(), request.getTerrain());
        return terrain.getGrid();
    }
}
