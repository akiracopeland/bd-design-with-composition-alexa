package com.amazon.ata.designcomposition;

import java.util.List;

public class ReadOnlyAlexaQAClient {

    private AlexaQAClient alexaQAClient;

    public ReadOnlyAlexaQAClient(AlexaQAClient alexaQAClient) {
        this.alexaQAClient = alexaQAClient;
    }

    public List<AlexaAnswer> findAnswers(AlexaQuestion question) {
        return alexaQAClient.findAnswers(question);
    }

}
