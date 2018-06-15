package dabdevelopers.com.perfumes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class HomePage extends AppCompatActivity implements View.OnClickListener {


    GridView grid;
    ArrayList<ItemDetails> checkout;
    CustomGrid cg;

    String[] perfumes = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr",
            "Pinterest",
            "Quora",
            "Twitter",
            "Vimeo",
            "WordPress",
            "Youtube",
            "Stumbleupon",
            "SoundCloud",
            "Reddit",
            "Blogger"

    } ;
    int[] imageId = {
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per,
            R.drawable.per

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        Button toolcart=(Button)toolbar.findViewById(R.id.toolcart);
        Button toolwish=(Button)toolbar.findViewById(R.id.toolwish);
        //checkout=new ArrayList<ItemDetails>();
        cg=new CustomGrid();


        CustomGrid adapter = new CustomGrid(HomePage.this, perfumes, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(HomePage.this, "You Clicked at " , Toast.LENGTH_SHORT).show();

            }
        });

        toolcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent i=new Intent(HomePage.this,Cart.class);



                   //checkout=cg.goToCart();
                Intent i=new Intent(HomePage.this,Cart.class);
                Toast.makeText(HomePage.this,"Clicked cart "+cg.checkout,Toast.LENGTH_SHORT).show();

            }
        });

        toolwish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this,"Clicked wish",Toast.LENGTH_SHORT).show();

            }
        });








    }

    @Override
    public void onClick(View view) {
        Toast.makeText(HomePage.this, "You Clicked at xxxxx " , Toast.LENGTH_SHORT).show();
    }
}

