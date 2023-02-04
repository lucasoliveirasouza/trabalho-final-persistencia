function monteMensagem(elemento, header, body){
	elemento.classList.value = 'form-control animated shake invalido';
	Modal.renderErro(header, body);
}
		
function removaEstadoInvalido(elemento){
	elemento.classList.remove('animated');
	elemento.classList.remove('shake');
	elemento.classList.remove('invalido');	
}

HTMLElement.prototype.obtenhaParentes = function (parentSelector) {
    const parents = [];
    let oldParent = this.parentNode;

    if (parentSelector === undefined) {
        while (oldParent !== document) {
            const newParent = oldParent;
            parents.push(newParent);
            oldParent = newParent.parentNode;
        }

        parents.push(document);
    } else {
        const possiveisPais = document.querySelectorAll(parentSelector).toArray();

        while (oldParent.parentElement) {
            const newParent = oldParent;
            if (possiveisPais.includes(newParent)) {
                parents.push(newParent);
            }
            oldParent = newParent.parentNode;
        }
    }
    
    return parents;
}