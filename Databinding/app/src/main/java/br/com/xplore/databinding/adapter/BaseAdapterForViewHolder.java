package br.com.xplore.databinding.adapter;

import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;
import java.util.Observable;

import br.com.xplore.databinding.adapter.holder.BaseViewHolder;

/**
 * Created by r028367 on 14/11/2017.
 */

public abstract class BaseAdapterForViewHolder extends RecyclerView.Adapter<BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater
                , getLayoutForType(viewType), parent, false);

        return new BaseViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(getDataAtPosition(position));
    }

    public abstract Object getDataAtPosition(int position);
    public abstract int getLayoutForType(int viewType);
}
