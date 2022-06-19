package hw7.copy;

public class DiameterComparator implements java.util.Comparator<NearEarthObject> {

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
