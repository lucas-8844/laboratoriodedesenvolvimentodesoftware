# Laboratorio 3 De Desenvolvimento De Software 
INTEGRANTES:
- Lucas Carvalho Peres 
- Matheus Pretti de Oliva

# Histórias de Usuário — Sistema de Moeda Estudantil

## 1. Cadastro e Autenticação

### História 1.1 — Cadastro de Aluno
**Como** aluno,  
**quero** me cadastrar informando meus dados pessoais e acadêmicos,  
**para que** eu possa participar do programa de moeda estudantil.

**Critérios de aceitação:**
- O sistema deve validar CPF, email e verificar se a instituição existe.
- O cadastro só será aceito se todos os campos obrigatórios forem preenchidos corretamente.

---

### História 1.2 — Login de Usuário
**Como** usuário (aluno, professor ou empresa),  
**quero** fazer login com email e senha,  
**para que** eu possa acessar minha conta com segurança.

**Critérios de aceitação:**
- O sistema deve autenticar com base nas credenciais.
- Mensagem de erro deve ser exibida em caso de falha na autenticação.

---

## 2. Envio e Recebimento de Moedas

### História 2.1 — Enviar Moedas ao Aluno
**Como** professor,  
**quero** enviar moedas para meus alunos com uma mensagem de reconhecimento,  
**para que** eu possa valorizar seu desempenho e comportamento em aula.

**Critérios de aceitação:**
- O professor deve ter saldo suficiente para enviar as moedas.
- A mensagem de reconhecimento é obrigatória.
- O saldo do professor deve ser atualizado após o envio.

---

### História 2.2 — Notificação por E-mail ao Aluno
**Como** aluno,  
**quero** ser notificado por e-mail ao receber moedas,  
**para que** eu saiba que fui reconhecido por um professor.

**Critérios de aceitação:**
- O email deve conter a quantidade recebida, o nome do professor e a mensagem enviada.

---

## 3. Consultar Extrato

### História 3.1 — Extrato do Aluno
**Como** aluno,  
**quero** consultar meu extrato de transações,  
**para que** eu possa visualizar o histórico de moedas recebidas e trocadas.

---

### História 3.2 — Extrato do Professor
**Como** professor,  
**quero** visualizar o extrato de moedas enviadas,  
**para que** eu possa acompanhar como utilizei meu saldo ao longo do tempo.

---

## 4. Resgate de Vantagens

### História 4.1 — Resgatar Vantagem
**Como** aluno,  
**quero** trocar minhas moedas por produtos ou descontos cadastrados,  
**para que** eu possa usufruir dos benefícios oferecidos pelas empresas parceiras.

**Critérios de aceitação:**
- O aluno só poderá resgatar uma vantagem se tiver saldo suficiente.
- O saldo será descontado após a troca.
- Um cupom com código único será enviado ao aluno e à empresa parceira.

---

### História 4.2 — Notificação à Empresa Parceira
**Como** empresa parceira,  
**quero** receber um e-mail com o código do cupom gerado,  
**para que** eu possa verificar e validar a troca realizada por um aluno.

---

## 5. Cadastro de Vantagens

### História 5.1 — Cadastrar Vantagens
**Como** empresa parceira,  
**quero** cadastrar vantagens com descrição, custo e imagem,  
**para que** os alunos possam visualizar e resgatar essas ofertas.

**Critérios de aceitação:**
- Todos os campos devem ser obrigatórios no cadastro da vantagem.
- A imagem deve ser exibida junto da descrição para os alunos.

---

## 6. Gestão de Moedas

### História 6.1 — Recarregar Saldo por Semestre
**Como** professor,  
**quero** ter mil moedas adicionadas ao meu saldo no início de cada semestre,  
**para que** eu possa continuar reconhecendo alunos continuamente.

**Critérios de aceitação:**
- O saldo é cumulativo, ou seja, moedas não utilizadas permanecem disponíveis no semestre seguinte.


## Diagrama de Casos de uso
![Diagrama de casos de uso](https://github.com/lucas-8844/laboratoriodedesenvolvimentodesoftware/blob/Laborat%C3%B3rio-3/Diagramas/Casos%20de%20uso.jpeg?raw=true)




## Diagrama de Classe

![Diagrama de Classe 2](https://github.com/lucas-8844/laboratoriodedesenvolvimentodesoftware/blob/Laborat%C3%B3rio-3/Diagramas/diagrama%20de%20classes.jpeg?raw=true)


## Diagrama de Componentes




