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
        if (power == 0.0) {
            calculatePower(tension, current, resistance);
        }
    }

    private void calculatePower(double tension, double current, double resistance) {
        if (resistance == 0.0) {
            power = tension * current;
        }
        if (tension == 0.0) {
            power = resistance * (current * current);
        }
        else {
            power = (tension * tension) / resistance;
        }
    }
}
