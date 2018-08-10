package hw;

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;

public class Main {

  public static void main(final String[] args) {

    final Graph<String, DefaultEdge> myMap = new SimpleGraph<>(DefaultEdge.class);

    final String GH = CountryCodes.GH;
    final String MA = CountryCodes.MA;
    final String BF = CountryCodes.BF;
    final String LB = CountryCodes.LB;
    final String GN = CountryCodes.GN;
    final String IC = CountryCodes.IC;

    myMap.addVertex(IC);
    myMap.addVertex(GN);
    myMap.addVertex(LB);
    myMap.addVertex(BF);
    myMap.addVertex(MA);
    myMap.addVertex(GH);

    myMap.addEdge(IC, GN);
    myMap.addEdge(IC, LB);
    myMap.addEdge(IC, BF);
    myMap.addEdge(IC, MA);
    myMap.addEdge(IC, GH);
    myMap.addEdge(GN, LB);
    myMap.addEdge(GN, MA);
    myMap.addEdge(MA, BF);
    myMap.addEdge(BF, GH);

    System.out.println(myMap);

    final Iterator<String> bf = new BreadthFirstIterator<>(myMap, IC);
    while (bf.hasNext()) {
      final String country = bf.next();
      System.out.println("Breadth first IC start " + country);
    }
    final Iterator<String> bf1 = new BreadthFirstIterator<>(myMap, GN);
    while (bf1.hasNext()) {
      final String country = bf1.next();
      System.out.println("Breadth first GN start " + country);
    }
    final Iterator<String> cf = new ClosestFirstIterator<>(myMap, IC);
    while (cf.hasNext()) {
      final String country = cf.next();
      System.out.println("Closest first IC start " + country);
    }
    final Iterator<String> cf1 = new ClosestFirstIterator<>(myMap, GN);
    while (cf1.hasNext()) {
      final String country = cf1.next();
      System.out.println("Closest first GN start " + country);
    }
    final Iterator<String> df = new DepthFirstIterator<>(myMap, IC);
    while (df.hasNext()) {
      final String country = df.next();
      System.out.println("Depth first IC start " + country);
    }
    final Iterator<String> df1 = new DepthFirstIterator<>(myMap, GN);
    while (df1.hasNext()) {
      final String country = df1.next();
      System.out.println("Depth first GN start " + country);
    }
    final Iterator<String> rw = new RandomWalkIterator<>(myMap, IC, false, 9);
    while (rw.hasNext()) {
      final String country = rw.next();
      System.out.println("Random walk IC start " + country);
    }
    final Iterator<String> rw1 = new RandomWalkIterator<>(myMap, GN, false, 9);
    while (rw1.hasNext()) {
      final String country = rw1.next();
      System.out.println("Random walk GN start " + country);
    }
    GreedyColoring colorGraph = new GreedyColoring(myMap);

    System.out.println(colorGraph.getColoring());
  }
}
