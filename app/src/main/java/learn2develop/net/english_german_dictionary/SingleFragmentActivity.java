package learn2develop.net.english_german_dictionary;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

//import android.app.Fragment;
/**
 * Created by hitabaca on 3/31/17.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract android.support.v4.app.Fragment createFragment();

    private final int NOUN=1;
    private final int VERB=2;
    private final int PREPOSITION=3;
    private final int CARDINAL_NUMBER=4;
    private final int ADJECTIVE=5;
    private final int ADVERB=6;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm= getSupportFragmentManager();
        Fragment fragment= fm.findFragmentById(R.id.fragment_container);

        switch (CrimeLab.get(this).getFunction()){
            case NOUN:
                setTitle(R.string.setting_choice2);
                break;
            case VERB: setTitle(R.string.setting_choice3);
                break;
            case PREPOSITION: setTitle(R.string.setting_choice4);
                break;
            case ADJECTIVE: setTitle(R.string.setting_choice5);
                break;
            case ADVERB: setTitle(R.string.setting_choice6);
                break;
            case CARDINAL_NUMBER: setTitle(R.string.setting_choice7);
                break;
            default: setTitle(R.string.setting_choice8);
        }


        if(fragment==null){
            fragment=createFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
