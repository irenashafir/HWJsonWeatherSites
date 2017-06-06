package shafir.irena.hwjsonweathersite;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

    public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {
        String value;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }

        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.

            String cityClicked = "";
            int id = item.getItemId();

            switch (id){
                case R.id.tel_aviv:
    //                getSupportFragmentManager().beginTransaction().replace(R.id.frame,
    //                        new weatherFragment()).commit();
                    cityClicked = "TelAviv,IL";

                    break;
                case R.id.haifa:
                    cityClicked = "haifa, IL";
                    break;
                case R.id.eilat:
                    cityClicked ="eilat, IL";
                    break;
                case R.id.ako:
                    cityClicked = "Ako, IL";
                    break;
                case R.id.new_york:
                    cityClicked = "New York, NY";
                    break;
                case R.id.london:
                    cityClicked = "london, UK";
                    break;
                case R.id.other:
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("city name");
                    dialog.setMessage("please insert the city name & country code");
                    final EditText newCity = new EditText(this);
                    dialog.setView(newCity);
                    dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        }
                    });
                    dialog.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            value = newCity.getText().toString().trim();
                        }
                    });
                    dialog.show();
                    cityClicked = value;
                    break;
            }

            weatherFragment wf = onTabSelected(cityClicked);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, wf).commit();


            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }


        public weatherFragment onTabSelected(String city) {
            weatherFragment f = new weatherFragment();
            Bundle bundle = new Bundle();
            bundle.putString("selectedCity",city);
            f.setArguments(bundle);
            return f;
        }


    }
