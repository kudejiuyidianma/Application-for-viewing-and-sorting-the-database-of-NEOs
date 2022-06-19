package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject> {

	/**
	 * Compare the two arguments based on the value of their approach date.
	 */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return left.getClosestApproachDate().compareTo(right.getClosestApproachDate());
    }
}
