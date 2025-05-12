package sprint4.texla;

public class Texla extends Automobile{
    protected double autoPilotMaxSpeed;
    protected double autoPilotAcceleration;

    public Texla() {
        autoPilotMaxSpeed = 60;
        autoPilotAcceleration = 11;
    }

    // исправьте метод для ускорения при автопилоте
    public void accelerateByAutopilot() {
        if (speed < autoPilotMaxSpeed){
            speed += autoPilotAcceleration;
        } else {
            speed = autoPilotMaxSpeed;
        }
    }

    @Override
    public void accelerate() {
        if (speed < maxSpeed) {
            speed += acceleration;
        } else {
            speed = maxSpeed;
        }
    }

    @Override
    public void brake() {
        if (speed > 0) {
            speed -= brakingSpeed;
        }
        if (speed < 0) {
            speed = 0;
        }
    }
}


