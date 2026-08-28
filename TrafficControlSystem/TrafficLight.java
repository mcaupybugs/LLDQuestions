package TrafficControlSystem;

public class TrafficLight {
    private final int trafficLightId;
    private final Direction direction;
    private TrafficLightState trafficLightState;

    public TrafficLight(int trafficLightId, Direction direction) {
        this.trafficLightId = trafficLightId;
        this.direction = direction;
        this.trafficLightState = TrafficLightState.RED;
    }

    public int getTrafficLightId() {
        return trafficLightId;
    }

    public Direction getDirection() {
        return direction;
    }

    public TrafficLightState getTrafficLightState() {
        return trafficLightState;
    }

    public void forceState(TrafficLightState state) {
        this.trafficLightState = state;
    }

    @Override
    public String toString() {
        return "Light " + trafficLightId + " (" + direction + ")=" + trafficLightState;
    }
}
