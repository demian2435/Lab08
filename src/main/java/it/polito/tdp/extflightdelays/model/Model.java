package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private ExtFlightDelaysDAO dao = new ExtFlightDelaysDAO();
	private Map<Integer, Airport> airportIdMap = new HashMap<Integer, Airport>();
	public Graph<Airport, DefaultWeightedEdge> g;

	public String creaGrafo(int miglia) {
		List<Airport> a = dao.loadAllAirports();
		a.forEach(x -> airportIdMap.put(x.getId(), x));

		g = new SimpleWeightedGraph<Airport, DefaultWeightedEdge>(DefaultWeightedEdge.class);

		Graphs.addAllVertices(g, a);

		List<CoppieFlight> coppie = dao.uniqueCoppieFlight(airportIdMap, miglia);

		for (CoppieFlight c : coppie) {
			try {
				DefaultWeightedEdge x = g.addEdge(c.getPartenza(), c.getArrivo());
				g.setEdgeWeight(x, c.getDistanza());
			} catch (Exception e) {
			}
		}

		String res = "Grafo creato: vertici " + g.vertexSet().size() + " - archi " + g.edgeSet().size();
		for (CoppieFlight c : coppie) {
			res = res + "\n" + c.getPartenza() + " - " + c.getArrivo() + " : " + c.getDistanza();
		}
		
		return res;
	}

}
