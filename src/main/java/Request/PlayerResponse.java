package Request;

import Request.Player;
import Request.Query;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse {
    private List<Player> data;
    private Query query;

    @Override
    public String toString(){
        return "Request.Player " + data + query;
    }


    public List<Player> getData() {
        return data;
    }

    public void setData(List<Player> data) {
        this.data = data;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
