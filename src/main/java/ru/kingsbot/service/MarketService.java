package ru.kingsbot.service;

import ru.kingsbot.entity.market.Market;
import ru.kingsbot.repository.MarketRepository;

public class MarketService {

    private final MarketRepository marketRepository = new MarketRepository();

    public Market load(Long id) {
        return marketRepository.load(id);
    }

}
