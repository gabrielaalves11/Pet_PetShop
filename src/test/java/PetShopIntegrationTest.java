import org.junit.jupiter.api.*;

import java.util.List;

class PetShopIntegrationTest {

    private PetShop petShop;

    @BeforeEach
    void setup() {
        petShop = new PetShop();
    }

    @Test
    void testPetShopIntegration() {

        Pet pet1 = new Pet("Max", "Cachorro", 3, "Golden Retriever");
        Pet pet2 = new Pet("Lucy", "Gato", 2, "Siamese");

        Client client1 = new Client("John", "Rua 1");
        Client client2 = new Client("Alice", "Rua 2");

        client1.addPet(pet1);
        client2.addPet(pet2);

        petShop.addClient(client1);
        petShop.addClient(client2);

        // Teste de listagem de pets para o cliente 1
        List<Pet> petsClient1 = petShop.listPetsToClient(client1.getId());
        Assertions.assertEquals(2, petsClient1.size());
        Assertions.assertEquals(pet1, petsClient1.get(0));

        // Teste de listagem de pets para o cliente 2
        List<Pet> petsClient2 = petShop.listPetsToClient(client2.getId());
        Assertions.assertEquals(2, petsClient2.size());
        Assertions.assertEquals(pet2, petsClient2.get(1));

        // Atualização do pet do cliente 1
        Pet newPet1 = new Pet("Buddy", "Cachorro", 4, "Labrador Retriever");
        client1.updatePet(pet1.getId(), newPet1);

        // Teste de atualização do pet
        Pet updatedPet1 = Pet.searchPet(pet1.getId());
        Assertions.assertEquals(newPet1.getName(), updatedPet1.getName());
        Assertions.assertEquals(newPet1.getSpecies(), updatedPet1.getSpecies());
        Assertions.assertEquals(newPet1.getAge(), updatedPet1.getAge());
        Assertions.assertEquals(newPet1.getRace(), updatedPet1.getRace());

        // Exclusão do pet do cliente 2
        client2.deletePet(pet2.getId());

        // Teste de exclusão do pet
        Pet deletedPet2 = Pet.searchPet(pet2.getId());
        Assertions.assertNull(deletedPet2);

        // Exclusão do cliente 2
        petShop.deletePetToClient(client2.getId(), pet2.getId());
        petShop.deleteClient(client2.getId());

        // Teste de exclusão do cliente
        Client deletedClient2 = Client.searchClient(client2.getId());
        Assertions.assertNull(deletedClient2);

        // Verifica se a lista de pets do cliente 2 está vazia
        List<Pet> emptyPetsClient2 = petShop.listPetsToClient(client2.getId());
        Assertions.assertEquals(0, emptyPetsClient2.size());
    }
}
