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
		throw new UnsupportedOperationException("fileToAdjacencyMatrix");
	}

	private static int cityToIndex(String city) {
		throw new UnsupportedOperationException("cityToIndex");
	}

	private static void dijkstra(int s, int t) {
		throw new UnsupportedOperationException("dijkstra");
	}
}
