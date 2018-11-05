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
        if (current == 0.0) {
            calculateCurrent(tension, resistance, power);
        }
        if (resistance == 0.0) {
            calculateResistance(tension, current, power);
        }
        if (tension == 0.0) {
            calculateTension(power, current, resistance);
        }
    }

    private void calculatePower(double tension, double current, double resistance) {
        if (resistance == 0.0) {
            power = tension * current;
        }
        if (tension == 0.0) {
            power = resistance * (current * current);
        }
        if (current == 0.0) {
            power = (tension * tension) / resistance;
        }
    }

    private void calculateCurrent(double tension, double resistance, double power) {
        if (tension == 0.0) {
            current = Math.sqrt(power / resistance);
        }
        if (resistance == 0.0) {
            current = power / tension;
        }
        if (power == 0.0) {
            current = tension / resistance;
        }
    }

    private void calculateTension(double power, double current, double resistance) {
        if (power == 0.0) {
            tension = resistance * current;
        }
        if (current == 0.0) {
            tension = Math.sqrt((power * resistance));
        }
        if (resistance == 0.0) {
            tension = power / current;
        }
    }

    private void calculateResistance(double tension, double current, double power) {
        if (tension == 0.0) {
            resistance = power / (current * current);
        }
        if (current == 0.0) {
            resistance = (tension + tension) / power;
        }
        if (power == 0.0) {
            resistance = tension / current;
        }
    }
}