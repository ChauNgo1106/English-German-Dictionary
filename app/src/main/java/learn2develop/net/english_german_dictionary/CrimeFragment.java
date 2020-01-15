package learn2develop.net.english_german_dictionary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.CheckBox;



/**
 * Created by hitabaca on 3/9/17.
 */

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID="crime_id";

    private Dictionary mDictionary;
   private TextView mGermanWord;
    private TextView mPartOfSpeech;
    private TextView mEnglishWord;


//updating
    public static CrimeFragment newInstance(String crimeId){
        Bundle argument=new Bundle();
        argument.putSerializable(ARG_CRIME_ID,crimeId);
        CrimeFragment fragment =new CrimeFragment();
        fragment.setArguments(argument);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String crimeId=(String) getArguments().getSerializable(ARG_CRIME_ID);
        mDictionary=CrimeLab.get(getActivity()).getDictionary(crimeId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState){
        //inflate the view and wire up the Edit Text and add listener.

        View v=inflater.inflate(R.layout.fragment_dicitonary,parent,false);
        mGermanWord=(TextView) v.findViewById(R.id.german_word);
        mEnglishWord=(TextView)v.findViewById(R.id.english_word);
        mPartOfSpeech = (TextView) v.findViewById(R.id.partOfSpeech);

//updating
            mGermanWord.setText(mDictionary.getGermanWord());
             mEnglishWord.setText(mDictionary.getEnglishWord());
            mPartOfSpeech.setText(mDictionary.getPartOfSpeech());

        return v;
    }

}
