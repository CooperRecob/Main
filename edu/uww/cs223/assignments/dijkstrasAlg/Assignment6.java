package edu.uww.cs223.assignments.dijkstrasAlg;

import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Assignment6 {
	// DO NOT MODIFY
	private static final double[][] adjMatrix = new double[51][51];
	private static final String[] cities = new String[51];

	public static void main(String[] args) {
		fileToAdjacencyMatrix("distances.csv");

		dijkstra(cityToIndex("Portland ME"), cityToIndex("Seattle WA"));
		System.out.println();

		dijkstra(cityToIndex("Jacksonville FL"), cityToIndex("Seattle WA"));
		System.out.println();

		dijkstra(cityToIndex("Boston MA"), cityToIndex("Los Angeles CA"));
		System.out.println();

		dijkstra(cityToIndex("New York City NY"), cityToIndex("Los Angeles CA"));
		System.out.println();

		dijkstra(cityToIndex("Chicago IL"), cityToIndex("Honolulu HI"));
		System.out.println();

		dijkstra(cityToIndex("Nashville TN"), cityToIndex("Milwaukee WI"));
		System.out.println();

		dijkstra(cityToIndex("Milwaukee WI"), cityToIndex("Anchorage AK"));
		System.out.println();

		dijkstra(cityToIndex("Charlotte NC"), cityToIndex("Houston TX"));
		System.out.println();

		dijkstra(cityToIndex("Albuquerque NM"), cityToIndex("Portland OR"));
		System.out.println();

		dijkstra(cityToIndex("Philadelphia PA"), cityToIndex("Las Vegas NV"));
		System.out.println();
	}
	// END DO NOT MODIFY

	private static void fileToAdjacencyMatrix(String path) {
		try {
			Scanner scanner = new Scanner(new File(path));
			scanner.nextLine();
			for (int i = 0; i < 51; i++) {
				String[] line = scanner.nextLine().split(",");
				cities[i] = line[0];
				for (int j = 0; j < 51; j++) {
					adjMatrix[i][j] = Double.parseDouble(line[j + 1]);
				}
			}
			scanner.close();
		} catch (Exception e) {
			throw new UnsupportedOperationException("fileToAdjacencyMatrix");
		}
	}

	private static int cityToIndex(String city) {
		for (int i = 0; i < 51; i++) {
			if (cities[i].equals(city)) {
				return i;
			}
		}
		throw new UnsupportedOperationException("cityToIndex");
	}

	private static void dijkstra(int s, int t) {
		try {
			double dist[] = new double[51];
			for (int i = 0; i < 51; i++) {
				dist[i] = Double.POSITIVE_INFINITY;
			}
			dist[s] = 0;
			PriorityQueue<Integer> open = new PriorityQueue<Integer>((a, b) -> Double.compare(dist[a], dist[b]));
			open.add(s);
			boolean closed[] = new boolean[51];
			int parent[] = new int[51];
			for (int i = 0; i < 51; i++) {
				parent[i] = -1;
			}
			while (!open.isEmpty()) {
				int umin = open.poll();
				closed[umin] = true;
				for (int v = 0; v < 51; v++) {
					if (adjMatrix[umin][v] == -1 || closed[v]) {
						continue;
					}
					double len = dist[umin] + adjMatrix[umin][v];
					if (len < dist[v]) {
						dist[v] = len;
						parent[v] = umin;
					}
					if (!open.contains(v)) {
						open.add(v);
					}
				}
			}
			if (dist[t] == Double.POSITIVE_INFINITY) {
				System.out.println("No path from " + cities[s] + " to " + cities[t]);
				return;
			}
			int curr = t;
			ArrayList<Integer> path = new ArrayList<Integer>();
			while (curr != -1) {
				path.add(curr);
				curr = parent[curr];
			}
			System.out.println("Path from " + cities[s] + " to " + cities[t] + ":");
			for (int i = path.size() - 1; i >= 0; i--) {
				System.out.print("\t" + cities[path.get(i)]);
				if (i != 0) {
					System.out.print("\n");
				}
			}
			System.out.println("\nTotal Distance: " + dist[t] + " miles");
		} catch (Exception e) {
			throw new UnsupportedOperationException("dijkstra");
		}
	}
}
