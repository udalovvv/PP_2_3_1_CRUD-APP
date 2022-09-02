package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static int COUNT = 1;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(COUNT++, "Audi", "4"));
        cars.add(new Car(COUNT++, "BMW", "X5"));
        cars.add(new Car(COUNT++, "Mercedes", "E200"));
        cars.add(new Car(COUNT++, "VW", "Tiguan"));
        cars.add(new Car(COUNT++, "Lada", "Vesta"));
    }

    public List<Car> getCars(int count) {
        if (count > cars.size()) {return cars;}

        List<Car> temp = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            temp.add(cars.get(i));
        }
        return temp;
    }
}
