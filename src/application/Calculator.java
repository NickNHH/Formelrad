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
    }

    private void calculatePower() {
        if (tension != 0.0 && current != 0.0) {
            power = tension * current;
        }
        if (resistance != 0.0 && current != 0.0) {
            power = resistance * (current * current);
        }
        if (tension != 0.0 && resistance != 0.0) {
            power = (tension * tension) / resistance;
        }
    }

    private void calculateCurrent() {
        if (power != 0.0 && resistance != 0.0) {
            current = Math.sqrt(power / resistance);
        }
        if (power != 0.0 && tension != 0.0) {
            current = power / tension;
        }
        if (tension != 0.0 && resistance != 0.0) {
            current = tension / resistance;
        }
    }

    private void calculateTension() {
        if (resistance != 0.0 && current != 0.0) {
            tension = resistance * current;
        }
        if (power != 0.0 && resistance != 0.0) {
            tension = Math.sqrt((power * resistance));
        }
        if (power != 0.0 && current != 0.0) {
            tension = power / current;
        }
    }

    private void calculateResistance() {
        if (power != 0.0 && current != 0.0) {
            resistance = power / (current * current);
        }
        if (tension != 0.0 && power != 0.0) {
            resistance = (tension + tension) / power;
        }
        if (tension != 0.0 && current != 0.0) {
            resistance = tension / current;
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
        if (getPower() != 0.0 && getCurrent() != 0.0) {
            output = true;
        }
        if (getResistance() != 0.0 && getCurrent() != 0.0) {
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
}