document.addEventListener('DOMContentLoaded', () => {
  const formAluno = document.getElementById('form-aluno');
  const nomeInput = document.getElementById('nome');
  const emailInput = document.getElementById('email');
  const listaAlunos = document.getElementById('lista-alunos');
  const listaEmpresas = document.getElementById('lista-empresas');

  // Função para cadastrar aluno
  formAluno.addEventListener('submit', (event) => {
    event.preventDefault();

    const nome = nomeInput.value;
    const email = emailInput.value;

    // Envia os dados para o back-end
    fetch('http://localhost:8080/alunos', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        nome,
        email
      }),
    })
    .then(response => response.json())
    .then(data => {
      alert('Aluno cadastrado com sucesso!');
      listarAlunos();
    })
    .catch(error => console.error('Erro ao cadastrar aluno:', error));
  });

  // Função para listar alunos
  function listarAlunos() {
    fetch('http://localhost:8080/alunos')
      .then(response => response.json())
      .then(data => {
        listaAlunos.innerHTML = '';
        data.forEach(aluno => {
          const li = document.createElement('li');
          li.textContent = `${aluno.nome} - ${aluno.email}`;
          listaAlunos.appendChild(li);
        });
      })
      .catch(error => console.error('Erro ao listar alunos:', error));
  }

  // Função para listar empresas parceiras
  function listarEmpresas() {
    fetch('http://localhost:8080/empresas')
      .then(response => response.json())
      .then(data => {
        listaEmpresas.innerHTML = '';
        data.forEach(empresa => {
          const li = document.createElement('li');
          li.textContent = empresa.nome;
          listaEmpresas.appendChild(li);
        });
      })
      .catch(error => console.error('Erro ao listar empresas:', error));
  }

  // Carregar dados na página
  listarAlunos();
  listarEmpresas();
});
