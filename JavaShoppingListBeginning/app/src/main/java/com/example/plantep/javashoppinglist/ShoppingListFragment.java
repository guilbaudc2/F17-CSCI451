package com.example.plantep.javashoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ShoppingListFragment extends Fragment {
    public static final String EXTRA_TODO_ID = "todo_id";
    private RecyclerView todoRecyclerView;
    private ToDoAdapter adapter;

    public ShoppingListFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        todoRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_todo);
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ShoppingList shoppingList = ShoppingList.getList();
        List<Item> todos = shoppingList.getItems();

        if(adapter ==null) {
            adapter = new ToDoAdapter(todos);
            todoRecyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private class ToDoHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
        public TextView countTV;
        public TextView titleTV;
        public TextView categoryTV;
        public CheckBox completedCheck;
        private Item todo;

        public ToDoHolder(View itemView) {
            super(itemView);
            countTV = (TextView)itemView.findViewById(R.id.tv_item_count);
            titleTV = (TextView)itemView.findViewById(R.id.tv_item_title);
            categoryTV = (TextView)itemView.findViewById(R.id.tv_item_category);
            completedCheck = (CheckBox)itemView.findViewById(R.id.check_item_incart);
            itemView.setOnClickListener(this);
        }

        public void bindToDo(Item todo)
        {
            this.todo = todo;
            countTV.setText("" + todo.getCount());
            titleTV.setText(todo.getTitle());
            categoryTV.setText(todo.getCategory());
            completedCheck.setChecked(todo.isComplete());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(),ItemActivity.class);
            intent.putExtra(EXTRA_TODO_ID, todo.getId());
            startActivity(intent);
        }
    }

    private class ToDoAdapter extends RecyclerView.Adapter<ToDoHolder> {
        private List<Item> todos;

        public ToDoAdapter(List<Item> todos) {this.todos = todos;}

        @Override
        public ToDoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_item,
                    parent, false);
            return new ToDoHolder(view);
        }

        @Override
        public void onBindViewHolder(ToDoHolder holder, int position) {
            Item todo = todos.get(position);
            holder.bindToDo(todo);
        }

        @Override
        public int getItemCount() {
            Log.d("Portia", "List size is: " + todos.size());
            return todos.size();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}