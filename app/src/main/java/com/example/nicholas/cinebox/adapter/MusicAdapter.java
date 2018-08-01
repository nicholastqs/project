package com.example.nicholas.cinebox.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.nicholas.cinebox.model.MusicModel;
import java.util.ArrayList;
import com.example.nicholas.cinebox.R;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class MusicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private Context mContext;
  private ArrayList<MusicModel> modelList;

  private OnItemClickListener mItemClickListener;


  public MusicAdapter(Context context, ArrayList<MusicModel> modelList) {
    this.mContext = context;
    this.modelList = modelList;
  }

  public void updateList(ArrayList<MusicModel> modelList) {
    this.modelList = modelList;
    notifyDataSetChanged();

  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

    View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_recycler_list, viewGroup, false);
    mContext = viewGroup.getContext();
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

    //Here you can fill your row view
    if (holder instanceof ViewHolder) {
      final MusicModel model = getItem(position);
      ViewHolder genericViewHolder = (ViewHolder) holder;

      genericViewHolder.itemTxtTitle.setText(model.getTitle());
      genericViewHolder.itemTxtMessage.setText(model.getArtist());


    }
  }


  @Override
  public int getItemCount() {

    return modelList.size();
  }

  public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
    this.mItemClickListener = mItemClickListener;
  }

  private MusicModel getItem(int position) {
    return modelList.get(position);
  }


  public interface OnItemClickListener {

    void onItemClick(View view, int position, MusicModel model);
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgUser;
    private TextView itemTxtTitle;
    private TextView itemTxtMessage;


    // @BindView(R.id.img_user)
    // ImageView imgUser;
    // @BindView(R.id.item_txt_title)
    // TextView itemTxtTitle;
    // @BindView(R.id.item_txt_message)
    // TextView itemTxtMessage;
    // @BindView(R.id.radio_list)
    // RadioButton itemTxtMessage;
    // @BindView(R.id.check_list)
    // CheckBox itemCheckList;
    public ViewHolder(final View itemView) {
      super(itemView);

      // ButterKnife.bind(this, itemView);

      this.imgUser = (ImageView) itemView.findViewById(R.id.img_user);
      this.itemTxtTitle = (TextView) itemView.findViewById(R.id.item_txt_title);
      this.itemTxtMessage = (TextView) itemView.findViewById(R.id.item_txt_message);

      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          mItemClickListener
              .onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));


        }
      });

    }
  }

}

