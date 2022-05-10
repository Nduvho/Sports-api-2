package Request;

import Request.Query;
import Request.Referee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefereeResponse {
    private List<Referee> data;
    private Query query;

    @Override
    public String toString(){
        return "Request.Referee " + data + query;
    }

    public List<Referee> getData() {
        return data;
    }

    public void setData(List<Referee> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
