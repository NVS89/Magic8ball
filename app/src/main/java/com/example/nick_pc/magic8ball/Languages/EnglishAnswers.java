package com.example.nick_pc.magic8ball.Languages;

import com.example.nick_pc.magic8ball.AnswerPhrase;

import java.util.HashMap;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public class EnglishAnswers
        extends AnswersBase
{
    //фрази на английском
    @Override
    protected void PopulateAnswers(HashMap<Integer, AnswerPhrase> answers) {
        AnswerPhrase answer = new AnswerPhrase("", "Ask me", "anything");
        answers.put(0, answer);

        answer = new AnswerPhrase("", "It is", "certain");
        answers.put(1, answer);

        answer = new AnswerPhrase("It is", "decidedly", "so");
        answers.put(2, answer);

        answer = new AnswerPhrase("", "Without a", "doubt");
        answers.put(3, answer);

        answer = new AnswerPhrase("", "Yes", "definitely");
        answers.put(4, answer);

        answer = new AnswerPhrase("", "You may rely", "on it");
        answers.put(5, answer);

        answer = new AnswerPhrase("", "As I see it", "yes");
        answers.put(6, answer);

        answer = new AnswerPhrase("", "Most likely");
        answers.put(7, answer);

        answer = new AnswerPhrase("", "Outlook", "good");
        answers.put(8, answer);

        answer = new AnswerPhrase("", "Signs point", "to yes");
        answers.put(9, answer);

        answer = new AnswerPhrase("", "Yes");
        answers.put(10, answer);

        answer = new AnswerPhrase("", "Reply hazy", "try again");
        answers.put(11, answer);

        answer = new AnswerPhrase("", "Ask again", "later");
        answers.put(12, answer);

        answer = new AnswerPhrase("Better not", "tell you", "now");
        answers.put(13, answer);

        answer = new AnswerPhrase("Cannot", "predict", "now");
        answers.put(14, answer);

        answer = new AnswerPhrase("Concentrate", "and ask", "again");
        answers.put(15, answer);

        answer = new AnswerPhrase("", "Don’t count", "on it");
        answers.put(16, answer);

        answer = new AnswerPhrase("", "My reply", "is no");
        answers.put(17, answer);

        answer = new AnswerPhrase("", "My sources", "say no");
        answers.put(18, answer);

        answer = new AnswerPhrase("", "Outlook not", "so good");
        answers.put(19, answer);

        answer = new AnswerPhrase("", "Very", "doubtful");
        answers.put(20, answer);
    }
}
