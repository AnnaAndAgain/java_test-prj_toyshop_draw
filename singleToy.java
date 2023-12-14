package toyshop_draw;

public class singleToy {
    private int toyID;
    private String name;
    private int drawWeight;

    public singleToy(String name, int ID, int weight){
        this.name = name;
        this.toyID = ID;
        this.drawWeight = weight;
    }

    public String getName(){
        return name;
    }

    public Integer getId(){
        return toyID;
    }
            
    public Integer getWeight(){
        return drawWeight;
    }
    
    @Override
    public String toString(){
        return "Toy{" + 
                "ID=" + String.valueOf(toyID) + 
                "; name=" + name + 
                "weight=" + String.valueOf(drawWeight) + '\'' +
                '}';

    }
}
