package hw7.copy;

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

    public String toString() {
    	SimpleDateFormat formatter= new SimpleDateFormat("yy-MM-dd");
		String date = formatter.format(this.closestApproachDate);
		String id = String.valueOf(this.referenceID);
		String name = this.name.substring(this.name.lastIndexOf("("));
		String mag = String.valueOf(this.absoluteMagnitude).substring(0, 4);
		String dia = String.valueOf(this.averageDiameter).substring(0,5);
		String isd = String.valueOf(this.isDangerous);
		String miss = String.valueOf(this.missDistance).substring(0,8);
        return String.format("%9s%15s%7s%9s%10s%13s%12s%9s", id,name,mag,dia,isd,date,miss,this.orbitingBody);
    }

    public int getReferenceID() {
        return this.referenceID;
    }

    public void setReferenceID(int referenceID) {
        this.referenceID = referenceID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAbsoluteMagnitude() {
        return this.absoluteMagnitude;
    }

    public void setAbsoluteMagnitude(double absoluteMagnitude) {
        this.absoluteMagnitude = absoluteMagnitude;
    }

    public double getAverageDiameter() {
        return this.averageDiameter;
    }

    public void setAverageDiameter(double averageDiameter) {
        this.averageDiameter = averageDiameter;
    }

    public boolean getIsDangerous() {
        return this.isDangerous;
    }

    public void setIsDangerous(boolean isDangerous) {
        this.isDangerous = isDangerous;
    }

    public Date getClosestApproachDate() {
        return this.closestApproachDate;
    }

    public void setClosestApproachDate(Date closestApproachDate) {
        this.closestApproachDate = closestApproachDate;
    }

    public double getMissDistance() {
        return this.missDistance;
    }

    public void setMissDistance(double missDistance) {
        this.missDistance = missDistance;
    }

    public String getOrbitingBody() {
        return this.orbitingBody;
    }

    public void setOrbitingBody(String orbitingBody) {
        this.orbitingBody = orbitingBody;
    }

}
