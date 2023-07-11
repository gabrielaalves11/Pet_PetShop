import org.junit.jupiter.api.*;

import java.util.List;

class PetShopAcceptanceTest {

    private PetShop petShop;
    private Client client1;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    void setup() {
        petShop = new PetShop();
        client1 = new Client("John", "RUa do lado");
        pet1 = new Pet("Max", "Cachorro", 3, "Golden Retriever");
        pet2 = new Pet("Lucy", "Gato", 2, "Siamese");
    }

    @Test
    void testAddAndListPetsForClient() {
        petShop.addClient(client1);
        petShop.addPetToClient(client1.getId(), pet1);
        petShop.addPetToClient(client1.getId(), pet2);

        List<Pet> petsClient1 = petShop.listPetsToClient(client1.getId());

        Assertions.assertEquals(2, petsClient1.size());
        Assertions.assertTrue(petsClient1.contains(pet1));
        Assertions.assertTrue(petsClient1.contains(pet2));
    }
}