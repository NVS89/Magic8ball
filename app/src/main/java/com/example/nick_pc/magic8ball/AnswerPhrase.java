package com.example.nick_pc.magic8ball;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public class AnswerPhrase {
    private String m_line1;
    private String m_line2;
    private String m_line3;

    public AnswerPhrase(String line1)
    {
        if (line1 == null)
        {
            throw new IllegalArgumentException("line1");
        }
        m_line1 = line1;
    }

    public AnswerPhrase(String line1, String line2)
    {
        if (line1 == null)
        {
            throw new IllegalArgumentException("line1");
        }
        if (line2 == null)
        {
            throw new IllegalArgumentException("line2");
        }

        m_line1 = line1;
        m_line2 = line2;
    }

    public AnswerPhrase(String line1, String line2, String line3)
    {
        if (line1 == null)
        {
            throw new IllegalArgumentException("line1");
        }
        if (line2 == null)
        {
            throw new IllegalArgumentException("line2");
        }
        if (line3 == null)
        {
            throw new IllegalArgumentException("line3");
        }

        m_line1 = line1;
        m_line2 = line2;
        m_line3 = line3;
    }

    public String get_line1()
    {
        return m_line1;
    }

    public String get_line2()
    {
        return m_line2;
    }

    public String get_line3()
    {
        return m_line3;
    }
}
