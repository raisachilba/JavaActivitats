package ProgOrientadaObjectes.Carrera;

public class Team {

    private String name;
    private Runner[] runners;
    private int numRunners;
    private boolean international;

    public Team(String name, boolean international){
        this.name = name;
        runners = new Runner[5];
        numRunners = 0;
        this.international = international;
    }

    public String getName() { return name; }
    public Runner[] getRunners() { return runners; }
    public int getNumRunners() { return numRunners; }
    public boolean isInternational() { return international; }

    public void setName(String name) { this.name = name; }
    public void setRunners(Runner[] runners) { this.runners = runners; }
    public void setNumRunners(int numRunners) { this.numRunners = numRunners; }
    public void setInternational(boolean international) { this.international = international; }

    public void addRunner(Runner r){
        for ( int i = 0; i>runners.length-1; i++){
            if(runners[i] == null){
                runners[i] = r;
                numRunners++;
                break;
            }
        }
    }

    public float averageTimes(){
        if(numRunners == 0){
            return 0;
        }
        else {
            float sumTimes = 0;
            for (int i = 0; i < numRunners; i++) {
                sumTimes += runners[i].averageTimes();
            }
            return sumTimes / numRunners;
        }
    }

    public boolean areAllProfessionals(){
        for(int i=0; i<numRunners; i++){
            Runner r = getRunners()[i];
            if(!r.isProfessional()){
                return false;
            }
        }
        return true;
    }
    public int getNumProfessionals() {
        int np = 0;
        for (int i = 0; i < numRunners; i++) {
            Runner ri = runners[i];
            if (ri.isProfessional()) {
                np++;
            }
        }
        return np;
    }
}