import io.pivotal.dsta.GeoHasher;
import io.pivotal.dsta.GeoHasherOptionsMetadata;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cq on 16/5/15.
 */
public class GeoHasherTests {


    private final GeoHasherOptionsMetadata optionsMetadata = new GeoHasherOptionsMetadata();
    private GeoHasher geoHasher;


    @Test
    public void testGeoHashCreation() {

        optionsMetadata.setGeoHashSize(5);
        optionsMetadata.setLatPos(0);
        optionsMetadata.setLngPos(1);
        geoHasher = new GeoHasher(optionsMetadata);
        String eventWithGeoHash = geoHasher.process("10.02,25.32");
        Assert.assertNotNull(eventWithGeoHash);

    }

    @Test
    public void testGeoHashSize() {

        optionsMetadata.setGeoHashSize(5);
        optionsMetadata.setLatPos(0);
        optionsMetadata.setLngPos(1);
        geoHasher = new GeoHasher(optionsMetadata);
        String eventWithGeoHash = geoHasher.process("11.02,35.32");
        Assert.assertEquals(5, eventWithGeoHash.split(",")[2].length());
    }

    @Test
    public void testHashInjectionToEvent(){

        optionsMetadata.setGeoHashSize(5);
        optionsMetadata.setLatPos(0);
        optionsMetadata.setLngPos(1);
        GeoHasher geoHasher = new GeoHasher(optionsMetadata);
        String eventWithGeoHash = geoHasher.process("12.02,45.32");
        Assert.assertEquals("t40hr",eventWithGeoHash.split(",")[2]);
    }

    @Test
    public void testLatLngPosition(){
        optionsMetadata.setGeoHashSize(5);
        optionsMetadata.setLatPos(2);
        optionsMetadata.setLngPos(4);
        geoHasher = new GeoHasher(optionsMetadata);
        String eventWithGeoHash = geoHasher.process("hello,world,13.02,again,55.32");
        Assert.assertEquals("t4r64",eventWithGeoHash.split(",")[5]);
    }


}
