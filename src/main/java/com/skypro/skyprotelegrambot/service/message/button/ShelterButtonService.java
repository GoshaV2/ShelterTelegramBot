package com.skypro.skyprotelegrambot.service.message.button;

import com.pengrad.telegrambot.model.request.Keyboard;
import com.skypro.skyprotelegrambot.entity.Shelter;

public interface ShelterButtonService {
    /**
     * @return кнопки по разделам приюта. Нужны после выбора приюта.
     */
    Keyboard getInfoMenu();

    /**
     * @return кнопки выбора приюта
     */
    Keyboard getChooseSheltersMenu();

    /**
     * @param shelter
     * @return возвращаем кнопки по информации о приюте в аргументах метода
     */
    Keyboard getBaseInformationMenu(Shelter shelter);

    /**
     * @param shelter
     * @return возвращаем кнопки по информации о том как взять питомца из приюта в аргументах метода
     */
    Keyboard getTakePetInformationMenu(Shelter shelter);
}
