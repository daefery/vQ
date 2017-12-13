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
 * Use the {@link BookmarkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookmarkFragment extends Fragment {

    public BookmarkFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BookmarkFragment newInstance() {
        BookmarkFragment fragment = new BookmarkFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.quran_fragment_bookmark, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tvBookmark);
        textView.setText("Bookmark Ajah");
        return rootView;
    }

}
