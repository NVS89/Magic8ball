package com.example.nick_pc.magic8ball.Languages;

import com.example.nick_pc.magic8ball.AnswerPhrase;

import java.util.HashMap;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public abstract class AnswersBase {
    private HashMap<Integer, AnswerPhrase> m_answers = new HashMap<Integer, AnswerPhrase>();

    public AnswersBase()
    {
        m_answers = new HashMap<Integer, AnswerPhrase>();
        PopulateAnswers(m_answers);
    }

    public AnswerPhrase GetAnswer(int id) {
        if (id < 0)
        {
            throw new IllegalArgumentException("id");
        }

        AnswerPhrase result = m_answers.get(id);
        return result;
    }

    public int Count()
    {
        return m_answers.size();
    }

    protected abstract void PopulateAnswers(HashMap<Integer, AnswerPhrase> answers);
}
