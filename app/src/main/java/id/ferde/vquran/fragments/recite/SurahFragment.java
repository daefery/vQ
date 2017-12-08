package id.ferde.vquran.fragments.recite;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ferde.vquran.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SurahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurahFragment extends Fragment {

    TextView mTextView;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public SurahFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SurahFragment newInstance() {
        SurahFragment fragment = new SurahFragment();
//        Bundle args = new Bundle();
//        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_surah, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tvSurah);
        textView.setText("Testing Ajah");
        return rootView;
    }

}
