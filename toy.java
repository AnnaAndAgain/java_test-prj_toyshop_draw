package toyshop_draw;

public class toy {
    private int toyID;
    private String name;
    private int qty;
    private int drawWeight;

    public toy(int ID, String name, int quantity, int weight){
        this.toyID = ID;
        this.name = name;
        this.qty = quantity;
        this.drawWeight = weight;
    }

    public String getName(){
        return name;
    }

    public Integer getId(){
        return toyID;
    }
    
    public Integer getQuantity(){
        return qty;
    }
    
    public Integer getWeight(){
        return drawWeight;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(Integer quantity){
        this.qty = quantity;
    }

    public void setWeight(Integer weight){
        this.drawWeight = weight;
    }

    public void addQuantity(Integer quantity){
        this.qty += quantity;
    }

    @Override
    public String toString(){
        return "Toy{" + 
                "ID=" + String.valueOf(toyID) + 
                "; name=" + name + 
                "; quantity=" + String.valueOf(qty) +
                "; weight=" + String.valueOf(drawWeight) +
                "} \n";

    }


}
