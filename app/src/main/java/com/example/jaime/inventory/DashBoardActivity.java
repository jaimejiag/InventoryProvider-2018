package com.example.jaime.inventory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Vector;

public class DashBoardActivity extends AppCompatActivity {
    private GridLayout gridDashboard;
    private CLickListenerDashboard mListenerDashboard;


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
            }

            if (intent != null)
                startActivity(intent);
        }
    }
}
