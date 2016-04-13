package com.example.nick_pc.magic8ball.Languages;

import com.example.nick_pc.magic8ball.AnswerPhrase;

import java.util.HashMap;

/**
 * Created by Nick-PC on 14.01.2016.
 */
public class RussianAnswers
        extends AnswersBase{
//фразы на русском
    @Override
    protected void PopulateAnswers(HashMap<Integer, AnswerPhrase> answers) {
        AnswerPhrase answer = new AnswerPhrase("", "Спроси", "меня");
        answers.put(0, answer);

        answer = new AnswerPhrase("", "Бесспорно");
        answers.put(1, answer);

        answer = new AnswerPhrase("", "Предрешено");
        answers.put(2, answer);

        answer = new AnswerPhrase("Никаких", "сомнений");
        answers.put(3, answer);

        answer = new AnswerPhrase("", "Определённо", "да");
        answers.put(4, answer);

        answer = new AnswerPhrase("Можешь быть", "уверен в", "этом");
        answers.put(5, answer);

        answer = new AnswerPhrase("", "Мне кажется", "да");
        answers.put(6, answer);

        answer = new AnswerPhrase("", "Вероятнее", "всего");
        answers.put(7, answer);

        answer = new AnswerPhrase("Хорошие", "перспективы");
        answers.put(8, answer);

        answer = new AnswerPhrase("Знаки", "говорят", "да");
        answers.put(9, answer);

        answer = new AnswerPhrase("", "Да");
        answers.put(10, answer);

        answer = new AnswerPhrase("Пока не ясно", "попробуй", "снова");
        answers.put(11, answer);

        answer = new AnswerPhrase("", "Спроси", "позже");
        answers.put(12, answer);

        answer = new AnswerPhrase("", "Лучше", "не знать");
        answers.put(13, answer);

        answer = new AnswerPhrase("Сейчас нельзя", "предсказать");
        answers.put(14, answer);

        answer = new AnswerPhrase("", "Cпроси", "снова");
        answers.put(15, answer);

        answer = new AnswerPhrase("", "Даже", "не думай");
        answers.put(16, answer);

        answer = new AnswerPhrase("", "Мой ответ", "нет");
        answers.put(17, answer);

        answer = new AnswerPhrase("По моим", "данным", "нет");
        answers.put(18, answer);

        answer = new AnswerPhrase("Перспективы", "не очень", "хорошие");
        answers.put(19, answer);

        answer = new AnswerPhrase("Весьма", "сомнительно");
        answers.put(20, answer);
    }
}
