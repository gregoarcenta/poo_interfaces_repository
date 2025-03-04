package org.arcentales.genericsclasses;

public class ExampleGenerics {
    public static <T> void printTruck(Truck<T> truck) {
        for (T t : truck) {
            if (t instanceof Animal) System.out.println(((Animal) t).getName() + " tipo: " + ((Animal) t).getType());
            else if (t instanceof Machinery) System.out.println("Tipo: " + ((Machinery) t).getType());
            else if (t instanceof Car) System.out.println(((Car) t).getBrand());

        }
    }

    public static void main(String[] args) {
        Truck<Animal> truckHorses = new Truck<>(5);
        truckHorses.add(new Animal("Josefo", "Caballo"));
        truckHorses.add(new Animal("Grillo", "Caballo"));
        truckHorses.add(new Animal("Maria Julieta", "Caballo"));
        truckHorses.add(new Animal("Negro", "Caballo"));
        printTruck(truckHorses);

        Truck<Machinery> truckMachinery = new Truck<>(3);
        truckMachinery.add(new Machinery("Grua Morquilla"));
        truckMachinery.add(new Machinery("Bulldozer"));
        truckMachinery.add(new Machinery("Perforadora"));
        printTruck(truckMachinery);

        Truck<Car> truckCar = new Truck<>(1);
        truckCar.add(new Car("Chevrolet"));
        printTruck(truckCar);
    }
}
