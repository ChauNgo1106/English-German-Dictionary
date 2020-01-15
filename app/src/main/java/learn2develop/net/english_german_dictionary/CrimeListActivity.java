package learn2develop.net.english_german_dictionary;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
/**
 * Created by hitabaca on 3/31/17.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment()
    {
        return new CrimeListFragment();
    }
}
