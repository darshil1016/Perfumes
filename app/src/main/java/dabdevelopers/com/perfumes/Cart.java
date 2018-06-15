package dabdevelopers.com.perfumes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toast.makeText(Cart.this,"In cart class",Toast.LENGTH_SHORT).show();
    }
}
