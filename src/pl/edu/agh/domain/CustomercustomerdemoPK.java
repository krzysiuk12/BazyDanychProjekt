package pl.edu.agh.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Krzysiu on 2014-04-02.
 */
public class CustomercustomerdemoPK implements Serializable {
    private String customerid;
    private String customertypeid;

    @Column(name = "customerid")
    @Id
    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    @Column(name = "customertypeid")
    @Id
    public String getCustomertypeid() {
        return customertypeid;
    }

    public void setCustomertypeid(String customertypeid) {
        this.customertypeid = customertypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomercustomerdemoPK that = (CustomercustomerdemoPK) o;

        if (customerid != null ? !customerid.equals(that.customerid) : that.customerid != null) return false;
        if (customertypeid != null ? !customertypeid.equals(that.customertypeid) : that.customertypeid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerid != null ? customerid.hashCode() : 0;
        result = 31 * result + (customertypeid != null ? customertypeid.hashCode() : 0);
        return result;
    }
}
