package shafir.irena.hwjsonweathersite;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**

 */
public class weatherRecyclerAdapter extends RecyclerView.Adapter<weatherRecyclerAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private final Weather weather;



    public weatherRecyclerAdapter(Context context, Weather weather) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.weather = weather;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_weather, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvCity.setText(weather.getCityName());
        holder.tvLon.setText(String.valueOf(weather.getLon()));
        holder.tvLat.setText(String.valueOf(weather.getLat()));
        holder.tvTempNum.setText(String.valueOf(weather.getTemp()));
        holder.tvHumidityNum.setText(String.valueOf(weather.getHumidity()));
        holder.tvPressureNum.setText(String.valueOf(weather.getPressure()));
        holder.tvTempMinNum.setText(String.valueOf(weather.getMinTemp()));
        holder.tvTempMaxNum.setText(String.valueOf(weather.getMaxTemp()));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCity;
        TextView tvLon;
        TextView tvLat;
        TextView tvTemp;
        TextView tvPressure;
        TextView tvPressureNum;
        TextView tvTempNum;
        TextView tvHumidityNum;
        TextView tvHumidity;
        TextView tvTempMin;
        TextView tvTempMinNum;
        TextView tvTempMax;
        TextView tvTempMaxNum;


        public ViewHolder(View itemView) {
            super(itemView);

            tvCity = (TextView) itemView.findViewById(R.id.tvCity);
            tvLon = (TextView) itemView.findViewById(R.id.tvLon);
            tvLat = (TextView) itemView.findViewById(R.id.tvLat);
            tvTemp = (TextView) itemView.findViewById(R.id.tvTemp);
            tvPressure = (TextView) itemView.findViewById(R.id.tvPressure);
            tvPressureNum = (TextView) itemView.findViewById(R.id.tvPressureNum);
            tvTempNum = (TextView) itemView.findViewById(R.id.tvTempNum);
            tvHumidityNum = (TextView) itemView.findViewById(R.id.tvHumidityNum);
            tvHumidity = (TextView) itemView.findViewById(R.id.tvHumidity);
            tvTempMin = (TextView) itemView.findViewById(R.id.tvTempMin);
            tvTempMinNum = (TextView) itemView.findViewById(R.id.tvTempMinNum);
            tvTempMax = (TextView) itemView.findViewById(R.id.tvTempMax);
            tvTempMaxNum = (TextView) itemView.findViewById(R.id.tvTempMaxNum);

        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
