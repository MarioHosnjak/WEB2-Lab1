function createEditForm() {
    console.log("Create form!!!");
    console.log(event.target.getAttribute("data"));
    let i = event.target.getAttribute("data");
    event.target.style.display = "none";

    let gameDiv = document.getElementById(event.target.getAttribute("data"));

    // Create a form element
    var form = document.createElement('form');
    form.method = 'post'; // Set the form method to POST
    form.action = 'http://localhost:8080/api/editGameResult'

// Create a div element
    var div = document.createElement('div');

    var gameIdInput = document.createElement('input');
    gameIdInput.type = "hidden";
    gameIdInput.name = "gameId";
    gameIdInput.value = gameData[i]['id'];

// Create a radio button input
    var radio1 = document.createElement('input');
    radio1.type = 'radio';
    radio1.name = 'newRes'; // Name attribute groups radio buttons
    radio1.value = "1";

    var radioX = document.createElement('input');
    radioX.type = 'radio';
    radioX.name = 'newRes'; // Name attribute groups radio buttons
    radioX.value = "0";

    var radio2 = document.createElement('input');
    radio2.type = 'radio';
    radio2.name = 'newRes'; // Name attribute groups radio buttons
    radio2.value = "2";

// Create a label for the radio button
    var label1 = document.createElement('label');
    label1.textContent = '1';

    var labelX = document.createElement('label');
    labelX.textContent = 'X';

    var label2 = document.createElement('label');
    label2.textContent = '2';


// Append the radio button and label to the div
    div.appendChild(gameIdInput)
    div.appendChild(radio1);
    div.appendChild(label1);
    div.appendChild(radioX);
    div.appendChild(labelX);
    div.appendChild(radio2);
    div.appendChild(label2);

// Append the div to the form
    form.appendChild(div);

// Create a submit button
    var submitButton = document.createElement('input');
    submitButton.type = 'submit';
    submitButton.value = 'Submit';

// Append the submit button to the form
    form.appendChild(submitButton);

// Append the form to the gameDiv
    gameDiv.appendChild(form);
}