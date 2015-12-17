package mobile.com.firstapplogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/17/2015.
 */
public class ListViewAdapter extends ArrayAdapter<Cars> {
    Context con;
    ArrayList<Cars> arrList;

    public ListViewAdapter(Context context, ArrayList<Cars> arrayList) {
        super(context, R.layout.row_view, arrayList);
        con = context;
        arrList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_view,parent,false);
        TextView tvID = (TextView) view.findViewById(R.id.tv_ID);
        TextView tvVehicleManufacturerName = (TextView) view.findViewById(R.id.tv_VehicleManufacturerName);
        TextView tvVehMfrCode = (TextView) view.findViewById(R.id.tv_VehMfrCode);
        TextView tvRepresentedTestVehMake = (TextView) view.findViewById(R.id.tv_RepresentedTestVehMake);
        TextView tvRepresentedTestVehModel = (TextView) view.findViewById(R.id.tv_RepresentedTestVehModel);

        tvID.setText(arrList.get(position).ID);
        tvVehicleManufacturerName.setText(arrList.get(position).VehicleManufacturerName);
        tvVehMfrCode.setText(arrList.get(position).VehMfrCode);
        tvRepresentedTestVehMake.setText(arrList.get(position).RepresentedTestVehMake);
        tvRepresentedTestVehModel.setText(arrList.get(position).RepresentedTestVehModel);

        return view;
    }
}

