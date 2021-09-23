package com.example.decentspec_v3.federated_learning;

import android.util.Log;

import org.deeplearning4j.nn.api.Model;
import org.deeplearning4j.optimize.api.BaseTrainingListener;

import java.io.Serializable;

public class ScoreRecorder extends BaseTrainingListener implements Serializable {

    private double score_avg;
    private TrainingPara para;

    public ScoreRecorder(TrainingPara para) {
        this.para = para;
        score_avg = 0.0;
    }

    @Override
    public void iterationDone(Model model, int iteration, int epoch) {
        int iter_in_epoch = iteration % (para.DATASET_SIZE / para.BATCH_SIZE);
        score_avg = (score_avg * iter_in_epoch + model.score()) / (iter_in_epoch+1);
        if  (iter_in_epoch % 200 == 0)
            Log.d("startTraining", String.valueOf(iter_in_epoch) + " : " + String.valueOf(epoch) + " : " + String.valueOf(score_avg));
    }

    public double getScore() {
        return score_avg;
    }
}