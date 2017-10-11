package com.example.jaime.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Vector;

public class DashBoardActivity extends AppCompatActivity {
    private GridLayout gridDashboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_support);

        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        //Definir un array de int que contendrá el id de la imágenes.
        int[] images = {R.drawable.chair, R.drawable.closet, R.drawable.cpu, R.drawable.keyboard,
                R.drawable.monitor, R.drawable.mouse, R.drawable.printer, R.drawable.proyector,
                R.drawable.inventory, R.drawable.table, R.drawable.whiteboard};

        //No se utiliza en Java/Android array de objetos, se utiliza Vector o colecciones.
        //ImageView[] imageViews = new ImageView[images.length];

        //No utilizamos la clase Vector porque no trabaja con hilos y no requiere sincronización.
        //Vector<ImageView> imageViewVector = new Vector<>();

        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboardWidth);
        float height = getResources().getDimension(R.dimen.imgDashboardHeight);

        for (int i = 0; i < images.length; i++) {
            imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1F);
            imageView.setLayoutParams(params);
            gridDashboard.addView(imageView);
        }
    }
}
