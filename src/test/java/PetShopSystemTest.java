import org.junit.jupiter.api.*;

import java.util.List;

class PetShopSystemTest {

    @BeforeEach
    public void clearPetList() {
        Pet.clearPetList();
    }

    @Test
    void testPetShopSystem() {
        PetShop petShop = new PetShop();

        Pet pet1 = new Pet("Max", "Cachorro", 3, "Golden Retriever");
        Pet pet2 = new Pet("Lucy", "Gato", 2, "Siamese");

        Client client1 = new Client("John", "Rua 1");
        Client client2 = new Client("Alice", "Rua 2");

        petShop.addClient(client1);
        petShop.addClient(client2);

        petShop.addPetToClient(client1.getId(), pet1);
        petShop.addPetToClient(client2.getId(), pet2);

        // Verificação da lista de pets do cliente 1
        List<Pet> petsClient1 = petShop.listPetsToClient(client1.getId());
        Assertions.assertEquals(2, petsClient1.size());
        Assertions.assertEquals(pet1, petsClient1.get(0));

        // Verificação da lista de pets do cliente 2
        List<Pet> petsClient2 = petShop.listPetsToClient(client2.getId());
        Assertions.assertEquals(2, petsClient2.size());
        Assertions.assertEquals(pet2, petsClient2.get(1));

        // Atualização do pet do cliente 1
        Pet newPet1 = new Pet("Buddy", "Dog", 4, "Labrador Retriever");
        petShop.updatePetToClient(client1.getId(), pet1.getId(), newPet1);

        // Verificação da atualização do pet
        Pet updatedPet1 = petShop.listPetsToClient(client1.getId()).get(0);
        Assertions.assertEquals(newPet1.getName(), updatedPet1.getName());
        Assertions.assertEquals(newPet1.getSpecies(), updatedPet1.getSpecies());
        Assertions.assertEquals(newPet1.getAge(), updatedPet1.getAge());
        Assertions.assertEquals(newPet1.getRace(), updatedPet1.getRace());

        // Exclusão do pet do cliente 2
        petShop.deletePetToClient(client2.getId(), pet2.getId());

        // Verificação da exclusão do pet
        Pet deletedPet2 = Pet.searchPet(pet2.getId());
        Assertions.assertNull(deletedPet2);

        // Exclusão do cliente 1
        petShop.deleteClient(client1.getId());

        // Verificação da exclusão do cliente
        Client deletedClient1 = Client.searchClient(client1.getId());
        Assertions.assertNull(deletedClient1);
    }
}