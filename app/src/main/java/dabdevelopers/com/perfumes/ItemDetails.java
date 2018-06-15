package dabdevelopers.com.perfumes;

/**
 * Created by darshil10 on 12/6/18.
 */

class ItemDetails {

    String name;
    int price, imageid;
    ItemDetails(){

    }
    ItemDetails(String name,int price,int imageid)
    {
        this.name=name;
        this.price=price;
        this.imageid=imageid;
    }

    public String getName(){
        return name;
    }

    public int getImageid() {
        return imageid;
    }

    public int getPrice() {
        return price;
    }
}
