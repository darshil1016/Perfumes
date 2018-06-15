package dabdevelopers.com.perfumes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by darshil10 on 11/6/18.
 */

public class CustomGrid extends BaseAdapter {
    private Context mContext;
    private String[] perfumes;
    private int[] Imageid;
    ItemDetails itemdetails;
    ArrayList<ItemDetails> checkout;
    ArrayList<ItemDetails> wishlist=new ArrayList<ItemDetails>();
    int flag=0;
    

    public CustomGrid(){}

    public CustomGrid(Context c,String[] perfumes,int[] Imageid ) {
        super();
        mContext = c;
        this.Imageid = Imageid;
        this.perfumes = perfumes;
    }



    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return perfumes.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
             final Button wish = (Button) grid.findViewById(R.id.grid_wish);
            Button cart = (Button) grid.findViewById(R.id.grid_cart);
            textView.setText(perfumes[position]);
            imageView.setImageResource(Imageid[position]);
            checkout=new ArrayList<ItemDetails>();
            wish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    flag=0;

                    for(int i=0;i<wishlist.size();i++)
                    {
                        if((wishlist.get(i).name).equals(perfumes[position]))
                        {
                            flag=1;
                            break;
                        }


                    }
                    if(flag==1)
                        Toast.makeText(mContext,"Already in wishlist",Toast.LENGTH_SHORT).show();
                    else{
                        itemdetails=new ItemDetails(perfumes[position],500,Imageid[position]);
                        wishlist.add(itemdetails);
                        Toast.makeText(mContext,"Adding to wishlist "+perfumes[position],Toast.LENGTH_SHORT).show();
                    }


                   /* if(view.getResources().equals(R.drawable.ic_favorite_black_18dp))
                            wish.setBackgroundResource(R.drawable.cart);
                    else
                        wish.setBackgroundResource(R.drawable.ic_favorite_black_18dp);
                    //Toast.makeText(mContext,"pos "+position,Toast.LENGTH_SHORT).show();*/
                }
            });

            cart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    flag=0;

                   for(int i=0;i<checkout.size();i++)
                    {
                        if((checkout.get(i).name).equals(perfumes[position]))
                        {
                            flag=1;
                            break;
                        }


                    }
                    if(flag==1)
                        Toast.makeText(mContext,"Already in cart "+checkout,Toast.LENGTH_SHORT).show();
                    else{
                    itemdetails=new ItemDetails(perfumes[position],500,Imageid[position]);
                    checkout.add(itemdetails);
                        Toast.makeText(mContext,"Adding to cart "+perfumes[position],Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(mContext,"cart pos "+checkout.get(position).getName(),Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            grid = (View) convertView;
        }




        return grid;
    }

    public ArrayList<ItemDetails> goToCart() {


       /* Intent i=new Intent(mContext,Cart.class);
        i.putExtra("nvp", wishlist);
        mContext.startActivity(i);*/
        return checkout;

    }
}