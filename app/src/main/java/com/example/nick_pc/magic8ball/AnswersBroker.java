package com.example.nick_pc.magic8ball;

import com.example.nick_pc.magic8ball.Languages.AnswersBase;
import com.example.nick_pc.magic8ball.Languages.EnglishAnswers;
import com.example.nick_pc.magic8ball.Languages.RussianAnswers;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public class AnswersBroker {
    private HashMap<String, AnswersBase> m_languageToAnswers = new HashMap<String, AnswersBase>();

    public  AnswersBroker()
    {
        AnswersBase russianAnswers = new RussianAnswers();
        m_languageToAnswers.put("ru", russianAnswers);
        m_languageToAnswers.put("uk", russianAnswers);
        m_languageToAnswers.put("uz", russianAnswers);
        m_languageToAnswers.put("ka", russianAnswers);
        m_languageToAnswers.put("be", russianAnswers);
    }

    public AnswersBase GetAnswers()
    {
        AnswersBase result = null;

        String selectedLanguage = Locale.getDefault().getLanguage();
        if (m_languageToAnswers.containsKey(selectedLanguage))
        {
            result = m_languageToAnswers.get(selectedLanguage);
        }
        else
        {
            result = new EnglishAnswers();
        }

        return result;
    }
}

