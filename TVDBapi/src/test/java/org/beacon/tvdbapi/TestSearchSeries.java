	package org.beacon.tvdbapi;

import org.beacon.tvdbapi.datatypes.TVShow;
import org.junit.Test;


public class TestSearchSeries {

    @Test
    public void test() {
        for(TVShow serie : new TVDBapi().getTVShows("big")){
            System.out.println(serie.getName());
        }
        
    }

}
