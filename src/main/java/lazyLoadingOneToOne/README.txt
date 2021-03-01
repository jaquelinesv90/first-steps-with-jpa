Lazy loading com @OneToOne

 utilizamos one-to-many e many-to-many para lazy loading como estratégia padrão.
 e utilizamos qualquer-coisa-para-um a estratégia eager loading como padrão.
 
O problema ocorre quando tentamos fazer a parte non-owner(o que não é dono) da relação se tornar lazy.
A parte não owner da relação é a que utilizamos o atributo mappedBy.

Acontece que, quando optamos em deixar essa parte como Lazy, simplesmente não funciona.A parte anotada com @OneToOne(mappedBy = "...")
acaba sendo carregada do mesmo jeito.




