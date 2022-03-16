//Crear preguntas
function crearPregunta() {
	var csrfToken = $("[name='_csrf']").attr("value");
	var url = document.getElementById("formPreguntas").action;
	if ($('#txtPregunta').val() != "") {
		fetch(url, {
			headers: {
				"Content-Type": "application/json; charset=utf-8",
				'X-CSRF-TOKEN': csrfToken
			},
			method: 'POST',
			credentials: 'same-origin',
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
	
}
/*function crearPregunta() {
event.preventDefault();
	try {
		let enlace = document.getElementById("formPreguntas").action;

		var csrfToken = $("[name='_csrf']").attr("value");

		fetch(enlace, {
			headers: { "Content-Type": "application/json; charset=utf-8", 'X-CSRF-TOKEN': csrfToken }, method: 'POST',
			credentials: 'same-origin',
			body: JSON.stringify({ pregunta: $('#Pregunta').val() })
		})
			.then(function(response) {
				if (response.ok) {
					return response.json();
				}
			})
			.then(response => {
				obtenerPreguntas();
			})
	} catch (error) {
		window.location('/usuario/login');
	}
}*/

	