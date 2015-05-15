package io.pivotal.dsta;

import com.github.davidmoten.geo.GeoHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;

/**
 * Created by cq on 16/5/15.
 */
public class GeoHasher {


    @Value("${geoHashSize}")
    private int geoHashSize;

    @Value("${latPos}")
    private int latPos;

    @Value("${lngPos}")
    private int lngPos;


    public GeoHasher(GeoHasherOptionsMetadata optionsMetadata){
        geoHashSize = optionsMetadata.getGeoHashSize();
        latPos = optionsMetadata.getLatPos();
        lngPos = optionsMetadata.getLngPos();
    }

    public GeoHasher(){}

    /**
     * Generates a geohash from the coordinates passed on the event.
     * @param event
     * @return
     */
    public String process(String event) {

        Assert.notNull(event);
        String[] csvFields = event.split(",");
        double lat = Double.valueOf(csvFields[latPos]);
        double lng = Double.valueOf(csvFields[lngPos]);

        String geoHash = GeoHash.encodeHash(lat, lng, geoHashSize);

        String[] newCSVFields = new String[csvFields.length + 1];
        System.arraycopy(csvFields,0,newCSVFields,0,csvFields.length);
        newCSVFields[newCSVFields.length - 1] = geoHash;

        String csv = String.join(",", newCSVFields);

        return csv;
    }


}
