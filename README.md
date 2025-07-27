<p align="center">
  <img src="https://hermes.digitalinnovation.one/assets/diome/logo.png" alt="Logo DIO" width="300"/>
</p>

# Desafio-Design-Patterns-Dio

Este projeto foi desenvolvido como parte do desafio da DIO sobre Design Patterns em Java com Spring Boot. O objetivo é aplicar os padrões de projeto **Facade** e **Strategy** na construção de uma API RESTful para um sistema de gestão de Petshop.

## 🚀 Tecnologias Utilizadas

* **Java 21:** Linguagem de programação.
* **Spring Boot 3.x:** Framework para construção da API REST.
* **Spring Data JPA:** Abstração para persistência de dados.
* **H2 Database:** Banco de dados em memória para desenvolvimento.
* **Maven:** Gerenciador de dependências do projeto.
* **Design Patterns:** Facade e Strategy.

## 📦 Funcionalidades da API

A API oferece endpoints para gerenciar informações de um Petshop, Tutores e Animais, demonstrando a aplicação dos padrões de projeto:

* **Gestão de Petshops:**
    * `GET /api/petshop/petshops`: Lista todos os petshops.
    * `GET /api/petshop/petshops/{id}`: Busca um petshop por ID.
    * `POST /api/petshop/petshops`: Cria um novo petshop.
    * `PUT /api/petshop/petshops/{id}`: Atualiza um petshop existente.
    * `DELETE /api/petshop/petshops/{id}`: Exclui um petshop.

* **Gestão de Tutores:**
    * `GET /api/petshop/tutores`: Lista todos os tutores.
    * `GET /api/petshop/tutores/{id}`: Busca um tutor por ID.
    * `POST /api/petshop/tutores`: Cria um novo tutor.
    * `PUT /api/petshop/tutores/{id}`: Atualiza um tutor existente.
    * `DELETE /api/petshop/tutores/{id}`: Exclui um tutor.
    * `GET /api/petshop/tutores/{tutorId}/animais`: Lista todos os animais de um tutor específico.

* **Gestão de Animais:**
    * `GET /api/petshop/animais`: Lista todos os animais.
    * `GET /api/petshop/animais/{id}`: Busca um animal por ID.
    * `POST /api/petshop/animais/tutor/{tutorId}`: Cria um novo animal associando-o a um tutor existente.
    * `PUT /api/petshop/animais/{id}`: Atualiza um animal existente.
    * `DELETE /api/petshop/animais/{id}`: Exclui um animal.

* **Filtro de Animais (Padrão Strategy):**
    * `GET /api/petshop/animais/filter?strategyType={tipoEstrategia}&criteria={criterio}`: Permite filtrar animais usando diferentes estratégias (ex: por espécie, por nome).
        * `strategyType`: Ex: `bySpeciesStrategy`, `byNameStrategy`.
        * `criteria`: O valor para o filtro (ex: `Cachorro`, `Rex`).

## ✨ Padrões de Projeto Aplicados

* **Facade (PetShopFacade):**
    * Fornece uma interface simplificada para o subsistema complexo de operações do Petshop (TutorService, AnimalService, PetShopService). O controlador interage apenas com a fachada, desacoplando-o da complexidade interna.
* **Strategy (FilterAnimalStrategy):**
    * Permite definir uma família de algoritmos (diferentes formas de filtrar animais) e encapsular cada um deles em uma classe separada (ex: `FilterBySpeciesStrategy`, `FilterByNameStrategy`). O serviço de filtro pode alternar entre essas estratégias em tempo de execução, tornando o código mais flexível e extensível.

