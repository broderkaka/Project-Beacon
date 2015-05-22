package org.beacon.tvshow;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.beacon.tvdb.gen.searchSeries.SeriesList;

import java.util.ArrayList;
import java.util.List;

public class TVShowTemplateList {
    @JsonProperty("tvshows")
    private List<TVShowTemplate> tvshowList;

    public static TVShowTemplateList EMPTY = new TVShowTemplateList();
    private TVShowTemplateList()
    {
        tvshowList = new ArrayList<>();
    }

    public static TVShowTemplateList fromSeriesList(SeriesList seriesList)
    {
        TVShowTemplateList list = new TVShowTemplateList();
        for(SeriesList.Series serie: seriesList.getSeries())
        {
            list.tvshowList.add(TVShowTemplate.fromSeries(serie));
        }
        return list;
    }


}
