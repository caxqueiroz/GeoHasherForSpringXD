package io.pivotal.dsta;

import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * Created by cq on 16/5/15.
 */
public class GeoHasherOptionsMetadata {

    private int geoHashSize = 5;

    private int latPos = 0;
    private int lngPos = 1;


    @ModuleOption(value = "the Latitude position in the string (TSV style)", defaultValue = "0")
    public void setLatPos(int pos){
        latPos = pos;
    }


    public int getLatPos(){
        return latPos;
    }

    @ModuleOption(value = "the Longitude position in the string (TSV style)", defaultValue = "1")
    public void setLngPos(int pos){
        lngPos = pos;
    }

    public int getLngPos(){
        return lngPos;
    }


    @ModuleOption(value = "the size of the hash.", defaultValue = "5")
    public void setGeoHashSize(int size) {
        geoHashSize = size;
    }

    /**
     *
     * @return
     */
    public int getGeoHashSize(){
        return geoHashSize;
    }
}
