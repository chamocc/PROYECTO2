/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejo
 */
public void testMinimal(){
  graph.makeEdge("a","b","cost",(double)1);
  graph.makeEdge("a","c","cost",(double)1);
  graph.makeEdge("a","d","cost",(double)1);
  graph.makeEdge("a","e","cost",(double)1);
  graph.makeEdge("b","c","cost",(double)1);
  graph.makeEdge("c","d","cost",(double)1);
  graph.makeEdge("d","e","cost",(double)1);
  graph.makeEdge("e","b","cost",(double)1);
  FloydWarshall<Double> floydWarshall=new FloydWarshall<Double>(0.0,Double.MAX_VALUE,Direction.OUTGOING,CommonEvaluators.doubleCostEvaluator("cost"),new org.neo4j.graphalgo.impl.util.DoubleAdder(),new org.neo4j.graphalgo.impl.util.DoubleComparator(),graph.getAllNodes(),graph.getAllEdges());
  assertTrue(floydWarshall.getCost(graph.getNode("a"),graph.getNode("a")) == 0.0);
  assertTrue(floydWarshall.getCost(graph.getNode("a"),graph.getNode("b")) == 1.0);
  assertTrue(floydWarshall.getCost(graph.getNode("b"),graph.getNode("a")) == Double.MAX_VALUE);
}