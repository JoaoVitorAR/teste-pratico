function buscarCEP() {
    
    var cep = document.getElementById("cep").value;
    var url = `https://viacep.com.br/ws/${cep}/json/`;

    console.log(cep);
    console.log(url);
    fetch(url)
        .then(response => response.json())
        .then(data => exibirResultado(data))
        .catch(error => console.error('Erro ao buscar CEP:', error));
}

function exibirResultado(data) {
    var resultado = document.getElementById("resultadoCEP");
    resultado.innerHTML = `
         ${data.cep}, 
         ${data.logradouro}, 
         ${data.bairro},
         ${data.localidade}/${data.uf}
    `;
}