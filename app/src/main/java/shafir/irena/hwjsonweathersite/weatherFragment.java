package shafir.irena.hwjsonweathersite;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import shafir.irena.hwjsonweathersite.dummy.DummyContent;
import shafir.irena.hwjsonweathersite.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * interface.
 */
public class weatherFragment extends Fragment implements WeatherDataSource.onWeatherArrivedListener{
    RecyclerView list;

  public weatherFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_weather_list, container, false);
        list = (RecyclerView) v.findViewById(R.id.list);

        String city = getArguments().getString("selectedCity");

        WeatherDataSource.getWeather(this, city);

        return v;
    }

    @Override
    public void onWeatherArrived(final Weather w, final Exception e) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (e == null){
                    list.setAdapter(new weatherRecyclerAdapter(getContext(), w));
                    list.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }
        });
    }



}
