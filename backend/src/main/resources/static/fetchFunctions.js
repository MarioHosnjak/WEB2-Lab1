async function fetchAndDisplayGameData(tournamentId) {
    try {
        const response = await fetch(`http://localhost:8080/api/games?id=${tournamentId}`);

        if (response.ok) {
            gameData = await response.json();

            // Display the data in an HTML element
            const wrapper = document.createElement('div');
            wrapper.className = 'wrapperDiv';
            for (let i = 0; i < gameData.length; i++) {
                const gameDiv = document.createElement('div');
                gameDiv.className = 'gameClass';
                const gameNo = document.createElement('h3');
                gameNo.textContent = 'Game ' + String(i+1);
                const hr = document.createElement('hr')
                hr.style.width = '60%';
                hr.style.border = '1px solid black';
                hr.style.marginTop = '0px';
                const teamsSpan = document.createElement('h4');
                teamsSpan.textContent = gameData[i]['team1'] + '  -  ' + gameData[i]['team2'];
                const gameRes = document.createElement('h4');
                gameRes.textContent = 'Result = ' + (gameData[i]['result'] === '1' ? gameData[i]['team1'] + ' won!' : gameData[i]['result'] === '0' ? 'Draw' : gameData[i]['result'] === '2' ? gameData[i]['team2'] + ' won!' : 'Default');
                gameDiv.appendChild(gameNo);
                gameDiv.appendChild(hr);
                gameDiv.appendChild(teamsSpan);
                gameDiv.appendChild(gameRes);
                wrapper.appendChild(gameDiv);
                wrapper.appendChild(document.createElement('br'));
            }
            document.body.appendChild(wrapper);
            return gameData;
        } else {
            throw new Error(`Failed to fetch data: ${response.status} - ${response.statusText}`);
        }
    } catch (error) {
        console.error(error);
    }
}