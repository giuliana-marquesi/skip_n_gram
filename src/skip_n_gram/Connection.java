package skip_n_gram;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Connection {

	public static void main(String args[]){
		
		OrientGraph graph = new OrientGraph("remote:localhost:2424/skip_n_gram");
		try {
			Vertex luca = graph.addVertex(null); // 1st OPERATION: IMPLICITLY BEGINS TRANSACTION
			luca.setProperty( "name", "Luca" );
			Vertex marko = graph.addVertex(null);
			marko.setProperty( "name", "Marko" );
			Edge lucaKnowsMarko = graph.addEdge(null, luca, marko, "knows");
			graph.commit();
			
		} finally {
		  graph.shutdown();
		}
	}

}
