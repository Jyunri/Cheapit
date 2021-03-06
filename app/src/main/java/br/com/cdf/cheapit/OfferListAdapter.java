package br.com.cdf.cheapit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Jimy on 12/1/16.
 */

public class OfferListAdapter extends ArrayAdapter<Offer> {


    //Lista de itens para popular a ListView. Essas Listas serao enviadas como argumento.
    ArrayList<Offer> offers;

    ArrayList<Offer> filterList;  // Auxiliar arrayList to searchView

    //Construtor do Adapter. Colocar o numero de parametros necessarios para criar as listas de dados
    public OfferListAdapter(Context context, ArrayList<Offer> offers) {
        super(context, R.layout.offer_row, offers);
        this.offers = offers;

        filterList = new ArrayList<>();
        filterList.addAll(offers);
    }

    //Retorna o objeto que compoe um row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //seta qual row sera utilizado para mostrar os dados
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.offer_row, parent, false);

        //insere a oferta baseado na posicao da lista
        String item = offers.get(position).partner;
        TextView tvItem = (TextView)customView.findViewById(R.id.tvName);
        tvItem.setText(item);

        String descricao = offers.get(position).description;
        TextView tvDescricao = (TextView)customView.findViewById(R.id.tvDescription);
        tvDescricao.setText(descricao);

        String imagem = offers.get(position).image;
        ImageView ivImagem = (ImageView)customView.findViewById(R.id.ivOfferVoucher);

        //ivImagem.setImageResource(getContext().getResources().getIdentifier("drawable/"+imagem,null,getContext().getPackageName()));
        Glide.with(getContext()).load(imagem).into(ivImagem);


        //retorna o objeto
        return customView;
    }

    public void filter(String filterText)
    {
        Log.i("Adapter Filter","Filtering "+filterText);
        filterText = filterText.toLowerCase(Locale.getDefault());
        offers.clear();
        if (filterText.length() == 0) {
            offers.addAll(filterList);
        } else{
            for(Offer o:filterList){
                if (o.partner.toLowerCase(Locale.getDefault()).contains(filterText)) {
                    Log.i("Offer on filter",o.partner);
                    offers.add(o);
                }
            }
        }
        notifyDataSetChanged();
    }
}
