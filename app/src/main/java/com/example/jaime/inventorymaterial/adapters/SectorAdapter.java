package com.example.jaime.inventorymaterial.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.jaime.inventorymaterial.R;
import com.example.jaime.inventorymaterial.pojo.Sector;
import com.example.jaime.inventorymaterial.repository.SectorRepository;

import java.util.ArrayList;

/**
 * Clase Adapter de objetos Sector para la vista item_sector
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {
    private ArrayList<Sector> sectors;
    private ArrayList<Sector> sectorsModified;  //Guarda los sectores modificados en la interfaz.
    private OnSwitchCheckedChangeListener changeListener;


    public SectorAdapter() {
        sectors = SectorRepository.getInstance().getSectors();
        sectorsModified = new ArrayList<>();
        changeListener = new OnSwitchCheckedChangeListener();
    }


    /**
     * Constructor que se llamará cuando SectorActivity venga de un cambio de configuración
     * y se haya salvado el estado dinámico.1
     * @param
     */
    public SectorAdapter(ArrayList<Sector> sectorsModified) {
        sectors = SectorRepository.getInstance().getSectors();
        this.sectorsModified = sectorsModified;
        changeListener = new OnSwitchCheckedChangeListener();
        identifySectorsModified();
    }


    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_sector, null);
        SectorViewHolder holder = new SectorViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(SectorViewHolder holder, int position) {
        holder.swSector.setChecked(sectors.get(position).isEnabled());
        holder.swSector.setOnCheckedChangeListener(changeListener);
        holder.swSector.setTag(sectors.get(position));
        holder.txvSectorName.setText(sectors.get(position).getName());

        if (sectors.get(position).isSectorDefault())
            holder.txvSectorDefault.setText(R.string.txv_sectorDefault);
    }


    /**
     * Se creará tantos elementos SectorViewHolder como elementos haya en el ArrayList definido.
     * @return El tamaño de la lista.
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }


    /**
     * Devuelve el Array de los sectores modificados cuando la activity estaba visible
     * y que no se ha guardado en la base de datos (persistente).
     * Hay que guardar el estado dinámico (cuando giras la pantalla).
     * @return ArrayList de sectores modificados
     */
    public ArrayList<Sector> getSectorsModified() {
        return sectorsModified;
    }


    private void identifySectorsModified() {
        int index;

        for (int i = 0; i < sectors.size(); i++) {
            index = 0;

            while (index < sectorsModified.size()) {
                if (sectors.get(i).equals(sectorsModified.get(index))) {
                    sectors.get(i).setEnabled(sectorsModified.get(index).isEnabled());
                    index = sectorsModified.size();
                } else
                    index++;
            }
        }
    }


    public static class SectorViewHolder extends RecyclerView.ViewHolder {
        private Switch swSector;
        private TextView txvSectorName;
        private TextView txvSectorDefault;


        public SectorViewHolder(View itemView) {
            super(itemView);

            swSector = (Switch) itemView.findViewById(R.id.sw_sector);
            txvSectorName = (TextView) itemView.findViewById(R.id.txv_sectorName);
            txvSectorDefault = (TextView) itemView.findViewById(R.id.txv_sectorDefault);
        }
    }


    private class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Sector sectorSelected = (Sector) buttonView.getTag();
            int index = 0;
            int sectorModifiedKey = sectorsModified.size() + 1;

            sectorSelected.setEnabled(isChecked);

            while (index < sectorsModified.size()) {
                if (sectorSelected.equals(sectorsModified.get(index))) {
                    sectorsModified.get(index).setEnabled(sectorSelected.isEnabled());
                    index = sectorModifiedKey;
                } else
                    index++;
            }

            if (index == sectorsModified.size())
                sectorsModified.add(sectorSelected);
        }
    }
}
