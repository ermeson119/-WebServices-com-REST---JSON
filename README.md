# Projeto de Web Services com REST: PESSOA e TELEFONE

Este projeto foi desenvolvido com base nas notas de aula e no material (código) apresentado em sala durante a exposição do conteúdo sobre Web Services com REST e JSON. O objetivo é criar um web service REST usando Spring Boot, que implemente um CRUD completo para as classes **Pessoa** e **Telefone**, utilizando o banco de dados H2.

## Requisitos do Projeto

Os estudantes deverão seguir as seguintes etapas para o desenvolvimento do projeto:

1. **Escolha do Tema**: 
   O tema escolhido é **PESSOA e TELEFONE**, que representa a relação entre uma pessoa e seus telefones, configurada como uma agregação 1 para n.

2. **Análise de Negócio**:
   A análise do tema identifica as classes **Pessoa** e **Telefone**, que se relacionam de forma agregada. Cada pessoa pode ter vários telefones associados.

   - **Classe Pessoa**:
     - `id`: Integer
     - `nome`: String
     - `telefones`: List<Telefone> (relação 1 para n)

   - **Classe Telefone**:
     - `id`: Integer
     - `dd`: String
     - `numero`: String

3. **Implementação das Classes**:
   Implementar as classes **Pessoa** e **Telefone** em Java, seguindo os padrões expostos em sala, usando Spring Boot e o banco de dados H2. As classes devem substituir as classes Livro e Autor do exemplo original.

4. **Modificação do Código para Web Service REST**:
   Implementar um CRUD REST com as seguintes funcionalidades para as classes:

   - **4.1 Exibição de Todos os Objetos**: 
     Exibir todos os objetos da classe principal (Pessoa), incluindo os telefones associados.

   - **4.2 Exibição de Elemento Individual**: 
     Exibir um elemento individual de Pessoa ou Telefone, mediante o ID passado na URL.

   - **4.3 Inserção de Objetos**: 
     Inserir novos objetos de Pessoa e Telefone, com os dados passados no corpo da chamada.

   - **4.4 Exclusão de Elementos**: 
     Excluir elementos das tabelas Pessoa ou Telefone com base em um ID passado na URL.

   - **4.5 Alteração de Elementos**: 
     Alterar um elemento das tabelas com base em um ID passado na URL e dados fornecidos no corpo da chamada.

5. **Testes**:
   O web service REST desenvolvido será testado usando SOAPUI ou a interface Swagger-UI (incluindo a dependência `springdoc-openapi-starter-webmvc-ui`).

6. **Configuração do Banco de Dados H2**:
   - Alterar o `application.properties` para configurar o banco H2 como persistente:
     ```properties
     spring.datasource.url=jdbc:h2:file:~/test
     spring.h2.console.enabled=true
     spring.h2.console.path=/h2-console
     ```
   - Acessar o banco de dados via interface web no endereço: [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

## Regras do Trabalho

- As classes **Livro** e **Autor** não podem ser utilizadas no trabalho.
- Trabalho preferencialmente em duplas ou trios; grupos com mais de 3 estudantes não serão aceitos.
- O tema escolhido deve ser divulgado no grupo do WhatsApp. Temas iguais serão considerados como cópia e a nota será dividida entre os grupos.
- Valor: 100 pontos.

## Extras

Os seguintes itens extras poderão agregar até 50% na nota final:

- Implementar um relacionamento n para n bidirecional, com lista dos elementos da outra classe em cada classe, resolvendo o problema de loop do JSON.

## Exemplos e Referências

Utilize os exemplos disponibilizados em nossa conta do GitHub para referência:

- [Exemplo 1: Web Service de Livraria com REST](link_do_exemplo_1)
- [Exemplo 2: Web Service de Biblioteca com REST](link_do_exemplo_2)

Certifique-se de seguir os padrões e orientações descritos nas notas de aula e exemplos para garantir a conformidade do trabalho.

## Autores

- **Pessoa**
- **Telefone**

---

**Nota**: A execução correta de todas as etapas descritas garantirá a totalidade da pontuação. Leia atentamente as instruções para evitar erros que possam impactar na nota final.
