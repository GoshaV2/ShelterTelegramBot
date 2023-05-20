package com.skypro.skyprotelegrambot.controller;

import com.skypro.skyprotelegrambot.dto.request.VolunteerContactDto;
import com.skypro.skyprotelegrambot.entity.VolunteerContact;
import com.skypro.skyprotelegrambot.service.VolunteerContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteer_contact")
public class VolunteerContactController {
    private final VolunteerContactService volunteerContactService;

    public VolunteerContactController(VolunteerContactService volunteerContactService) {
        this.volunteerContactService = volunteerContactService;
    }

    @PostMapping("/")
    @Operation(
            summary = "Добавление контакта волонтера"
    )
    public VolunteerContact create(@RequestBody VolunteerContactDto volunteerContactDto) {
        return volunteerContactService.createVolunteerContact(volunteerContactDto);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Изменение параметров контактных данных волонтера"
    )
    public VolunteerContact update(@RequestBody VolunteerContactDto volunteerContactDto,
                                   @PathVariable(name = "id") Long id) {
        return volunteerContactService.updateVolunteerContact(volunteerContactDto, id);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск контакта волонтера по id"
    )
    public VolunteerContact findVolunteerContactById(@PathVariable (name = "id") Long id) {
        return volunteerContactService.findVolunteerContactById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление контактов волонтера"
    )
    public void delete(@PathVariable @Parameter(description = "id контакта волонтера") Long id) {
        volunteerContactService.deleteVolunteerContactById(id);
    }
}