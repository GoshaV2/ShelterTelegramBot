package com.skypro.skyprotelegrambot.service.message.button;

import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.skypro.skyprotelegrambot.entity.Category;
import com.skypro.skyprotelegrambot.entity.Shelter;
import com.skypro.skyprotelegrambot.model.command.ShelterCommand;
import com.skypro.skyprotelegrambot.service.AnswerService;
import com.skypro.skyprotelegrambot.service.PropertyMessageService;
import com.skypro.skyprotelegrambot.service.ShelterService;
import org.springframework.stereotype.Service;

@Service
public class ShelterButtonServiceImpl implements ShelterButtonService {
    private final ShelterService shelterService;
    private final PropertyMessageService propertyMessageService;
    private final AnswerService answerService;


    public ShelterButtonServiceImpl(ShelterService shelterService, PropertyMessageService propertyMessageService, AnswerService answerService) {
        this.shelterService = shelterService;
        this.propertyMessageService = propertyMessageService;
        this.answerService = answerService;
    }

    @Override
    public Keyboard getInfoMenu(long shelterId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(
                new InlineKeyboardButton(propertyMessageService.getMessage("shelter.info"))
                        .callbackData(ShelterCommand.GET_INFO_MENU.getStartPath()));
        inlineKeyboardMarkup.addRow(
                new InlineKeyboardButton(propertyMessageService.getMessage("shelter.howGetAnimal"))
                        .callbackData("/3"));
        inlineKeyboardMarkup.addRow(new InlineKeyboardButton(propertyMessageService.getMessage("button.back"))
                .callbackData("/start"));
        return inlineKeyboardMarkup;
    }

    @Override
    public Keyboard getChooseSheltersMenu() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        shelterService.getShelters().forEach(shelter -> {
            inlineKeyboardMarkup.addRow(new InlineKeyboardButton(shelter.getName())
                    .callbackData(ShelterCommand.CHOOSE_SHELTER.getStartPath() + shelter.getId()));
        });
        return inlineKeyboardMarkup;
    }

    @Override
    public Keyboard getBaseInformationMenu(Shelter shelter,long shelterId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        answerService.getAnswersByCategory(Category.INFORMATION, shelter).forEach(answer -> {
            inlineKeyboardMarkup.addRow(new InlineKeyboardButton(answer.getTitle())
                    .callbackData(answer.getCommand()));
        });
        inlineKeyboardMarkup.addRow(
                new InlineKeyboardButton(propertyMessageService.getMessage("button.back"))
                        .callbackData(ShelterCommand.CHOOSE_SHELTER.getStartPath() + shelterId)
        );
        return inlineKeyboardMarkup;
    }
}
