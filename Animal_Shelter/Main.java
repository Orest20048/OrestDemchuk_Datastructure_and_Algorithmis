import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalShelter shelter = new AnimalShelter();

        while (true) {
            System.out.println("\nAnimal Shelter Menu:");
            System.out.println("1. Enqueue a Dog");
            System.out.println("2. Enqueue a Cat");
            System.out.println("3. Dequeue Any Animal");
            System.out.println("4. Dequeue a Dog");
            System.out.println("5. Dequeue a Cat");
            System.out.println("6. Show Remaining Animals");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter dog's name: ");
                    String dogName = scanner.nextLine();
                    shelter.enqueue(new Dog(dogName));
                    System.out.println(dogName + " added to the shelter.");
                    break;
                case 2:
                    System.out.print("Enter cat's name: ");
                    String catName = scanner.nextLine();
                    shelter.enqueue(new Cat(catName));
                    System.out.println(catName + " added to the shelter.");
                    break;
                case 3:
                    Animal adoptedAnimal = shelter.dequeueAny();
                    System.out.println(adoptedAnimal != null ? "Adopted: " + adoptedAnimal.getName() : "No animals available.");
                    break;
                case 4:
                    Dog adoptedDog = shelter.dequeueDog();
                    System.out.println(adoptedDog != null ? "Adopted Dog: " + adoptedDog.getName() : "No dogs available.");
                    break;
                case 5:
                    Cat adoptedCat = shelter.dequeueCat();
                    System.out.println(adoptedCat != null ? "Adopted Cat: " + adoptedCat.getName() : "No cats available.");
                    break;
                case 6:
                    System.out.println("Remaining Animals: " + shelter.getAnimalCount());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
