package umn.ac.tamline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter3 extends RecyclerView.Adapter<ProgramAdapter3.ViewHolder>{

    Context context;
    String[] programNameList;
    String[] programPercakapanList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView rowName;
        TextView rowPercakapan;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rowName = itemView.findViewById(R.id.namabengkel);
            rowPercakapan = itemView.findViewById(R.id.percakapanbengkel);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public ProgramAdapter3(Context context, String[] programNameList, String[] programPercakapanList, int[] images){
        this.context = context;
        this.programNameList = programNameList;
        this.programPercakapanList = programPercakapanList;
        this.images = images;
    }

    @NonNull
    @Override
    public ProgramAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.satuan_riwayat, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramAdapter3.ViewHolder holder, int position) {
        holder.rowName.setText(programNameList[position]);
        holder.rowPercakapan.setText(programPercakapanList[position]);
        holder.rowImage.setImageResource(images[0]);
    }

    @Override
    public int getItemCount() {
        return programNameList.length;
    }
}
