package src.skip_n_gram;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Connection {
	
	private OrientGraph graph;
	
	public Connection() {
		
		try {
			graph = new OrientGraph("remote:localhost:2424/skip_n_gram");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public OrientGraph getConnectedGraph(){
		
		return graph;
		  
	}
	
	public void closeConnection(){
		graph.shutdown();
	}
	
}


