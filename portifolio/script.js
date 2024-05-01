$(document).ready(function(){
    // Adiciona animação de rolagem suave para os links do menu
    $("a").on('click', function(event) {
        if (this.hash !== "") {
            event.preventDefault();
            var hash = this.hash;
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 1000, function(){
                window.location.hash = hash;
            });
        }
    });

    // Função para rolar a página de volta para o topo
    function voltarAoTopo() {
        if (document.body.scrollTop !== 0 || document.documentElement.scrollTop !== 0) {
            window.scrollBy(0, -50); // Velocidade da rolagem ajustável, quanto menor o número, mais rápida a rolagem
            requestAnimationFrame(voltarAoTopo);
        }
    }

    // Adicionando um evento de clique ao botão
    $("#voltarAoTopo").on("click", function() {
        voltarAoTopo();
    });
});