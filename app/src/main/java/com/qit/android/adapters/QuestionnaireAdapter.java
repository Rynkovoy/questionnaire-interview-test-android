package com.qit.android.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qit.R;
import com.qit.android.activity.QitActivity;
import com.qit.android.models.quiz.Questionnaire;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuestionnaireAdapter extends RecyclerView.Adapter<QuestionnaireAdapter.QuestionnaireViewHolder> {

    private List<Questionnaire> questionnaires;
    private Context context;

    public class QuestionnaireViewHolder extends RecyclerView.ViewHolder {
        public CircleImageView civQuestionnaire;
        public TextView tvTitle;
        public TextView tvTopic;

        public QuestionnaireViewHolder(View view) {
            super(view);
            civQuestionnaire = view.findViewById(R.id.civQuestionnaire);
            tvTitle = view.findViewById(R.id.tvQuestionnaireTitle);
            tvTopic = view.findViewById(R.id.tvQuestionnaireTopic);
            context = view.getContext();
        }
    }

    public QuestionnaireAdapter(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    @Override
    public QuestionnaireViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_questionnaire_list, parent,false);
        return new QuestionnaireViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final QuestionnaireViewHolder holder, int position) {
        Questionnaire questionnaire = questionnaires.get(position);
        holder.tvTitle.setText(questionnaire.getSummary());
        holder.tvTopic.setText(questionnaire.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.tvTitle.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionnaires.size();
    }
}
