package enhancedForLoop;

public class Main {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        Planet[] array = new Planet[3];

        array[0] = new Planet();
        array[1] = new Planet("Krypton", 10020, true, 3);
        array[2] = new Planet("Mars", 99999, false, 7);

        /*
         * Rectangle[] quads = new Rectangle[5];
         * 
         * quads[0] = new Rectangle();
         * quads[1] = new Rectangle();
         * quads[2] = new Rectangle();
         * quads[3] = new Rectangle();
         * quads[4] = new Rectangle();
         */

        Date[] friendBirthdays = new Date[7];

        friendBirthdays[0] = new Date();
        friendBirthdays[1] = new Date();
        friendBirthdays[2] = new Date();
        friendBirthdays[3] = new Date();
        friendBirthdays[4] = new Date();
        friendBirthdays[5] = new Date();
        friendBirthdays[6] = new Date();

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        int i = 0;

        while (true) {
            System.out.println(nums[i]);
            if (i >= nums.length - 1) {
                break;
            }
            i++;
        }

        i = 0;

        while (i < nums.length) {
            System.out.println(nums[i]);
            i++;
        }

        for (Planet planet : array) {
            System.out.println(planet.toString());
        }

        /*
         * for(i = 0; i < quads.length; i++) {
         * quads[i].graphRectangle();
         * }
         * 
         * for (Rectangle rectangle : quads) {
         * rectangle.graphRectangle();
         * }
         */

        for (Date day : friendBirthdays) {
            day.displayMonthDayYear();
        }

        for (Date date : friendBirthdays) {
            date.displayMonthDayYear();
        }

        String[] words = { "play", "ball", "plant", "fight" };

        for (String word : words) {
            word += "er";
            System.out.println(word);
        }

        for (i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        Animal[] wildAnimals1 = { new Animal("Lion"), new Animal("Tiger"), new Animal("Bear"), new Animal("Giraffe") };

        for (Animal a : wildAnimals1) {
            a = new Animal("Elephant");
            System.out.println(a);
        }

        for (i = 0; i < wildAnimals1.length; i++) {
            System.out.println(wildAnimals1[i].toString());
        }

        Animal[] wildAnimals2 = { new Animal("Lion"), new Animal("Tiger"), new Animal("Bear"), new Animal("Giraffe") };

        for (Animal a : wildAnimals2) {
            a.setAnimal("Dog");
        }

        for (i = 0; i < wildAnimals2.length; i++) {
            System.out.println(wildAnimals2[i].toString());
        }
    }
}