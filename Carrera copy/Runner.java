package ProgOrientadaObjectes.Carrera;

public class Runner {

    private String name;
    private String team;
    private String[] raceIDs;
    private float[] times;
    private int numRaces;
    private boolean professional;

    public Runner(String name){
        this.name = name;
        this.team = "Sense Equip";
        this.raceIDs = new String[5];
        this.times = new float[5];
        this.numRaces = 0;
        this.professional = false;

        //Inicialitzar tots els atributs
    }

    public Runner (String name, String team, boolean professional){
        this.name = name;
        this.team = team;
        this.raceIDs = new String[5];
        this.times = new float[5];
        this.numRaces = 0;
        this.professional = professional;
    }

    public String getName() { return name; }
    public String getTeam() { return team; }
    public String[] getRaceIDs() { return raceIDs; }
    public float[] getTimes() { return times; }
    public int getNumRaces() { return numRaces; }
    public boolean isProfessional() { return professional; }

    public void setName(String name) { this.name = name; }
    public void setTeam(String team) { this.team = team; }
    public void setRaceIDs(String[] raceIDs) { this.raceIDs = raceIDs; }
    public void setTimes(float[] times) { this.times = times; }
    public void setNumRaces(int numRaces) { this.numRaces = numRaces; }
    public void setProfessional(boolean professional) { this.professional = professional; }

    public void addRace(String nameRace){
        for ( int i = 0; i>raceIDs.length-1; i++){
            if(raceIDs[i] == null){
                raceIDs[i]= nameRace;
                numRaces++;
                break;
            }
        }
    }

    public void addTime (float t){
        for( int i = 0; i>times.length-1; i++) {
            if (times[i] == 0) {
                times[i] = t;
                break;
            }
        }
    }

    public float bestTime(){
        float minTime = Float.MAX_VALUE;
        for(int i=0; i<numRaces; i++){
            if(times[i]<minTime){
                minTime = times[i];
            }
        }
        return minTime;
    }

    public float averageTimes(){
        if(numRaces==0){
            return 0;
        }
        else {
            float sumTimes = 0;
            for (int i = 0; i < numRaces; i++) {
                sumTimes += times[i];
            }
            return sumTimes / numRaces;
        }
    }

    public String bestRace(){
        float minTime = Float.MAX_VALUE;
        int index = -1;
        for(int i=0; i<numRaces; i++){
            if(times[i]<minTime){
                minTime = times[i];
                index = i;
            }
        }
        return raceIDs[index];
    }

}
