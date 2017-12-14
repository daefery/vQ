package id.ferde.vquran.fragments.quran;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import id.ferde.vquran.R;
import id.ferde.vquran.handlers.HttpHandler;
import id.ferde.vquran.models.Surah;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SurahFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurahFragment extends Fragment {

    TextView mTextView;
    private static final String ARG_SECTION_NUMBER = "section_number";

    private String TAG = SurahFragment.class.getSimpleName();

    private ProgressDialog pDialog;
    ListView lvSurah;
    // URL to get contacts JSON
    private static String url = "http://api.alquran.cloud/surah";//"https://api.androidhive.info/contacts/";

    ArrayList<Surah> surahList;

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
        final ArrayList<Surah> surahArrayList = new ArrayList<>();
        View rootView = inflater.inflate(R.layout.quran_fragment_surah, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.tvSurah);
//        textView.setText("Testing Ajah");

//        BindDictionary<Surah> dict = new BindDictionary<Surah>();
//        dict.addStringField(R.id.tvName, new StringExtractor<Surah>() {
//            @Override
//            public String getStringValue(Surah item, int position) {
//                return item.name;
//            }
//        });
//        dict.addStringField(R.id.tvEmail, new StringExtractor<Surah>() {
//            @Override
//            public String getStringValue(Surah item, int position) {
//                return item.email;
//            }
//        });
//        dict.addStringField(R.id.tvPhone, new StringExtractor<Surah>() {
//            @Override
//            public String getStringValue(Surah item, int position) {
//                return item.phone;
//            }
//        });
//
//        Surah s1 = new Surah("Test1", "test@gmail.com", "08837232322");
//        for(int i=0;i<10;i++){
//            surahArrayList.add(s1);
//        }
//
//        FunDapter adapter = new FunDapter(SurahFragment.this.getActivity(), surahArrayList, R.layout.quran_surahlist_layout, dict);
//
//        ListView lvSurah = (ListView)rootView.findViewById(R.id.lvSurah);
//        lvSurah.setAdapter(adapter);
//        lvSurah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Surah selectedProduct = surahArrayList.get(position);
//                Toast.makeText(SurahFragment.this.getActivity(), selectedProduct.name, Toast.LENGTH_SHORT).show();
//            }
//        });

        surahList = new ArrayList<>();

        lvSurah = (ListView)rootView.findViewById(R.id.lvSurah);
        new GetSurahList().execute();
        return rootView;
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetSurahList extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
//                    JSONArray contacts = jsonObj.getJSONArray("contacts");
                    JSONArray contacts = jsonObj.getJSONArray("data");

                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

//                        String id = c.getString("id");
//                        String name = c.getString("name");
//                        String email = c.getString("email");
//                        String address = c.getString("address");
//                        String gender = c.getString("gender");

                        int number = c.getInt("number");
                        String name = c.getString("name");
                        String englishName = c.getString("englishName");
                        String englishNameTranslation = c.getString("englishNameTranslation");
                        int numberOfAyahs = c.getInt("numberOfAyahs");
                        String revelationType = c.getString("revelationType");


                        Surah surah = new Surah(number, name, englishName, englishNameTranslation, numberOfAyahs, revelationType);

                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");

                        // tmp hash map for single contact
//                        HashMap<String, String> contact = new HashMap<>();


                        // adding each child node to HashMap key => value
//                        contact.put("id", id);
//                        contact.put("name", name);
//                        contact.put("email", email);
//                        contact.put("mobile", mobile);
//                        contact.put("number", number);
//                        contact.put("name", name);
//                        contact.put("englishName", englishName);
//                        contact.put("englishNameTranslation", englishNameTranslation);
//                        contact.put("numberOfAyahs", numberOfAyahs);
//                        contact.put("revelationType", revelationType);

                        // adding contact to contact list
//                        contactList.add(contact);
                        surahList.add(surah);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
//            ListAdapter adapter = new SimpleAdapter(
//                    getActivity(), contactList,
//                    R.layout.quran_surahlist_layout, new String[]{"name", "englishName",
//                    "revelationType"}, new int[]{R.id.tvName,
//                    R.id.tvEmail, R.id.tvPhone});
//
//            ListAdapter adp = new SimpleAdapter(
//                    getActivity(), contactList, R.layout.quran_surahlist_layout,
//            )

            BindDictionary<Surah> dict = new BindDictionary<>();

            dict.addStringField(R.id.tvSurahNumber, new StringExtractor<Surah>() {
                @Override
                public String getStringValue(Surah item, int position) {
                    return ""+item.number;
                }
            });

            dict.addStringField(R.id.tvSurahName, new StringExtractor<Surah>() {
                @Override
                public String getStringValue(Surah item, int position) {
                    return item.englishName;
                }
            });

            dict.addStringField(R.id.tvSurahDesc, new StringExtractor<Surah>() {
                @Override
                public String getStringValue(Surah item, int position) {
                    return item.revelationType+" | "+item.numberOfAyahs+" Ayah";
                }
            });

            dict.addStringField(R.id.tvSurahArab, new StringExtractor<Surah>() {
                @Override
                public String getStringValue(Surah item, int position) {
                    return item.name;
                }
            });

            FunDapter adapter = new FunDapter(SurahFragment.this.getActivity(), surahList, R.layout.quran_surahlist_layout, dict);

            lvSurah.setAdapter(adapter);
            lvSurah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Surah selectedProduct = surahList.get(position);
                    Toast.makeText(SurahFragment.this.getActivity(), selectedProduct.englishName, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
