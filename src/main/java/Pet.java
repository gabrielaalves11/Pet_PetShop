import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pet {
    private int id;
    private String name;
    private String species;
    private int age;
    private String race;

    public static Map<Integer, Pet> petList = new HashMap<>();
    private static int sequentialId = 1;

    public Pet(String name, String species, int age, String race) {
        this.id = sequentialId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.race = race;
        sequentialId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public static void addPet(Pet pet) {
        petList.put(pet.getId(), pet);
    }

    public static void updatePet(int id, Pet newPet) {
        if (petList.containsKey(id)) {
            petList.put(id, newPet);
        }
    }

    public static void deletePet(int id) {
        petList.remove(id);
    }

    public static Pet searchPet(int id) {
        return petList.get(id);
    }

    public static List<Pet> getPetList() {
        return new ArrayList<>(petList.values());
    }

    public static Pet getPetById(int idPet) {
        return petList.get(idPet);
    }

    public static void clearPetList() {
        petList.clear();
    }
}
