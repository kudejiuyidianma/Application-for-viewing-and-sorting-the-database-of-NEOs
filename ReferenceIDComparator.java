package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {

	/**
	 * Compare the two arguments based on the value of their reference ID.
	 */
    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        if (left.getReferenceID() == right.getReferenceID()) {
            return 0;
        } else if (left.getReferenceID() > right.getReferenceID()){
            return 1;
        } else {
            return -1;
        }
    }

}
