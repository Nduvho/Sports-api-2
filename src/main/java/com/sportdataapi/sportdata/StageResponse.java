package com.sportdataapi.sportdata;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StageResponse {
    private List< Stage> data;
    private Query query;

    @Override
    public String toString(){
        return "Stage " + data + query;
    }

    public List<Stage> getData() {
        return data;
    }

    public void setData(List<Stage> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
