/*
$(document).on("click", "#enviarPregunta", function() {
	br = document.createElement("br");
	div = document.getElementById("preguntas");
	div.innerHTML += "Pregunta: " + $('#txtPregunta').val();
	div.appendChild(br);
});
*/

//Crear preguntas
function crearPregunta() {
	if ($('#txtPregunta').val() != "") {
		fetch('/pregunta/crearPregunta', {
			headers: {
				'Content-type': 'application/json;charset=UTF-8'
				
			},
			method: 'POST',
			body: JSON.stringify({ pregunta: $('#txtPregunta').val() })
		})
			.then(function(response) {
				if (response.ok) {
					return response.json()
				} else {
					throw "Error";
				}
			}).then(pregunta => {
				br = document.createElement("br");
				div = document.getElementById("preguntas");
				div.innerHTML += "Pregunta: " + pregunta;
				div.appendChild(br);
			})
	}
}
function obtenerPreguntas(){
	