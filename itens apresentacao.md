
### Dificuldades
* LightEdges
* versões de ambiente
* Conexões
* terminadores
* criar tratamento para excessões de fato
* usar as querys diferentes do banco de dados

### Estratégia
* uso do git
* separar em partes para conseguir avançar
* separar em pacotes por consequencia

### Apresentar
* o que seria o n-gram
* e o skip-gram
* orientdb - grafos
* sequencia cronologica da visualização

When using Lightweight Edges, OrientDB stores edges as links rather than records. This improves performance, but as a consequence, the .getEdges() method only retrieves records of the class E. When using Lightweight Edges, OrientDB only creates records in class E under certain circumstances, such as when the edge has properties. Otherwise, the edges exist as links on the in and out vertices.

If you want to use .getEdges() to return all edges, disable the Lightweight Edges feature by executing the following command:

orientdb> ALTER DATABASE my_db useLightweightEdges=FALSE

You only need to run this command once to disable Lightweight Edges. The change only takes effect on edges you create after running it. For existing edges, you need to convert them from links to actual edges before the .getEdges() method returns all edges. For more information, see Troubleshooting.