package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
public class DiameterComparator implements java.util.Comparator<NearEarthObject> {
	/**
	 * Compare the two arguments based on the value of their diameter.
	 */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getAverageDiameter() == right.getAverageDiameter()) {
            return 0;
        } else if (left.getAverageDiameter() > right.getAverageDiameter()) {
            return 1;
        } else {
            return -1;
        }
    }

}
