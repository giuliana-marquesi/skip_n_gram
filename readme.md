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

	- [*] Baixar OrientDb e criar subi-lo
	- [*] Criar conexão no OrientDB com Java
	- [*] Criar vértices e arestas de exemplo
	- [*] Carregar asquivos txt
	- [*] Separar palavras por espaços
	- [ ] Eliminar os terminadores
	- [ ] Adicionar as palavras separadas como vértices e uni-las sequencialmente
	- [ ] Somente carregar para o BD arestas (ligações entre palavras) que ainda não existem
	- [ ] Contar frequencia dessa interação
	- [ ] Pular palavras (skip_n_gram)
	- [ ] Exportar visualização em grafo
	- [ ] Visualização deve ser pela "intesidade" que as relações aparecem
