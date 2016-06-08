/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methexample.Canvas.MainCanvas.ToolboxPanel;

/**
 *
 * @author ΙΩΑΝΝΑ
 */
    public class Pair <S,P>{ // constactor me pair
    private S sign;
    private P price;
           
    public Pair(S sign2,P price2)
    {
        this.sign=sign2;
        this.price=price2;
    }

    public Pair(S sign2)
    {
        this.sign=sign2;
    }
    
    public Pair(){
        
    }
    
    public S getLeft() {
        return sign;
    }

    public void setLeft(S sign) {
        this.sign = sign;
    }

    public P getRight() {
        return price;
    }

    public void setRight(P price) {
        this.price = price;
    }
}
