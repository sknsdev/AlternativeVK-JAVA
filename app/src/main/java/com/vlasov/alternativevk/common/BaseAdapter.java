package com.vlasov.alternativevk.common;

import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.ViewGroup;

import com.vlasov.alternativevk.model.view.BaseViewModel;
import com.vlasov.alternativevk.ui.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {

    private List<BaseViewModel> list = new ArrayList<>();

    private ArrayMap<Integer, BaseViewModel> mTypeInstances = new ArrayMap<>();


    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mTypeInstances.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    public void registerTypeInstance(BaseViewModel item) {
        if (!mTypeInstances.containsKey(item.getType().getValue())) {
            mTypeInstances.put(item.getType().getValue(), item);
        }
    }


    public void setItems(List<BaseViewModel> items) {
        clearList();
        addItems(items);
    }

    public void addItems(List<? extends BaseViewModel> newItems) {

        for (BaseViewModel newItem : newItems) {
            registerTypeInstance(newItem);
        }

        list.addAll(newItems);

        notifyDataSetChanged(); //проверяет колво значений и по их колву создает вьюхолдеры

    }


    public void clearList() {
        list.clear();
    }


    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public BaseViewModel getItem(int position) {
        return list.get(position);
    }



    public int getRealItemCount() { //Он будет перебирать все элементы списка, проверять является ли элемент
                                    // реальным и возвращать реальное количество элементов.
        int count = 0;
        for (int i = 0; i < getItemCount(); i++) {
            if (!getItem(i).isItemDecorator()) {
                count += 1;
            }
        }
        return count;
    }
}
