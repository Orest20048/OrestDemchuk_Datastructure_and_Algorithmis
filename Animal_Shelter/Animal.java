abstract class Animal {
    private static int counter = 0;  // Global counter for timestamps
    private final int order;         // Unique identifier for FIFO tracking
    private final String name;

    public Animal(String name) {
        this.name = name;
        this.order = counter++;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }
}
