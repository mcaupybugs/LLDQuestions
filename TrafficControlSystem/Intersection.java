package TrafficControlSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Intersection {
    private final int intersectionId;
    private final List<TrafficLight> trafficLights;
    private final List<Phase> phases;
    private final TrafficControlStrategy trafficControlStrategy;
    private int currentPhaseIndex;
    private ControlMode controlMode;
    private Phase manualPhase;

    public Intersection(
            int intersectionId,
            List<TrafficLight> trafficLights,
            List<Phase> phases,
            TrafficControlStrategy trafficControlStrategy) {
        if (trafficLights == null || trafficLights.isEmpty()) {
            throw new IllegalArgumentException("Intersection must have traffic lights.");
        }
        if (phases == null || phases.isEmpty()) {
            throw new IllegalArgumentException("Intersection must have phases.");
        }

        this.intersectionId = intersectionId;
        this.trafficLights = new ArrayList<>(trafficLights);
        this.phases = new ArrayList<>(phases);
        this.trafficControlStrategy = trafficControlStrategy;
        this.currentPhaseIndex = 0;
        this.controlMode = ControlMode.AUTOMATIC;
        this.manualPhase = null;

        applyPhase(this.phases.get(currentPhaseIndex));
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public List<Phase> getPhases() {
        return Collections.unmodifiableList(phases);
    }

    public int getCurrentPhaseIndex() {
        return currentPhaseIndex;
    }

    public ControlMode getControlMode() {
        return controlMode;
    }

    public void advance() {
        if (controlMode != ControlMode.MANUAL) {
            Phase nextPhase = trafficControlStrategy.getNextPhase(this);
            currentPhaseIndex = phases.indexOf(nextPhase);
            applyPhase(nextPhase);
        }
    }

    public void startManualOverride(String phaseName) {
        Phase selectedPhase = findPhase(phaseName);
        controlMode = ControlMode.MANUAL;
        manualPhase = selectedPhase;
        applyPhase(selectedPhase);
    }

    public void stopManualOverride() {
        if (controlMode != ControlMode.MANUAL) {
            return;
        }

        controlMode = ControlMode.AUTOMATIC;
        manualPhase = null;
        applyPhase(phases.get(currentPhaseIndex));
    }

    public String getStatus() {
        StringBuilder builder = new StringBuilder();
        builder.append("Intersection ")
                .append(intersectionId)
                .append(" [mode=")
                .append(controlMode)
                .append(", phase=")
                .append(getActivePhase().getPhaseName())
                .append("] ");

        for (TrafficLight trafficLight : trafficLights) {
            builder.append(trafficLight).append(" ");
        }

        return builder.toString().trim();
    }

    private Phase getActivePhase() {
        if (controlMode == ControlMode.MANUAL) {
            return manualPhase;
        }
        return phases.get(currentPhaseIndex);
    }

    private void applyPhase(Phase phase) {
        for (TrafficLight trafficLight : trafficLights) {
            if (phase.getAllowedDirections().contains(trafficLight.getDirection())) {
                trafficLight.forceState(TrafficLightState.GREEN);
            } else {
                trafficLight.forceState(TrafficLightState.RED);
            }
        }
    }

    private Phase findPhase(String phaseName) {
        return phases.stream()
                .filter(phase -> phase.getPhaseName().equalsIgnoreCase(phaseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Phase not found for intersection."));
    }
}