import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kulkarni_my on 10/26/2016.
 */
public class ParkingApplication {
    static int floor = 0;
    static int section = 0;
    static int cars = 0;
    static Map<Car, Info> carInfoHashMap = new HashMap<>();


    public static void modFloor(int x) {
        floor = ((floor + x) % 3 + 3) % 3;
    }

    public static void modSection(int x) {
        section = ((section + x) % 4 + 4) % 4;
    }

    public static void modCars(int x) {
        cars = ((cars + x) % 20 + 20) % 20;
    }

    public static void incr() {
        modFloor(1);
        modCars(1);
        modSection(1);
    }

    public static void decr() {
        modFloor(-1);
        modCars(-1);
        modSection(-1);
    }

    public static void main(String[] args) {
        Car car = new Car("Lamborghini Galardo", "MH 12 KV4309", "Mayur Kulkarni", "Yellow", 9028638624L, "Pune");
        carInfoHashMap.put(car, new Info(floor, section, cars));
        incr();
        String randomStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        SecureRandom sr = new SecureRandom();
        for (int i = 0; i < 20; i++) {
            carInfoHashMap.put(new Car(randomStr.substring(sr.nextInt(10), sr.nextInt(10) + 15), randomStr.substring(sr.nextInt(10), sr.nextInt(10) + 15),
                    randomStr.substring(sr.nextInt(10), sr.nextInt(10) + 15), randomStr.substring(sr.nextInt(10), sr.nextInt(10) + 15), 871927839123L,
                    randomStr.substring(sr.nextInt(10), sr.nextInt(10) + 15)), new Info(floor, section, cars));
            incr();
        }
        System.out.println(carInfoHashMap);
        Car carToFind = new Car("Lamborghini Galardo", "MH 12 KV4309", "Mayur Kulkarni", "Yellow", 9028638624L, "Pune");
        System.out.println("*****************");
        System.out.println(carInfoHashMap.get(carToFind));
    }
}

class Info {
    int floor;
    int section;
    int car;

    public Info(int floor, int section, int car) {
        this.floor = floor;
        this.section = section;
        this.car = car;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Info{" +
                "floor=" + floor +
                ", section=" + section +
                ", car=" + car +
                "}\n";
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info = (Info) o;

        if (floor != info.floor) return false;
        return section == info.section;

    }

    @Override
    public int hashCode() {
        int result = floor;
        result = 31 * result + section;
        return result;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

}

class Car {
    String carName;
    String carNumber;
    String ownerName;
    String carModel;
    long ownerMobileNumber;
    String ownerAddress;

    public Car(String carName, String carNumber, String ownerName, String carModel, long ownerMobileNumber, String ownerAddress) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.ownerName = ownerName;
        this.carModel = carModel;
        this.ownerMobileNumber = ownerMobileNumber;
        this.ownerAddress = ownerAddress;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", carModel='" + carModel + '\'' +
                ", ownerMobileNumber=" + ownerMobileNumber +
                ", ownerAddress='" + ownerAddress + '\'' +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (!carName.equals(car.carName)) return false;
        if (!carNumber.equals(car.carNumber)) return false;
        return ownerName.equals(car.ownerName);

    }

    @Override
    public int hashCode() {
        int result = carName.hashCode();
        result = 31 * result + carNumber.hashCode();
        result = 31 * result + ownerName.hashCode();
        return result;
    }


}