package com.sportdataapi.sportdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketResponse {
    private List<Market> data;
    private Query query;

    @Override
    public String toString(){
        return "Markets " + data + query;
    }

    public List<Market> getData() {
        return data;
    }

    public void setData(List<Market> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
