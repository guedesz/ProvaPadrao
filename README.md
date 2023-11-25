ALUNO: Gustavo Luis Guedes da Rosa


Etapa 1:
Foram usados Injeção de Dependência Esse padrão permite que as dependências sejam injetadas de fora da classe, tornando-a mais flexível e fácil de testar, podendo trocar de provedor de pagamento facilmente, também utiliza o principio  open/closed em vista que não precisamos mudar o código de outros provedores para criar um novo e por fim utilizando principio de responsabilidade única .

Etapa 2:
Utilizei Singletone para a criação do Carrinho de Compras uma vez que ele deve ser único para cada usuário e usando o princípio de responsabilidade única.

Etapa 3:
Utilizei Observe Pattern onde o LogisticAgent fica escutando o Ecommerce e. sempre que uma ordem for success ou cancelled o evento acontece e também usei Injeção de dependência para não violar o princípio open/closed e ter a opção de criar outros agentes sem modificar o código antigo. 