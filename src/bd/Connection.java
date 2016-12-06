package bd;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Connection {
	
	public OrientGraph graph;
	
	public Connection() {
		
		try {
			graph = new OrientGraph("remote:localhost:2424/s_n_g");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public OrientGraph connectGraph() {
		return graph;
	}

	public void closeConnection(){
		graph.shutdown();
	}

	public void commit() {
		// TODO Auto-generated method stub
		
	}

	public void rollback() {
		// TODO Auto-generated method stub
		
	}
}
