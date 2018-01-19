package com.example.jaime.inventorydb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jaime.inventorydb.data.prefs.AppPreferencesHelper;
import com.example.jaime.inventorydb.ui.dependency.DependencyActivity;
import com.example.jaime.inventorydb.ui.inventory.InventoryActivity;
import com.example.jaime.inventorydb.ui.prefs.AccountSettingActivity;
import com.example.jaime.inventorydb.ui.prefs.GeneralSettingActivity;
import com.example.jaime.inventorydb.ui.product.ProductActivity;
import com.example.jaime.inventorydb.ui.sector.SectorActivity;

/**
 * Clase que muestra el dashboard principal a modo de menú principal.
 */
public class DashBoardActivity extends AppCompatActivity {
    private GridLayout gridDashboard;
    private CLickListenerDashboard mListenerDashboard;


    @Override
    protected void onStart() {
        super.onStart();
        showAppPreferences();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_support);

        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);
        mListenerDashboard = new CLickListenerDashboard();

        //Definir un array de int que contendrá el id de la imágenes Inventory, Product,
        // Despendencias, Secciones, Preferencias.
        int[] images = {R.drawable.inventory, R.mipmap.ic_product, R.mipmap.ic_dependencias,
                R.mipmap.ic_section, R.mipmap.ic_settings};

        //No se utiliza en Java/Android array de objetos, se utiliza Vector o colecciones.
        //ImageView[] imageViews = new ImageView[images.length];

        //No utilizamos la clase Vector porque no trabaja con hilos y no requiere sincronización.
        //Vector<ImageView> imageViewVector = new Vector<>();

        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);

        for (int i = 0; i < images.length; i++) {
            imageView = new ImageView(this);
            imageView.setId(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            imageView.setImageResource(images[i]);
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(mListenerDashboard);
            gridDashboard.addView(imageView);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case  R.id.action_account_setting:
                startActivity(new Intent(DashBoardActivity.this, AccountSettingActivity.class));
                break;

            case R.id.action_general_setting:
                startActivity(new Intent(DashBoardActivity.this, GeneralSettingActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void showAppPreferences() {
        AppPreferencesHelper sharedPreferences = ((InventoryApplication)getApplicationContext()).getAppPreferencesHelper();
        String message = "Tu usuario es " + sharedPreferences.getCurrentUserName();

        sharedPreferences.setCurrentUserName("Francisco Franco");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    class CLickListenerDashboard implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (v.getId()) {
                case R.drawable.inventory:
                    intent = new Intent(DashBoardActivity.this, InventoryActivity.class);
                    break;

                case R.mipmap.ic_product :
                    intent = new Intent(DashBoardActivity.this, ProductActivity.class);
                    break;

                case R.mipmap.ic_dependencias:
                    intent = new Intent(DashBoardActivity.this, DependencyActivity.class);
                    break;

                case  R.mipmap.ic_section:
                    intent = new Intent(DashBoardActivity.this, SectorActivity.class);
            }

            if (intent != null)
                startActivity(intent);
        }
    }
}
