package com.sportdataapi.sportdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamsResponse {
    private List<Teams> data;
    private Query query;

    @Override
    public String toString(){
        return "Teams " + data + query;
    }

    public List<Teams> getData() {
        return data;
    }

    public void setData(List<Teams> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
