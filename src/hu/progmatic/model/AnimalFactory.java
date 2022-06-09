package hu.progmatic.model;

public class AnimalFactory {
    // 1. visszatérési érték egy közös (esetleg absztrakt) ősosztály vagy interfész
    // 2. konvenció szerint benne van a nevében a create
    // 3. a paraméterek alapján képes eldönteni, hogy pontosan melyik osztályt kell példányosítani
    //      ÉS képes beállítani a létrehozott példányt
    public static Animal createAnimal(String species, String name, int birthYear) {
        if (species.equalsIgnoreCase("cat")) {
            return new Cat(name, birthYear);
        } else if (species.equalsIgnoreCase("dog")) {
            return new Dog(name, birthYear);
        } else {
            return null;
        }
    }
}
