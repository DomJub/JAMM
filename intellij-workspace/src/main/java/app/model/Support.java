package app.model;

/**
 * Created by Jub on 31/05/2017.
 */
public class Support {
    protected String nomSupport;

    public Support(){}

    public Support (String nomSupport){
        this.nomSupport = nomSupport;
    }

    public String getName() {
        return this.nomSupport;
    }

    public void setName(String nomSupport) {
        this.nomSupport = nomSupport;
    }
}
