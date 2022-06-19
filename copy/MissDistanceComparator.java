package hw7.copy;

public class MissDistanceComparator implements java.util.Comparator<NearEarthObject> {

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
