package learn2develop.net.english_german_dictionary;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.Context;

/**
 * Created by hitabaca on 4/7/17.
 */



public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID="com.bignerdranch.android.english_german_dictionary.crime_id";

    public static Intent newIntent(Context packageContext, String crimeId) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String crimeId = (String) getIntent()
                .getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

}
