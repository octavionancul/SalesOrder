package cl.octavionancul.salesorder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.octavionancul.salesorder.adapters.SalesOrderClickListener;
import cl.octavionancul.salesorder.adapters.SalesOrdersAdapter;
import cl.octavionancul.salesorder.models.SalesOrder;

import static android.text.TextUtils.isEmpty;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements SalesOrderClickListener{
    public static final String SALES_ORDER_ID = "cl.octavionancul.salesorder.KEY.SALES_ORDER_ID";
private  SalesOrdersAdapter adapter;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = view.findViewById(R.id.salesorderRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);

 /*       List<SalesOrder> salesOrderList = new ArrayList<>();

        salesOrderList.add(new SalesOrder("producto1",1,100));

        salesOrderList.add(new SalesOrder("producto2",1,200));*/

        adapter = new SalesOrdersAdapter(this);

        recyclerView.setAdapter(adapter);

        final EditText productEt = view.findViewById(R.id.productEt);
        final EditText quantityEt = view.findViewById(R.id.quantityEt);
        final EditText priceEt = view.findViewById(R.id.priceEt);

        Button button = view.findViewById(R.id.saveBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isEmpty(productEt.getText().toString())) {
                    productEt.setError("Ingrese producto");

                } else if (isEmpty(quantityEt.getText().toString())) {
                    quantityEt.setError("Ingrese cantidad");

                } else if (isEmpty(priceEt.getText().toString())) {
                    priceEt.setError("Ingrese precio");

                }else{
                    String product = productEt.getText().toString();
                    int quantity = Integer.parseInt(quantityEt.getText().toString());
                    int price = Integer.parseInt(priceEt.getText().toString());

                    SalesOrder salesOrder = new SalesOrder(product,quantity,price);
                    salesOrder.save();

                //   recyclerView.scrollToPosition(adapter.getItemCount()-1);
                    updateList(salesOrder);

                        recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);



                }

            }
        });


    }

    public void updateList(SalesOrder salesOrder){

        adapter.update(salesOrder);
    }


    @Override
    public void clickedID(long id) {

        Intent intent = new Intent(getContext(),DetailsActivity.class);
        intent.putExtra(SALES_ORDER_ID,id);
        startActivity(intent);

    }
}
