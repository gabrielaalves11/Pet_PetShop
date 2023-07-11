import java.util.ArrayList;
import java.util.List;

public class PetShop {

    public void addPetToClient(int idClient, Pet pet) {
        Client client = Client.searchClient(idClient);
        if (client != null) {
            client.addPet(pet);
        }
    }

    public void updatePetToClient(int idClient, int idPet, Pet newPet) {
        Client client = Client.searchClient(idClient);
        if (client != null) {
            client.updatePet(idPet, newPet);
        }
    }

    public void deletePetToClient(int idClient, int idPet) {
        Client client = Client.searchClient(idClient);
        if (client != null) {
            client.deletePet(idPet);
        }
    }

    public List<Pet> listPetsToClient(int idClient) {
        Client client = Client.searchClient(idClient);
        if (client != null) {
            return client.PetList();
        }
        return new ArrayList<>();
    }

    public void addClient(Client client) {
        Client.addClient(client);
    }

    public void deleteClient(int idClient) {
        Client.deleteClient(idClient);
    }
}
