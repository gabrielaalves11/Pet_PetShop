import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PetShopTest {

    private PetShop petShop;
    private Client client;

    @BeforeEach
    public void setup() {
        petShop = new PetShop();
        client = new Client("João", "Rua A");
    }

    @BeforeEach
    public void clearPetList() {
        Pet.clearPetList();
    }

    @Test
    public void testAddPetToClient() {
        Pet pet1 = new Pet("Rex", "Cachorro", 3, "Labrador");

        Client.addClient(client);
        petShop.addPetToClient(client.getId(), pet1);

        List<Pet> petList = petShop.listPetsToClient(client.getId());

        Assertions.assertEquals(1, petList.size());
        Assertions.assertEquals(pet1, petList.get(0));
    }

    @Test
    public void testUpdatePetToClient() {
        Pet pet2 = new Pet("Rei", "Cachorro", 3, "Pug");
        Client.addClient(client);
        petShop.addPetToClient(client.getId(), pet2);

        pet2.setName("Bella");
        pet2.setSpecies("Gato");
        pet2.setAge(1);
        pet2.setRace("Siamês");
        petShop.updatePetToClient(client.getId(), pet2.getId(), pet2);

        List<Pet> petList = petShop.listPetsToClient(client.getId());

        Assertions.assertEquals("Bella", petList.get(0).getName());
        Assertions.assertEquals("Gato", petList.get(0).getSpecies());
        Assertions.assertEquals(1, petList.get(0).getAge());
        Assertions.assertEquals("Siamês", petList.get(0).getRace());
    }

    @Test
    public void testDeletePetToClient() {
        Pet pet4 = new Pet("Max", "Cachorro", 3, "Labrador");
        Client.addClient(client);
        petShop.addPetToClient(client.getId(), pet4);

        petShop.deletePetToClient(client.getId(), pet4.getId());

        List<Pet> petList = petShop.listPetsToClient(client.getId());

        Assertions.assertEquals(0, petList.size());
    }

    @Test
    public void testListPetsToClient() {
        Pet pet4 = new Pet("Max", "Cachorro", 3, "Labrador");
        Pet pet5 = new Pet("Rock", "Cachorro", 2, "Golden Retriever");
        Client.addClient(client);
        petShop.addPetToClient(client.getId(), pet4);
        petShop.addPetToClient(client.getId(), pet5);

        List<Pet> petList = petShop.listPetsToClient(client.getId());

        Assertions.assertEquals(2, petList.size());
        Assertions.assertTrue(petList.contains(pet4));
        Assertions.assertTrue(petList.contains(pet5));
    }
}