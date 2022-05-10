package Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookMakers {
    public int bookmaker_id;
    public String name;

    @Override
    public String toString(){
        return "Bookmaker name" + name;
    }

    public int getBookmaker_id() {
        return bookmaker_id;
    }

    public void setBookmaker_id(int bookmaker_id) {
        this.bookmaker_id = bookmaker_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
