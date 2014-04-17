package pl.edu.agh.tutorial.mappings.associations.unidirectional.onetomany.xml;

/**
 * Created by Krzysiu on 2014-04-16.
 */
public class Order {

    private Long id;
    private int productAmount;
    private float cost;

    public Order() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getProductAmount() {
        return productAmount;
    }
    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
}
