let currentTerrain = 'land';

function changeTerrain(terrain) {
    currentTerrain = terrain;
}

window.onload = function() {
    fetchTerrain();
};

function fetchTerrain() {
    fetch('/terrain/generate')
        .then(response => response.json())
        .then(data => {
            renderTerrain(data);
        });
}

function renderTerrain(data) {
    const gridContainer = document.getElementById('terrain-grid');
    gridContainer.innerHTML = ''; // Clear existing grid

    data.forEach((row, x) => {
        row.forEach((tile, y) => {
            const tileElement = document.createElement('div');
            tileElement.classList.add('terrain', `tile-${tile}`);
            tileElement.onclick = () => updateTile(x, y);
            gridContainer.appendChild(tileElement);
        });
    });
}

function updateTile(x, y) {
    fetch('/terrain/update', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            x: x,
            y: y,
            terrain: currentTerrain
        })
    })
    .then(response => response.json())
    .then(data => {
        renderTerrain(data);
    });
}
