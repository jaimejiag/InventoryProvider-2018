package com.example.jaime.inventoryprovider.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.jaime.inventoryprovider.R;
import com.example.jaime.inventoryprovider.data.model.Sector;

import java.util.ArrayList;

/**
 * Clase Adapter de objetos Sector para la vista item_sector
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder> {
    private ArrayList<Sector> mSectors;
    private OnSwitchCheckedChangeListener mChangeListener;
    private OnSectorUpdatedListener mSectorUpdatedListener;
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;


    public interface OnSectorUpdatedListener {
        void onSectorUpdated(Sector sector);
    }


    public interface OnItemClickListener {
        void onItemClick(Sector sector);
    }


    public interface OnItemLongClickListener {
        void onItemLongClick(Sector sector);
    }


    public SectorAdapter(OnSectorUpdatedListener sectorUpdatedListener, OnItemClickListener clickListener,
                         OnItemLongClickListener longClickListener) {
        mSectors = new ArrayList<>();
        mChangeListener = new OnSwitchCheckedChangeListener();
        mSectorUpdatedListener = sectorUpdatedListener;
        mClickListener = clickListener;
        mLongClickListener = longClickListener;
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

        holder.bind(mSectors.get(position), mClickListener, mLongClickListener);
    }


    /**
     * Se creará tantos elementos SectorViewHolder como elementos haya en el ArrayList definido.
     * @return El tamaño de la lista.
     */
    @Override
    public int getItemCount() {
        return mSectors.size();
    }


    public void addAll(ArrayList<Sector> sectors) {
        mSectors = sectors;
        notifyDataSetChanged();
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


        public void bind(final Sector sector, final OnItemClickListener clickListener,
                         final OnItemLongClickListener longClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onItemClick(sector);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onItemLongClick(sector);
                    return true;
                }
            });
        }
    }


    private class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Sector sector = (Sector) buttonView.getTag();
            sector.setEnabled(isChecked);
            mSectorUpdatedListener.onSectorUpdated(sector);
        }
    }
}
