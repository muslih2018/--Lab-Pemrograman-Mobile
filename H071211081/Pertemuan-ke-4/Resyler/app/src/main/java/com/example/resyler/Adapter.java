package com.example.resyler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

private ArrayList<itemModel> dataitem;
String hilter="hilter";
String soekarno="soekarno";
    String arga="Arga";
    String aqid="aqid";
    String nazi="Nazi";
    String taufiq="Tafufiq";
    String salim="Salim";
    String juwanda="Juwanda";
    String Aqid="Aqid";
private Context context;
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView chat;
        TextView nama;
        ImageView gambar;
        CardView profil;
        LinearLayout kechat;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama =itemView.findViewById(R.id.nama);
            chat =itemView.findViewById(R.id.chat);
            gambar =itemView.findViewById(R.id.gambar);
            profil =itemView.findViewById(R.id.profil);
            kechat =itemView.findViewById(R.id.kechat);
        }
    }

    Adapter(Context context,ArrayList<itemModel> dataitem){
        this.context=context;
        this.dataitem=dataitem;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
      TextView nama=holder.nama;
      TextView chat=holder.chat;
      ImageView gambar =holder.gambar;

      nama.setText(dataitem.get(position).getName());
      chat.setText(dataitem.get(position).getType());
      gambar.setImageResource(dataitem.get(position).getImage());

    //ke profil
      holder.profil.setOnClickListener(view ->{
    if(dataitem.get(position).getName().equalsIgnoreCase("hilter")){
        Intent intent =new Intent(context,MainActivity2.class);
        intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
        intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
        context.startActivity(intent);
    }
          if(dataitem.get(position).getName().equalsIgnoreCase("Soekarno")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
          if(dataitem.get(position).getName().equalsIgnoreCase("Nazi")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
          if(dataitem.get(position).getName().equalsIgnoreCase("Arga")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
          if(dataitem.get(position).getName().equalsIgnoreCase("Tafufiq")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
          if(dataitem.get(position).getName().equalsIgnoreCase("Salim")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
          if(dataitem.get(position).getName().equalsIgnoreCase("Awid")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
          if(dataitem.get(position).getName().equalsIgnoreCase("Juwanda")){
              Intent intent =new Intent(context,MainActivity2.class);
              intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
              intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
              context.startActivity(intent);
          }
      } );


      //kechat
        holder.kechat.setOnClickListener(view ->{
            if(dataitem.get(position).getName().equalsIgnoreCase("hilter")){
                Bundle b = new Bundle();
                b.putStringArray("chatdata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","semoga kamu baik baik saja"});
                Intent intent =new Intent(context,MainActivity3.class);
                intent.putExtras(b);
                intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                intent.putExtra("hilter", hilter);
                context.startActivity(intent);
            }
            if(dataitem.get(position).getName().equalsIgnoreCase("Soekarno")){
                Bundle b = new Bundle();
                b.putStringArray("chaydata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","goblok"});
                Intent intent =new Intent(context,MainActivity3.class);
                intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                intent.putExtra("hilter", soekarno);
                context.startActivity(intent);
            }
            if(dataitem.get(position).getName().equalsIgnoreCase("Nazi")){
                Bundle b = new Bundle();
                b.putStringArray("chatdata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","semoga kamu baik baik saja"});
                Intent intent =new Intent(context,MainActivity3.class);
                intent.putExtras(b);
                intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                intent.putExtra("hilter", nazi);
                context.startActivity(intent);
            }
            if(dataitem.get(position).getName().equalsIgnoreCase("Arga")){
                Bundle b = new Bundle();
                b.putStringArray("chaydata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","goblok"});
                Intent intent =new Intent(context,MainActivity3.class);
                intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                intent.putExtra("hilter", arga);
                context.startActivity(intent);
            }
            if(dataitem.get(position).getName().equalsIgnoreCase("Tafufiq")){
                Bundle b = new Bundle();
                b.putStringArray("chatdata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","semoga kamu baik baik saja"});
                Intent intent =new Intent(context,MainActivity3.class);
                intent.putExtras(b);
                intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                intent.putExtra("hilter", taufiq);
                context.startActivity(intent);
            }
            if(dataitem.get(position).getName().equalsIgnoreCase("Salim")){
                Bundle b = new Bundle();
                b.putStringArray("chaydata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","goblok"});
                Intent intent =new Intent(context,MainActivity3.class);
                intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                intent.putExtra("hilter", salim);
                context.startActivity(intent);}
                if(dataitem.get(position).getName().equalsIgnoreCase("Aqid")){
                    Bundle b = new Bundle();
                    b.putStringArray("chatdata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","semoga kamu baik baik saja"});
                    Intent intent =new Intent(context,MainActivity3.class);
                    intent.putExtras(b);
                    intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                    intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                    intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                    intent.putExtra("hilter", aqid);
                    context.startActivity(intent);
                }
                if(dataitem.get(position).getName().equalsIgnoreCase("Juwanda")){
                    Bundle b = new Bundle();
                    b.putStringArray("chaydata", new String[]{"Hallo Apa kabar?", "Kamu sehat-sehat?","goblok"});
                    Intent intent =new Intent(context,MainActivity3.class);
                    intent.putExtra("TEXT_DEFAULT",dataitem.get(position).getName());
                    intent.putExtra("GAMBAR_DEFAULT",dataitem.get(position).getImage());
                    intent.putExtra("NOMOR_DEFAULT",dataitem.get(position).getNomortelpon());
                    intent.putExtra("hilter", juwanda);
                    context.startActivity(intent);
                }

        } );

    }

    @Override
    public int getItemCount() {
        return dataitem.size();
    }


}
