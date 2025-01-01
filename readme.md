BOO - BANCO ORIENTADO A OBJETO

Desafio de Java Orientado a Objeto para construção de um sistema bancário no prompt


CONTEXTO:
Você foi contratado pelo BANCO OO para desenvolver um sistema bancário. A equipe de negócios requisitou que o sistema deve possuir as seguintes funcionalidades:

    1. Cadastrar Conta
    2. Acessar Conta
    3. Sair

No cadastro de contas, cliente deve indicar se a conta que deseja abrir é do tipo Corrente ou Poupança. Após, deve ser solicitado ao cliente que informe:

    1. Nome completo: campo textual;
    2. CPF: campo numérico;
    3. Endereço: campo textual;
    4. Telefone: campo textual;
    5. Senha: campo numérico;
    6. saldo: campo numérico, com duas casas decimais.

Ao submeter estes dados o sistema deve gerar randomicamente:

    1. número de agência: campo numérico, com 4 caracteres
    2. número da conta: campo numérico, com 5 caracteres. Veja este vídeo para te ajudar a realizar este item

REQUISITOS TÉCNICOS:

    Crie uma classe Pessoa (com os atributos nome, cpf, endereço e telefone) e inclua o objeto como atributo na classe Conta.
    As classes de ContaCorrente e ContaPoupaca são subclasses de Conta.
    Crie um objeto do tipo ContaCorrente ou ContaPoupanca conforme a indicação do cliente na criação de conta. Caso o tipo de conta seja corrente, solicite o cadastro de uma chave PIX.
    A classe conta deve ser gravada em uma variável global e os atributos localmente.
    O sistema deve retornar o número da agência, conta e uma mensagem de sucesso.
    A aplicação não deve ser encerrada após criar a conta, deve retornar para o menu inicial.

No menu Acessar Conta deve ser solicitado ao cliente que informe:
    1. agência;
    2. número da conta;
    3. senha

    Caso o cliente digite agência, número da conta ou senha inválidos, deve-se retornar qual dado está incorreto. Após, valide se a conta do cliente existe.
    Se for uma conta do tipo Corrente, exiba um menu com as seguintes funções:
    Depositar
    A conta deve receber o valor do depósito, somar ao saldo e retornar o valor do saldo atualizado.

Sacar
    A conta deve:
        1- receber o valor do saque que deverá ser realizado,
        2- validar se existem saldo disponível para que esse valor seja sacado,
        3- se tiver saldo, a conta de deverá subtrair o saldo pelo valor do saque
        4- retornar o valor do saldo atualizado, senão apenas retorne mensagem de saldo insuficiente.

Pix
    A conta deve receber a chave pix e o valor da transferência, validar a existência da chave e validar se o saldo é maior ou igual ao valor da transferência solicitada.
    Se sim, subtraia do saldo o valor do PIX e retorne um comprovante contendo: número da transação (gerado randomicamente), chave PIX da conta enviada e o valor transferido.
    Senão, apenas retorne mensagem de saldo insuficiente.
    Se for uma conta do tipo Poupança, exiba um menu com as seguintes funções:

Aplicar
    A conta deve receber o valor da aplicação, somar ao saldo, aplicar um rendimento de 1% ao valor total e retornar o valor do saldo atualizado.

Resgatar
    A conta deve receber o valor do resgate,
    Validar se o saldo for maior ou igual ao valor do resgate solicitado, subtrair o saldo pelo valor do resgate e retornar o valor do saldo atualizado, senão apenas retornar a mensagem de saldo insuficiente.
    Nos menus de conta corrente e conta poupança, devem conter também as funções:

Consultar o saldo
    Deve retornar o sado da conta logada.

Encerrar Conta
    Deve retornar mensagem de confirmação.
    Se a resposta for sim, apague a conta e volte para o menu inicial
    Senão, apenas retorne para o menu Acessar Conta.

Voltar
    Deve retornar ao menu Principal.
    Na opção Sair do menu principal a execução da aplicação deve ser encerrada.

Requisitos para aprovação:

Além dos critérios mencionados acima, também será considerado para aprovação que:
    - A aplicação rode, sem que seja necessário nenhum ajuste.
    - Sejam implementados os 3 pilares da Orientação a Objetos: Encapsulamento, Herança e Polimorfismo.
    - As validações solicitadas não podem retornar exceção sem tratamento.