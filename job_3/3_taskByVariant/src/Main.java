import java.util.ArrayList;
import java.util.Comparator;

class Room {
    private int id; // Идентификатор комнаты
    private String codeNumbers; // Код номера
    private int numberPeople; // Количество человек
    private String comfortType; // Комфортность
    private double price; // Цена

    // Конструктор
    public Room(int id, String codeNumbers, int numberPeople, String comfortType, double price) {
        this.id = id;
        this.codeNumbers = codeNumbers;
        this.numberPeople = numberPeople;
        this.comfortType = comfortType;
        this.price = price;
    }

    // Геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeNumbers() {
        return codeNumbers;
    }

    public void setCodeNumbers(String codeNumbers) {
        this.codeNumbers = codeNumbers;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getComfortType() {
        return comfortType;
    }

    public void setComfortType(String comfortType) {
        this.comfortType = comfortType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Переопределение метода toString() для форматированного вывода
    @Override
    public String toString() {
        return String.format("Room{id=%d, code='%s', people=%d, comfort='%s', price=%.2f}",
                id, codeNumbers, numberPeople, comfortType, price);
    }
}

class GroupRoom {
    private int groupId; // Уникальный ID группы
    private ArrayList<Room> rooms; // Список комнат

    // Конструкторы
    public GroupRoom() {
        this.rooms = new ArrayList<>();
    }

    public GroupRoom(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    // Методы для работы с массивом комнат
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoomById(int id) {
        rooms.removeIf(room -> room.getId() == id);
    }

    public void sortRoomsByPrice() {
        rooms.sort(Comparator.comparingDouble(Room::getPrice));
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    // Переопределение toString() для вывода всех комнат
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GroupRoom{\n");
        for (Room room : rooms) {
            sb.append(room.toString()).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем комнаты
        Room room1 = new Room(1, "101A", 2, "Standard", 5000);
        Room room2 = new Room(2, "102B", 3, "Deluxe", 8000);
        Room room3 = new Room(3, "103C", 1, "Suite", 12000);

        // Создаем список комнат и добавляем их в группу
        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        GroupRoom group = new GroupRoom(roomList);

        // Вывод до сортировки
        System.out.println("До сортировки:");
        System.out.println(group);

        // Сортировка комнат по цене
        group.sortRoomsByPrice();

        // Вывод после сортировки
        System.out.println("После сортировки:");
        System.out.println(group);

        // Удаление комнаты по ID
        group.removeRoomById(2);

        // Вывод после удаления
        System.out.println("После удаления комнаты с ID=2:");
        System.out.println(group);
    }
}
