package com.example.myapplicationlll.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationlll.R;
import com.example.myapplicationlll.databinding.AttendaceItemBinding;
import com.example.myapplicationlll.model.Person;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    List<Person> personList;
    OnSelectItem onSelectItem;
    public void setOnSelectItem(OnSelectItem onSelectItem) {
        this.onSelectItem = onSelectItem;
    }

    public ItemAdapter(List<Person> personList) {
        this.personList = personList;
    }
    public void addNewPerson(Person person){
        personList.add(person);
        notifyDataSetChanged();

    }
    public void setNewPersons(List<Person>persons){
        this.personList =persons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       AttendaceItemBinding binding = AttendaceItemBinding.inflate(layoutInflater,parent,false);
        return  new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(personList.get(position), position);
    }

    @Override
    public int getItemCount() {
        if(personList == null) return 0;
        return personList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{
        AttendaceItemBinding itemBinding;
        public ItemViewHolder(AttendaceItemBinding itemBinding) {
            super(itemBinding.getRoot());
             this.itemBinding =itemBinding;
        }
        void onBind(Person item, int position){
            itemBinding.setPerson(item);
            itemBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
              @Override
              public boolean onLongClick(View v) {
                    onSelectItem.onClick(position);
                  return false;
              }
          });
        }
    }
    interface OnSelectItem{
        void onClick(int position);
    }

}
