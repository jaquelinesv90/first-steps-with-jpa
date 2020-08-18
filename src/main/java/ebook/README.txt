**conteúdo disponivel ebook - algaworks- JPA- Guia Definitivo

Gerenciando estados

3.1. Estados e ciclo de vida

Objetos de entidade são instâncias de classes mapeadas usando JPA, que ficam na memória e representam registros
do banco de dados.Essas instâncias possuem um ciclo de vida, que é gerenciado pelo JPA.

Os estados do ciclo de vida das entidades são: transient(ou new), managed, detached e removed.

As transições entre os estados são feitas através de métodos do EntityManager.

Transient: são instanciados usando o operador new.Não afeta os registros do banco.

Managed: objetos gerenciados, são instancias de entidade que possuem um identificador e representam um registro
da tabela do banco de dados.Ex. um objeto persistido através de um método do EntityManager,  como o persist.
Objetos gerenciados estão sempre associados a um contexto de persistência, ou seja, qualquer alteração 
nesses objetos são sincronizadas com o banco de dados.

Removed: uma instância de uma entidade pode ser excluída através do método remove do EntityManager.
Um objeto entra no estado removed quando ele é marcado para ser eliminado, mas é fisicamente excluído durante a
sincronização com o banco de dados.

Detached:Um objeto sempre inicia no estado 'transient' e depois pode se tornar gerenciado. Quando o EntityManager pe fechado,
continua existindo uma instância do objeto, mas já no estado detached.Esse estado existe para quando os objetos estão 
desconectados, não tendo mais sincronia com o banco de dados.A JPA fornece operações para reconectar esses objetos a um 
novo EntityManager.


Contexto de persistencia
É uma coleção de objetos gerenciados por um EntityManager.Se uma entidade é pesquisada, mas ela já existe no contexto de
persistencia, o objeto é retornado sem acessar o banco de dados.Esse recurso é chamado de cache de primeiro nível.
Uma mesma entidade pode ser representada por diferentes objetos na memória, desde que seja em diferentes instâncias 
de EntityManagers. Em uma única instancia de EntityManager, apenas um objeto que representa determinada entidade(com o
mesmo identificador) pode ser gerenciada.pág 47

Objetos desanexados
São objetos em um estado que não é gerenciado pelo EntityManager,mas ainda representam entidades no banco.
As alterações em objetos desanexados não são sincronizadas com o banco de dados.














