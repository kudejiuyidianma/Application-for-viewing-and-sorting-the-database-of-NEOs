package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {
	/**
	 * Compare the two arguments based on the value of their miss distance.
	 */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getMissDistance() == right.getMissDistance()) {
            return 0;
        } else if (left.getMissDistance() > right.getMissDistance()) {
            return 1;
        } else {
            return -1;
        }
    }
}
