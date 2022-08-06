package repository;

import domain.Car;

import java.util.List;

public interface ICarRepository {

    public List<Car> getAll();
    public Car save(Car c);
    public Car update(Car c);
}
