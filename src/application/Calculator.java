package application;

/**
 * Calculates the formula wheel
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
    private double power;
    private double tension;
    private double current;
    private double resistance;
    private double newPower;
    private double newTension;
    private double newCurrent;
    private double newResistance;

    Calculator(double power, double tension, double current, double resistance) {
        super();
        this.power = power;
        this.tension = tension;
        this.current = current;
        this.resistance = resistance;
    }

    double getPower() {
        return power;
    }

    double getTension() {
        return tension;
    }

    double getCurrent() {
        return current;
    }

    double getResistance() {
        return resistance;
    }

    @Override
    public String toString() {
        return "Calculator [power=" + power +
                ", tension=" + tension +
                ", current=" + current +
                ", resistance=" + resistance + "]";
    }

    void calculate() {
        if (canCalculatePower()) {
            calculatePower();
        }
        if (canCalculateCurrent()) {
            calculateCurrent();
        }
        if (canCalculateResistance()) {
            calculateResistance();
        }
        if (canCalculateTension()) {
            calculateTension();
        }

        setResults();
    }

    private void setResults() {
        if (newPower != 0.0) {
            power = newPower;
        }
        if (newCurrent != 0.0) {
            current = newCurrent;
        }
        if (newTension != 0.0) {
            tension = newTension;
        }
        if (newResistance != 0.0) {
            resistance = newResistance;
        }
    }

    private void calculatePower() {
        if (tension != 0.0 && current != 0.0) {
            newPower = tension * current;
            System.out.println("Power = " + tension + " + " + current);
            System.out.println("Power = " + newPower);
        }
        if (resistance != 0.0 && current != 0.0) {
            newPower = resistance * (current * current);
            System.out.println("Power = " + resistance + " * (" + current + " * " + current + ")");
            System.out.println("Power = " + newPower);
        }
        if (tension != 0.0 && resistance != 0.0) {
            newPower = (tension * tension) / resistance;
            System.out.println("Power = " + "(" + tension + " * " + tension + ") / " + resistance);
            System.out.println("Power = " + newPower);
        }
    }

    private void calculateCurrent() {
        if (power != 0.0 && resistance != 0.0) {
            newCurrent = Math.sqrt(power / resistance);
            System.out.println("Current = " + "square root (" + power + " / " + resistance + ")");
            System.out.println("Current = " + newCurrent);
        }
        if (power != 0.0 && tension != 0.0) {
            newCurrent = power / tension;
            System.out.println("Current = " + power + " / " + tension);
            System.out.println("Current = " + newCurrent);
        }
        if (tension != 0.0 && resistance != 0.0) {
            newCurrent = tension / resistance;
            System.out.println("Current = " + tension + " / " + resistance);
            System.out.println("Current = " + newCurrent);
        }
    }

    private void calculateTension() {
        if (resistance != 0.0 && current != 0.0) {
            newTension = resistance * current;
            System.out.println("Tension = " + resistance + " * " + current);
            System.out.println("Tension = " + newTension);
        }
        if (power != 0.0 && resistance != 0.0) {
            newTension = Math.sqrt((power * resistance));
            System.out.println("Tension = " + "square root (" + power + " * " + resistance + ")");
            System.out.println("Tension = " + newTension);
        }
        if (power != 0.0 && current != 0.0) {
            newTension = power / current;
            System.out.println("Tension = " + power + " / " + current);
            System.out.println("Tension = " + newTension);
        }
    }

    private void calculateResistance() {
        if (power != 0.0 && current != 0.0) {
            newResistance = power / (current * current);
            System.out.println("Resistance = " + power + " / (" + current + " * " + current + ")");
            System.out.println("Resistance = " + newResistance);
        }
        if (tension != 0.0 && power != 0.0) {
            newResistance = (tension * tension) / power;
            System.out.println("Resistance = (" + tension + "+" + tension + ") / " + power);
            System.out.println("Resistance = " + newResistance);
        }
        if (tension != 0.0 && current != 0.0) {
            newResistance = tension / current;
            System.out.println("Resistance = " + tension + " / " + current);
            System.out.println("Resistance = " + newResistance);
        }
    }

    private boolean canCalculatePower() {
        boolean output = false;
        if (getTension() != 0.0 && getResistance() != 0.0) {
            output = true;
        }
        if (getTension() != 0.0 && getCurrent() != 0.0) {
            output = true;
        }
        if (getResistance() != 0.0 && getCurrent() != 0.0) {
            output = true;
        }
        return output;
    }

    private boolean canCalculateCurrent() {
        boolean output = false;
        if (getPower() != 0.0 && getResistance() != 0.0) {
            output = true;
        }
        if (getPower() != 0.0 && getTension() != 0.0) {
            output = true;
        }
        if (getResistance() != 0.0 && getTension() != 0.0) {
            output = true;
        }
        return output;
    }

    private boolean canCalculateResistance() {
        boolean output = false;
        if (getTension() != 0.0 && getPower() != 0.0) {
            output = true;
        }
        if (getTension() != 0.0 && getCurrent() != 0.0) {
            output = true;
        }
        if (getPower() != 0.0 && getCurrent() != 0.0) {
            output = true;
        }
        return output;
    }

    private boolean canCalculateTension() {
        boolean output = false;
        if (getCurrent() != 0.0 && getResistance() != 0.0) {
            output = true;
        }
        if (getPower() != 0.0 && getCurrent() != 0.0) {
            output = true;
        }
        if (getResistance() != 0.0 && getPower() != 0.0) {
            output = true;
        }
        return output;
    }

    boolean powerChanged() {
        return power == newPower;
    }

    boolean currentChanged() {
        return current == newCurrent;
    }

    boolean tensionChanged() {
        return tension == newCurrent;
    }

    boolean resistanceChanged() {
        return resistance == newResistance;
    }
}