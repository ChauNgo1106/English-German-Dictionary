package learn2develop.net.english_german_dictionary;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.DecorContentParent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import learn2develop.net.english_german_dictionary.Dictionary;

/**
 * Created by hitabaca on 3/31/17.
 */

public class CrimeListFragment extends Fragment  {

    private RecyclerView mCrimeRecyclerView;
    private DictionaryAdapter mAdapter;
    private Button search;
/*

private Button search;
 */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view.findViewById(R.id.word_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Dictionary> dictionaries = crimeLab.getDictionary();

        mAdapter = new DictionaryAdapter(dictionaries);
        mCrimeRecyclerView.setAdapter(mAdapter);

    }


    private class DictionaryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //modification

        private Dictionary mDictionary;
        private TextView mGerman;
        private TextView mEnglish;
        private TextView mPartOfSpeech;

        //new data fields
      /*  private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckbox;
*/
        public DictionaryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //mTitleTextView = (TextView) itemView;
            mGerman = (TextView) itemView.findViewById(R.id.list_item_german_title_text_view);
            mEnglish = (TextView) itemView.findViewById(R.id.list_item_english_title_text_view);
            mPartOfSpeech = (TextView) itemView.findViewById(R.id.list_item_partOfSpeech_title_text_view);
        }

        //modification
        public void bindDictionary(Dictionary dictionary) {
            mDictionary = dictionary;
            mGerman.setText(mDictionary.getGermanWord());
            mEnglish.setText((mDictionary.getEnglishWord()));

//Updating news.
            List list = new ArrayList<String>();

            if (mDictionary.getPartOfSpeech().contains("noun"))
                list.add("noun");
            if (mDictionary.getPartOfSpeech().contains("verb1"))
                list.add("verb");
            if (mDictionary.getPartOfSpeech().contains("preposition"))
                list.add("preposition");
            if (mDictionary.getPartOfSpeech().contains("adjective"))
                list.add("adjective");
            if (mDictionary.getPartOfSpeech().contains("adverb"))
                list.add("adverb");
            if (mDictionary.getPartOfSpeech().contains("cardinal number"))
                list.add("cardinal number");

            String partOfSpeech = list.toString();
            partOfSpeech = partOfSpeech.substring(0, partOfSpeech.length() - 1);

            partOfSpeech = partOfSpeech.substring(1);

            mPartOfSpeech.setText(partOfSpeech);

        }
        //end updating.

        @Override
        public void onClick(View v) {
            Intent intent = CrimePagerActivity.newIntent(getActivity(), mDictionary.getGermanWord());

            startActivity(intent);
        }
    }

    private class DictionaryAdapter extends RecyclerView.Adapter<DictionaryHolder> {
        private List<Dictionary> mDictionaries;

        public DictionaryAdapter(List<Dictionary> dictionaries) {
            mDictionaries = dictionaries;
        }

        @Override
        public DictionaryHolder onCreateViewHolder(ViewGroup parent, int viewTape) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.item_list, parent, false);
            return new DictionaryHolder(view);

        }

        @Override
        public void onBindViewHolder(DictionaryHolder holder, int position) {
            Dictionary dictionary = mDictionaries.get(position);
            holder.bindDictionary(dictionary);
        }

        @Override
        public int getItemCount() {
            return mDictionaries.size();
        }



    //new updating
    public void setFilter(List<Dictionary> countryModels) {
        mDictionaries = new ArrayList<>();
        mDictionaries.addAll(countryModels);
        notifyDataSetChanged();
    }
}
}
