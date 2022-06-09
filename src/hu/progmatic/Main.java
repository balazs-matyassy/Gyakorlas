package hu.progmatic;

import hu.progmatic.model.Animal;
import hu.progmatic.model.AnimalFactory;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<Animal> animals = loadAnimals("animals.txt");
            System.out.println("A beolvasott adatok száma: " + animals.size());

            // 1. feladat
            Map<String, List<Animal>> animalsBySpecies = new TreeMap<>();

            for (Animal animal : animals) {
                if (!animalsBySpecies.containsKey(animal.getSpecies())) {
                    animalsBySpecies.put(animal.getSpecies(), new ArrayList<>());
                }

                List<Animal> subList = animalsBySpecies.get(animal.getSpecies());
                subList.add(animal);
            }

            // 2. feladat
            Map<String, Integer> countBySpecies = new TreeMap<>();

            for (Animal animal : animals) {
                int count = countBySpecies.getOrDefault(animal.getSpecies(), 0);
                countBySpecies.put(animal.getSpecies(), count + 1);
            }

            // countBySpecies.keySet() -> {"CAT", "DOG"}
            //        values = {countBySpecies.get("CAT"), countBySpecies.get("DOG")}
            // countBySpecies.values() -> {2, 2}
            // (countBySpecies.entrySet() -> {"CAT" -> 2, "DOG" -> 2}
            for (String species : countBySpecies.keySet()) {
                System.out.println(species + ": " + countBySpecies.get(species));
            }

            saveAnimals("checked.txt", animals);
            saveAnimals("cats.txt", animalsBySpecies.get("CAT"));
            saveAnimals("dogs.txt", animalsBySpecies.get("DOG"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Animal> loadAnimals(String path) throws IOException {
        List<Animal> animals = new ArrayList<>();

        // BufferedReader reader = new BufferedReader(new FileReader(path))
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    String[] values = line.split(";");
                    Animal animal = AnimalFactory.createAnimal(values[0], values[1], Integer.parseInt(values[2]));
                    animals.add(animal);
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Hibás sor figyelmen kívül hagyása...");
                }
            }
        }

        /* BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                Animal animal = AnimalFactory.createAnimal(values[0], values[1], Integer.parseInt(values[2]));
                animals.add(animal);
            }
        } finally {
            System.out.println("Ez mindig lefut. :)");
            if (reader != null) {
                reader.close();
            }
        } */

        return animals;
    }

    private static void saveAnimals(String path, Collection<Animal> animals) throws IOException {
        // PrintWriter writer = new PrintWriter(new FileWriter("path"));
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Animal animal : animals) {
                writer.println(animal.toCSV());
            }
        }
    }
}
