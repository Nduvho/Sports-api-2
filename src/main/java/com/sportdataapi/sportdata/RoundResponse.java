package com.sportdataapi.sportdata;

import java.util.List;

public class RoundResponse {
    private List<Round> data;
    private Query query;



    @Override
    public String toString(){
        return "Round " + data + query;
    }

    public List<Round> getData() {
        return data;
    }

    public void setData(List<Round> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
