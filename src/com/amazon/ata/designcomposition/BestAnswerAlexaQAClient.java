package com.amazon.ata.designcomposition;

import java.util.List;

public class BestAnswerAlexaQAClient {

    private AlexaQAClient alexaQAClient;

    BestAnswerAlexaQAClient(AlexaQAClient alexaQAClient) {
        this.alexaQAClient = alexaQAClient;
    }

    public AlexaAnswer findBestAnswer(AlexaQuestion question) {
        AlexaAnswer bestAnswer = new AlexaAnswer("", -0.1);

        for (AlexaAnswer answer : alexaQAClient.findAnswers(question)) {
            if (answer.getAnswerQuality() > bestAnswer.getAnswerQuality()) {
                bestAnswer = answer;
            }
        }
        return bestAnswer;
    }

    public void submitQuestionAnswerSuggestions(AlexaQuestion question, List<AlexaAnswer> answers) {
        for (AlexaAnswer suggestedAnswer : answers) {
            alexaQAClient.submitQuestionAnswerSuggestion(question, suggestedAnswer);
        }
    }
}
