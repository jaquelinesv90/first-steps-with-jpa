- Os sistemas que usam JPA precisam de apenas uma instância de EntityManagerFactory,
que pode ser criada durante a inicialização da aplicação.
Esta única instância pode ser usada por qualquer código que queira obter um EntityManager.

- Um EntityManager é responsável por gerenciar entidades no contexto de persistência.
Através dos métodos dessa interface, é possível persistir, pesquisar e excluir objetos do
 banco de dados.
