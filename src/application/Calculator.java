package application;

/**
 * Calculates the formula wheel
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
        } else if (current == 0.00) {
            calculateCurrent(tension, resistance, power);
        } else if (resistance = 0.00) {
            calculateResistance(tension, current, power);
        }
    }

    private void calculatePower(double tension, double current, double resistance) {
        if (resistance == 0.0) {
            power = tension * current;
        }
        if (tension == 0.0) {
            power = resistance * (current * current);
        } else {
            power = (tension * tension) / resistance;
        }
    }

    private void calculateCurrent(double tension, double resistance, double power){
        // Calculate
		if(tension == 0.00){
			current = sqrt(power / resistance);
		}

		if(resistance == 0.00){
			current = power / tension;
		}

		if(power == 0.00) {
            current = tension / resistance;
        }
	}

    private void calculateResistance(double tension, double current, double power) {
        // Calculate
        if (tension == 0.00) {
            resistance = power / (current * current);
        }

        if (current = 0.00) {
            resistance = (tension + tension) / power;
        }

        if (power = 0.00) {
            resistance = tension / current;
        }
    }
}