package cl.octavionancul.salesorder.data;

import java.util.ArrayList;
import java.util.List;

import cl.octavionancul.salesorder.models.SalesOrder;

public class Queries {

    public List<SalesOrder> salesOrders(){


        List<SalesOrder> salesOrders = new ArrayList<>();

        List<SalesOrder> salesOrderList =  SalesOrder.listAll(SalesOrder.class);

        if(salesOrderList!=null && salesOrderList.size()>0){

            salesOrders.addAll(salesOrderList);
        }

        return  salesOrders;
    }
}
