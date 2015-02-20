package org.beacon.tvdbapi;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;


public class TestFetchEpisodes {

    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException {
        for(int i = 0; i < 500; i++)
        {
            for(Episode ep : new EpisodesSearcher().loadEpisodes("80379")){
                System.out.println(ep.getEpisodeName() + " " + ep.getFirstAired());
            }
        }
        
    }

}
