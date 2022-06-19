package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import big.data.DataSource;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NeoDatabase {
    public static final String API_KEY = "FU0N0ei49sQFOhvkf1XbpQehtbzuvna7yAKWOdhC";
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
    private ArrayList<NearEarthObject> database;
    
    /**
     * Default constructor.
     */
    public NeoDatabase() {
    	database = new ArrayList<NearEarthObject>();
    }

    /**
     * Builds a query URL given a page number. 
     * @param pageNumber Integer ranging from 0 to 715 indicating the page the user wishes to load.
     * @return a query URL by the given page number
     * @throws IllegalArgumentException If pageNumber is not in the valid range.
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException {
        if (pageNumber >= 0 && pageNumber <= 715) {
            return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);
        } else {
        	throw new IllegalArgumentException();
		}
    }

    /**
     * Opens a connection to the data source indicated by queryURL and adds all NearEarthObjects found in the dataset.
     * @param queryURL String containing the URL requesting a dataset from the NASA NeoW service
     * @throws IllegalArgumentException If queryURL is null or cound not be resolved by the server.
     * @throws JSONException 
     * @throws IOException
     */
    public void addAll(String queryURL) throws IllegalArgumentException, JSONException, IOException {
        if (queryURL == null) {
            throw new IllegalArgumentException();
        }
        HttpsURLConnection conn = null;
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            URL getRequest = new URL(queryURL);
            conn = (HttpsURLConnection) getRequest.openConnection();
            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setUseCaches(false);
            conn.setConnectTimeout(1000 * 100);
            conn.setReadTimeout(1000 * 100);
            conn.connect();

            if(conn.getResponseCode()==200){
                JSONTokener tokener = new JSONTokener(conn.getInputStream());
                JSONObject root = new JSONObject(tokener);
                
                JSONArray arr = root.getJSONArray("near_earth_objects");
                for(int i=0; i<root.length(); i++) {
                	JSONObject neo = arr.getJSONObject(i);
                	int id = Integer.parseInt((String) neo.get("neo_reference_id"));
                	String name = (String) neo.get("name");
                	double absoluteMagnitude = (double) neo.get("absolute_magnitude_h");
                	
                	double minDiameter = Double.parseDouble(neo.getJSONObject("estimated_diameter").getJSONObject("kilometers").get("estimated_diameter_min").toString());
                	double maxDiameter = Double.parseDouble(neo.getJSONObject("estimated_diameter").getJSONObject("kilometers").get("estimated_diameter_max").toString());
                    boolean isDangerous = (boolean) neo.get("is_potentially_hazardous_asteroid");
                    JSONArray close = neo.getJSONArray("close_approach_data");
                    long closestDateTimestamp = (Long) close.getJSONObject(0).get("epoch_date_close_approach");
                    JSONObject miss = close.getJSONObject(0).getJSONObject("miss_distance");
                    double missDistance = Double.parseDouble((String) miss.get("kilometers"));
                    String orbitingBody = (String) close.getJSONObject(0).get("orbiting_body");
                	NearEarthObject object = new NearEarthObject(id,name,absoluteMagnitude,minDiameter,maxDiameter,isDangerous,
                			closestDateTimestamp,missDistance,orbitingBody);
                	database.add(object);
                }
                
                
            }else{
                System.out.printf("Http Connect Error, Error Code: %s", conn.getResponseCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.disconnect();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
    
    
    /**
     * Sorts the database using the specified Comparator of NearEarthObjects.
     * @param comp Comparator of NearEarthObjects which will be used to sort the database. 
     * @throws IllegalArgumentException If comp is null.
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException {
        if (comp == null){
            throw new IllegalArgumentException();
        }
        NearEarthObject[] array = new NearEarthObject[database.size()];
        for(int i=0; i<database.size(); i++) {
        	array[i] = database.get(i);
        }
        Arrays.sort(array, comp);
        database = new ArrayList<NearEarthObject>();
        for(int i=0; i<array.length; i++) {
        	database.add(array[i]);
        }
    }

    /**
     * Displays the database in a neat, tabular form, listing all member variables for each NearEarthObject. 
     * @throws Exception This NeoDatabase is not initialized or null.
     */
    public void printTable() throws Exception {
        if (this.database.get(0) != null) {
            System.out.println("     ID   |      Name    | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
            String div = "======================================================================================";
            System.out.println(div);
            for (int i = 0; i < this.database.size(); i++) {
                System.out.println(this.database.get(i));
            }
        } else {
        	throw new Exception();
		}
    }
}
