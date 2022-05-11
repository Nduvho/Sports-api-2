package com.sportdataapi.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookMakersResponse {
    private List<BookMakers> data;
    private Query query;

    @Override
    public String toString(){
        return "Bookmakers " + data + query;
    }

    public List<BookMakers> getData() {
        return data;
    }

    public void setData(List<BookMakers> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
