package learn2develop.net.english_german_dictionary;

/**
 * Created by hitabaca on 4/14/17.
 */


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;



public class Generate_Word_Resources extends Activity {

    private List<Dictionary> mDictionaries;

    private EditText mEnglish;
    private EditText mGerman;

    private CheckBox mNounCheckbox;
    private CheckBox mVerbCheckbox;
    private CheckBox mAdverbCheckbox;
    private CheckBox mAdjectiveCheckbox;
    private CheckBox mPrepositionCheckbox;
    private CheckBox mCardinalNumberCheckbox;

    private Button mNextButton;
    private Button mBackButton;
    private Button mClearButton;
    private Button mAddButton;
    private Button mRemoveButton;

    private int mCurrentIndex = 0;

    ArrayList<String> list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generating_dictionary_content);

        mDictionaries = CrimeLab.get(this).getDictionary();
        mCurrentIndex = mDictionaries.size()-1;


        mGerman = (EditText)findViewById(R.id.inputGermanEditText);
        mEnglish = (EditText)findViewById(R.id.inputEnglishEditText);

        mNounCheckbox = (CheckBox) findViewById(R.id.checkbox_noun);
        mVerbCheckbox = (CheckBox) findViewById(R.id.checkbox_verb);
        mAdjectiveCheckbox = (CheckBox) findViewById(R.id.checkbox_adjective);
        mAdverbCheckbox = (CheckBox) findViewById(R.id.checkbox_adverb);
        mPrepositionCheckbox = (CheckBox) findViewById(R.id.checkbox_preposition);
        mCardinalNumberCheckbox = (CheckBox) findViewById(R.id.checkbox_cardinalNumber);

        if (mDictionaries.size() != 0)
            updateUI();

        /////back button////////////
        mBackButton = (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex == 0)
                    mCurrentIndex = mDictionaries.size()-1;
                else
                    mCurrentIndex = (mCurrentIndex - 1) % mDictionaries.size();
                updateUI();

            }
        });

        ////////mNextButton///////////
        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCurrentIndex == (mDictionaries.size()+1)){
                    mCurrentIndex = 0;
                }
                else
                    mCurrentIndex = (mCurrentIndex + 1) % mDictionaries.size();

                updateUI();
            }
        });

////////adding button//////

        mAddButton = (Button) findViewById(R.id.add_button);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInput()) {

        list=new ArrayList<String>();
                    if (mNounCheckbox.isChecked())
                        list.add("noun");
                    if (mVerbCheckbox.isChecked())
                        list.add("verb1");
                    if (mPrepositionCheckbox.isChecked())
                        list.add("preposition");
                    if (mAdjectiveCheckbox.isChecked())
                        list.add("adjective");
                    if (mAdverbCheckbox.isChecked())
                        list.add("adverb");
                    if (mCardinalNumberCheckbox.isChecked())
                        list.add("cardinal number");

                    CrimeLab.get(null).addDictionary(new Dictionary(mGerman.getText().toString(), list.toString(), mEnglish.getText().toString()));

                    updateList();

                    mCurrentIndex = mDictionaries.size()-1;
                    updateUI();
                    mRemoveButton.setEnabled(true);
                }//end if statement


            }
        });
////////////remove button//////////
        mRemoveButton = (Button) findViewById(R.id.remove_button);
        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDictionaries.size()!=0) {
                    CrimeLab.get(null).removeDictionary(mDictionaries.get(mCurrentIndex));
                    updateList();
                    if (mCurrentIndex == mDictionaries.size())
                        mCurrentIndex = 0;
                    updateUI();

                    if (mDictionaries.size() == 0)
                        mRemoveButton.setEnabled(false);
                }
            }
        });

////////clear button/////
        mClearButton = (Button) findViewById(R.id.clear_button);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGerman.setText("");
                mEnglish.setText("");
                mNounCheckbox.setChecked(false);
                mVerbCheckbox.setChecked(false);
                mPrepositionCheckbox.setChecked(false);
                mAdverbCheckbox.setChecked(false);
                mAdjectiveCheckbox.setChecked(false);
                mCardinalNumberCheckbox.setChecked(false);
            }
        });

    }

   //validate
    private boolean validateInput() {
        boolean isValidInput = true;


        if (mGerman.getText().toString().equals("")) {
            mGerman.setError("");
            isValidInput = false;
        }

        if (mEnglish.getText().toString().equals("")) {
            mEnglish.setError("");
            isValidInput = false;
        }
         if(
                 (!mNounCheckbox.isChecked())
                &&(!mVerbCheckbox.isChecked())
                 &&(!mAdjectiveCheckbox.isChecked())
                 &&(!mAdverbCheckbox.isChecked())
                 &&(!mPrepositionCheckbox.isChecked())
                 &&(!mCardinalNumberCheckbox.isChecked())
                 )
             Toast.makeText(getBaseContext(),"Error! One of preposition must be checked ",Toast.LENGTH_SHORT).show();
        isValidInput=false;
        return isValidInput;
    }

    private void updateList(){ mDictionaries= CrimeLab.get(this).getDictionary();}


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_noun:
                //if (checked)list.add("noun"); else list.remove("noun"); break;
            case R.id.checkbox_verb:
                //if (checked) list.add("vverb"); else list.remove("vverb"); break;
            case R.id.checkbox_preposition:
                //if (checked)list.add("preposition");else list.remove("preposition"); break;
            case R.id.checkbox_adjective:
                //if (checked)list.add("adjective"); else list.remove("adjective"); break;
            case R.id.checkbox_adverb:
                //if (checked)list.add("adverb"); else list.remove("adverb"); break;
            case R.id.checkbox_cardinalNumber:
                //if (checked)list.add("cardinal number"); else list.remove("cardinal number");break;
        }
    }

    private void updateUI(){
        mGerman.setText(mDictionaries.get(mCurrentIndex).getGermanWord());
        mEnglish.setText(mDictionaries.get(mCurrentIndex).getEnglishWord());

        if (mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("noun"))
            mNounCheckbox.setChecked(true);
        else if (!mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("noun"))

            mNounCheckbox.setChecked(false);

        if (mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("verb1"))
            mVerbCheckbox.setChecked(true);
        else if (!mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("verb1"))

            mVerbCheckbox.setChecked(false);

        if (mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("adjective"))
            mAdjectiveCheckbox.setChecked(true);
       else if (!mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("adjective"))

            mAdjectiveCheckbox.setChecked(false);

        if (mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("adverb"))
            mAdverbCheckbox.setChecked(true);
        else if (!mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("adverb"))

            mAdverbCheckbox.setChecked(false);

        if (mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("preposition"))
            mPrepositionCheckbox.setChecked(true);
        else if (!mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("preposition"))

            mPrepositionCheckbox.setChecked(false);
        if (mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("cardinal number"))
            mCardinalNumberCheckbox.setChecked(true);
        else if (!mDictionaries.get(mCurrentIndex).getPartOfSpeech().contains("cardinal number"))

            mCardinalNumberCheckbox.setChecked(false);
    }

}





