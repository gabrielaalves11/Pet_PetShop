import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PetTest {
    private Pet pet;

    @BeforeEach
    public void setUp() {
        pet = new Pet("Max", "Cachorro", 3, "Labrador");
    }

    @BeforeEach
    public void clearPetList() {
        Pet.clearPetList();
    }

    @Test
    public void testAddPet() {
        Pet.addPet(pet);
        Pet retrievedPet = Pet.searchPet(pet.getId());
        Assertions.assertEquals(pet, retrievedPet);
    }

    @Test
    public void testUpdatePet() {
        Pet.addPet(pet);
        Pet updatedPet = new Pet("Bella", "Gato", 2, "Persian");
        Pet.updatePet(pet.getId(), updatedPet);
        Pet retrievedPet = Pet.searchPet(pet.getId());
        Assertions.assertEquals(updatedPet, retrievedPet);
    }

    @Test
    public void testDeletePet() {
        Pet.addPet(pet);
        Pet.deletePet(pet.getId());
        Pet retrievedPet = Pet.searchPet(pet.getId());
        Assertions.assertNull(retrievedPet);
    }

    @Test
    public void testGetPetList() {
        Pet pet1 = new Pet("Charlie", "Cat", 2, "Siamese");
        Pet pet2 = new Pet("Lucy", "Dog", 4, "Golden Retriever");

        Pet.addPet(pet1);
        Pet.addPet(pet2);

        List<Pet> petList = Pet.getPetList();
        Assertions.assertEquals(2, petList.size());
        Assertions.assertTrue(petList.contains(pet1));
        Assertions.assertTrue(petList.contains(pet2));
    }
}