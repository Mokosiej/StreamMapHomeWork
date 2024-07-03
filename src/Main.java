import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("Toyota", 2005, 150000),
                new Car("Honda", 1998, 500000),
                new Car("Volkswagen", 2002, 180000),
                new Car("Volvo", 2000, 210000),
                new Car("BMW", 2010, 70000),
                new Car("Volkswagen", 1995, 300000),
                new Car("Ford", 2015, 120000),
                new Car("Volvo", 1999, 600000)
        );


        int totalMileage = cars.stream()
                .filter(car -> car.getYear() > 1999)
                .mapToInt(Car::getMileage)
                .sum();
        System.out.println("Общий пробег машин новее 1999 года: " + totalMileage);


        Optional<Car> oldestHighMileageCar = cars.stream()
                .filter(car -> car.getMileage() > 500000)
                .min((car1, car2) -> Integer.compare(car1.getYear(), car2.getYear()));
        oldestHighMileageCar.ifPresent(car -> System.out.println("Самая старая машина с пробегом более 500 000: " + car));


        Optional<Car> maxMileageCar = cars.stream()
                .filter(car -> (car.getBrand().startsWith("V") || car.getBrand().startsWith("W")) && car.getMileage() <= 200000)
                .max((car1, car2) -> Integer.compare(car1.getMileage(), car2.getMileage()));
        maxMileageCar.ifPresent(car -> System.out.println("Машина с маркой на \"V\" или \"W\" и пробегом не более 200 000: " + car));
    }
}

