package hu.progmatic.model;

public final class Dog extends Animal {
    public Dog() {
    }

    public Dog(String name, int birthYear) {
        super(name, birthYear);
    }

    @Override
    public String getSpecies() {
        return "DOG";
    }

    @Override
    public String getSound() {
        return "Woof";
    }
}
