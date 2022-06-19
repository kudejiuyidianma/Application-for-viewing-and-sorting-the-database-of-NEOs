package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NearEarthObject {
    private int referenceID;

    private String name;

    private double absoluteMagnitude;

    private double averageDiameter;

    private boolean isDangerous;

    private Date closestApproachDate;

    private double missDistance;

    private String orbitingBody;

    
    
    /**
     * Default Constructor.
     * @param referenceID Unique the ID of the NEO.
     * @param name Unique name of the asteroid or orbital body.
     * @param absoluteMagnitude Absolute brightness of the asteroid or orbital body in the sky.
     * @param minDiameter Estimated minimum diameter of the asteroid or orbital body in kilometers. 
     * @param maxDiameter Estimated maximum diameter of the asteroid or orbital body in kilometers. 
     * @param isDangerous Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     * @param closestDateTimestamp Unix timestamp representing the date of closest approach.
     * @param missDistance Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     * @param orbitingBody Planet or other orbital body which this NEO orbits.
     */ 
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter,
                           boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody) {
        this.referenceID = referenceID;
        this.name = name;
        this.absoluteMagnitude = absoluteMagnitude;
        this.averageDiameter = (maxDiameter - minDiameter) / 2;
        this.isDangerous = isDangerous;
        Date closestApproachDate = new Date(closestDateTimestamp);
        this.closestApproachDate = closestApproachDate;
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }

    
    /**
     * The printer of NEO in certain format.
     */
    public String toString() {
        SimpleDateFormat formatter= new SimpleDateFormat("yy-MM-dd");
		String date = formatter.format(this.closestApproachDate);
		String id = String.valueOf(this.referenceID);
		String name = this.name.substring(this.name.lastIndexOf("("));
		String mag = String.valueOf(this.absoluteMagnitude).substring(0,4);
		String dia = String.valueOf(this.averageDiameter).substring(0,5);
		String isd = String.valueOf(this.isDangerous);
		String miss = String.valueOf(this.missDistance).substring(0,8);
        return String.format("%9s%15s%7s%9s%10s%13s%12s%9s", id,name,mag,dia,isd,date,miss,this.orbitingBody);
    }
    

    /**
     * The getter of the referenceID
     * @return The unique ID of NEO
     */
    public int getReferenceID() {
        return this.referenceID;
    }

    
    /**
     * The setter of referenceID
     * @param referenceID The new unique ID of NEO.
     */
    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    
    /**
     * The getter of the name
     * @return The unique name of NEO
     */
    public String getName() {
        return this.name;
    }
    
    
    /**
     * The setter of the name
     * @param referenceID The new unique name of NEO.
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * The getter of the absoluteMagnitude
     * @return Absolute brightness of the asteroid or orbital body in the sky.
     */
    public double getAbsoluteMagnitude() {
        return this.absoluteMagnitude;
    }

    /**
     * The setter of the absoluteMagnitude
     * @param referenceID New absolute brightness of the asteroid or orbital body in the sky.
     */
    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    
    /**
     * The getter of the averageDiameter
     * @return The average diameter of the NEO
     */
    public double getAverageDiameter() {
        return this.averageDiameter;
    }

    
    /**
     * The setter of the averageDiameter
     * @return New average diameter of the NEO
     */
    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    /**
     * The getter of the isDangerous
     * @return Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     */
    public boolean getIsDangerous() {
        return this.isDangerous;
    }
    
    
    /**
     * The setter of the isDangerous
     * @return New boolean value indicating whether the astroid or orbital body is a potential impact threat.
     */
    public void setIsDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    
    /**
     * The getter of the closestApproachDate
     * @return Unix timestamp representing the date of closest approach.
     */
    public Date getClosestApproachDate() {
        return this.closestApproachDate;
    }

    
    /**
     * The setter of the closestApproachDate
     * @return New unix timestamp representing the date of closest approach.
     */
    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    
    /**
     * The getter of the missDistance
     * @return Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     */
    public double getMissDistance() {
        return this.missDistance;
    }

    
    /**
     * The setter of the missDistance
     * @return New distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     */
    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    
    /**
     * The getter of the orbitingBody
     * @return Planet or other orbital body which this NEO orbits.
     */
    public String getOrbitingBody() {
        return this.orbitingBody;
    }
    
    
    /**
     * The setter of the orbitingBody
     * @return New planet or other orbital body which this NEO orbits.
     */
    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

}
