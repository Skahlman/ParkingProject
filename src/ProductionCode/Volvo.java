package ProductionCode;

public class Volvo implements Car {

    public int position;
    public int sensors_result = 0;
    public boolean parked;
    boolean[] parking_situation;


    public Volvo(){
        this.position = 0;
        this.parking_situation = new boolean[500];
    }

    @Override
    public boolean[] MoveForward() {
        if(position != 500) // if the car is not at the end of the street -> move forward
            this.position++;
        else // don't move forward, just return the same parking situation
            return parking_situation;

        parking_situation[position] = isEmpty(); // sets the position to empty or not empty
        return parking_situation;
    }

    @Override
    public Boolean isEmpty() {

        if (sensors_result == 200)
            return false;
        else
            return true;
    }



    @Override
    public int MoveBackward() {
        this.position = this.position - 1;
        return this.position;
    }

    @Override
    public void Park() {
        parked = true;
    }

    @Override
    public void UnPark() {
        parked = false;
    }

    public void setSensors(int value) {
        sensors_result = value;
    }


    @Override
    public String WhereIs() {
        return "The position of the car is: " + position;
    }

    public boolean isParked(){

        return parked;
    }
}
