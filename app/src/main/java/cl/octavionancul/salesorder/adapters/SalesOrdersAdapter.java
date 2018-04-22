package cl.octavionancul.salesorder.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.octavionancul.salesorder.R;
import cl.octavionancul.salesorder.data.Queries;
import cl.octavionancul.salesorder.models.SalesOrder;

public class SalesOrdersAdapter extends RecyclerView.Adapter<SalesOrdersAdapter.ViewHolder> {

    private List<SalesOrder> orders = new Queries().salesOrders();

    public SalesOrdersAdapter(SalesOrderClickListener listener) {
        this.listener = listener;
    }

    private SalesOrderClickListener listener;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_salesorder, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        SalesOrder salesOrder = orders.get(position);
        holder.productTv.setText(salesOrder.getProduct());
        holder.quantityTv.setText(Integer.toString(salesOrder.getQuantity()));

        holder.productTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SalesOrder auxSalesOrder = orders.get(holder.getAdapterPosition());
               listener.clickedID(auxSalesOrder.getId());
              //  Log.d("list", String.valueOf(auxSalesOrder.getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void update(SalesOrder salesOrder) {

            orders.add(salesOrder);
            notifyDataSetChanged();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView productTv, quantityTv;

        public ViewHolder(View itemView) {
            super(itemView);
            productTv = itemView.findViewById(R.id.productTv);
            quantityTv = itemView.findViewById(R.id.quantityTv);

        }
    }
}
