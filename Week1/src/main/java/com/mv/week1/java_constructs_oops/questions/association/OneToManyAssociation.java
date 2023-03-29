package com.mv.week1.java_constructs_oops.questions.association;

import java.util.ArrayList;
import java.util.List;

class Trainee {

    String name;

    public Trainee(String name, TrainingBatch trainingBatch) {
        this.name = name;
        this.trainingBatch = trainingBatch;
    }

    TrainingBatch trainingBatch;

    public void setTrainingBatch(TrainingBatch trainingBatch) {
        this.trainingBatch = trainingBatch;
    }
}

class TrainingBatch {
    public TrainingBatch(int batchID, List<Trainee> trainees) {
        this.batchID = batchID;
        this.trainees = trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    int batchID;
    List<Trainee> trainees;

}

public class OneToManyAssociation {

    public static void main(String[] args) {

        // A trainee can be associated with only one training batch
        // A training batch can have many trainees
        // This is one-to-many association
        Trainee trainee = new Trainee("Madhavan", null);
        TrainingBatch trainingBatch = new TrainingBatch(1, new ArrayList<>());
        trainee.setTrainingBatch(trainingBatch);
        trainingBatch.setTrainees(List.of(trainee));


    }


}
