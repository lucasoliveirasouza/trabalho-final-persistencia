class Modal{
	static render(titulo, descricao, ehSucesso){
		const divModal = document.createElement('div');
		divModal.setAttribute('id', 'container_modal');
		divModal.classList.value = 'modal fade show animated fadeInDown';
		
		const divModalDialog = document.createElement('div');
		divModalDialog.classList.add('modal-dialog');
		
		const divModalContent = document.createElement('div');
		divModalContent.classList.add('modal-content');
		
		const divModalHeader = document.createElement('div');
		divModalHeader.classList.add('modal-header');
		
		const title = document.createElement('h5');
		title.classList.add('modal-title');
		title.innerText = titulo;
		
		const iconeSucesso = document.createElement('i');
		iconeSucesso.classList.value = ehSucesso ? 'fas fa-laugh-beam' : 'fas fa-dizzy';
		iconeSucesso.style.color = ehSucesso ? 'green' : 'red';
		iconeSucesso.style.fontSize = '22pt';
		
		const modalBody = document.createElement('h5');
		modalBody.classList.add('modal-body');
		
		const modalDescricao = document.createElement('p');
		modalDescricao.innerText = descricao;
		
		const modalFooter = document.createElement('div');
		modalFooter.classList.value = 'd-flex justify-content-center modal-footer';
		
		const buttonClose = document.createElement('button');
		buttonClose.setAttribute('type', 'button');
		buttonClose.setAttribute('data-bs-dismiss', 'modal');
		buttonClose.classList.value = 'btn btn-secondary mt-3';
		buttonClose.innerText = 'Fechar';
		buttonClose.addEventListener('click', (ev) => {
			const divAlvo = ev.target.obtenhaParentes().find(parent => parent.getAttribute('id') == 'container_modal');
			if(divAlvo){
				divAlvo.classList.value = 'modal fade show animated bounceOutUp';
				setTimeout(() => {divAlvo.remove();}, 1000); 
			}
		});
		
		
		modalFooter.appendChild(buttonClose);
		modalBody.appendChild(modalDescricao);
		divModalHeader.appendChild(title);
		divModalHeader.appendChild(iconeSucesso);
		
		divModalContent.appendChild(divModalHeader);
		divModalContent.appendChild(modalBody);
		divModalContent.appendChild(modalFooter);
		
		divModalDialog.appendChild(divModalContent);
		
		divModal.appendChild(divModalDialog);
		
		const containerTarget = document.getElementById('container');
		if(containerTarget){
			containerTarget.appendChild(divModal);
			return;
		}
		
		throw new DOMException("Não existe um container para a modal");
	}
	
	static renderSucesso(titulo, texto){
		return this.render(titulo, texto, true);
	} 
	
	static renderErro(titulo, texto){
		return this.render(titulo, texto, false);
	} 
}