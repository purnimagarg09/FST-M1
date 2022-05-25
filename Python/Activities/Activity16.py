class Car:
    'This is Car Class'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")

car1 = Car("Ford", "Ecosport", "2016", "Manual", "Brown")
car2 = Car("Maruti", "Alto", "2011", "Manual", "Silver")
car3 = Car("Honda", "City", "2021", "Automatic", "White")

car1.accelerate()
car2.stop()
car3.accelerate()