function createTable(gameData, scoringSystem) {
    let tableDict = {}
    for (let i = 0; i < gameData.length; i++) {
        if (gameData[i]['result'] === '1') {
            if (tableDict[gameData[i]['team1']]) {
                tableDict[gameData[i]['team1']] += scoringSystem[0];
            } else {
                tableDict[gameData[i]['team1']] = scoringSystem[0]
            }
            if (tableDict[gameData[i]['team2']]) {
                tableDict[gameData[i]['team2']] += scoringSystem[2];
            } else {
                tableDict[gameData[i]['team2']] = scoringSystem[2]
            }
        } else if (gameData[i]['result'] === '0') {
            if (tableDict[gameData[i]['team1']]) {
                tableDict[gameData[i]['team1']] += scoringSystem[1];
            } else {
                tableDict[gameData[i]['team1']] = scoringSystem[1]
            }
            if (tableDict[gameData[i]['team2']]) {
                tableDict[gameData[i]['team2']] += scoringSystem[1];
            } else {
                tableDict[gameData[i]['team2']] = scoringSystem[1]
            }
        } else if (gameData[i]['result'] === '2') {
            if (tableDict[gameData[i]['team1']]) {
                tableDict[gameData[i]['team1']] += scoringSystem[2];
            } else {
                tableDict[gameData[i]['team1']] = scoringSystem[2]
            }
            if (tableDict[gameData[i]['team2']]) {
                tableDict[gameData[i]['team2']] += scoringSystem[0];
            } else {
                tableDict[gameData[i]['team2']] = scoringSystem[0]
            }
        }
    }
    const sortedTable = Object.entries(tableDict)
        .map(([key, value]) => ( {key, value} ))
        .sort((a, b) => a.value - b.value).reverse();

    createTeamTable(sortedTable);

    return tableDict;
}

function createTeamTable(sortedDictionary) {
    const wrapper = document.createElement("div");
    wrapper.className = "wrapperDiv";
    const table = document.createElement("table");

    // Create table header
    const thead = document.createElement("thead");
    const headerRow = document.createElement("tr");
    const teamNameHeader = document.createElement("th");
    teamNameHeader.textContent = "Team Name";
    const pointsHeader = document.createElement("th");
    pointsHeader.textContent = "Points";

    headerRow.appendChild(teamNameHeader);
    headerRow.appendChild(pointsHeader);
    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Create table body
    const tbody = document.createElement("tbody");
    for (let i = 0; i < sortedDictionary.length; i++) {
        const row = document.createElement("tr");
        const teamNameCell = document.createElement("td");
        teamNameCell.textContent = sortedDictionary[i].key; // Team name
        const pointsCell = document.createElement("td");
        pointsCell.textContent = sortedDictionary[i].value; // Points

        row.appendChild(teamNameCell);
        row.appendChild(pointsCell);
        tbody.appendChild(row);
    }
    table.appendChild(tbody);

    let hr = document.createElement('hr')
    hr.style.width = '20 em';
    document.body.appendChild(hr);

    wrapper.appendChild(table);
    document.body.appendChild(wrapper);

    return table;
}