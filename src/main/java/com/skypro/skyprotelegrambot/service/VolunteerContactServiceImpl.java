package com.skypro.skyprotelegrambot.service;

import com.skypro.skyprotelegrambot.dto.request.VolunteerContactDto;
import com.skypro.skyprotelegrambot.entity.Shelter;
import com.skypro.skyprotelegrambot.entity.VolunteerContact;
import com.skypro.skyprotelegrambot.exception.NotFoundElement;
import com.skypro.skyprotelegrambot.repository.VolunteerContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerContactServiceImpl implements VolunteerContactService {
    private final VolunteerContactRepository volunteerContactRepository;
    private final ShelterService shelterService;

    public VolunteerContactServiceImpl(VolunteerContactRepository volunteerContactRepository, ShelterService shelterService) {
        this.volunteerContactRepository = volunteerContactRepository;
        this.shelterService = shelterService;
    }

    @Override
    public VolunteerContact findVolunteerContactById(Long id) {
        return volunteerContactRepository.findVolunteerContactById(id)
                .orElseThrow(() -> new NotFoundElement(id, VolunteerContact.class));
    }

    @Override
    public VolunteerContact createVolunteerContact(VolunteerContactDto volunteerContactDto) {
        VolunteerContact volunteerContact = new VolunteerContact();
        volunteerContact.setPhone(volunteerContactDto.getPhone());
        volunteerContact.setTelegramTag(volunteerContactDto.getTelegramTag());
        volunteerContact.setEmail(volunteerContactDto.getEmail());
        volunteerContact.setFullName(volunteerContactDto.getFullName());
        volunteerContact.setShelter(shelterService.findShelterById(volunteerContactDto.getShelterId()));
        volunteerContact.setChatId(volunteerContact.getChatId());
        return volunteerContactRepository.save(volunteerContact);
    }

    @Override
    public VolunteerContact updateVolunteerContact(VolunteerContactDto volunteerContactDto, Long id) {
        VolunteerContact volunteerContact = findVolunteerContactById(id);
        volunteerContact.setPhone(volunteerContactDto.getPhone());
        volunteerContact.setTelegramTag(volunteerContactDto.getTelegramTag());
        volunteerContact.setEmail(volunteerContactDto.getEmail());
        volunteerContact.setFullName(volunteerContactDto.getFullName());
        volunteerContact.setChatId(volunteerContact.getChatId());
        return volunteerContactRepository.save(volunteerContact);
    }

    @Override
    public void deleteVolunteerContactById(Long id) {
        volunteerContactRepository.delete(findVolunteerContactById(id));
    }

    @Override
    public List<VolunteerContact> findAllByShelter(Shelter shelter) {
        return volunteerContactRepository.findAllByShelter(shelter);
    }
}
