package com.example.jaime.inventorydb.ui.sector;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.jaime.inventorydb.R;
import com.example.jaime.inventorydb.data.db.model.Dependency;
import com.example.jaime.inventorydb.data.db.model.Sector;

import java.util.ArrayList;


public class AddEditSectorFragment extends Fragment implements SectorContract.AddEditSectorView {
    public static final String TAG = "addeditsectorfragment";

    private TextInputLayout tilName;
    private TextInputLayout tilSortname;
    private TextInputLayout tilDescription;
    private TextInputEditText edtName;
    private TextInputEditText edtSortname;
    private TextInputEditText edtDescription;
    private Spinner spIdDependency;
    private Spinner spIsEnable;
    private Spinner spIsDefault;
    private FloatingActionButton fabSaveSector;

    private Toolbar mToolbar;
    private SectorContract.Presenter mPresenter;
    private AddEditSectorListener mCallback;
    private TextWatcher mTextWatcher;
    private ArrayList<Dependency> mDependencies;


    public interface AddEditSectorListener {
        void onListSector();
    }


    public static AddEditSectorFragment newInstance(Bundle arguments) {
        AddEditSectorFragment fragment = new AddEditSectorFragment();

        if (arguments != null)
            fragment.setArguments(arguments);

        return fragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (AddEditSectorListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implement AddEditSectorListener");
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new SectorPresenter(this);
        mDependencies = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_addedit_sector, container, false);

        tilName = (TextInputLayout) view.findViewById(R.id.til_sector_name);
        tilSortname = (TextInputLayout) view.findViewById(R.id.til_sector_sortname);
        tilDescription = (TextInputLayout) view.findViewById(R.id.til_sector_description);
        edtName = (TextInputEditText) view.findViewById(R.id.edt_sector_name);
        edtSortname = (TextInputEditText) view.findViewById(R.id.edt_sector_sortname);
        edtDescription = (TextInputEditText) view.findViewById(R.id.edt_sector_description);
        spIdDependency = (Spinner) view.findViewById(R.id.sp_idDependency);
        spIsEnable = (Spinner) view.findViewById(R.id.sp_isEnable);
        spIsDefault = (Spinner) view.findViewById(R.id.sp_isDefault);
        fabSaveSector = (FloatingActionButton) view.findViewById(R.id.fab_sector_save);
        mToolbar = (Toolbar) view.findViewById(R.id.tb_addeditSector);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);

        initializeTextWatcher();
        edtName.addTextChangedListener(mTextWatcher);
        edtSortname.addTextChangedListener(mTextWatcher);
        edtDescription.addTextChangedListener(mTextWatcher);

        fabSaveSector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.requestToAddSector(generateSector());
            }
        });

        mPresenter.requestToLoadDependecies();
        ArrayAdapter<Dependency> idDependencyAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, mDependencies);
        spIdDependency.setAdapter(idDependencyAdapter);

        ArrayAdapter<String> isEnableAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                        new String[] { getResources().getString(R.string.sp_isEnable_true),
                                getResources().getString(R.string.sp_isEnable_false) });
        spIsEnable.setAdapter(isEnableAdapter);

        ArrayAdapter<String> isDefaultAdapter =
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item,
                        new String[] { getResources().getString(R.string.sp_isDefault_true),
                                getResources().getString(R.string.sp_isDefault_false) });
        spIsDefault.setAdapter(isDefaultAdapter);
    }


    @Override
    public void navigateToListSector() {
        mCallback.onListSector();
    }


    @Override
    public void showNameEmptyError() {
        tilName.setError(getResources().getString(R.string.error_sectorNameEmpty));
    }


    @Override
    public void showSortnameEmptyError() {
        tilSortname.setError(getResources().getString(R.string.error_sectorSortnameEmpty));
    }


    @Override
    public void showDescriptionEmptyError() {
        tilDescription.setError(getResources().getString(R.string.error_sectorDescriptionEmpty));
    }


    @Override
    public void showSectorExistsError() {
        Snackbar.make(getView(), getResources().getString(R.string.error_sectorExists), Snackbar.LENGTH_SHORT).show();
    }


    @Override
    public void initializeDependencies(ArrayList<Dependency> dependencies) {
        mDependencies = dependencies;
    }


    private Sector generateSector() {
        String name = edtName.getText().toString();
        String sortname = edtSortname.getText().toString();
        String description = edtDescription.getText().toString();
        int idDependency = ((Dependency)spIdDependency.getSelectedItem()).get_ID();
        boolean isEnable;
        boolean isDefault;

        if (spIsEnable.getSelectedItemPosition() == 0)
            isEnable = true;
        else
            isEnable = false;

        if (spIsDefault.getSelectedItemPosition() == 0)
            isDefault = true;
        else
            isDefault = false;

        return new Sector(idDependency, name, sortname, description, isEnable, isDefault);
    }


    private void initializeTextWatcher() {
        mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tilName.setError(null);
                tilSortname.setError(null);
                tilDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }
}
