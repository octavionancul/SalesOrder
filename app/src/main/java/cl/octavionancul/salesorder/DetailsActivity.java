package cl.octavionancul.salesorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cl.octavionancul.salesorder.models.SalesOrder;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long id = getIntent().getLongExtra(MainActivityFragment.SALES_ORDER_ID,0);

        SalesOrder salesOrder = SalesOrder.findById(SalesOrder.class,id);


        TextView productdTv = findViewById(R.id.productodTv);
        TextView quantitydTv =  findViewById(R.id.quantitydTv);
        TextView pricedTv = findViewById(R.id.pricedTv);

        productdTv.setText(salesOrder.getProduct());
        quantitydTv.setText(Integer.toString(salesOrder.getQuantity()));
       pricedTv.setText(Integer.toString(salesOrder.getPrice()));


    }
}
