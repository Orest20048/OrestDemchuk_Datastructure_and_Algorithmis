package DoubleLinkedList;

/**
 * Implements an application that supports undo/redo functionality using a doubly linked list.
 * Each state change is stored as a node in the list, allowing for easy navigation.
 * Example usage: 1 <-> 2 <-> 3 <-> 4 <-> 5
 */
public class UndoRedoManager<T> {
    
    private class Node {
        private T state;
        private Node prev;
        private Node next;

        private Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    // Add a new state to the list
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            newNode.prev = currentState;
            currentState.next = newNode;
        }
        currentState = newNode; // Move to the new state

        // Clear redo history
        if (newNode.prev != null) {
            newNode.prev.next = null;
        }
    }

    // Undo operation - move to the previous state if possible
    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No more undo operations available.");
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    // Redo operation - move to the next state if possible
    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No more redo operations available.");
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();
        
        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");

        System.out.println("Undo: " + manager.undo()); // Should print "State 2"
        System.out.println("Undo: " + manager.undo()); // Should print "State 1"
        System.out.println("Redo: " + manager.redo()); // Should print "State 2"
        System.out.println("Redo: " + manager.redo()); // Should print "State 3"
        
        manager.addState("State 4"); // This should clear redo history
        System.out.println("Redo: " + manager.redo()); // Should print "No more redo operations available."
    }
}
