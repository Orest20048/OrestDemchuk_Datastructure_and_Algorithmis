import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Animal Shelter that follows FIFO adoption rules for Dogs and Cats.
 */
class AnimalShelter {
    private final Queue<Animal> shelterQueue;

    public AnimalShelter() {
        shelterQueue = new LinkedList<>();
    }

    /**
     * Adds an animal to the shelter, ensuring no duplicate entries.
     */
    public void enqueue(Animal animal) {
        if (!shelterQueue.contains(animal)) {
            shelterQueue.offer(animal);
        }
    }

    /**
     * Adopts the oldest animal in the shelter (FIFO).
     * @return The adopted animal, or null if no animals are available.
     */
    public Animal dequeueAny() {
        return shelterQueue.poll();
    }

    /**
     * Adopts the oldest dog.
     * @return The adopted dog, or null if no dogs are available.
     */
    public Dog dequeueDog() {
        for (Animal animal : shelterQueue) {
            if (animal instanceof Dog) {
                shelterQueue.remove(animal);
                return (Dog) animal;
            }
        }
        return null;
    }

    /**
     * Adopts the oldest cat.
     * @return The adopted cat, or null if no cats are available.
     */
    public Cat dequeueCat() {
        for (Animal animal : shelterQueue) {
            if (animal instanceof Cat) {
                shelterQueue.remove(animal);
                return (Cat) animal;
            }
        }
        return null;
    }

    /**
     * Gets the number of animals remaining in the shelter.
     */
    public int getAnimalCount() {
        return shelterQueue.size();
    }
}
