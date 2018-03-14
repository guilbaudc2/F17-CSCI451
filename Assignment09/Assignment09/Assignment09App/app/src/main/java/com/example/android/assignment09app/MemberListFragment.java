package com.example.android.assignment09app;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemberListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private MemberAdapter adapter;

    public static final String EXTRA_MEMBER_ID = "member_id";
    private Callbacks callbacks;

    public interface Callbacks {
        void onMemberSelected(int memberID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbacks = (Callbacks) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public MemberListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_member_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_member_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    public void updateUI() {
        MemberSet memberSet = MemberSet.getMemberSet();
        List<Member> members = memberSet.getMembers();

        if (adapter == null) {
            adapter = new MemberAdapter(members);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }

    private class MemberHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView tvNickName;
        private ImageView ivPicture;
        private int memberID;

        public MemberHolder(View itemView) {
            super(itemView);
            tvNickName = (TextView) itemView.findViewById(R.id.tv_list_nickname);
            ivPicture = (ImageView) itemView.findViewById(R.id.iv_list_pic);
            itemView.setOnClickListener(this);
        }

        public void setMemberID(int memberID) {
            this.memberID = memberID;
        }

        @Override
        public void onClick(View view) {
//            Intent intent = MemberPagerActivity.newIntent(getActivity(), memberID);
//            startActivity(intent);
            callbacks.onMemberSelected(memberID);
        }
    }


    private class MemberAdapter extends RecyclerView.Adapter<MemberHolder> {
        private List<Member> members;

        public MemberAdapter(List<Member> members) {
            this.members = members;
        }

        @Override
        public MemberHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View viewMH = inflater.inflate(R.layout.list_item_member, parent, false);
            return new MemberHolder(viewMH);
        }

        @Override
        public void onBindViewHolder(MemberHolder holder, int position) {
            Member member = members.get(position);
            holder.tvNickName.setText(member.getStageName());
            holder.ivPicture.setImageResource(member.getPhotoID());
            holder.setMemberID(position);

        }

        @Override
        public int getItemCount() {
            return members.size();
        }

    }
}
