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


1.Contexto de persistencia
É uma coleção de objetos gerenciados por um EntityManager.Se uma entidade é pesquisada, mas ela já existe no contexto de
persistencia, o objeto é retornado sem acessar o banco de dados.Esse recurso é chamado de cache de primeiro nível.
Uma mesma entidade pode ser representada por diferentes objetos na memória, desde que seja em diferentes instâncias 
de EntityManagers. Em uma única instancia de EntityManager, apenas um objeto que representa determinada entidade(com o
mesmo identificador) pode ser gerenciada.pág 47

2.Objetos desanexados
São objetos em um estado que não é gerenciado pelo EntityManager,mas ainda representam entidades no banco.
As alterações em objetos desanexados não são sincronizadas com o banco de dados.Utilizamos objetos desanexados, por exemplo,
quando eles são expostos para alteração através de páginas web e apenas em um segundo momento o usuário solicita a 
gravação das alterações do objeto.

*Regras para implementação de chaves primárias compostas
- É uma classe POJO.
- É uma classe pública com um construtor público sem argumento.
- Se você usar o acesso baseado em propriedade, as propriedades da classe de chave primária serão públicas ou protegidas.
- É serializável.
- Ele define os métodos equals e hashCode. A semântica de igualdade de valor para esses métodos deve ser consistente com a
igualdade do banco de dados para os tipos de banco de dados para os quais a chave é mapeada.
- Uma instância do EmbeddedId é usada com a operação EntityManager find (), para encontrar uma entidade por seu id.

3.Objetos embutidos
Objetos embutidos são componenetes de uma entidade, cujas propriedades são mapeadas para a mesma tabela da entidade.
Em algumas situação, podemos precisar usar a orientação a objetos para componentizar nossas entidades, mas manter os
dados  em uma única tabela.Outra situação comum é o mapeamento de tabelas de banco de dados legados, onde não é permitido
alterar a estrutura das tabelas.

4.Mapeamento entidades

Mapeamento um-para-um
@OneToOne

Veiculo 1 ---> 1 proprietario
 
implementação unidirecional:
*obtem-se o proprietário a partir de um veículo
Na classe veículo adicione o atributo proprietario, mapeando com OneToOne
adicione também a anotação @JoinColumn(name = "cod_proprietario")


implementação bidirecional:
*obtem-se o proprietário a partir de um veículo e o veículo a partir de um propritário
Na classe veículo adicione o atributo proprietario, mapeando com @OneToOne
adicione também a anotação @JoinColumn(name = "cod_proprietario")

Na classe proprietario  adicione o atributo veiculo, mapeando com @OneToOne
mappedBy "proprietario".
ex:   @OneToOne(mappedBy = "proprietario")
	  private Veiculo veiculo;

5.Mapeamento muitos-para-um
conhecido como @Many-to-one
*um veículo poderá possuir apenas um proprietário, mas um proprietário
poderá estar associado a muitos veículos.
A anotação @ManyToOne indica a multiplicidade do relacionamento entre
veículo e proprietário

Veiculo * ---> 1 proprietario

Na classe Veiculo adicionar 
    @ManyToOne
    @JoinColumn(name = "proprietario_codigo")
    private Proprietario proprietario;
 Caso queira se fazer a associação bidirecional mapear um atributo na 
 entidade owner com - @OneToMany.
 
    
 Mapeamento um-para-muitos
 conhecido como @OneToMany
 deve ser utilizada para mapear coleções

Veiculo * --->1 proprietario

na classe proprietario adicionar
	@OneToMany(mappedBy = "proprietario")
	private List<Veiculo> veiculos;


Mapemento muitos-para-muitos
conhecido como many-to-many

Veiculo* ----- * Acessorio

*relacionamentos muito-para-muitos necessitam de tabela associativa
o jpa possui um recursso de schema generation que poderá recriar as tabelas automaticamente.


