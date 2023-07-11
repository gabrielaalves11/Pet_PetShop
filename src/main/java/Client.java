import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    private int id;
    private String name;
    private String address;

    public static Map<Integer, Client> clientList = new HashMap<>();
    private static int sequentialId = 1;

    public Client(String name, String address) {
        this.id = sequentialId;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void addClient(Client client) {
        clientList.put(client.getId(), client);
    }

    public static void updateClient(int id, Client client) {
        if (clientList.containsKey(id)) {
            clientList.put(id, client);
        }
    }

    public static void deleteClient(int id) {
        clientList.remove(id);
    }

    public static Client searchClient(int id) {
        return clientList.get(id);
    }

    public void addPet(Pet pet) {
        Pet.addPet(pet);
    }

    public void updatePet(int idPet, Pet newPet) {
        Pet pet = Pet.getPetById(idPet);
        if (pet != null) {
            pet.setName(newPet.getName());
            pet.setSpecies(newPet.getSpecies());
            pet.setAge(newPet.getAge());
            pet.setRace(newPet.getRace());
        }
    }

    public void deletePet(int idPet) {
        Pet pet = Pet.getPetById(idPet);
        if (pet != null) {
            Pet.deletePet(idPet);
        }
    }

    public List<Pet> PetList() {
        return Pet.getPetList();
    }
}
