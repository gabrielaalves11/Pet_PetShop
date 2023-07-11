import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClientTest {

    @BeforeEach
    public void setup() {
        Client.clientList.clear();
    }

    @BeforeEach
    public void clearPetList() {
        Pet.clearPetList();
    }

    @Test
    public void testAddClient() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Client.addClient(client);

        Assertions.assertEquals(1, Client.clientList.size());
        Assertions.assertTrue(Client.clientList.containsKey(client.getId()));
        Assertions.assertEquals(client, Client.clientList.get(client.getId()));
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Client.addClient(client);

        client.setName("Maria Sousa");
        Client.updateClient(client.getId(), client);

        Assertions.assertEquals("Maria Sousa", Client.clientList.get(client.getId()).getName());
    }

    @Test
    public void testDeleteClient() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Client.addClient(client);

        Client.deleteClient(client.getId());

        Assertions.assertEquals(0, Client.clientList.size());
        Assertions.assertFalse(Client.clientList.containsKey(client.getId()));
    }

    @Test
    public void testSearchClient() {
        Client client1 = new Client("Carlos Magno", "Rua da feira");
        Client client2 = new Client("Maria Sousa", "Rua Santana");
        Client.addClient(client1);
        Client.addClient(client2);

        Client searchClient = Client.searchClient(client1.getId());

        Assertions.assertEquals(client1, searchClient);
    }

    @Test
    public void testAddPet() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Pet pet = new Pet("Max", "Cachorro", 3, "Labrador");

        client.addPet(pet);

        List<Pet> petList = client.PetList();
        Assertions.assertEquals(1, petList.size());
        Assertions.assertEquals(pet, petList.get(0));
    }

    @Test
    public void testUpdatePet() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Pet pet = new Pet("Max", "Cachorro", 3, "Labrador");
        client.addPet(pet);

        pet.setName("Rex");
        client.updatePet(pet.getId(), pet);

        List<Pet> petList = client.PetList();
        Assertions.assertEquals("Rex", petList.get(0).getName());
    }

    @Test
    public void testDeletePet() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Pet pet = new Pet( "Max", "Cachorro", 3, "Labrador");
        client.addPet(pet);

        client.deletePet(pet.getId());

        List<Pet> petList = client.PetList();
        Assertions.assertEquals(0, petList.size());
    }

    @Test
    public void testPetList() {
        Client client = new Client("Carlos Magno", "Rua da feira");
        Pet pet = new Pet("Max", "Cachorro", 3, "Labrador");
        Pet pet1 = new Pet("Rock", "Cachorro", 2, "Golden Retriever");

        client.addPet(pet);
        client.addPet(pet1);

        List<Pet> petList = client.PetList();
        Assertions.assertEquals(2, petList.size());
        Assertions.assertEquals(pet, petList.get(0));
        Assertions.assertEquals(pet1, petList.get(1));
        Assertions.assertTrue(petList.contains(pet));
        Assertions.assertTrue(petList.contains(pet1));
    }
}
