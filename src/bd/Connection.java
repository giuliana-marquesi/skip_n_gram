package bd;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Connection {
	
	public OrientGraph graph;
	
	public Connection() {
		System.out.println("instanciou o Connection");
	}
	
	public void connectGraph() {
		try {
			graph = new OrientGraph("remote:localhost:2424/s_n_g");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public void closeConnection(){
		graph.shutdown();
	}

	protected OrientGraph getGraph(){
		return graph;
	}
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	public void rollback() {
		// TODO Auto-generated method stub
		
	}
}
