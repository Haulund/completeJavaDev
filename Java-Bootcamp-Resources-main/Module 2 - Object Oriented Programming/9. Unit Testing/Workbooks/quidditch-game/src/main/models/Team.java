package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers; 

    public Team(String house, String keeper, String seeker, String[] chasers) {
        if(
            house == null || keeper == null || seeker == null || chasers == null ||
            house.isBlank() || keeper.isBlank() || seeker.isBlank()
        ){
            throw new IllegalArgumentException("Parameters for Team cannot be null/blank");
        }
        if (chasers.length != 3) {
            throw new IllegalArgumentException("Chasers Array needs to be = 3");
        }
        if (Team.hasNull(chasers) || Team.hasblank(chasers)){
            throw new IllegalArgumentException("chasers array cannot have null/blank");
        }
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        checkParameter(house);
        this.house = house;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        checkParameter(keeper);
        this.keeper = keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        checkParameter(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length);
    }

    public void setChasers(String[] chasers) {
        if (chasers.length != 3 || hasNull(chasers) || hasblank(chasers)) {
            throw new IllegalArgumentException(chasers + " cannot be null or blank ore less than 3");
        }
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }
    
    public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

    public static boolean hasNull(String[] chasers) {
        return Arrays.stream(chasers).anyMatch(chaser -> chaser == null);
    }

    public static boolean hasblank(String[] chasers) {
        return Arrays.stream(chasers).anyMatch(chaser -> chaser.isBlank());
    }

    public void checkParameter(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }

    public String toString() {
        return "House: " + this.house + "\n" +
          "Keeper: " + this.keeper + "\n" +         
          "Seeker: "  + this.seeker + "\n" +         
          "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if( !(obj instanceof Team)) {
            return false;
        }

        Team team = (Team)obj;
        return this.house.equals(team.house) &&
        this.keeper.equals(team.keeper) &&
        this.seeker.equals(team.seeker) &&
        Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));
    }

    public int hashCode(){
        return Objects.hash(house, keeper, seeker,Arrays.toString(chasers));
    }
}
