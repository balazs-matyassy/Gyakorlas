package hu.progmatic.model;

public abstract class Animal {
    private String name;
    private int birthYear;

    public Animal() {
    }

    public Animal(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getBirthYear() {
        return birthYear;
    }

    public final void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public abstract String getSpecies();

    public abstract String getSound();

    // ha pl. a Cat-nek vagy a Dog-nak más exportáló metódusra van szüksége,
    // akkor nem szabad final-ként definiálni
    public final String toCSV() {
        return getSpecies() + ";" + name + ";" + birthYear;
    }

    @Override
    public final String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", species=" + getSpecies() +
                ", sound=" + getSound() +
                '}';
    }
}
