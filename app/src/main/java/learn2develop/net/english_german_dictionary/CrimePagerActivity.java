package learn2develop.net.english_german_dictionary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import java.util.List;
import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 *
 * Created by hitabaca on 4/4/17.
 */

public class CrimePagerActivity extends AppCompatActivity {
    //new
    private static final String EXTRA_CRIME_ID="com.bignerdranch.android.english_german_dictionary.crime_id";
    //new

    private ViewPager mViewPager;
    private List<Dictionary> mDictionary;

    //new
    public static Intent newIntent(Context packageContext,String crimeId){
        Intent intent=new Intent(packageContext, CrimePagerActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeId);
        return intent;

    }
    //new
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary_pager);

        //new
        String crimeId=(String)getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        //new

        //more upadting
        mViewPager=(ViewPager) findViewById(R.id.activity_dictionary_pager_view_pager);
        //setTitle("Definitions");



        mDictionary=CrimeLab.get(this).getDictionary();
        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Dictionary dictionary=mDictionary.get(position);
                return CrimeFragment.newInstance(dictionary.getGermanWord());

            }

            @Override
            public int getCount() {
                return mDictionary.size();
            }
        });
        for(int i=0;i<mDictionary.size();i++){
            if(mDictionary.get(i).getGermanWord().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

    }

}
