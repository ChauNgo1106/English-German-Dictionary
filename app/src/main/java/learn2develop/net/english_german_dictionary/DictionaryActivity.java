package learn2develop.net.english_german_dictionary;

/**
 * Created by hitabaca on 4/14/17.
 */
import java.util.List;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;



public class DictionaryActivity extends AppCompatActivity {
    private static List<Dictionary> mDictionaries;
    private final int NOUN = 1;
    private final int VERB = 2;
    private final int PREPOSITION = 3;
    private final int CARDINAL_NUMBER = 4;
    private final int ADJECTIVE = 5;
    private final int ADVERB = 6;
    private final int DEFAULT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {

        menu.findItem(R.id.option1).setEnabled(mDictionaries==null);

        menu.findItem(R.id.option2).setEnabled(mDictionaries!=null);
        menu.findItem(R.id.option3).setEnabled(mDictionaries!=null);
        menu.findItem(R.id.option4).setEnabled(mDictionaries!=null);
        menu.findItem(R.id.option5).setEnabled(mDictionaries!=null);
        menu.findItem(R.id.option6).setEnabled(mDictionaries!=null);
        menu.findItem(R.id.option7).setEnabled(mDictionaries!=null);
        menu.findItem(R.id.option8).setEnabled(mDictionaries!=null);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        CrimeLab.get(null).setFunction(0);

        switch (id) {
            case R.id.option1:

                if (mDictionaries == null)

                    CrimeLab.get(null).addDictionary();
                startActivity(new Intent(getApplicationContext(), Generate_Word_Resources.class));
                mDictionaries = CrimeLab.get(null).getDictionary();

                return true;
            case R.id.option2:
                CrimeLab.get(null).setFunction(NOUN);
                Intent intent2 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent2);


                return true;

            case R.id.option3:
                CrimeLab.get(null).setFunction(VERB);

                Intent intent3 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent3);
            case R.id.option4:
                CrimeLab.get(null).setFunction(PREPOSITION);
                Intent intent4 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent4);
                return true;

            case R.id.option5:

                CrimeLab.get(null).setFunction(ADJECTIVE);
                Intent intent5 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent5);
                return true;
            case R.id.option6:

                CrimeLab.get(null).setFunction(ADVERB);
                Intent intent6 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent6);
                return true;
            case R.id.option7:

                CrimeLab.get(null).setFunction(CARDINAL_NUMBER);
                Intent intent7 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent7);

                return true;
            case R.id.option8:
                CrimeLab.get(null).setFunction(DEFAULT);
                Intent intent8 = new Intent(this, CrimeListActivity.class);
                this.startActivity(intent8);
                return true;

            case R.id.option9:

                AlertDialog.Builder warningExitBuilder = new AlertDialog.Builder(this);
                warningExitBuilder.setTitle(getResources().getString(R.string.alertExitDialog));

                warningExitBuilder.setPositiveButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                System.exit(1);      // Exit the program
                            }
                        });
                AlertDialog warningDialog = warningExitBuilder.create();
                warningDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }






}

