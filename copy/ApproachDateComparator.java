package hw7.copy;

public class ApproachDateComparator implements java.util.Comparator<NearEarthObject> {

    @Override
    public int compare(NearEarthObject left, NearEarthObject right) {
        return left.getClosestApproachDate().compareTo(right.getClosestApproachDate());
    }
}
