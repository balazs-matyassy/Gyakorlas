package hu.progmatic.model;

public final class Cat extends Animal {
    public Cat() {
    }

    public Cat(String name, int birthYear) {
        super(name, birthYear);
    }

    @Override
    public String getSpecies() {
        return "CAT";
    }

    @Override
    public String getSound() {
        return "Meow";
    }
}
