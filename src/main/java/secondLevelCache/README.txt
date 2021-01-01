Cache de segundo nível


Ele pode te ajudar a resolver alguns problemas de performance, reduzindo o número de consultas ao banco de dados.
Existem 3 tipos de cache no contexto do hibernate.
1 - Session cache(first level): Cache de sessão, ou seja, quando você abrir uma sessão no hibernate, ele vai fazer um cache, 
fechou a sessão aquele cache é encerrado.Se você abriu uma sessão salvou o objeto e precisou consultar ele, não vai
fazer uma consulta novamente, ele permanece naquele cache mas isso dentro da mesma sessão.
2 - (second level) Responsável por fazer cache entre várias sessões do hibernate.Ele funciona dentro de uma mesma SessionFactory
Normalmente é uma sessionFactory por aplicação.
3 - QueryCache : é usado para cachear o resultado de uma query, então ele faz a associação entre uma query seus parametros.



