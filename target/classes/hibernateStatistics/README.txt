Alguma vez você ja se perguntou porque uma solicitação de servidor demorou tanto no sistema de produção 
enquanto na sua máquina local estava funcionando perfeitamente?
Quedas estranhas de desempenho costumam estar relacionadas a consultas lentas ao banco de dados.De que forma 
encontrar a solução ? Implementando hibernate statistics. Ele fornece informações necessárias para analisar as consultas
de banco de dados.

A primeira coisa que precisamos fazer é dizer ao Hibernate para gerar as estatisticas para nós.Portanto, precisamos
definir a propriedade do sistema hibernate.generate_statistics como true.As estatisticas são desativadas por padrão 
porque tem uma influencia negativa no desempenho.Portanto, ative-os, apenas quando precisar deles.

Agora o hibernate irá escrever uma declaração de log de várias linhas com informações estatisticas no final da sessão.
Isso é muito útil para obter uma visão geral de quanto tempo foi gasto na comunicação do banco de dados.Mas, na maioria dos
casos, precisamos de mais informações.Precisamos saber se houve um problema de desempenho geral.Portanto, gostaríamos de regis-
trar o tempo de execução de cada consulta.Isso pode ser feito definindo o nível de log de org.hibernate.stat como DEBUG.

As estatisticas gerais fornecem informações sobre o número de conexões e instruções JDBC, o uso do cache e as liberações realizadas.
Aqui, você deve sempre verificar o número de afirmações primeiro.Muitos problemas de desempenho são causados por problemas de seleção
N+1 que podem resultar em muitas consultas adicionais.




