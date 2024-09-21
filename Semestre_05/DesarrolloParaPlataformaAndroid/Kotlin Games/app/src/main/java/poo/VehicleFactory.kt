package poo

abstract class Vehicle(val wheels: Int){
    fun brake(){
        println("Braking with $wheels wheels")
    }

    fun stop(){
        println("Stopping")
    }

    fun accelerate(){
        println("Accelerating")
    }
}

class Motorcycle(val brand: String, val maxSpeed: Double, val model: String) : Vehicle(2){
    fun wheelies(){
        print("Wheeling with a $brand motorcycle at $maxSpeed km/h")
    }
}

class Car(doors: Int, val brand: String, val model: String, val plate: String) : Vehicle(4){
    fun openDoors(){
        println("Opening doors")
    }

    fun closeDoors(){
        println("Closing doors")
    }
}

class Truck(val container: Int, val hasBed: Boolean) : Vehicle(16){
    fun sleep(){
        if(hasBed){
            println("Sleeping")
        }else{
            println("Can't sleep")
        }
    }

    fun getContainerNumber() : String{
        return "The truck has $container container"
    }
}

class VehicleFactory(){
    private val vehicles = mutableListOf<Vehicle>()

    fun produceCar(car: Car){
        vehicles.add(car)
    }

    fun produceTruck(truck: Truck){
        vehicles.add(truck)
    }

    fun produceMotorcycles(motorcycle: Motorcycle){
        vehicles.add(motorcycle)
    }

    fun getVehicles() : List<Vehicle>{
        return vehicles
    }
}

fun main(){
    val factory = VehicleFactory()
    factory.produceCar(Car(doors = 4, brand = "Tesla", model = "Model X", plate = "GL8S9MG"))
    factory.produceTruck(Truck(container = 3, hasBed = true))
    factory.produceMotorcycles(Motorcycle(brand = "Harley", maxSpeed = 350.00, model = "Model 2"))
    val vehicles = factory.getVehicles()
    for(vehicle in vehicles){
        if(vehicle is Car){
            vehicle.closeDoors()
        }
        if(vehicle is Motorcycle){
            vehicle.wheelies()
        }
        if(vehicle is Truck){
            vehicle.sleep()
        }
    }
}