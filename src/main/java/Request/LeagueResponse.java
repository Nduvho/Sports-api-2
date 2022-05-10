package Request;

import Request.League;
import Request.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueResponse {
    private List<League> data;
    private Query query;

    @Override
    public String toString(){
        return "Request.League" + data + query;
    }

    public List<League> getData() {
        return data;
    }

    public void setData(List<League> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
