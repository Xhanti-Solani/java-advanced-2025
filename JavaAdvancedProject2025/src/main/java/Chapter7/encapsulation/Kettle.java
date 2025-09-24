package Chapter7.encapsulation;


/**
 * @author Xhanti Solani
 *
 */



public class Kettle {

    // enum to keep kettle state
    private enum State {
            ON,
            OFF,
            EMPTY,
            REFILLING,
            BOILING
    }
    //Attributes
    private State state;

    // getters abd setters
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    // Methods
    public void switchOn() {
        System.out.println("Switching on");
       setState(State.ON);
    }
    public void switchOff() {
        System.out.println("Switching off");
        setState(State.OFF);
    }
    public void putWater() {
        System.out.println("Putting water");
        setState(State.REFILLING);
    }
    private void accessElectricity() {
        System.out.println("Accessing electricity");
    }

    public void boiling() {
        System.out.println("Boiling");
        setState(State.BOILING);
    }

    public void fill() {
        System.out.println("Filling");
        setState(State.REFILLING);
    }
    public void empty() {
        System.out.println("Empty");
        setState(State.EMPTY);
    }

    public void fillAndBoil() {
        System.out.println("Filling and boiling");
        setState(State.REFILLING);
        accessElectricity();
    }





}

