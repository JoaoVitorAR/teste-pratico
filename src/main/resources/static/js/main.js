const dataAtual = new Date();
const dataFormatada = `${String(dataAtual.getDate()).padStart(2, '0')}/${String(dataAtual.getMonth() + 1).padStart(2, '0')}/${dataAtual.getFullYear()}`;
document.getElementById('dataFormatada').textContent = `${dataFormatada}`;

function buscarCEP() {
    
    let cep = document.getElementById('cep').value;
    let url = `https://viacep.com.br/ws/${cep}/json/`;
    fetch(url)
        .then(response => response.json())
        .then(data => exibirResultado(data))
        .catch(error => console.error('Erro ao buscar CEP:', error));

}

function exibirResultado(data) {
    document.getElementById('resultadoCEP').value = (
        `${data.cep}, 
        ${data.logradouro}, 
        ${data.bairro},
        ${data.localidade}/${data.uf}`
    );
}

function InserirProduto() {
    var e = document.getElementById("produto");
    var produtoId = e.value;
    var produto = e.options[e.selectedIndex].text;
    let quantidade = document.getElementById('quantidade').value;
    let total = obterValorElemento();
    var preco_unitario = 0;
    var valorTotalProduto = 0;
    
    $.ajax({
        url: 'RecuperaValorProdutoPorId?produtoId=' + produtoId,
        type: 'get',
        DataType: 'json',
        success: function(preco) {
            preco_unitario = preco;
            valorTotalProduto = quantidade * preco;        
            let valorTotal = parseFloat(total);
            valorTotal += (quantidade * preco);
            document.getElementById('listaProdutos').value = valorTotal.toFixed(2);    
            preencheTabela(produtoId, produto, preco_unitario, quantidade, valorTotalProduto);
        },
        error: function(e) {
            console.error(e);
        }
    });
       
}

function preencheTabela(codigo_produto, descricao_produto, preco_unitario, quantidade, total_produto ){
    var tabela = document.getElementById("tableProduto");

    if (tabela.rows.length > 1){
        var ultimaLinha = tabela.rows[tabela.rows.length - 1];
        var primeiraCelula = ultimaLinha.cells[0];
        var num_item = parseInt(primeiraCelula.innerText) + 1;  
    } 

    var novaLinha = tabela.insertRow();
    var cel1= novaLinha.insertCell(0);
    var cel2= novaLinha.insertCell(1);
    var cel3= novaLinha.insertCell(2);
    var cel4= novaLinha.insertCell(3);
    var cel5= novaLinha.insertCell(4);
    var cel6= novaLinha.insertCell(5);

    if (num_item == undefined) {
        num_item = 1;
    }

    cel1.innerHTML = String(num_item).padStart(3,0);
    cel2.innerHTML = codigo_produto;
    cel3.innerHTML = descricao_produto;
    cel4.innerHTML = preco_unitario;
    cel5.innerHTML = quantidade;
    cel6.innerHTML = total_produto;  
}

function obterValorElemento() {
    return parseFloat(document.getElementById('listaProdutos').value) || 0;
}


$(document).ready(function(){
    $("#formVenda").submit(function(event){
        event.preventDefault();

        var clienteId = document.getElementById("cliente");

        var formData = {
            id: 0,
            num_item: 0,
            produto_id: 0,
            cliente_id: clienteId.value,
            quantidade: 0,
            total_compra: $("#listaProdutos").val(),
            cep: $("#cep").val(),
            endereco: $("#resultadoCEP").val()
        }
        console.log(formData)

        $.ajax({
            type: "POST",
            url: "/InsertVendas",
            data: formData,
            success: function(data) {
                alert("Venda realizada com sucesso.");
            },
            error: function(xhr, status, error) {
                var responseJSON = JSON.parse(xhr.responseText);
                var errorMessage = responseJSON.errorMessage;
                alert("Erro: " + errorMessage);
            }
        });

        window.location.href="/listarVendas"
    });
});