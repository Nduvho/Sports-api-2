package com.sportdataapi.sportdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueResponse {
    private List<Venue> data;
    private Query query;

    @Override
    public String toString(){
        return "Venue " + data + query;
    }

    public List<Venue> getData() {
        return data;
    }

    public void setData(List<Venue> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
