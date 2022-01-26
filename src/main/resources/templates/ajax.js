window.onload = inicio;

function inicio(){
    mostrarOfertas();
    
    $("#listaOfertas").on("click", "#borrar", function() {
        $(this).closest("tr").remove();
        var id = $(this).index();
        let ruta = "/borrar/"+id;
        window.location.href = ruta;
     });
}

function mostrarOfertas(){
    fetch('/ofertas', {headers: {"Content-Type": "application/json; charset=utf-8"}})
        .then(res => res.json()) // parse response as JSON (can be res.text() for plain response)
        .then(response => {
                for (let oferta of response) {
                let listaOfertas = document.getElementById("listaOfertas");
                let tr = document.createElement("tr");

                let tdId = document.createElement("td");
                tdId.textContent = oferta.id;
                let tdNombre = document.createElement("td");
                tdNombre.textContent = oferta.nombre;
                let tdPrecio = document.createElement("td");
                tdPrecio.textContent = oferta.precio;
                let tdInfo = document.createElement("td");
                let tdBorrar = document.createElement("td");

                if(oferta.prioridad == "Baja"){
                    tr.setAttribute("class", "table-active");
                }else if(oferta.prioridad == "Media"){
                    tr.setAttribute("class", "table-warning");
                }else if(oferta.prioridad == "Alta"){
                    tr.setAttribute("class", "table-danger");
                }


                let btnInfo = document.createElement("input");
                btnInfo.setAttribute("type", "button");
                btnInfo.setAttribute("class", "btn btn-info");
                btnInfo.setAttribute("id","info");
                btnInfo.setAttribute("value", "Info");

                let btnBorrar = document.createElement("input");
                btnBorrar.setAttribute("type", "button");
                btnBorrar.setAttribute("class", "btn btn-danger");
                btnBorrar.setAttribute("id","borrar");
                btnBorrar.setAttribute("value", "Borrar");

                tr.appendChild(tdId);
                tr.appendChild(tdNombre);
                tr.appendChild(tdPrecio);
                tdInfo.appendChild(btnInfo);
                tdBorrar.appendChild(btnBorrar);
                tr.appendChild(tdInfo);
                tr.appendChild(tdBorrar);
                listaOfertas.appendChild(tr);
            }
        })

}

function mostrarInfo(){
    $("#modal").modal("show");
    fetch('/ofertas/', {headers: {"Content-Type": "application/json; charset=utf-8"}})
        .then(res => res.json()) // parse response as JSON (can be res.text() for plain response)
        .then(oferta => {

            let modal = document.getElementById("modal-body");
            modal.replaceChildren();
            let p1 = document.createElement('p');
            p1.innerText=oferta.id;
            let p2 = document.createElement('p');
            p2.innerText=oferta.nombre;

            modal.appendChild(p1);
            modal.appendChild(p2);
        })
}

function borrarOferta(){
    fetch('/ofertas/', {headers: {"Content-Type": "application/json; charset=utf-8"}})
        .then(res => res.json()) // parse response as JSON (can be res.text() for plain response)
        .then(oferta => {
             
        })
}


