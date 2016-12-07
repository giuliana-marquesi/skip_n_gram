#**Projeto para implementar skip_n_gram**

##*- O que é o skip_n_gram?*

n-gram é uma unidade de medida que determina "n" sequencian de palavras ou letras.


[O que a poderosa Wikipedia diz sobre](https://en.wikipedia.org/wiki/N-gram "Wikipedia sobre n_gram")

[Google contador de n-grams](https://books.google.com/ngrams/graph?content=n%C3%A3o%2Centendi%2Cmesmo&year_start=1800&year_end=2000&corpus=18&smoothing=3&share=&direct_url=t1%3B%2Cn%C3%A3o%3B%2Cc0%3B.t1%3B%2Centendi%3B%2Cc0%3B.t1%3B%2Cmesmo%3B%2Cc0 "Google Books n-grams")


##*- Do projeto:*
	
este projeto tem como objetivo contar a frequencia de determinados n-grams em um determinado texto. Porém pulando uma certa quantia de caracteres ou palavras, por isso o skip.

##*- Grafos:*
	
Para a visualização dos dados e também a persistência deles. Foi escolhido o banco de dados OrientDB, que é orientado a grafos e classes.

##*- O que precisamos fazer:*

- [X] Baixar OrientDb e criar subi-lo
- [X] Criar conexão no OrientDB com Java
- [X] Criar vértices e arestas de exemplo
- [X] Carregar asquivos txt
- [X] Separar palavras por espaços
- [X] Eliminar os terminadores
- [X] Adicionar as palavras separadas como vértices e uni-las sequencialmente
- [ ] Somente carregar para o BD arestas (ligações entre palavras) que ainda não existem
- [ ] Contar frequencia dessa interação
- [ ] Pular palavras (skip_n_gram)
- [ ] Exportar visualização em grafo
- [ ] Visualização deve ser pela "intesidade" que as relações aparecem

###Links OrientDB:

[Vértices e Arestas na API](http://orientdb.com/docs/last/Graph-VE.html)

[Gremlin API](http://orientdb.com/docs/last/Gremlin.html)

[Documentacao ThinkerPop](http://tinkerpop.apache.org/)

[Modelagem de dados](http://orientdb.com/docs/last/Concepts.html)

[Melhorando a performance](http://orientdb.com/docs/last/Performance-Tuning.html)
