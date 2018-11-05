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
        calculateCurrent(tension, resistance, power);
    }

    private void calculateCurrent(double tension, double resistance, double power){
    	//Calculate
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
}
