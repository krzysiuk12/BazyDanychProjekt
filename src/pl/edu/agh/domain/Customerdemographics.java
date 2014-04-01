package pl.edu.agh.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Krzysiu on 2014-04-02.
 */
@Entity
public class Customerdemographics {
    private String customertypeid;
    private String customerdesc;
    private Collection<Customercustomerdemo> customercustomerdemosByCustomertypeid;

    @Id
    @Column(name = "customertypeid")
    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid;
    }

    @Basic
    @Column(name = "customerdesc")
    public String getCustomerdesc() {
        return customerdesc;
    }

    public void setCustomerdesc(String customerdesc) {
        this.customerdesc = customerdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customerdemographics that = (Customerdemographics) o;

        if (customerdesc != null ? !customerdesc.equals(that.customerdesc) : that.customerdesc != null) return false;
        if (customertypeid != null ? !customertypeid.equals(that.customertypeid) : that.customertypeid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customertypeid != null ? customertypeid.hashCode() : 0;
        result = 31 * result + (customerdesc != null ? customerdesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerdemographicsByCustomertypeid")
    public Collection<Customercustomerdemo> getCustomercustomerdemosByCustomertypeid() {
        return customercustomerdemosByCustomertypeid;
    }

    public void setCustomercustomerdemosByCustomertypeid(Collection<Customercustomerdemo> customercustomerdemosByCustomertypeid) {
        this.customercustomerdemosByCustomertypeid = customercustomerdemosByCustomertypeid;
    }
}
