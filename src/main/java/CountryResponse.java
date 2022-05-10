import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponse {

    private List < Country> data;
    private Query query;

    @Override
   public String toString(){
       return "Country" + data + query;

    }

    public List < Country> getData() {
        return data;
    }

    public void setCountry(List < Country> country) {
        this.data = country;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

}
