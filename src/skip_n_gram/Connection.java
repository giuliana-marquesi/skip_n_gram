package skip_n_gram;

import com.tinkerpop.blueprints.impls.orient.OrientGraph;

public class Connection {
	
	public OrientGraph graph;
	
	public Connection() {
		
		try {
			graph = new OrientGraph("remote:localhost:2424/s_n_g", "root", "root");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public OrientGraph getConn() {
		return graph;
	}
}
