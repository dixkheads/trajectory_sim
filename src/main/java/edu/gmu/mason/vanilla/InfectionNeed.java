package edu.gmu.mason.vanilla;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

import edu.gmu.mason.vanilla.environment.Job;
import edu.gmu.mason.vanilla.environment.SpatialNetwork;
import edu.gmu.mason.vanilla.environment.Travel;
import edu.gmu.mason.vanilla.log.Skip;
import edu.gmu.mason.vanilla.log.State;
import edu.gmu.mason.vanilla.utils.ChangeApartmentInstruction;
import edu.gmu.mason.vanilla.utils.ChangeJobInstruction;
import edu.gmu.mason.vanilla.utils.CollectionUtil;
import edu.gmu.mason.vanilla.utils.DateTimeUtil;

public class InfectionNeed implements Need, java.io.Serializable{
    private static final long serialVersionUID = 14342964231251311L;
    @Skip
    private Person agent;
    @State
    private InfectionStatus infectionStatus;
    @State
    private VaccinationStatus vaccinationStatus = VaccinationStatus.Unvaccinated;
    @Skip
    private LocalDateTime lastInfectedTime;
    @Skip
    private LocalDateTime lastVaccinatedTime;
    public InfectionNeed(Person agent) {
        this.agent = agent;
    }
    public void setInfectionStatus(InfectionStatus infectionStatus) {
        this.infectionStatus = infectionStatus;
        if(infectionStatus != InfectionStatus.Healthy) {
            this.lastInfectedTime = agent.getSimulationTime();
        }
    }
    public void setVaccinationStatus(VaccinationStatus vaccinationStatus) {
        this.vaccinationStatus = vaccinationStatus;
        if(vaccinationStatus == VaccinationStatus.Vaccinated) {
            this.lastVaccinatedTime = agent.getSimulationTime();
        }
    }
    public void infect() {

    }
    public void cure() {

    }
    @Override
    public void update() {

    }

    /**
     * Attempt to tackle with the current infection status
     */
    @Override
    public void satisfy() {

    }

    @Override
    public boolean isSatisfied() {
        return infectionStatus == InfectionStatus.Healthy;
    }
    public InfectionStatus getInfectionStatus() {
        return infectionStatus;
    }
    public VaccinationStatus getVaccinationStatus() {
        return vaccinationStatus;
    }

    public void kill() {
        this.agent = null;
        this.lastInfectedTime = null;
        this.lastVaccinatedTime = null;

    }
}
