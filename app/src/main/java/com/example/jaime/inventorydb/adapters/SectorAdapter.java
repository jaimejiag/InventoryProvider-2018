package com.example.jaime.inventorydb.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Clase Adapter de objetos Sector para la vista item_sector
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {
    private ArrayList<Sector> mSectors;
    private ArrayList<Sector> mSectorsModified;  //Guarda los sectores modificados en la interfaz.
    private OnSwitchCheckedChangeListener mChangeListener;
    private OnItemClickListener mClickListener;


    public interface OnItemClickListener {
        void onItemClick(Sector sector);
    }


    public SectorAdapter(OnItemClickListener clickListener) {
        mSectors = new ArrayList<>();
        mSectorsModified = new ArrayList<>();
        mChangeListener = new OnSwitchCheckedChangeListener();
        mClickListener = clickListener;
    }


    /**
     * Constructor que se llamará cuando SectorActivity venga de un cambio de configuración
     * y se haya salvado el estado dinámico.1
     * @param
     */
    public SectorAdapter(ArrayList<Sector> sectorsModified, OnItemClickListener clickListener) {
        mSectors = new ArrayList<>();
        mClickListener = clickListener;
        mSectorsModified = sectorsModified;
        mChangeListener = new OnSwitchCheckedChangeListener();
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
        holder.swSector.setChecked(mSectors.get(position).isEnabled());
        holder.swSector.setOnCheckedChangeListener(mChangeListener);
        holder.swSector.setTag(mSectors.get(position));
        holder.txvSectorName.setText(mSectors.get(position).getName());

        if (mSectors.get(position).isSectorDefault())
            holder.txvSectorDefault.setText(R.string.txv_sectorDefault);

        holder.bind(mSectors.get(position), mClickListener);
    }


    /**
     * Se creará tantos elementos SectorViewHolder como elementos haya en el ArrayList definido.
     * @return El tamaño de la lista.
     */
    @Override
    public int getItemCount() {
        return mSectors.size();
    }


    /**
     * Devuelve el Array de los sectores modificados cuando la activity estaba visible
     * y que no se ha guardado en la base de datos (persistente).
     * Hay que guardar el estado dinámico (cuando giras la pantalla).
     * @return ArrayList de sectores modificados
     */
    public ArrayList<Sector> getSectorsModified() {
        return mSectorsModified;
    }


    public void addAll(ArrayList<Sector> sectors) {
        mSectors.clear();
        mSectorsModified.clear();
        mSectors = sectors;
    }


    private void identifySectorsModified() {
        int index;

        for (int i = 0; i < mSectors.size(); i++) {
            index = 0;

            while (index < mSectorsModified.size()) {
                if (mSectors.get(i).equals(mSectorsModified.get(index))) {
                    mSectors.get(i).setEnabled(mSectorsModified.get(index).isEnabled());
                    index = mSectorsModified.size();
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


        public void bind(final Sector sector, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(sector);
                }
            });
        }
    }


    private class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Sector sectorSelected = (Sector) buttonView.getTag();
            int index = 0;
            int sectorModifiedKey = mSectorsModified.size() + 1;

            sectorSelected.setEnabled(isChecked);

            while (index < mSectorsModified.size()) {
                if (sectorSelected.equals(mSectorsModified.get(index))) {
                    mSectorsModified.get(index).setEnabled(sectorSelected.isEnabled());
                    index = sectorModifiedKey;
                } else
                    index++;
            }

            if (index == mSectorsModified.size())
                mSectorsModified.add(sectorSelected);
        }
    }
}
