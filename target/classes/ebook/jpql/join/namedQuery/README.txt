O uso de JPQL dinâmicas nos traz uma maior flexibilidade já que elas podem ser criadas em tempo de 
execução em qualquer lugar na aplicaçãi.Além disso não poluímos nossas entidades com várias named queries.
Em contrapartida erros de sintaxe na JPQL são encontrados mais facilmente com named queries, que elas são
validadas na inicialização da aplicação.

Outra vantagem de queries dinâmicas bastante negligenciadas é a possibilidade de uso de hot deploy da IDE.
Por ela ser definida em tempo de execução, podemos alterá-la sem ter que reiniciar o servidor web.

 