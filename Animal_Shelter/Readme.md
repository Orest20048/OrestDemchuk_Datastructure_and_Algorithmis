Animal Shelter System

Overview

This project implements an Animal Shelter Management System that follows a First-In, First-Out (FIFO) adoption policy. The shelter only accommodates dogs and cats and allows users to:

Add new dogs and cats to the shelter.

Adopt the oldest animal (regardless of type) or choose the oldest dog or cat.

View the remaining animals in the shelter.

Exit the system through an interactive menu-based CLI.

Features

FIFO Adoption: Ensures animals are adopted in the order they arrived.

Category-Based Adoption: Users can adopt a dog, cat, or the oldest available animal.

User-Friendly CLI Menu: Provides an interactive experience for users.

Java-Based Implementation: Written in Java, following object-oriented principles.

Maven Build Support: Uses Maven for dependency management and project structure.

Prerequisites

Java 11+

Maven 3.6+

Installation

Clone the repository:

git clone <repository-url>

Navigate into the project directory:

cd animal-shelter

Build the project using Maven:

mvn clean install

Running the Application

Run the application using:

mvn exec:java -Dexec.mainClass="Main"

Class Structure

Animal.java

Base class for Dog and Cat.

Assigns a FIFO order to each animal.

Dog.java & Cat.java

Inherit from Animal.

Represent dog and cat entities.

AnimalShelter.java

Manages the shelter operations.

Implements enqueue, dequeueAny, dequeueDog, and dequeueCat methods.

Main.java

Provides an interactive menu for user interaction.
