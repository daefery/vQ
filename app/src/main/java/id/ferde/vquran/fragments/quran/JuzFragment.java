package id.ferde.vquran.fragments.quran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ferde.vquran.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JuzFragment extends Fragment {


    public JuzFragment() {
        // Required empty public constructor
    }

    public static JuzFragment newInstance() {
        JuzFragment fragment = new JuzFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.quran_fragment_juz, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tvJuz);
        textView.setText("Testing Juz Ammah");
        return rootView;
    }

}
