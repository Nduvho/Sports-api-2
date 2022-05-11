package com.sportdataapi.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonResponse {

    private List<Season> data;
    private Query query;

    @Override
    public String toString(){
        return "Request.Season" + data + query;
    }

    public List<Season> getData() {
        return data;
    }

    public void setData(List<Season> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
