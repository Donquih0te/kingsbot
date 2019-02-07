package ru.kingsbot.service;

import ru.kingsbot.entity.donate.Donate;
import ru.kingsbot.repository.DonateRepository;

import java.util.List;

public class DonateService {

    private final DonateRepository donateRepository = new DonateRepository();

    public List<Donate> getByCustomer(Integer id) {
        return donateRepository.getByCustomer(id);
    }

    public List<Donate> findByNotCompleted() {
        return donateRepository.findByNotCompleted();
    }

}
