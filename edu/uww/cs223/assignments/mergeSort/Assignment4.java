import java.util.ArrayList;
import java.util.Arrays;

public class Assignment4 {
	private static int[] binaryMerge(int[] a, int[] b) {
		try {
			int[] c = new int[a.length + b.length];
			int i = 0, j = 0, k = 0;
			while (i < a.length && j < b.length) {
				if (a[i] < b[j]) {
					c[k++] = a[i++];
				} else {
					c[k++] = b[j++];
				}
			}
			while (i < a.length) {
				c[k++] = a[i++];
			}
			while (j < b.length) {
				c[k++] = b[j++];
			}
			return c;
		} catch (Exception e) {
			throw new UnsupportedOperationException("binaryMerge)");
		}
	}

	private static void mergeSort(int[] mergedArray, int left, int right, LinkedList.Node leftNode, LinkedList.Node rightNode) {
		try {
			if (left < right) {
				int mid = (left + right) / 2;
				LinkedList.Node midNode = leftNode;
				for (int i = left; i < mid; i++) {
					midNode = midNode.next;
				}
				mergeSort(mergedArray, left, mid, leftNode, midNode);
				mergeSort(mergedArray, mid + 1, right, midNode.next, rightNode);
				int k = left;
				LinkedList.Node tmp1 = leftNode;
				LinkedList.Node tmp2 = midNode.next;
				while(tmp1 != midNode.next && tmp2 != rightNode.next){
					if(tmp1.value < tmp2.value){
						mergedArray[k++] = tmp1.value;
						tmp1 = tmp1.next;
					}
					else{
						mergedArray[k++] = tmp2.value;
						tmp2 = tmp2.next;
					}
				}
				while(tmp1 != midNode.next){
					mergedArray[k++] = tmp1.value;
					tmp1 = tmp1.next;
				}
				while(tmp2 != rightNode.next){
					mergedArray[k++] = tmp2.value;
					tmp2 = tmp2.next;
				}
				k = left;
				LinkedList.Node tmp3 = leftNode;
				while(tmp3 != rightNode.next){
					tmp3.value = mergedArray[k++];
					tmp3 = tmp3.next;
				}
			}
		} catch (Exception e) {
			throw new UnsupportedOperationException("mergeSort)");
		}
	}

	private static ArrayList<String> commonElements(String[] A, String[] B) {
		try {
			ArrayList<String> C = new ArrayList<String>();
			int a = 0;
			int b = 0;
			while (a < A.length && b < B.length) {
				if (A[a].compareTo(B[b]) < 0) {
					a++;
				} else if (A[a].compareTo(B[b]) > 0) {
					b++;
				} else {
					C.add(A[a]);
					a++;
					while (a < A.length && A[a].compareTo(A[a - 1]) == 0) {
						a++;
					}
				}
			}
			return C;
		} catch (Exception e) {
			throw new UnsupportedOperationException("commonElements");
		}
	}

	// DO NOT MODIFY
	private static void mergeSort(LinkedList list) {
		int[] mergedArray = new int[list.size()];
		mergeSort(mergedArray, 0, list.size() - 1, list.getHead(), list.getTail());
	}

	public static void main(String[] args) {
		// PART 1
		System.out.println("Part 1: Binary Merge");

		int[] a = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24 };
		int[] b = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25 };

		System.out.println("Merging:");
		System.out.println(Arrays.toString(a));
		System.out.println("With:");
		System.out.println(Arrays.toString(b));

		int[] c = binaryMerge(a, b);

		System.out.println("Result:");
		System.out.println(Arrays.toString(c));

		// PART 2
		System.out.println("\nPart 2: Linked List Merge Sort");

		int[] nums = new int[] { 16, 16, 15, 14, 9, 8, 21, 0, 7, 6, 7, 7, 9, 18, 1, 20, 24, 6, 19, 21, 7, 22, 17, 7,
				14 };
		LinkedList linkedList = new LinkedList(nums);

		System.out.println("Before: ");
		System.out.println(linkedList);

		mergeSort(linkedList);

		System.out.println("After: ");
		System.out.println(linkedList);

		// PART 3
		System.out.println("\nPart 3: Common Elements");

		ArrayList<String> sharedMovies = commonElements(LetterboxdTop100, ImdbTop100);

		System.out.printf("Letterboxd/IMDB Consensus Top %d Movies:%n", sharedMovies.size());
		for (int i = 0; i < sharedMovies.size(); i++) {
			String movie = sharedMovies.get(i);
			System.out.printf("\t%d)\t%s%n", i + 1, movie);
		}
	}

	public static String[] LetterboxdTop100 = { "12 Angry Men", "A Brighter Summer Day", "A Man Escaped",
			"A Separation", "A Woman Under the Influence", "All About Eve", "Andrei Rublev", "Apocalypse Now",
			"Autumn Sonata", "Barry Lyndon", "Before Sunrise", "Before Sunset", "Cinema Paradiso", "City Lights",
			"City of God", "Close-Up", "Come and See", "Do the Right Thing", "Eternity and a Day",
			"Everything Everywhere All at Once", "Fanny and Alexander", "Goodfellas", "Grave of the Fireflies",
			"Harakiri", "High and Low", "I Am Cuba", "Ikiru", "In the Mood for Love", "Incendies",
			"Inglourious Basterds", "It's a Wonderful Life", "It's Such a Beautiful Day", "La Haine", "Late Spring",
			"Lawrence of Arabia", "Le Trou", "Love Exposure", "M", "Memories of Murder", "Mirror",
			"Mishima: A Life in Four Chapters", "Neon Genesis Evangelion: The End of Evangelion", "Nights of Cabiria",
			"No Country for Old Men", "Oldboy", "Once Upon a Time in the West", "One Flew Over the Cuckoo's Nest",
			"Parasite", "Paris Texas", "Paths of Glory", "Perfect Blue", "Persona", "Portrait of a Lady on Fire",
			"Princess Mononoke", "Psycho", "Ran", "Rear Window", "Sansho the Bailiff", "Satantango",
			"Scenes from a Marriage", "Schindler's List", "Seven Samurai", "Sherlock Jr.",
			"Spider-Man: Across the Spider-Verse", "Spider-Man: Into the Spider-Verse", "Spirited Away", "Stalker",
			"Star Wars: Episode V - The Empire Strikes Back", "Sunset Boulevard", "The 400 Blows", "The Apartment",
			"The Ascent", "The Battle of Algiers", "The Cranes Are Flying", "The Dark Knight", "The Godfather",
			"The Godfather: Part II", "The Good the Bad and the Ugly", "The Handmaiden",
			"The Human Condition I: No Greater Love", "The Human Condition II: Road to Eternity",
			"The Human Condition III: A Soldier's Prayer", "The Lord of the Rings: The Fellowship of the Ring",
			"The Lord of the Rings: The Return of the King", "The Lord of the Rings: The Two Towers",
			"The Passion of Joan of Arc", "The Pianist", "The Red Shoes", "The Seventh Seal",
			"The Shawshank Redemption", "The Silence of the Lambs", "The Thing", "There Will Be Blood",
			"Three Colours: Red", "Tokyo Story", "Where Is the Friend's House?", "Whiplash", "Wild Strawberries",
			"Woman in the Dunes", "Yi Yi" };
	public static String[] ImdbTop100 = { "12 Angry Men", "2001: A Space Odyssey", "3 Idiots", "A Clockwork Orange",
			"Alien", "Aliens", "Amadeus", "American Beauty", "American History X", "Apocalypse Now",
			"Avengers: Endgame", "Avengers: Infinity War", "Back to the Future", "Braveheart", "Capernaum",
			"Casablanca", "Cinema Paradiso", "City Lights", "City of God", "Coco", "Come and See", "Das Boot",
			"Django Unchained", "Dr. Strangelove or: How I Learned to Stop Worrying and Love the Bomb",
			"Eternal Sunshine of the Spotless Mind", "Fight Club", "Forrest Gump", "Full Metal Jacket", "Gladiator",
			"Good Will Hunting", "Goodfellas", "Grave of the Fireflies", "Hamilton", "Harakiri", "Heat", "High and Low",
			"Inception", "Inglourious Basterds", "Interstellar", "It's a Wonderful Life", "Jai Bhim", "Joker",
			"Leon: The Professional", "Life Is Beautiful", "Memento", "Modern Times", "Oldboy",
			"Once Upon a Time in America", "Once Upon a Time in the West", "One Flew Over the Cuckoo's Nest",
			"Oppenheimer", "Parasite", "Paths of Glory", "Psycho", "Pulp Fiction", "Raiders of the Lost Ark",
			"Rear Window", "Requiem for a Dream", "Reservoir Dogs", "Saving Private Ryan", "Scarface",
			"Schindler's List", "Se7en", "Seven Samurai", "Spider-Man: Across the Spider-Verse",
			"Spider-Man: Into the Spider-Verse", "Spirited Away", "Star Wars: Episode IV - A New Hope",
			"Star Wars: Episode V - The Empire Strikes Back", "Sunset Boulevard", "Terminator 2: Judgment Day",
			"The Dark Knight", "The Dark Knight Rises", "The Departed", "The Godfather", "The Godfather: Part II",
			"The Good the Bad and the Ugly", "The Great Dictator", "The Green Mile", "The Hunt", "The Intouchables",
			"The Lion King", "The Lives of Others", "The Lord of the Rings: The Fellowship of the Ring",
			"The Lord of the Rings: The Return of the King", "The Lord of the Rings: The Two Towers", "The Matrix",
			"The Pianist", "The Prestige", "The Shawshank Redemption", "The Shining", "The Silence of the Lambs",
			"The Usual Suspects", "Top Gun: Maverick", "Toy Story", "Up", "WALLE", "Whiplash",
			"Witness for the Prosecution", "Your Name." };
	// END DO NOT MODIFY
}