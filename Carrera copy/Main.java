package ProgOrientadaObjectes.Carrera;

public class Main {

    public static Team[] allTeams;
    public static Race[] allRaces;
    public static Runner[] allRunners;

    public static void main(String[] args) {

        allTeams = new Team[5];
        allRaces = new Race[10];
        allRunners = new Runner[100];

        allRunners[0] = new Runner("Alicia");
        allRunners[0].setTeam("Atletisme");
        allRunners[0].setProfessional(true);
        allRunners[1] = new Runner("Tomeu", "Golden Soul", true);

        allRunners[0].addRace("Sóller");
        allRunners[0].addTime(10.5f);
        allRunners[1].addRace("Alcúdia");
        allRunners[1].addTime(13.3f);
        allRunners[2].addRace("Palma");
        allRunners[2].addTime(12.9f);
        Runner r1 = allRunners[0];
        System.out.printf("Millor carrera de %s va ser a %s amb temps %.2f. \n",
                r1.getName(), r1.bestRace(), r1.bestTime());


        allTeams[0] = new Team("Equip A", true);
        allTeams[1] = new Team("Equip B", false);
        allTeams[0].addRunner(allRunners[0]);
        allTeams[1].addRunner(allRunners[1]);
        Team t1 = allTeams[0];
        System.out.printf("Temps mig de l'equip %s és %.2f. \n", t1.getName(), t1.averageTimes());


        allRaces[0] = new Race("Marató 1", false, 17);
        allRaces[0].addRunner(allRunners[0]);
        allRaces[0].addTimeToRunner(allRunners[0], 12.5f);

        allRaces[0].addRunner(allRunners[1]);
        allRaces[0].addTimeToRunner(allRunners[1], 14.3f);

        Race c1 = allRaces[0];
        System.out.printf("Millor corredor/a de la carrera %s és %s amb temps %.2f. \n",
                c1.getRaceID(), c1.bestRunner(), c1.bestTime());

        System.out.printf("%s és el millor corredor/a de l'equip %s.\n", bestProfessionalRunnerOfTeam(t1), t1.getName());

        Runner[] classified = getClassifiedRunners(c1, t1.getName());
        System.out.printf("Classificats de la carrera %s:\n", c1.getRaceID());
        for(int i=0; i<classified.length; i++){
            if(classified[i]!=null){
                System.out.printf("\t%s.\n", classified[i].getName());
            }
        }

        System.out.printf("%s és el millor equip.\n", bestTeam(allTeams));
        System.out.printf("L'equip %s té %d corredor/s professionals.\n", t1.getName(), t1.getNumProfessionals());

    }

    public static String bestProfessionalRunnerOfTeam (Team t){
        float minTime = Float.MAX_VALUE;
        String name = "";
        for(int i=0; i<t.getNumRunners();  i++){
            Runner r = t.getRunners()[i];
            if(r.isProfessional()){
                float time = r.bestTime();
                if(time < minTime){
                    minTime = time;
                    name = r.getName();
                }
            }
        }
        return name;
    }

    public static String bestTeam(Team[] teams){
        float minTime = Float.MAX_VALUE;
        int index = -1;
        for(int i=0; i<teams.length; i++){
            if(teams[i]!=null) {
                float time = teams[i].averageTimes();
                if (time < minTime) {
                    minTime = time;
                    index = i;
                }
            }
        }
        return teams[index].getName();
    }

    public static void printClassifiedRunners(Race r, String nameTeam){
        System.out.printf("Corredors classificats a la carrera %s: \n", r.getRaceID());
        for(int i=0; i<r.getNumRunners(); i++){
            Runner runner = r.getRunners()[i];
            float time = r.getTimes()[i];
            if(time < r.getClassificationTime() && runner.getTeam()== nameTeam){
                System.out.printf("\t%s amb temps %.2f.\n", runner.getName(), time);
            }
        }
    }

    public static Runner[] getClassifiedRunners(Race r, String nameTeam){
        Runner[] classified = new Runner[r.getNumRunners()];
        int numClassified = 0;
        for(int i=0; i<r.getNumRunners(); i++){
            Runner runner = r.getRunners()[i];
            float time = r.getTimes()[i];
            if(time < r.getClassificationTime() && runner.getTeam()== nameTeam){
                classified[numClassified] = runner;
                numClassified++;
            }
        }
        return classified;
    }

    public static boolean hasImproved(Runner r, Race[] races){
        float tempsAnterior = Float.MAX_VALUE;
        for(int i=0; i<races.length; i++){
            for(int nr=0; nr<races[i].getNumRunners(); nr++){
                if(races[i].getRunners()[nr] == r){
                    float temps = races[i].getTimes()[nr];
                    if(temps > tempsAnterior){
                        return false;
                    }
                    else {
                        tempsAnterior = temps;
                    }
                }
            }
        }
        return true;
    }

    public static boolean everClassified(Runner r, Race[] races){
        for(int i=0; i<races.length; i++){
            Race race = races[i];
            for(int nr=0; nr<race.getNumRunners(); nr++){
                Runner rr = race.getRunners()[nr];
                float times = race.getTimes()[nr];
                if(r == rr && times > race.getClassificationTime()){
                    return false;
                }
            }
        }
        return true;
    }

    public static float avgNumRunners(Race[] races){
        float sum = 0;
        for(int i=0; i<races.length; i++){
            sum += races[i].getNumRunners();
        }
        return sum / races.length;
    }

    public static float avgTimesRaces(Race[] races){
        float sum = 0;
        for(int i=0; i<races.length; i++){
            sum += races[i].averageTimes();
        }
        return sum / races.length;
    }

    public static String[] racesWhereWinnerIsNotProfessional(Race[] races){
        String[] racesIDs = new String[races.length];
        int numWinners = 0;

        for(int i=0; i<races.length; i++){
            String winnerName = races[i].bestRunner();
            for(int j=0; j<races[i].getNumRunners(); j++){
                Runner r = races[i].getRunners()[j];
                if(r.getName().equals(winnerName)){
                    if(!r.isProfessional()){
                        racesIDs[numWinners] = races[i].getRaceID();
                        numWinners++;
                    }
                    break;
                }
            }
        }
        return racesIDs;
    }
}
