package toyshop_draw;

import java.util.List;

public class toysForDraw {
    private List<Toy> toyListForDraw;

    public toysForDraw(List<Toy> toys){
        this.toyListForDraw = toys;
    }

    public void setToysForDraw(List<Toy> toys){
        this.toyListForDraw = toys;
    }

    public List<Toy> getToys(){
        return toyListForDraw;
    }

}
